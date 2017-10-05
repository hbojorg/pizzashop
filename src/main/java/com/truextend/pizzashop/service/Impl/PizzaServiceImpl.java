package com.truextend.pizzashop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.truextend.pizzashop.entity.Pizza;
import com.truextend.pizzashop.repository.IPizzaJpaRepository;
import com.truextend.pizzashop.service.IEntityService;


@Service("pizzaServiceImpl")
public class PizzaServiceImpl implements IEntityService<Pizza> {
	@Autowired
	@Qualifier("pizzaJpaRepository")
	private IPizzaJpaRepository pizzaJpaRepository;

	@Override
	public List<Pizza> listAll() {
		return pizzaJpaRepository.findAll();
	}

	@Override
	public Pizza add(Pizza pizza) {
		return pizzaJpaRepository.save(pizza);
	}

	@Override
	public void remove(int id) {
		pizzaJpaRepository.delete(id);		
	}

	@Override
	public Pizza update(Pizza course) {
		return pizzaJpaRepository.save(course);
	}

	@Override
	public Pizza findById(int id) {
		return pizzaJpaRepository.findOne(id);
	}

}
