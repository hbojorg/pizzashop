package com.truextend.pizzashop;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.truextend.pizzashop.controller.OrderRestController;
import com.truextend.pizzashop.controller.PizzaRestController;

@Configuration
@ApplicationPath("api/v1")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(PizzaRestController.class);
		register(OrderRestController.class);
	}

}
