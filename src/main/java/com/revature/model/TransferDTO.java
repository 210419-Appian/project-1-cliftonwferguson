package com.revature.model;

public class TransferDTO {
	
   public int sourceAccountId;
   public int targetAccountId;
   public double amount;
public int getsourceAccountId() {
	return sourceAccountId;
}
public void setsourceAccountId(int sourceAccountId) {
	this.sourceAccountId = sourceAccountId;
}
public int gettargetAccountId() {
	return targetAccountId;
}
public void settargetAccountId(int targetAccountId) {
	this.targetAccountId = targetAccountId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "TransferDTO [sourceAccountId=" + sourceAccountId + ", targetAccountId=" + targetAccountId + ", amount="
			+ amount + "]";
}
public TransferDTO(int sourceAccountId, int targetAccountId, double amount) {
	super();
	this.sourceAccountId = sourceAccountId;
	this.targetAccountId = targetAccountId;
	this.amount = amount;
}
public TransferDTO() {
	super();
	// TODO Auto-generated constructor stub
}


   
   
   
	
     
}
