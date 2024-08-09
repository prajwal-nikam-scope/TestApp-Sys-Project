package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.UserDetails;
import com.example.demo.UserDetailsRepository;
import com.example.demo.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private UserDetailsRepository dRepo;

	@GetMapping("/get")
	public List<UserDetails> get() {
		return dRepo.findAll();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody UserDetails d) {
		User u=d.getUser();
		QuestionController.exp=d.getExperience();
		uRepo.save(u);
		dRepo.save(d);
		return "User Added Seccessfully";
	}

}
