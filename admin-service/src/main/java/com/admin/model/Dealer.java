package com.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealer {

	@Positive(message = "ID must be positive")
	@NotNull(message = "ID cannot be left blank...")
	private int dealerId;

	@NotBlank(message = "Name cannot be left blank...")
	@Size(min = 2, message = "Name should be more than 2 letters...")
	private String dealerName;

	@Pattern(regexp = "\\d{10}", message = "Phone number must contain 10 digits...")
	private String dealerNumber;

	@Pattern(regexp = "^[a-z]{2,}[0-9]{3,}@gmail\\.com$", message = "Please provide valid email")
	private String dealerEmail;

	@NotBlank(message = "Address cannot be left blank")
	private String dealerAddress;

	@NotBlank(message = "Branch cannot be left blank")
	private String dealerBankBranch;

	@NotNull(message = "Account number cannot be left blank...")
	private long dealerAccountNumber;

//	@Column(name = "DEALER_STATUS")
//	private String dealerStatus;

//	private List<Crops> crops;

//	public int getDealerId() {
//		return dealerId;
//	}
//
//	public void setDealerId(int dealerId) {
//		this.dealerId = dealerId;
//	}
//
//	public String getDealerName() {
//		return dealerName;
//	}
//
//	public void setDealerName(String dealerName) {
//		this.dealerName = dealerName;
//	}
//
//	public String getDealerNumber() {
//		return dealerNumber;
//	}
//
//	public void setDealerNumber(String dealerNumber) {
//		this.dealerNumber = dealerNumber;
//	}
//
//	public String getDealerEmail() {
//		return dealerEmail;
//	}
//
//	public void setDealerEmail(String dealerEmail) {
//		this.dealerEmail = dealerEmail;
//	}
//
//	public String getDealerAddress() {
//		return dealerAddress;
//	}
//
//	public void setDealerAddress(String dealerAddress) {
//		this.dealerAddress = dealerAddress;
//	}
//
//	public String getDealerBankBranch() {
//		return dealerBankBranch;
//	}
//
//	public void setDealerBankBranch(String dealerBankBranch) {
//		this.dealerBankBranch = dealerBankBranch;
//	}
//
//	public long getDealerAccountNumber() {
//		return dealerAccountNumber;
//	}
//
//	public void setDealerAccountNumber(long dealerAccountNumber) {
//		this.dealerAccountNumber = dealerAccountNumber;
//	}
//
//	public String getDealerStatus() {
//		return dealerStatus;
//	}
//
//	public void setDealerStatus(String dealerStatus) {
//		this.dealerStatus = dealerStatus;
//	}
//
//	public Dealer(
//			@Positive(message = "ID must be positive") @NotNull(message = "ID cannot be left blank...") int dealerId,
//			@NotBlank(message = "Name cannot be left blank...") @Size(min = 2, message = "Name should be more than 2 letters...") String dealerName,
//			@Pattern(regexp = "\\d{10}", message = "Phone number must contain 10 digits...") String dealerNumber,
//			@Pattern(regexp = "^[a-z]{2,}[0-9]{3,}@gmail\\.com$", message = "Please provide valid email") String dealerEmail,
//			@NotBlank(message = "Address cannot be left blank") String dealerAddress,
//			@NotBlank(message = "Branch cannot be left blank") String dealerBankBranch,
//			@NotNull(message = "Account number cannot be left blank...") long dealerAccountNumber,
//			String dealerStatus) {
//		super();
//		this.dealerId = dealerId;
//		this.dealerName = dealerName;
//		this.dealerNumber = dealerNumber;
//		this.dealerEmail = dealerEmail;
//		this.dealerAddress = dealerAddress;
//		this.dealerBankBranch = dealerBankBranch;
//		this.dealerAccountNumber = dealerAccountNumber;
//		this.dealerStatus = dealerStatus;
//	}
//	
//	public Dealer() {
//		
//	}
}
