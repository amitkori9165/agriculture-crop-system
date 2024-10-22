package com.farmers.service;

import java.util.List;
import java.util.Optional;

import com.farmers.model.Farmer;

import jakarta.validation.Valid;

public interface FarmerServices {
	
//	For getting the farmers present in database
	public List<Farmer> getFarmer();
	
//	For getting the farmers by id
	public Optional<Farmer> getFarmer(int id);
	
//	For adding new farmer to database	
	public String addFarmer(@Valid Farmer farmer);
	
//	For updating the existing farmer in database
	public String updateFarmer(@Valid int id, @Valid Farmer updatedFarmer);
	
//	For deleting the specific farmer by id
	public String deleteFarmer(int id);
	
//	For deleting all the farmer from the database
	public String deleteFarmer();

}
