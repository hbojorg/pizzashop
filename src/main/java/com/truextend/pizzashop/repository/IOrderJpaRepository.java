package com.truextend.pizzashop.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truextend.pizzashop.entity.Order;


@Repository("orderJpaRepository")
public interface IOrderJpaRepository extends JpaRepository<Order, Serializable> {
	public abstract List<Order> findByStatus(Order.Status status);	
}
