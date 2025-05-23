package com.receipt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipt.exceptions.ReceiptAlreadyExistsException;
import com.receipt.exceptions.ReceiptNotFoundException;
import com.receipt.model.Receipt;
import com.receipt.repository.ReceiptRepository;

import jakarta.validation.Valid;

@Service
public class ReceiptServices {
	
	@Autowired
	ReceiptRepository repo;

	public List<Receipt> getReceipt() {
		
		List<Receipt> ReceiptList = repo.findAll();
		if(ReceiptList.isEmpty()) {
			throw new ReceiptNotFoundException("No Receipts found in database...!");
		}
		return ReceiptList; 
	}

	public Optional<Receipt> getReceiptByReceiptId(@Valid int receiptId) {
		 
		Optional<Receipt> receipt = repo.findById(receiptId);

		if (receipt.isEmpty()) {
			throw new ReceiptNotFoundException("Receipt with ID: " + receiptId + " is not present in database...!");
		}

		return receipt;
	}

	public String generateReceipt(@Valid Receipt receipt) {
		
		List<Receipt> receiptsList = repo.findAll();

		for (Receipt temp : receiptsList) {
			if (temp.getReceiptId() == receipt.getReceiptId()) {
				throw new ReceiptAlreadyExistsException(
						"Receipt with ID: " + receipt.getReceiptId() + " is already present in database...!");
			}
		}

		repo.save(receipt);
		return "Receipt generated successfully...! Receipt ID: "+receipt.getReceiptId();
	}

	public List<Receipt> getReceiptByFarmerId(@Valid int farmerId) {
		 
		List<Receipt> receiptsList = repo.getReceiptByFarmerId(farmerId);
		if(receiptsList.isEmpty()) {
			throw new ReceiptNotFoundException("No Receipts found with farmer ID: "+farmerId);
		}
		return receiptsList;
	}

	public List<Receipt> getReceiptBydealerId(@Valid int dealerId) {
		 
		List<Receipt> receiptsList = repo.getReceiptByDealerId(dealerId);
		if(receiptsList.isEmpty()) {
			throw new ReceiptNotFoundException("No Receipts found with dealer ID: "+dealerId);
		}
		return receiptsList;
	}
}
