package com.truextend.pizzashop.converter.model;

public class OrderModel {
	private Integer id;
	private String status;
	private Integer numberOrder;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNumberOrder() {
		return numberOrder;
	}
	public void setNumberOrder(Integer numberOrder) {
		this.numberOrder = numberOrder;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	
}
