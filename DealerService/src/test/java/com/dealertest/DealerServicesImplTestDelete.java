package com.dealertest;

import com.dealers.exception.DealerNotFoundException;
import com.dealers.model.Dealer;
import com.dealers.repository.DealerRepository;
import com.dealers.service.DealerServicesImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DealerServicesImplTestDelete {
	@InjectMocks
    private DealerServicesImpl dealerServices;

    @Mock
    private DealerRepository dealerRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testDeleteDealerWhenExists() {
        when(dealerRepo.findById(1)).thenReturn(Optional.of(new Dealer()));

        String result = dealerServices.deleteDealer(1);

        assertEquals("Dealer removed from the database....!", result);
        verify(dealerRepo, times(1)).deleteById(1);
    }

    @Test
    void testDeleteDealerWhenNotExists() {
        when(dealerRepo.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(DealerNotFoundException.class, () -> {
            dealerServices.deleteDealer(1);
        });

        assertEquals("Dealer with ID: 1 is not present in database...!", exception.getMessage());
    }

    @Test
    void testDeleteAllDealers() {
        String result = dealerServices.deleteDealer();

        assertEquals("All Dealers are removed from database...!", result);
        verify(dealerRepo, times(1)).deleteAll();
    }
}

