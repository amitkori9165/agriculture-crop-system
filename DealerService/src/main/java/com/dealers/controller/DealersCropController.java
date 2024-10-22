package com.dealers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealers.model.DealersCrop;
import com.dealers.service.DealersCropServices;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dealers")
public class DealersCropController {
	
	@Autowired
	DealersCropServices services;
	
//	 Endpoint to retrieve all crops
	@GetMapping("/showAllCrops")
	public List<DealersCrop> getCrops(){
		// Call the service layer to fetch the list of crops
		return services.getCrops();			
	}
	
//	 Endpoint to retrieve crops by name
	@GetMapping("/showCropsByName/{cropName}")
	public List<DealersCrop> getCrops(@PathVariable String cropName) {
		// Call the service layer to fetch the list of crops by name
		return services.getCrops(cropName);
	}
}
