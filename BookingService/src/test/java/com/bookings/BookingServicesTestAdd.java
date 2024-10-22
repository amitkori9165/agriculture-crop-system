package com.bookings;

import com.bookings.exception.BookingAlreadyExistsException;
import com.bookings.exception.BookingNotFoundException;
import com.bookings.model.Booking;
import com.bookings.repository.BookingRepository;
import com.bookings.service.BookingServices;

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

public class BookingServicesTestAdd {
	  @InjectMocks
	    private BookingServices bookingServices;

	    @Mock
	    private BookingRepository bookingRepo;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	
	    @Test
	    void testAddBookingWhenBookingIdNotExists() {
	        Booking booking = new Booking();
	        booking.setBookingId(1);
	        booking.setCropId(1);

	        when(bookingRepo.findById(1)).thenReturn(Optional.empty());
	        when(bookingRepo.findAll()).thenReturn(new ArrayList<>());

	        String result = bookingServices.addBooking(booking);

	        assertEquals("Booking confirm...! with Booking ID: 1", result);
	        verify(bookingRepo, times(1)).save(booking);
	    }

	    @Test
	    void testAddBookingWhenBookingAlreadyExistsById() {
	        Booking booking = new Booking();
	        booking.setBookingId(1);

	        when(bookingRepo.findById(1)).thenReturn(Optional.of(booking));

	        Exception exception = assertThrows(BookingAlreadyExistsException.class, () -> {
	            bookingServices.addBooking(booking);
	        });

	        assertEquals("Booking ID: 1 already present in database...", exception.getMessage());
	    }

	    @Test
	    void testAddBookingWhenBookingAlreadyExistsByCropId() {
	        Booking booking = new Booking();
	        booking.setBookingId(2);
	        booking.setCropId(1);

	        Booking existingBooking = new Booking();
	        existingBooking.setCropId(1);

	        List<Booking> bookingList = new ArrayList<>();
	        bookingList.add(existingBooking);

	        when(bookingRepo.findById(2)).thenReturn(Optional.empty());
	        when(bookingRepo.findAll()).thenReturn(bookingList);

	        Exception exception = assertThrows(BookingAlreadyExistsException.class, () -> {
	            bookingServices.addBooking(booking);
	        });

	        assertEquals("Booking for crop ID: 1 already present in database...!", exception.getMessage());
	    }

	    @Test
	    void testUpdateBookingWhenExists() {
	        Booking updatedBooking = new Booking();
	        updatedBooking.setBookingId(1);

	        when(bookingRepo.findById(1)).thenReturn(Optional.of(new Booking()));

	        String result = bookingServices.updateBooking(1, updatedBooking);

	        assertEquals("Booking updated successfully...!", result);
	        verify(bookingRepo, times(1)).save(updatedBooking);
	    }

	    @Test
	    void testUpdateBookingWhenNotExists() {
	        Booking updatedBooking = new Booking();

	        when(bookingRepo.findById(1)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(BookingNotFoundException.class, () -> {
	            bookingServices.updateBooking(1, updatedBooking);
	        });

	        assertEquals("Booking for ID: 1 not found in database...!", exception.getMessage());
	    }

}

