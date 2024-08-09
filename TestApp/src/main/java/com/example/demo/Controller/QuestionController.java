package com.example.demo.Controller;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Category;
import com.example.demo.CategoryRepository;
import com.example.demo.Choice;
import com.example.demo.ChoiceRepository;
import com.example.demo.Config;
import com.example.demo.ConfigRepository;
import com.example.demo.Question;
import com.example.demo.QuestionRepository;
import com.example.demo.QuestionService;
import com.example.demo.Skill;
import com.example.demo.SkillRepository;
import com.example.demo.Test;
import com.example.demo.TestConfig;
import com.example.demo.TestRepository;


@RestController
@CrossOrigin
@RequestMapping("/Question")
public class QuestionController {
	
	@Autowired
	private ChoiceRepository cRepo;
	
	@Autowired
    private QuestionRepository qRepo;
	
	@Autowired
	private TestRepository tRepo;
	
	@Autowired
	private ConfigRepository configRepo;
	
	@Autowired
	private SkillRepository skRepo;
	
	 @Autowired
	 private QuestionService questionService;
	
	@Autowired
	private CategoryRepository catRepo;
	
	static short exp;
	
	static List<Question> userQuestions;
    static Map<Long,List<Integer>> QA=new HashMap<>();
    
    @GetMapping("/get")
    public List<Question> getQuestion() {
        userQuestions = qRepo.findRandomQue();
        QA.clear();
        for(Question ques:userQuestions)
        {
        	Long id=ques.getId();
        	List<Choice> choice=ques.getListChoices();
        	List<Integer> correctOption=new ArrayList<>();
        	for(int i=0;i<choice.size();i++)
        	{
        		if(choice.get(i).getIsAnswer()==true)
        			correctOption.add(i+1);
        	}
            QA.put(id,correctOption);
        }
        
        return userQuestions;
    }
    @GetMapping("/getQue")
    public List<Question> getQue(@RequestParam long catid){
    	Category cat = catRepo.findById(catid).get();
    	List<Question> que = qRepo.findQuestionByCategoryId(catid);
    	return que;  	
    }
    
    @PostMapping("/addSkill")
    public String addSkill(@RequestBody Skill skill) {
    	skRepo.save(skill);
    	return "Skill add successfully";
    	
    }
    @PostMapping("/addCategory")
    public String addCategory(@RequestBody Category cat ,@RequestParam long id) {
    	
    	Skill sk = skRepo.findById(id).get();
    	cat.setSkill(sk);
    	catRepo.save(cat);
    	return "Category add successfully";  	
    }
    
    @GetMapping("/getSkill")
    public List<Skill> getAll() {   
    	List<Skill> skillList = new ArrayList();
    	skRepo.findAll().forEach(skillList::add);
    	return skillList;    	
    }
    
    @GetMapping("/getCategory")
    public List<Category>getAll(@RequestParam long ido){
    	Skill sk = skRepo.findById(ido).get();
    	List<Category> cat =catRepo.findBySkill(sk);
    	return cat;
    }
    
    @DeleteMapping("/deleteQue")
    public ResponseEntity<Void> deleteQuestion(@RequestParam long id) {
    	cRepo.deleteChoiceByQuestionId(id);
    	System.out.println("Choices delete sucessfully");
        questionService.deleteQue(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/submit")
	public int submitAnswers(@RequestBody Map<Long,List<Integer>> map)
    {
		
		int Score=0; 
		for (Map.Entry<Long, List<Integer>> UserMap : map.entrySet())
		{
			Long Qid = UserMap.getKey();
            List<Integer> User_optList = UserMap.getValue();
            List<Integer> Correct_list=QA.get(Qid);
            if(Correct_list.size()==User_optList.size())
            {
		           int count=0;
		           for(int i=0;i<Correct_list.size();i++)
		           {
		        	   if(Correct_list.contains(User_optList.get(i)))
		        	   {
		        		   count++;
		        	   }
		           }
		           if(count==Correct_list.size()) {
		        	   Score++;
		           }
            }
		}		
		System.out.println(QA);
		System.out.println(map);
		System.out.println(Score);
		return Score;
		
	}
	
	@PostMapping("/add")
	public Boolean saveQuestion(@RequestBody Question q) {
		List<Choice> l=q.getListChoices();
		System.out.println(q.getCategory());
		for(int i=0;i<l.size();i++) {
			cRepo.save(l.get(i));
		}
		qRepo.save(q);
		
		return true;
      
   }
    
	@GetMapping("/getChoice")
	public List<Choice> getChoice(@RequestParam long Qid){
		Question obj = qRepo.findById(Qid).get();
		List<Choice> cList = obj.getListChoices();
		return cList;
	}
	
	@GetMapping("/getQuestionByCategory")
	public List<Question> getByCategory() {
		exp=2;
		List<Question> queList=new ArrayList<>();
		List<Config> cList=configRepo.findAll();
		String level="";
		
		for(int i=0;i<cList.size();i++) {
			if(exp<=2) {
				level="Beginner";
			}
			else if(exp<=5) {
				level="Intermidiate";
			}
			else {
				level="expert";
			}
		}
		
		List<Test> list=tRepo.findActiveTestConfigs();
		Test test=list.get(0);
		
		int totalQue=test.getTotalQuestions();
		
		List<TestConfig> configList=test.getTestConfig();
		
		for(int i=0;i<configList.size();i++) {
			TestConfig tconfig=configList.get(i);
			
			int q=(totalQue *tconfig.getWeightage())/100;
			Long categoryId=tconfig.getId();
			
			List<Question> l=qRepo.findQuestionsByCategoryIdAndLevelWithLimit(categoryId, level, q);
			
			queList.addAll(l);
			
		}
		
		
		return queList;
	}
	
	
	@PutMapping("/update")
	public Boolean update(@RequestBody Question q) {
		
		Optional<Question> q1=qRepo.findById(q.getId());
		
		List<Choice> l=q.getListChoices();
		
		for(int i=0;i<l.size();i++) {
			cRepo.save(l.get(i));
		}
		qRepo.save(q);
		
		return true;
	}
	
//	@GetMapping("/get")
//	public List<Question> get() {
//		return qRepo.findRandomQue();
//	}
	
	
//	@GetMapping("/submit")
//	public int submit(@RequestBody Map<Long,List<Integer>> map) {
//		
//		int Score=0;
//		
//		for (Map.Entry<Long, List<Integer>> entry : map.entrySet()) {
//			Long Qid = entry.getKey();
//            List<Integer> optList = entry.getValue();
//            
//            Optional<Question> q=qRepo.findById(Qid);
//            Question que=q.get();
//            
//            List<Choice> l2=que.getListChoices();
//            List<Integer> corrList=new ArrayList<>();
//            
//            for(int j=0;j<l2.size();j++) {
//				if(l2.get(j).getIsAnswer()==true) {
//					corrList.add(j+1);
//				}
//			}
//            
//            if(corrList.size()==optList.size()) {
//            
//		            int count=0;
//		           for(int i=0;i<corrList.size();i++) {
//		        	   if(corrList.contains(optList.get(i))) {
//		        		   count++;
//		        	   }
//		           }
//		           if(count==corrList.size()) {
//		        	   Score++;
//		           }
//            }
//            
//		}		
//		return Score;
//		
//	}

}
