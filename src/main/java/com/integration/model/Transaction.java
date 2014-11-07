package com.integration.model;

public class Transaction {

	private int transactionId;
	private String description;
	private double value;
	private String transactionType;
	
	public Transaction(String description, double value, String transactionType){
		this.description = description;
		this.value = value;
		this.transactionType = transactionType;
	}

	
	
	public String getDescription() {
		return description;
	}

	public double getValue() {
		return value;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}



	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
