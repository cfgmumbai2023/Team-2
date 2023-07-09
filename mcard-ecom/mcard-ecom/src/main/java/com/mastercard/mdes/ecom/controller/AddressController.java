package com.mastercard.mdes.ecom.controller;

import com.mastercard.mdes.ecom.model.Address;
import com.mastercard.mdes.ecom.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressAPI")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public ResponseEntity<String> addAddress(@RequestBody Address address){
        if(addressService.addAddress(address)){
            return new ResponseEntity<String>("Address details saved successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred while adding address details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<String> updateAddress(@RequestBody Address address){
        if(addressService.updateAddress(address)){
            return new ResponseEntity<String>("Address details updated successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred while updating address details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAddressByCustomerId/{customerId}")
    public ResponseEntity<List<Address>> getAddressByCustomerId(@PathVariable("customerId") String customerId){
        List<Address> addressList = addressService.getAddressByCustomerId(customerId);
        if(addressList==null){
            return new ResponseEntity<List<Address>>(addressList,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<List<Address>>(addressList,HttpStatus.OK);
        }
    }
    @GetMapping("/getAddressByAddressId/{addressId}")
    public ResponseEntity<Address> getAddressByAddressId(@PathVariable("addressId") String addressId){
        Address address = addressService.getAddressByAddressId(addressId);
        if(address==null){
            return new ResponseEntity<Address>(address,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<Address>(address,HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteAddressByCustomerId/{customerId}")
    public ResponseEntity<String> deleteAddressByCustomerId(@PathVariable("customerId") String customerId){
        if(addressService.deleteAddressByCustomerId(customerId)){
            return new ResponseEntity<String>("Address details deleted with CustId successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error occurred while deleting address details with CustId",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("deleteAddressByAddressId/{addressId}")
    public ResponseEntity<String> deleteAddressByAddressId(@PathVariable("addressId") String addressId){
        if(addressService.deleteAddressByAddressId(addressId)){
            return new ResponseEntity<String>("Address details deleted with addressId successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error occurred while deleting address details with addressId",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
