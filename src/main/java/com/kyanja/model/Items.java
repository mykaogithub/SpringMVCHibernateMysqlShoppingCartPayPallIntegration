package com.kyanja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Items implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Product product;

	private int quantity;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "items_id")
	private long id;
	private String itemId;
	private double itemTotal;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Items(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Items() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Items [product=" + product + ", quantity=" + quantity + ", id=" + id + ", itemId=" + itemId
				+ ", itemTotal=" + itemTotal + ", cart=" + cart + "]";
	}

}
