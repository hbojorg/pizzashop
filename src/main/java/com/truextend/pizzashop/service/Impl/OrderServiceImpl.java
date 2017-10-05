package com.truextend.pizzashop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.truextend.pizzashop.entity.Order;
import com.truextend.pizzashop.repository.IOrderJpaRepository;
import com.truextend.pizzashop.service.IEntityService;

@Service("orderServiceImpl")
public class OrderServiceImpl implements IEntityService<Order> {
	@Autowired
	@Qualifier("orderJpaRepository")
	private IOrderJpaRepository orderJpaRepository;

	@Override
	public List<Order> listAll() {
		return orderJpaRepository.findAll();
	}

	@Override
	public Order add(Order instance) {
		return orderJpaRepository.save(instance);		
	}

	@Override
	public void remove(int id) {
		orderJpaRepository.delete(id);		
	}

	@Override
	public Order update(Order instance) {
		return orderJpaRepository.save(instance);		
	}

	@Override
	public Order findById(int id) {
		return orderJpaRepository.findOne(id);
	}

}
