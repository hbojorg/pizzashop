package com.truextend.pizzashop.controller;

import java.util.ArrayList;
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
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.truextend.pizzashop.converter.PizzaConverter;
import com.truextend.pizzashop.converter.model.PizzaModel;
import com.truextend.pizzashop.entity.Pizza;
import com.truextend.pizzashop.service.IEntityService;
import com.truextend.pizzashop.service.Impl.PizzaServiceImpl;

@Component
@Path("/pizza")
public class PizzaRestController {
	
	private final PizzaConverter pizzaConverter;	
	private final PizzaServiceImpl pizzaService;  
	
	@Autowired
	PizzaRestController(PizzaServiceImpl serviceImpl, PizzaConverter converter) {
		this.pizzaConverter = converter;
		this.pizzaService = serviceImpl;
	}
		
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<PizzaModel> getAll() {
		List<PizzaModel> list = pizzaConverter.getModels(pizzaService.listAll()); 
		return list;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public PizzaModel getPizza(@PathParam("id") String id) {
		PizzaModel model = pizzaConverter.entityToModel(pizzaService.findById(Integer.parseInt(id)));		
		return model;
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addBook(PizzaModel model) {
		pizzaService.add(pizzaConverter.modelToEntity(model));
		return Response.ok().build();
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response updateBook(@PathParam("id") String id, PizzaModel model) {
		pizzaService.update(pizzaConverter.modelToEntity(model));		
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deletePizza(@PathParam("id") String id) {
		pizzaService.remove(Integer.parseInt(id));		
		return Response.ok().build();
	}
}
