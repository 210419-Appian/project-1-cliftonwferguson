package com.revature.model;

public class BalanceDTO {
	
	public int accountId;
	
	public Double amount;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BalanceDTO [accountId=" + accountId + ", amount=" + amount + "]";
	}

	public BalanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
