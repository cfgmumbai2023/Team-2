package com.mastercard.mdes.ecom.controller;

import com.mastercard.mdes.ecom.model.Customer;
import com.mastercard.mdes.ecom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customerAPI")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomerDetails")
    public ResponseEntity<String> saveCustomerDetails(@RequestBody Customer customer){
        if(customerService.saveCustomer(customer)) {
            return new ResponseEntity<String>("Customer details saved successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred while adding customer details",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modifyCustomerDetails")
    public ResponseEntity<String> modifyCustomerDetails(@RequestBody Customer customer){
        if(customerService.modifyCustomer(customer)){
            return new ResponseEntity<String>("Customer details modified successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error occurred while modifying customer details",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = null;
        customerList = customerService.getAllCustomers();
        if(customerList==null){
            return new ResponseEntity<List<Customer>>(customerList,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
        }
    }

    @GetMapping("/getCustomerByTd/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("customerId") String customerId){
        Optional<Customer> customerDetailsById = null;
        customerDetailsById = customerService.getCustomerById(customerId);
        if(customerDetailsById == null){
            return new ResponseEntity<Optional<Customer>>(customerDetailsById,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<Optional<Customer>>(customerDetailsById,HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteCustomerDetails/{customerId}")
    public ResponseEntity<String> deleteCustomerDetails(String customerId){
        if(customerService.deleteCustomerDetails(customerId)){
            return new ResponseEntity<String>("Customer details modified successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error occurred while modifying customer details",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
