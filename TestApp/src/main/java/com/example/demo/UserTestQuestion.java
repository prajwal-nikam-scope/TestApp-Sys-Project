package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserTestQuestion {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "question_id")
	    private Question question;

	    @ManyToOne
	    @JoinColumn(name = "choice_id")
	    private Choice choice;

	    @Column(nullable = false, length = 20)
	    private String type;

	    @ManyToOne
	    @JoinColumn(name = "user_exam_id")
	    private UserResult userResult;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Question getQuestion() {
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public Choice getChoice() {
			return choice;
		}

		public void setChoice(Choice choice) {
			this.choice = choice;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public UserResult getUserExam() {
			return userResult;
		}

		public void setUserExam(UserResult UserResult) {
			this.userResult = userResult;
		}

		public UserTestQuestion(Long id, Question question, Choice choice, String type, UserResult UserResult) {
			super();
			this.id = id;
			this.question = question;
			this.choice = choice;
			this.type = type;
			this.userResult = userResult;
		}

		public UserTestQuestion() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "UserTestQuestion [id=" + id + ", question=" + question + ", choice=" + choice + ", type=" + type
					+ ", UserResult=" + userResult + "]";
		}
	    
	    

}
