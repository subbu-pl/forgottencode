package com.hackathon.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class MonthlyUsageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;;
	private int smartMeterId;
	private Timestamp startTime;
	private int mtrStart;
	private Timestamp endTime;
	private int mtrEnd;
	private int reading;
	private double amount;
	private String invoiceNumber;
	private Date dueDate;
	private String remarks;
	private String status;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSmartMeterId() {
		return smartMeterId;
	}
	public void setSmartMeterId(int smartMeterId) {
		this.smartMeterId = smartMeterId;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public int getMtrStart() {
		return mtrStart;
	}
	public void setMtrStart(int mtrStart) {
		this.mtrStart = mtrStart;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getMtrEnd() {
		return mtrEnd;
	}
	public void setMtrEnd(int mtrEnd) {
		this.mtrEnd = mtrEnd;
	}
	public int getReading() {
		return reading;
	}
	public void setReading(int reading) {
		this.reading = reading;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
