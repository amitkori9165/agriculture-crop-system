package com.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.admin.model.Crop;
import com.admin.services.AdminCropService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminCropController {

    @Autowired
    private AdminCropService adminCropService;

//	 Endpoint to retrieve all crops
    @GetMapping("/showAllCrops")
    public ResponseEntity<List<Crop>> getAllCrops() {
    	// Call the service layer to fetch the list of crops
        List<Crop> crops = adminCropService.showAllCrops();
        return ResponseEntity.ok(crops);
    }

//	 Endpoint to retrieve crops by name
    @GetMapping("/showCropsByName/{name}")
    public  List<Crop> getCropByName(@PathVariable String name) {
    	// Call the service layer to fetch the list of crops by name
    	return adminCropService.getCropByName(name);
    }

//    @PostMapping("/addCrop")
//    public String addCrop(@Valid @RequestBody Crop crop) {
//        return adminCropService.addCrop(crop);
//    }

//    @PutMapping("/updateCropById/{cropId}")
//    public String updateCrop(@PathVariable int cropId, @Valid @RequestBody Crop updatedCrop) {
//        return adminCropService.updateCrop(cropId, updatedCrop);
////        return ResponseEntity.ok(message);
//    }

//    @DeleteMapping("/deleteCropsById/{cropId}")
//    public String deleteCrop(@PathVariable int cropId) {
//        return adminCropService.deleteCrop(cropId);
//    }

//    @DeleteMapping("/deleteAllCrops")
//    public ResponseEntity<String> deleteAllCrops() {
//        String message = adminCropService.deleteAllCrops();
//        return ResponseEntity.ok(message);
//    }
}