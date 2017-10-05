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
public class Pizza implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id")
	protected Integer id;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "description")
	protected String description;
	
	@Column(name = "price_base")
	private Integer priceBase;
	
	@Column(name = "deleted")
	protected Boolean deleted;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PizzaIngredient", 
		joinColumns = { @JoinColumn(name="pizza_id")}, inverseJoinColumns = {@JoinColumn(name="ingredient_id")}
	)
	private Set<Ingredient> ingredients = new HashSet<>();
	
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

	public Integer getPriceBase() {
		return priceBase;
	}

	public void setPriceBase(Integer priceBase) {
		this.priceBase = priceBase;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
