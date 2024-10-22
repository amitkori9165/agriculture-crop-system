package com.dealers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RECEIPT_DETAILS")
public class Receipt {
	
	@Id
	@Column(name = "RECEIPT_ID")
	private int receiptId;
	
	@Column(name = "FARMER_ID")
	private int farmerId;
	
	@Column(name = "FARMER_PHONE_NUMBER")
	private String farmerPhoneNumber;
	
	@Column(name = "FARMER_ACCOUNT_NUMBER")
	private long farmerAccountNumber;
	
	@Column(name = "DEALER_ID")
	private int dealerId;
	
	@Column(name = "DEALER_PHONE_NUMBER")
	private String dealerPhoneNumber;
	
	@Column(name = "DEALER_ACCOUNT_NUMBER")
	private long dealerAccountNumber;
	
	
	@Column(name = "CROP_ID")
	private int cropId;
	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;
	@Column(name = "BOOKING_ID")
	private int bookingId;
}
