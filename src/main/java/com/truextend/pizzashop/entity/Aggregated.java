package com.truextend.pizzashop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "aggregated")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aggregated {
	@Id
	@GeneratedValue
	@Column(name = "id")
	protected Integer id;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "description")
	protected String description;
	
	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy="orderItems")
	protected Set<Order> orders = new HashSet<>();
	
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
