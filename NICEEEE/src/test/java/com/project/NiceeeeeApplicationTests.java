package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.dto.Customer_dto;
import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.repository.CustomerRepository;
import com.project.service.Customer_Service;
import com.project.serviceimplements.Customer_Serviceimpl;


class NiceeeeeApplicationTests {

    @Mock
    private CustomerRepository repo;

    @InjectMocks
    private Customer_Serviceimpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCust_to_dto() {
        Customer_Model customer = new Customer_Model();
        customer.setCid(1L);
        customer.setCname("John Doe");

        ResponseEntity<Customer_dto> response = service.cust_to_dto(customer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getCid());
        assertEquals("John Doe", response.getBody().getCname());
    }

    @Test
    void testRegisterWithValidData() {
        Customer_Model customer = new Customer_Model();
        customer.setCid(1L);
        customer.setCname("John Doe");
        customer.setCnumber("1234567890");
        customer.setCadharno("123456789012");

        when(repo.save(any(Customer_Model.class))).thenReturn(customer);

        ResponseEntity<Customer_dto> response = service.Register(customer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getCid());
        assertEquals("John Doe", response.getBody().getCname());
    }

    @Test
    void testRegisterWithInvalidPhoneNumber() {
        Customer_Model customer = new Customer_Model();
        customer.setCnumber("1234"); // Invalid phone number

        Exception exception = assertThrows(Mycustomexception.class, () -> service.Register(customer));
        assertEquals("Phone number should contain 10 digits", exception.getMessage());
    }

    @Test
    void testRegisterWithInvalidAadharNumber() {
        Customer_Model customer = new Customer_Model();
        customer.setCnumber("1234567890");
        customer.setCadharno("1234"); // Invalid Aadhar number

        Exception exception = assertThrows(Mycustomexception.class, () -> service.Register(customer));
        assertEquals("Adhar number should contain 12 digits", exception.getMessage());
    }

    @Test
    void testDeleteWithExistingId() {
        Long cid = 1L;
        when(repo.existsById(cid)).thenReturn(true);

        ResponseEntity<String> response = service.Delete(cid);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer deleted succesfully", response.getBody());
//        verify(repo, times(1)).deleteById(cid);
    }

    @Test
    void testDeleteWithNonExistingId() {
        Long cid = 1L;
        when(repo.existsById(cid)).thenReturn(false);

        Exception exception = assertThrows(Mycustomexception.class, () -> service.Delete(cid));
        assertEquals("Customer with " + cid + " is not present", exception.getMessage());
    }

    @Test
    void testUpdateWithExistingId() {
        Long cid = 1L;
        Customer_Model existingCustomer = new Customer_Model();
        existingCustomer.setCid(cid);
        existingCustomer.setCname("Old Name");

        Customer_Model updatedCustomer = new Customer_Model();
        updatedCustomer.setCid(cid);
        updatedCustomer.setCname("New Name");

        when(repo.findById(cid)).thenReturn(Optional.of(existingCustomer));
        when(repo.save(existingCustomer)).thenReturn(updatedCustomer);

        ResponseEntity<Customer_Model> response = service.Update(cid, updatedCustomer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("New Name", response.getBody().getCname());
    }

    @Test
    void testUpdateWithNonExistingId() {
        Long cid = 1L;
        Customer_Model model = new Customer_Model();
        when(repo.findById(cid)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Mycustomexception.class, () -> service.Update(cid, model));
        assertEquals("Customer with ID " + cid + " not found", exception.getMessage());
    }

    @Test
    void testGetcustomerWithExistingId() {
        Long cid = 1L;
        Customer_Model model = new Customer_Model();
        model.setCid(cid);
        model.setCname("John Doe");

        when(repo.findById(cid)).thenReturn(Optional.of(model));

        ResponseEntity<Customer_dto> response = service.Getcustomer(cid);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cid, response.getBody().getCid());
        assertEquals("John Doe", response.getBody().getCname());
    }

    @Test
    void testGetcustomerWithNonExistingId() {
        Long cid = 1L;
        when(repo.findById(cid)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Mycustomexception.class, () -> service.Getcustomer(cid));
        assertEquals("Cid is not present", exception.getMessage());
    }

    @Test
    void testGetcustomers() {
        Customer_Model customer1 = new Customer_Model();
        customer1.setCid(1L);
        customer1.setCname("John Doe");

        Customer_Model customer2 = new Customer_Model();
        customer2.setCid(2L);
        customer2.setCname("Jane Smith");

        when(repo.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        ResponseEntity<List<Customer_dto>> response = service.getcustomers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getCname());
        assertEquals("Jane Smith", response.getBody().get(1).getCname());
    }}