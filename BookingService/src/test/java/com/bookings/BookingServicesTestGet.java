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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServicesTestGet {
	@InjectMocks
    private BookingServices bookingServices;

    @Mock
    private BookingRepository bookingRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookingsWhenBookingsExist() {
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking()); // Add a mock Booking

        when(bookingRepo.findAll()).thenReturn(bookingList);

        List<Booking> result = bookingServices.getBookings();

        assertEquals(1, result.size());
        verify(bookingRepo, times(1)).findAll();
    }

    @Test
    void testGetBookingsWhenNoBookingsExist() {
        when(bookingRepo.findAll()).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(BookingNotFoundException.class, () -> {
            bookingServices.getBookings();
        });

        assertEquals("No bookings found in database...!", exception.getMessage());
    }

    @Test
    void testGetBookingsByIdWhenExists() {
        Booking booking = new Booking();
        booking.setBookingId(1);

        when(bookingRepo.findById(1)).thenReturn(Optional.of(booking));

        Optional<Booking> result = bookingServices.getBookings(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getBookingId());
        verify(bookingRepo, times(1)).findById(1);
    }

    @Test
    void testGetBookingsByIdWhenNotExists() {
        when(bookingRepo.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(BookingNotFoundException.class, () -> {
            bookingServices.getBookings(1);
        });

        assertEquals("Booking with ID: 1 not found in database...!", exception.getMessage());
    }
}

