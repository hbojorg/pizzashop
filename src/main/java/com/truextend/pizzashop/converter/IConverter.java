package com.truextend.pizzashop.converter;

import java.util.ArrayList;
import java.util.List;

import com.truextend.pizzashop.converter.model.PizzaModel;
import com.truextend.pizzashop.entity.Pizza;

public interface IConverter<E, M> {
	M entityToModel(E entity);
	E modelToEntity(M model);
	
	default List<M> getModels(List<E> list) {
		List<M> models = new ArrayList<M>();
		for (E e : list) {
			models.add(entityToModel(e));
		}	
			
		return models;		
	}
}
