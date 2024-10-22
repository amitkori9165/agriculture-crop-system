package com.cropstest;

import com.crops.exception.CropAlreadyExistsException;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CropServiceTestAdd {
	
	@InjectMocks
    private CropServices cropServices;

    @Mock
    private CropRepository cropRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddCropWhenNotExists() {
        Crop crop = new Crop();
        crop.setCropId(1);

        when(cropRepo.findAll()).thenReturn(new ArrayList<>());

        String result = cropServices.addCrop(crop);

        assertEquals("Crop added successfully...!", result);
        verify(cropRepo, times(1)).save(crop);
    }

    @Test
    void testAddCropWhenAlreadyExists() {
        Crop crop = new Crop();
        crop.setCropId(1);
        List<Crop> cropList = new ArrayList<>();
        cropList.add(crop);

        when(cropRepo.findAll()).thenReturn(cropList);

        Exception exception = assertThrows(CropAlreadyExistsException.class, () -> {
            cropServices.addCrop(crop);
        });

        assertEquals("Crop with ID: 1 already present is database...!", exception.getMessage());
    }

    @Test
    void testUpdateCropWhenCropExists() {
        Crop existingCrop = new Crop();
        existingCrop.setCropName("Wheat");

        Crop updatedCrop = new Crop();
        updatedCrop.setCropName("Rice");

        when(cropRepo.findAll()).thenReturn(List.of(existingCrop));

        String result = cropServices.updateCrop("Wheat", updatedCrop);

        assertEquals("Crop updated successfully...!", result);
        verify(cropRepo, times(1)).save(updatedCrop);
    }
    @Test
    void testUpdateCropWhenCropNotFound() {
        Crop updatedCrop = new Crop();

        when(cropRepo.findAll()).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(CropNotFoundException.class, () -> {
            cropServices.updateCrop("Corn", updatedCrop);
        });

        assertEquals("Crop : Corn not found in database...!", exception.getMessage());
    }
}

