package com.revature.model;

public class Account {
     private int accountId;
     private double balance;
     private AccountStatus statusId;
     private AccountType type;
     private User user;
     
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatusId() {
		return statusId;
	}
	public void setStatusId(AccountStatus statusId) {
		this.statusId = statusId;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", statusId=" + statusId + ", type=" + type
				+ ", user=" + user + "]";
	}
	public Account(int accountId, double balance, AccountStatus statusId, AccountType type, User user) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.statusId = statusId;
		this.type = type;
		this.user = user;
	}
	public Account(double balance, AccountStatus statusId, AccountType type, User user) {
		super();
		this.balance = balance;
		this.statusId = statusId;
		this.type = type;
		this.user = user;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
     
	
     
}
