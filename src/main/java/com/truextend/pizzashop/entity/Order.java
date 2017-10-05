package com.truextend.pizzashop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_pizza")
public class Order implements Serializable {		
	@Id
	@GeneratedValue
	@Column(name = "id")	
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date_order")
	private Date startDateOrder;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date_order")
	private Date endDateOrder;	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@Column(name = "price_total")
	private Integer priceTotal;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getStartDateOrder() {
		return startDateOrder;
	}

	public void setStartDateOrder(Date startDateOrder) {
		this.startDateOrder = startDateOrder;
	}

	public Date getEndDateOrder() {
		return endDateOrder;
	}

	public void setEndDateOrder(Date endDateOrder) {
		this.endDateOrder = endDateOrder;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Integer priceTotal) {
		this.priceTotal = priceTotal;
	}

	public static enum Status {
	    PENDING,
	    INPROGRESS,
	    COMPLETED,
	    DELIVERED;	    
	}	
}
