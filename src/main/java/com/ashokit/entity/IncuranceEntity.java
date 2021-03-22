package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Incurance_plan")
public class IncuranceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planId;
	private String planName;
	private String planStatus;
	private String holderName;
	private long holderSSN;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

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

	@Override
	public String toString() {
		return "IncuranceEntity [planId=" + planId + ", planName=" + planName + ", planStatus=" + planStatus
				+ ", holderName=" + holderName + ", holderSSN=" + holderSSN + "]";
	}

	
}
