package com.dealers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealers.model.Dealer;
import com.dealers.service.DealerServicesImpl;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/dealers")
public class DealerController {
	
	@Autowired
	DealerServicesImpl services;
	
	@GetMapping("/showAllDealers")
	public List<Dealer> getDealer(){
		
		return services.getDealer();
	}
	
	@GetMapping("/showDealersById/{id}")
	public Optional<Dealer> getDealer(@Valid @PathVariable int id) {
		
		return services.getDealer(id);
	}
	
	@PostMapping("/addDealers")
	public String addDealer(@Valid @RequestBody Dealer dealer) {
		return services.addDealer(dealer);
		
	}
	
	@PutMapping("/updateDealersById/{id}")
	public String updateDealer(@Valid @PathVariable int id ,@Valid @RequestBody Dealer updatedDealer ) {
		return services.updateDealer(id, updatedDealer);
	}
	
	@DeleteMapping("/deleteDealersById/{id}")
	public String deleteDealer(@Valid @PathVariable int id) {
		
		return services.deleteDealer(id);
	}
	
	@DeleteMapping("/deleteAllDealers")
	public String deleteDealer() {
		return services.deleteDealer();
	}
}
