package com.example.demo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 20)
	    private String title;

	    @Column(length = 2000)
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;

	    @Column(nullable = false, length = 20)
	    private String type;

	    @Column(nullable = false, length = 20)
	    private String level;
	    
	    @OneToMany
	    @JoinColumn(name = "Question_id")
	    private List<Choice> listChoices;

		public Question() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Question(Long id, String title, String description, Category category, String type, String level,
				List<Choice> listChoices) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.category = category;
			this.type = type;
			this.level = level;
			this.listChoices = listChoices;
		}

		@Override
		public String toString() {
			return "Question [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
					+ ", type=" + type + ", level=" + level + ", listChoices=" + listChoices + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public List<Choice> getListChoices() {
			return listChoices;
		}

		public void setListChoices(List<Choice> listChoices) {
			this.listChoices = listChoices;
		}

		
	    
	    

}
