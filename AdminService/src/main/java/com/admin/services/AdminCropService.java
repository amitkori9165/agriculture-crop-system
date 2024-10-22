package com.admin.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.admin.exception.CropAlreadyExistsException;
import com.admin.exception.CropNotFoundException;
import com.admin.exception.FarmerNotFoundException;
import com.admin.model.Crop;
import com.admin.model.Farmer;

import jakarta.validation.Valid;

@Service
public class AdminCropService {

	@Autowired
	RestTemplate rest;
	final String ROOT_URI1 = "http://localhost:8080/crops";
	final String ROOT_URI2 = "http://localhost:8080/farmers";

	public List<Crop> showAllCrops() {

		Crop[] cropArray = rest.getForEntity(ROOT_URI1 + "/showAllCrops", Crop[].class).getBody();
		List<Crop> cropList = Arrays.asList(cropArray);
		if (cropList.isEmpty()) {
			throw new CropNotFoundException("No crops found in database...!");
		}
		return cropList;
	}

	public List<Crop> getCropByName(String cropName) {
//        Crop crop = rest.getForObject(ROOT_URL1+"/showCropsByName/"+cropName, Crop.class);
//        if (crop != null) {
//            return Optional.of(crop);
//        } else {
//            throw new CropNotFoundException("Crop: " + cropName + " not found in database...!");
//        }

		Crop[] cropArray = rest.getForEntity(ROOT_URI1 + "/showCropsByName/" + cropName, Crop[].class).getBody();
		List<Crop> cropList = Arrays.asList(cropArray);
		if (cropList.isEmpty()) {
			throw new CropNotFoundException("No crops found by name: " + cropName);
		}
		return cropList;
	}

	public String addCrop(@Valid Crop crop) {

//    	validate crop id and farmer id

//    	Farmer[] farmerArr = rest.getForEntity(ROOT_URL2 + "/showAllFarmers",Farmer[].class).getBody();
		Farmer farmer = rest.getForEntity(ROOT_URI2 + "/showFarmersById/" + crop.getFarmerId(), Farmer.class).getBody();
		if (farmer == null) {
			throw new FarmerNotFoundException("Farmer with ID: " + crop.getFarmerId() + " not found is database...!");
		}

		Crop[] cropArr = rest.getForEntity(ROOT_URI1 + "/showAllCrops", Crop[].class).getBody();
		List<Crop> crops = Arrays.asList(cropArr);
		
		for (Crop c : crops) {
			if (c.getCropId() == crop.getCropId()) {
				throw new CropAlreadyExistsException(
						"Crop with ID: " + crop.getCropId() + " already present in database...!");
			}
		}

//		rest.postForEntity(ROOT_URI1 + "/addCrops", crop, Crop.class);
		rest.postForLocation(ROOT_URI1 +"/addCrops", crop,Crop.class);
		return "Crop added successfully...!";
	}

	public String updateCrop(int cropId, @Valid Crop updatedCrop) {
//        Optional<Crop> existingCrop = getCropByName(cropName);
//        if (existingCrop.isPresent()) {
//            rest.put(ROOT_URL1+"/updateCropsByName"+cropName, updatedCrop);
//            return "Crop updated successfully...!";
//        } else {
//            throw new CropNotFoundException("Crop: " + cropName + " not found in database...!");
//        }
		Crop crop = rest.getForEntity(ROOT_URI1 + "/showCropsById/" + cropId, Crop.class).getBody();
		if (crop == null) {
			throw new CropNotFoundException(
					"No crop found by ID: " +cropId);
		}

		rest.put(ROOT_URI1 + "/updateCropsById/" + cropId, updatedCrop);
		return "Crop updated successfully...!";

	}
//
    public String deleteCrop(int cropId) {
//        Optional<Crop> existingCrop = getCropByName(cropName);
//        if (existingCrop.isPresent()) {
//            rest.delete(ROOT_URL1+"/deleteCropsByName/"+cropName);
//            return "Crop deleted successfully...!";
//        } else {
//            throw new CropNotFoundException("Crop: " + cropName + " not found in database...!");
//        }
    	Crop crop = rest.getForEntity(ROOT_URI1 + "/showCropsById/" + cropId, Crop.class).getBody();
		if (crop == null) {
			throw new CropNotFoundException(
					"No crop found by ID: " +cropId);
		}
		rest.delete(ROOT_URI1 +"/deleteCropsById/"+cropId);
		return "Crop deleted successfully...!";
    	
    }

    public String deleteAllCrops() {
        rest.delete(ROOT_URI1+"/deleteAllCrops");
        return "All crops removed from database...!";
    }
}