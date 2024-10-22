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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CropServiceTestDelete {
	
	@InjectMocks
    private CropServices cropServices;

    @Mock
    private CropRepository cropRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteCropWhenCropExists() {
        Crop crop = new Crop();
        crop.setCropName("Corn");

        when(cropRepo.getCropByName("Corn")).thenReturn(List.of(crop));

        String result = cropServices.delete("Corn");

        assertEquals("Crop deleted successfully...!", result);
        verify(cropRepo, times(1)).deleteCropByName("Corn");
    }

    @Test
    void testDeleteCropWhenCropNotFound() {
        when(cropRepo.getCropByName("Corn")).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(CropNotFoundException.class, () -> {
            cropServices.delete("Corn");
        });

        assertEquals("Crop : Corn not found in database...!", exception.getMessage());
    }
    @Test
    void testDeleteAllCrops() {
        String result = cropServices.delete();

        assertEquals("All crops removed from database...!", result);
        verify(cropRepo, times(1)).deleteAll();
    }
	
}

