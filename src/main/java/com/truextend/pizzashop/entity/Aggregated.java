package com.truextend.pizzashop.entity;

import javax.persistence.*;

@Entity
@Table(name = "aggregated")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aggregated {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
