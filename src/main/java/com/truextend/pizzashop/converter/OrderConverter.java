package com.truextend.pizzashop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.truextend.pizzashop.converter.model.OrderModel;
import com.truextend.pizzashop.entity.Order;



@Component("orderConverter")
public class OrderConverter implements IConverter<Order, OrderModel> {

	@Override
	public OrderModel entityToModel(Order entity) {
		OrderModel model = new OrderModel();
		model.setNumberOrder(entity.getId());
		model.setStatus(entity.getStatus().name());
		return model;
	}

	@Override
	public Order modelToEntity(OrderModel model) {
		Order order = new Order();
		order.setId(model.getId());
		return order;
	}
	
	/*public List<OrderModel> getModels(List<Order> list) {
		List<OrderModel> models = new ArrayList<OrderModel>();
		for (Order order : list) {
			models.add(entityToModel(order));
		}	
			
		return models;		
	}*/

}
