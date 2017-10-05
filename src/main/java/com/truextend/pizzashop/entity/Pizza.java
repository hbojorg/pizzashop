package com.truextend.pizzashop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "pizza")
public class Pizza extends Aggregated implements Serializable {	
	
	@Column(name = "price_base")
	private Integer priceBase;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PizzaIngredient", 
		joinColumns = { @JoinColumn(name="pizza_id")}, inverseJoinColumns = {@JoinColumn(name="ingredient_id")}
	)
	private Set<Ingredient> ingredients = new HashSet<>();

	
	public Integer getPriceBase() {
		return priceBase;
	}

	public void setPriceBase(Integer priceBase) {
		this.priceBase = priceBase;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}		
}
