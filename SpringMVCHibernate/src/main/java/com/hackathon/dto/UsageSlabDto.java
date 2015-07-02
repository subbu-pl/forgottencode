package com.hackathon.dto;

import java.io.Serializable;

public class UsageSlabDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int slabId;
	private int usageTireStart;
	private int usageTireEnd;
	private double ratePerUnit;
	
	public int getSlabId() {
		return slabId;
	}
	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}
	public int getUsageTireStart() {
		return usageTireStart;
	}
	public void setUsageTireStart(int usageTireStart) {
		this.usageTireStart = usageTireStart;
	}
	public int getUsageTireEnd() {
		return usageTireEnd;
	}
	public void setUsageTireEnd(int usageTireEnd) {
		this.usageTireEnd = usageTireEnd;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
}
