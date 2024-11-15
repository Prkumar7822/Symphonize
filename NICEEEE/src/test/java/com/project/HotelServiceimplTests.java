package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.dto.HotelDTO;
import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.repository.CustomerRepository;
import com.project.repository.Hotel_Repository;
import com.project.serviceimplements.HotelServiceImpl;

class HotelServiceImplTests {

    @Mock
    private Hotel_Repository hotelRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddHotel() {
        Hotel_Model hotel = new Hotel_Model();
        hotel.setHotelid(1L);
        hotel.setHotelname("Luxury Inn");
        when(hotelRepository.save(any(Hotel_Model.class))).thenReturn(hotel);

        Hotel_Model result = hotelService.addHotel(hotel);
        assertEquals("Luxury Inn", result.getHotelname());
    }

    @Test
    void testRemoveHotel() {
        String result = hotelService.removeHotel(1L);
        assertEquals("deleted hotel with1Successfully", result);
    }

    @Test
    void testGetHotelById() {
        Hotel_Model hotel = new Hotel_Model();
        hotel.setHotelid(1L);
        hotel.setHotelname("Luxury Inn");
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        Hotel_Model result = hotelService.getHotelById(1L);
        assertEquals("Luxury Inn", result.getHotelname());
    }

    @Test
    void testGetHotelByIdNotFound() {
        when(hotelRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> hotelService.getHotelById(1L));
        assertEquals("Hotel not found", exception.getMessage());
    }

    @Test
    void testFindAll() {
        Hotel_Model hotel1 = new Hotel_Model();
        hotel1.setHotelid(1L);
        hotel1.setHotelname("Luxury Inn");
        hotel1.setHotelAddress("123 Main St");

        Hotel_Model hotel2 = new Hotel_Model();
        hotel2.setHotelid(2L);
        hotel2.setHotelname("Cozy Suites");
        hotel2.setHotelAddress("456 Elm St");

        when(hotelRepository.findAll()).thenReturn(Arrays.asList(hotel1, hotel2));

        List<HotelDTO> result = hotelService.findAll();
        assertEquals(2, result.size());
        assertEquals("Luxury Inn", result.get(0).getHotelName());
    }

   

    @Test
    void testSelectTypeInvalidRoomType() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer_Model()));
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(new Hotel_Model()));

        Exception exception = assertThrows(Mycustomexception.class,
                () -> hotelService.selectType(1L, 1L, "invalidRoom", 2));
        assertEquals("Room type not available", exception.getMessage());
    }

 

    @Test
    void testFoodSelectValidInput() {
        Hotel_Model hotel = new Hotel_Model();
        hotel.setHotelid(1L);
        hotel.setFoodBil(0.0);

        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        String result = hotelService.foodSelect(1L, "chicken curry", 2);
        assertEquals("Item added successfully", result);
    }

    @Test
    void testFoodSelectInvalidItem() {
        Hotel_Model hotel = new Hotel_Model();
        hotel.setHotelid(1L);

        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        Exception exception = assertThrows(Mycustomexception.class,
                () -> hotelService.foodSelect(1L, "invalidFood", 2));
        assertEquals("Item not found", exception.getMessage());
    }

    @Test
    void testFoodSelectInvalidCustomerId() {
        when(hotelRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Mycustomexception.class,
                () -> hotelService.foodSelect(1L, "chicken curry", 2));
        assertEquals("Invalid cid", exception.getMessage());
    }}