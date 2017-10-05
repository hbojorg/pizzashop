package com.truextend.pizzashop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "ingredient_id")
	private Integer ingredientId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy="ingredients")
	private Set<Pizza> pizzas = new HashSet<>();
}
