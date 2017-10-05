package com.truextend.pizzashop.service;

import java.util.List;

public interface IEntityService<T> {
	public List<T> listAll();
	public T add(T instance);
	public void remove(int id);
	public T update(T instance);
	public T findById(int id);
}
