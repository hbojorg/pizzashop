package com.truextend.pizzashop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_of_pizza")
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
	
	@Column(name = "slices")
	private Integer slices;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "size")
	private Size size;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="pizza_id")
	private Pizza pizza;
					
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="OrderItem", 
		joinColumns = { @JoinColumn(name="order_id")}, inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	private Set<Aggregated> orderItems = new HashSet<>();
	
	
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

	public Integer getSlices() {
		return slices;
	}

	public void setSlices(Integer slices) {
		this.slices = slices;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Pizza getPizza() {
		return pizza;
	}	

	public Set<Aggregated> getOrderItems() {
		return orderItems;
	}

	public static enum Status {
	    PENDING,
	    INPROGRESS,
	    COMPLETED,
	    DELIVERED;	    
	}
	
	public static enum Size {
	    PERSONAL,
	    SMALL,
	    MEDIUM,
	    LARGE;	    
	}
}
