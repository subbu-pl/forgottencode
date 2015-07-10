package com.hackathon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="invoice")
public class SmartMeterInvoice {

	@Id
	@Column(name="invoice_no")
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private int invoiceNumber;
	
	@Column(name="units")
	private int units;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="date")
	private Date createddate;
	
	@Column(name="smart_meter_id")
	private int smartMeterId;
	

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public int getSmartMeterId() {
		return smartMeterId;
	}

	public void setSmartMeterId(int smartMeterId) {
		this.smartMeterId = smartMeterId;
	}

	
}
