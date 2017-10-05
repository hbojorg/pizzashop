package com.truextend.pizzashop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/pizza")
public class PizzaController {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<String> getAllPizza() {
		List<String> response = new ArrayList<String>();
		response.add("Hawaiana");
		return response;
	}

}
