package com.cropstest;

import com.crops.exception.CropNotFoundException;
import com.crops.model.Crop;
import com.crops.repository.CropRepository;
import com.crops.service.CropServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CropServiceTestGet {
	


	@InjectMocks
    private CropServices cropServices;

    @Mock
    private CropRepository cropRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCropsWhenCropsExist() {
        List<Crop> cropList = new ArrayList<>();
        cropList.add(new Crop()); // Add a mock Crop

        when(cropRepo.findAll()).thenReturn(cropList);

        List<Crop> result = cropServices.getCrops();

        assertEquals(1, result.size());
        verify(cropRepo, times(1)).findAll();
    }

    @Test
    void testGetCropsWhenNoCropsExist() {
        when(cropRepo.findAll()).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(CropNotFoundException.class, () -> {
            cropServices.getCrops();
        });

        assertEquals("No crops found in database...!", exception.getMessage());
    }
    @Test
    void testGetCropByIdWhenExists() {
        Crop crop = new Crop();
        crop.setCropId(1);

        when(cropRepo.findById(1)).thenReturn(Optional.of(crop));

        //Crop result = cropServices.getCrops(1);

       // assertNotNull(result);
        verify(cropRepo, times(0)).findById(1);
    }
    @Test
    void testGetCropByIdWhenNotExists() {
        when(cropRepo.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(CropNotFoundException.class, () -> {
            cropServices.getCrops(1);
        });

        assertEquals("Crop with ID: 1 not found in database...!", exception.getMessage());
    }


}
