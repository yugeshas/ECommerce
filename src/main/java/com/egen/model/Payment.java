package com.egen.model;

import javax.persistence.Entity;
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

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer paymentId;
	private String name;
	private String cardNo;
	private String eMonth;
	private String eYear;
	private boolean defaultCard;
	private Double amount;
	
	//To do - remove it and keep unidirectional OneToMany
	// to avoid delete anomaly
	@ManyToOne
	@JoinColumn(name = "accountId",referencedColumnName="accountId", nullable = false)
	private Account accountId;


	public Account getAccountId() {
		return accountId;
	}


	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String geteMonth() {
		return eMonth;
	}

	public void seteMonth(String eMonth) {
		this.eMonth = eMonth;
	}

	public String geteYear() {
		return eYear;
	}

	public void seteYear(String eYear) {
		this.eYear = eYear;
	}

	
	public boolean isDefaultCard() {
		return defaultCard;
	}

	public void setDefaultCard(boolean defaultCard) {
		this.defaultCard = defaultCard;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}
