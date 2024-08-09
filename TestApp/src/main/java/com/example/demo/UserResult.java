package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserResult {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private Short score;

	    @ManyToOne
	    @JoinColumn(name = "userId")
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "exam_id")
	    private Test test;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Short getScore() {
			return score;
		}

		public void setScore(Short score) {
			this.score = score;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Test getExam() {
			return test;
		}

		public void setExam(Test test) {
			this.test = test;
		}

		public UserResult(Long id, Short score, User user, Test test) {
			super();
			this.id = id;
			this.score = score;
			this.user = user;
			this.test = test;
		}

		public UserResult() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "UserResult [id=" + id + ", score=" + score + ", user=" + user + ", test=" + test + "]";
		}
	    
	    

}
