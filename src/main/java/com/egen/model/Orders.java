package com.egen.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderId;
	private String status;
	private LocalDate orderOn;
	private LocalDate deliveryOnFrom;
	private LocalDate deliveryOnTo;
	private Double total;
	private Double tax;
	private Double shipping;
	private Double discount;
	//private enum DeliveryType; 

	@ManyToOne
	@JoinColumn(name = "accountId",referencedColumnName="accountId", nullable = false)
	private Account accountId;
	
	
	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	@OneToOne
    private Address shippingA;
	
	@OneToOne
    private Address billingA;
	
	@OneToMany
	@NotNull
	private List<Payment> payments = new ArrayList<>();
	
	@OneToMany
	@NotNull
	private List<Item> items = new ArrayList<>();

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderOn() {
		return orderOn;
	}

	public void setOrderOn(LocalDate orderOn) {
		this.orderOn = orderOn;
	}

	public LocalDate getDeliveryOnFrom() {
		return deliveryOnFrom;
	}

	public void setDeliveryOnFrom(LocalDate deliveryOnFrom) {
		this.deliveryOnFrom = deliveryOnFrom;
	}

	public LocalDate getDeliveryOnTo() {
		return deliveryOnTo;
	}

	public void setDeliveryOnTo(LocalDate deliveryOnTo) {
		this.deliveryOnTo = deliveryOnTo;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getShipping() {
		return shipping;
	}

	public void setShipping(Double shipping) {
		this.shipping = shipping;
	}


	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Address getShippingA() {
		return shippingA;
	}

	public void setShippingA(Address shippingA) {
		this.shippingA = shippingA;
	}

	public Address getBillingA() {
		return billingA;
	}

	public void setBillingA(Address billingA) {
		this.billingA = billingA;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	} 

	
	
}
