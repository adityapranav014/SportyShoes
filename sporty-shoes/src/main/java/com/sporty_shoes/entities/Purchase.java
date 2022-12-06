package com.sporty_shoes.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private long productId;
	private long UserId;
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

	public Purchase() {
	}

	public Purchase(long orderId, long productId, long userId, Date purchaseDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		UserId = userId;
		this.purchaseDate = purchaseDate;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Purchase [orderId=" + orderId + ", productId=" + productId + ", UserId=" + UserId + ", purchaseDate="
				+ purchaseDate + "]";
	}

}
