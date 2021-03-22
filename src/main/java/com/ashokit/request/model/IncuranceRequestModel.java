package com.ashokit.request.model;

public class IncuranceRequestModel {
	private String planName;
	private String planStatus;
	private String holderName;
	private long holderSSN;
	
	
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public long getHolderSSN() {
		return holderSSN;
	}
	public void setHolderSSN(long holderSSN) {
		this.holderSSN = holderSSN;
	}

}
