package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long category_id;

	    @Column(nullable = false, length = 20)
	    private String title;

	    @Column(length = 2000)
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "skill_id")
	    private Skill skill;

		public Long getCategory_id() {
			return category_id;
		}

		public void setCategory_id(Long category_id) {
			this.category_id = category_id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Skill getSkill() {
			return skill;
		}

		public void setSkill(Skill skill) {
			this.skill = skill;
		}

		public Category(Long category_id, String title, String description, Skill skill) {
			super();
			this.category_id = category_id;
			this.title = title;
			this.description = description;
			this.skill = skill;
		}

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Category [category_id=" + category_id + ", title=" + title + ", description=" + description
					+ ", skill=" + skill + "]";
		}

		

}
