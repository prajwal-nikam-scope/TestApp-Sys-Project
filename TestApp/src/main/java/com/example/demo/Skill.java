package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String skill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getskill() {
		return skill;
	}

	public void setskill(String skill) {
		this.skill = skill;
	}

	public Skill(Long id, String skill) {
		super();
		this.id = id;
		this.skill = skill;
	}

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Function [id=" + id + ", skill=" + skill + "]";
	}
    
    

}
