package com.dealertest;

import com.dealers.exception.DealerAlreadyExistsException;
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

public class DealerServiceImplTestAdd {
	@InjectMocks
    private DealerServicesImpl dealerServices;

    @Mock
    private DealerRepository dealerRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	    
    @Test
    void testAddDealerWhenNotExists() {
        Dealer dealer = new Dealer();
        dealer.setDealerId(1);

        when(dealerRepo.findAll()).thenReturn(new ArrayList<>());

        String result = dealerServices.addDealer(dealer);

        assertEquals("Dealer added successfully...!", result);
        verify(dealerRepo, times(1)).save(dealer);
    }

    @Test
    void testAddDealerWhenAlreadyExists() {
        Dealer dealer = new Dealer();
        dealer.setDealerId(1);
        List<Dealer> dealerList = new ArrayList<>();
        dealerList.add(dealer);

        when(dealerRepo.findAll()).thenReturn(dealerList);

        Exception exception = assertThrows(DealerAlreadyExistsException.class, () -> {
            dealerServices.addDealer(dealer);
        });

        assertEquals("Dealer with ID: 1 is already present in database...!", exception.getMessage());
    }

    @Test
    void testUpdateDealerWhenExists() {
        Dealer updatedDealer = new Dealer();
        updatedDealer.setDealerId(1);

        when(dealerRepo.findById(1)).thenReturn(Optional.of(new Dealer()));

        String result = dealerServices.updateDealer(1, updatedDealer);

        assertEquals("Dealer updated successfully...!", result);
        verify(dealerRepo, times(1)).save(updatedDealer);
    }

    @Test
    void testUpdateDealerWhenNotExists() {
        Dealer updatedDealer = new Dealer();

        when(dealerRepo.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(DealerNotFoundException.class, () -> {
            dealerServices.updateDealer(1, updatedDealer);
        });

        assertEquals("Dealer with ID: 1 is not present in database...!", exception.getMessage());
    }
}

