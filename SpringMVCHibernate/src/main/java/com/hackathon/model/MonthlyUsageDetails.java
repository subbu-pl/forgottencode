package com.hackathon.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monthly_usage_tr")
public class MonthlyUsageDetails {
	
	@Id
	@Column(name="USAGE_ID")
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private int usageId;
	
	@Column(name="SMART_METER_ID")
	private int smartMeterId;
	
	@Column(name="START_TIME")
	private Timestamp startDateTime;
	
	@Column(name="END_TIME")
	private Timestamp endDateTime;
	
	@Column(name="MTR_START")
	private int meterReadingStart;
	
	@Column(name="MTR_END")
	private int meterReadingEnd;
	
	@Column(name="READING")
	private int reading;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="INVOICE_NUMBER")
	private String invoiceNumber;
	
	@Column(name="DUE_DATE")
	private Date dueDate;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;

	public int getUsageId() {
		return usageId;
	}

	public void setUsageId(int usageId) {
		this.usageId = usageId;
	}

	public int getSmartMeterId() {
		return smartMeterId;
	}

	public void setSmartMeterId(int smartMeterId) {
		this.smartMeterId = smartMeterId;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	public int getMeterReadingStart() {
		return meterReadingStart;
	}

	public void setMeterReadingStart(int meterReadingStart) {
		this.meterReadingStart = meterReadingStart;
	}

	public int getMeterReadingEnd() {
		return meterReadingEnd;
	}

	public void setMeterReadingEnd(int meterReadingEnd) {
		this.meterReadingEnd = meterReadingEnd;
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

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
