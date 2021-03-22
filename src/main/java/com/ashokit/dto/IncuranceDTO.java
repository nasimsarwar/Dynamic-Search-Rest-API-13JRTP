package com.ashokit.dto;

public class IncuranceDTO {
	private int planId;
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

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "IncuranceDTO [planId=" + planId + ", planName=" + planName + ", planStatus=" + planStatus
				+ ", holderName=" + holderName + ", holderSSN=" + holderSSN + ", getPlanName()=" + getPlanName()
				+ ", getPlanStatus()=" + getPlanStatus() + ", getHolderName()=" + getHolderName() + ", getHolderSSN()="
				+ getHolderSSN() + ", getPlanId()=" + getPlanId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
