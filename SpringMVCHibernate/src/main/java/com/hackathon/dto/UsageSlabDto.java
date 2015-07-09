package com.hackathon.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usage_slab_ref")
public class UsageSlabDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USAGE_SLAB_ID")
	private int slabId;
	@Column(name="USAGE_TIER_START")
	private int usageTireStart;
	@Column(name="USAGE_TIER_END")
	private int usageTireEnd;
	@Column(name="RATE_PER_UNIT")
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
