package com.revature.model;

public class TransferDTO {
	
     private int accountIdA;
     private double balanceA;
     private int accountIdB;
     private double balanceB;
     
	public int getAccountIdA() {
		return accountIdA;
	}
	public void setAccountIdA(int accountIdA) {
		this.accountIdA = accountIdA;
	}
	public double getBalanceA() {
		return balanceA;
	}
	public void setBalanceA(double balanceA) {
		this.balanceA = balanceA;
	}
	public int getAccountIdB() {
		return accountIdB;
	}
	public void setAccountIdB(int accountIdB) {
		this.accountIdB = accountIdB;
	}
	public double getBalanceB() {
		return balanceB;
	}
	public void setBalanceB(double balanceB) {
		this.balanceB = balanceB;
	}
	public TransferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
     
	
     
}
