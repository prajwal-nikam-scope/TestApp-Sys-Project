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
public class Test {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 20)
	    private String title;

	    @Column(length = 2000)
	    private String description;

	    @Column(nullable = false)
	    private Long duration;

	    @Column(nullable = false)
	    private Short totalQuestions;
	    
	    private short minPercentage;

	    @Column(nullable = false)
	    private Boolean isActive;
	    
	    @OneToMany
	    @JoinColumn(name = "test_config_id")
	    private List<TestConfig> testConfig;

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

		public Long getDuration() {
			return duration;
		}

		public void setDuration(Long duration) {
			this.duration = duration;
		}

		public Short getTotalQuestions() {
			return totalQuestions;
		}

		public void setTotalQuestions(Short totalQuestions) {
			this.totalQuestions = totalQuestions;
		}

		public short getMinPercentage() {
			return minPercentage;
		}

		public void setMinPercentage(short minPercentage) {
			this.minPercentage = minPercentage;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public List<TestConfig> getTestConfig() {
			return testConfig;
		}

		public void setTestConfig(List<TestConfig> testConfig) {
			this.testConfig = testConfig;
		}

		public Test(Long id, String title, String description, Long duration, Short totalQuestions, short minPercentage,
				Boolean isActive, List<TestConfig> testConfig) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.duration = duration;
			this.totalQuestions = totalQuestions;
			this.minPercentage = minPercentage;
			this.isActive = isActive;
			this.testConfig = testConfig;
		}

		public Test() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Test [id=" + id + ", title=" + title + ", description=" + description + ", duration=" + duration
					+ ", totalQuestions=" + totalQuestions + ", minPercentage=" + minPercentage + ", isActive="
					+ isActive + ", testConfig=" + testConfig + "]";
		}

		
		
}
