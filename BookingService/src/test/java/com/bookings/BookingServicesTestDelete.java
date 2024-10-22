package com.bookings;

import com.bookings.exception.BookingNotFoundException;
import com.bookings.model.Booking;
import com.bookings.repository.BookingRepository;
import com.bookings.service.BookingServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServicesTestDelete {
	
	 @InjectMocks
	    private BookingServices bookingServices;

	    @Mock
	    private BookingRepository bookingRepo;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	
	 @Test
	    void testDeleteBookingWhenExists() {
	        when(bookingRepo.findById(1)).thenReturn(Optional.of(new Booking()));

	        String result = bookingServices.deleteBooking(1);

	        assertEquals("Booking removed from database...!", result);
	        verify(bookingRepo, times(1)).deleteById(1);
	    }

	    @Test
	    void testDeleteBookingWhenNotExists() {
	        when(bookingRepo.findById(1)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(BookingNotFoundException.class, () -> {
	            bookingServices.deleteBooking(1);
	        });

	        assertEquals("Booking for ID: 1 not found in database...!", exception.getMessage());
	    }

	    @Test
	    void testDeleteAllBookings() {
	        String result = bookingServices.deleteBooking();

	        assertEquals("All bookings are removed from database...!", result);
	        verify(bookingRepo, times(1)).deleteAll();
	    }

}

