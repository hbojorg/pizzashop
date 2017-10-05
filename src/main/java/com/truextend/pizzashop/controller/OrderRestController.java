package com.truextend.pizzashop.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.truextend.pizzashop.converter.OrderConverter;
import com.truextend.pizzashop.converter.model.OrderModel;
import com.truextend.pizzashop.entity.Order;
import com.truextend.pizzashop.service.IEntityService;
import com.truextend.pizzashop.service.Impl.OrderServiceImpl;


@Component
@Path("/order")
public class OrderRestController {
	
	private final OrderServiceImpl orderService;		
	private final OrderConverter orderConverter; 
	
	@Autowired
	OrderRestController (OrderServiceImpl entityService, OrderConverter converter) {
		this.orderService = entityService;
		this.orderConverter = converter;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<OrderModel> getAll() {
		List<OrderModel> list = orderConverter.getModels(orderService.listAll()); 
		return list;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public OrderModel getPizza(@PathParam("id") String id) {
		OrderModel model = orderConverter.entityToModel(orderService.findById(Integer.parseInt(id)));		
		return model;
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addBook(OrderModel model) {
		orderService.add(orderConverter.modelToEntity(model));
		return Response.ok().build();
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response updateBook(@PathParam("id") String id, OrderModel model) {
		orderService.update(orderConverter.modelToEntity(model));		
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deletePizza(@PathParam("id") String id) {
		orderService.remove(Integer.parseInt(id));		
		return Response.ok().build();
	}

}
