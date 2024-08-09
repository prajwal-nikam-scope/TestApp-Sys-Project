package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TestConfig {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Short weightage;
    
    private short diplayOrder;
    
    private short minPercentage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getWeightage() {
		return weightage;
	}

	public void setWeightage(Short weightage) {
		this.weightage = weightage;
	}

	public short getDiplayOrder() {
		return diplayOrder;
	}

	public void setDiplayOrder(short diplayOrder) {
		this.diplayOrder = diplayOrder;
	}

	public short getMinPercentage() {
		return minPercentage;
	}

	public void setMinPercentage(short minPercentage) {
		this.minPercentage = minPercentage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public TestConfig(Long id, Short weightage, short diplayOrder, short minPercentage, Category category) {
		super();
		this.id = id;
		this.weightage = weightage;
		this.diplayOrder = diplayOrder;
		this.minPercentage = minPercentage;
		this.category = category;
	}

	public TestConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TestConfig [id=" + id + ", weightage=" + weightage + ", diplayOrder=" + diplayOrder + ", minPercentage="
				+ minPercentage + ", category=" + category + "]";
	}

    

	
	
}
