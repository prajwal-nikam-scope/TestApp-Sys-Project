package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Config {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 20)
	    private String type;

	    @Column(nullable = false, length = 20)
	    private String configKey;

	    @Column(length = 2000)
	    private String value;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getKey() {
			return configKey;
		}

		public void setKey(String configKey) {
			this.configKey = configKey;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Config(Long id, String type, String configKey, String value) {
			super();
			this.id = id;
			this.type = type;
			this.configKey = configKey;
			this.value = value;
		}

		public Config() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Config [id=" + id + ", type=" + type + ", configKey=" + configKey + ", value=" + value + "]";
		}
	    
	    

}
