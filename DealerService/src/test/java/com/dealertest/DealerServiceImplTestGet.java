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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class DealerServiceImplTestGet {
	@InjectMocks
    private DealerServicesImpl dealerServices;

    @Mock
    private DealerRepository dealerRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDealerWhenDealersExist() {
        List<Dealer> dealerList = new ArrayList<>();
        dealerList.add(new Dealer()); // Add a mock Dealer

        when(dealerRepo.findAll()).thenReturn(dealerList);

        List<Dealer> result = dealerServices.getDealer();

        assertEquals(1, result.size());
        verify(dealerRepo, times(1)).findAll();
    }

    @Test
    void testGetDealerByIdWhenExists() {
        Dealer dealer = new Dealer();
        dealer.setDealerId(1);

        when(dealerRepo.findById(1)).thenReturn(Optional.of(dealer));

        Optional<Dealer> result = dealerServices.getDealer(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getDealerId());
        verify(dealerRepo, times(1)).findById(1);
    }
    @Test
    void testGetDealerByIdWhenNotExists() {
        when(dealerRepo.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(DealerNotFoundException.class, () -> {
            dealerServices.getDealer(1);
        });

        assertEquals("Dealer with ID: 1 is not present in database...!", exception.getMessage());
    }

}

