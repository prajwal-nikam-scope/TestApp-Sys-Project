package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository Qid;
	
	public void deleteQue(@RequestParam long id){
		Qid.deleteById(id);
	}
}
