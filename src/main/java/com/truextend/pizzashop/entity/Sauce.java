package com.truextend.pizzashop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sauce")
public class Sauce extends Aggregated implements Serializable {
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name="pizza_id")
	private Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}
}
