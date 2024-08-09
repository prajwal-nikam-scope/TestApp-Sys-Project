package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Test;
import com.example.demo.TestConfigRepository;
import com.example.demo.TestRepository;

@RestController
@CrossOrigin
@RequestMapping("/Test")
public class TestController {
	
	@Autowired
	private TestRepository tRepo;
	
	@Autowired
	private TestConfigRepository tConfigRepo;
	
	@PostMapping("/add")
	public boolean add(@RequestBody Test test) {
		tRepo.save(test);
		
		return true;
	}
	
	@GetMapping("/get")
	public List<Test> getTest() {
		return tRepo.findAll();
	}
	
	

}
