package com.revature.model;

public class AccoutType {
	
	private int typeId;
	private String type;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AccoutType [typeId=" + typeId + ", type=" + type + "]";
	}
	public AccoutType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	public AccoutType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
