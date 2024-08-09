package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 50)
	    private String fname;

	    @Column(nullable = false, length = 16)
	    private String lname;

	    @Column(nullable = false, unique = true, length = 50)
	    private String email;

	    @Column(nullable = false, unique = true, length = 16)
	    private String mobile;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public User(Long id, String fname, String lname, String email, String mobile) {
			super();
			this.id = id;
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.mobile = mobile;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", mobile="
					+ mobile + "]";
		}
	    
	    

}
