package com.receipt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receipt.model.Receipt;
import com.receipt.services.ReceiptServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
	
	@Autowired
	ReceiptServices services;
	
	
//	 Endpoint to retrieve all receipts
		@GetMapping("/showAllReceipts")
		public List<Receipt> getReceipt(){
			// Call the service layer to fetch the list of receipts
			return services.getReceipt();
		}
		
//		 Endpoint to retrieve receipts by receipts ID
		@GetMapping("/showReceiptsByReceiptId/{receiptId}")
		public Optional<Receipt> getReceiptsByReceiptId(@Valid @PathVariable int receiptId) {
			// Call the service layer to fetch the receipt by ID
			return services.getReceiptByReceiptId(receiptId);
		}
		
//		 Endpoint to generate new  receipt
		@PostMapping("/generateReceipts")
		public String generateReceipt(@Valid @RequestBody Receipt receipt) {
			// Call the service layer to generate receipts
			return services.generateReceipt(receipt);	
		}
		
//		 Endpoint to retrieve receipts by farmer ID
		@GetMapping("/showReceiptsByFarmerId/{farmerId}")
		public List<Receipt> getReceiptsByFarmerId(@Valid @PathVariable int farmerId) {
			// Call the service layer to fetch the receipt by farmer ID
			return services.getReceiptByFarmerId(farmerId);
		}
		
//		 Endpoint to retrieve receipts by dealer ID
		@GetMapping("/showReceiptsByDealerId/{dealerId}")
		public List<Receipt> getReceiptsByDealerId(@Valid @PathVariable int dealerId) {
			// Call the service layer to fetch the receipt by dealer ID
			return services.getReceiptBydealerId(dealerId);
		}
		
		
}
