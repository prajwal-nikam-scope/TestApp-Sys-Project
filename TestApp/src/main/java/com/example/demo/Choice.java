package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Choice {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 2000)
	    private String text;

	    @Column(nullable = false)
	    private Boolean isAnswer;

		public Choice() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Choice(Long id, String text, Boolean isAnswer) {
			super();
			this.id = id;
			this.text = text;
			this.isAnswer = isAnswer;
		}

		@Override
		public String toString() {
			return "Choice [id=" + id + ", text=" + text + ", isAnswer=" + isAnswer + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Boolean getIsAnswer() {
			return isAnswer;
		}

		public void setIsAnswer(Boolean isAnswer) {
			this.isAnswer = isAnswer;
		}

	   
	    
	    

}
