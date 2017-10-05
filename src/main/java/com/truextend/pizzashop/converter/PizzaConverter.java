package com.truextend.pizzashop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.truextend.pizzashop.converter.model.OrderModel;
import com.truextend.pizzashop.converter.model.PizzaModel;
import com.truextend.pizzashop.entity.Order;
import com.truextend.pizzashop.entity.Pizza;

@Component("pizzaConverter")
public class PizzaConverter implements IConverter<Pizza, PizzaModel> {

	@Override
	public PizzaModel entityToModel(Pizza entity) {
		PizzaModel model = new PizzaModel();
		model.setId(entity.getPizzaId());
		model.setName(entity.getName());
		return model;
	}

	@Override
	public Pizza modelToEntity(PizzaModel model) {
		Pizza pizza = new Pizza();
		pizza.setPizzaId(model.getId());
		pizza.setName(model.getName());
		pizza.setDescription(model.getDescription());
		return pizza;
	}
	
	/*
	public List<PizzaModel> getModels(List<Pizza> list) {
		List<PizzaModel> models = new ArrayList<PizzaModel>();
		for (Pizza pizza : list) {
			models.add(entityToModel(pizza));
		}	
			
		return models;		
	}*/
}
