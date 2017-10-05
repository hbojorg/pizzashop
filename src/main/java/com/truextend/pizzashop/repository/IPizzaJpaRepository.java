package com.truextend.pizzashop.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.truextend.pizzashop.entity.Pizza;


@Repository("pizzaJpaRepository")
public interface IPizzaJpaRepository extends JpaRepository<Pizza, Serializable> {
	public abstract Pizza findByName(String name);	
}
