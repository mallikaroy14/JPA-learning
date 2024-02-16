package com.bajaj.jpalearning.controller;

import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.models.Address;
import com.bajaj.jpalearning.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    AddressServices addressServices;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Address address) {
        Object address1 = addressServices.create(address);
        if (address1 != null) {
            return ResponseHandler.createResponse("Address added", HttpStatus.CREATED, address1);
        }
        return ResponseHandler.createResponse("Address already exist", HttpStatus.CONFLICT, null);

    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.createResponse("Address found", HttpStatus.OK, addressServices.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Address address = addressServices.get(id);
        return ResponseHandler.createResponse("Customer Found", HttpStatus.OK, address);
    }
}
