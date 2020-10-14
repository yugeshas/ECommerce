package com.egen.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addId;
	private String name;
	private String addressLine1;
	private String addressLine2;
	private String country;
	private String state;
	private String city;
	private String zip;
	private String type;
	private String contactNo;
	private String deliveryInstructions;
	private String sCode;
	private boolean weekendDelivery;
	

	//To do - remove it and keep unidirectional OneToMany
	// to avoid delete anomaly
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountId",referencedColumnName="accountId", nullable = false)
	private Account accountId;
	
	
	public Account getAccountId() {
		return accountId;
	}


	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}


	public Integer getAddId() {
		return addId;
	}


	public void setAddId(Integer addId) {
		this.addId = addId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}


	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}


	public String getsCode() {
		return sCode;
	}


	public void setsCode(String sCode) {
		this.sCode = sCode;
	}


	public boolean isWeekendDelivery() {
		return weekendDelivery;
	}


	public void setWeekendDelivery(boolean weekendDelivery) {
		this.weekendDelivery = weekendDelivery;
	}
	
}
