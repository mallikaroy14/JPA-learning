package com.bajaj.jpalearning.controller;

import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.models.Address;
import com.bajaj.jpalearning.models.CartItems;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.services.AddressServices;
import com.bajaj.jpalearning.services.CartItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart_items")
public class CartItemsController {

    @Autowired
    CartItemsServices cartItemsServices;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CartItems cartItems) {
        Object items = cartItemsServices.create(cartItems);
        if (items != null) {
            return ResponseHandler.createResponse("Items added", HttpStatus.CREATED, items);
        }
        return ResponseHandler.createResponse("Items already exist", HttpStatus.CONFLICT, null);

    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.createResponse("Items found", HttpStatus.OK, cartItemsServices.getAll());

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        CartItems items = cartItemsServices.get(id);
        return ResponseHandler.createResponse("Items Found", HttpStatus.OK, items);
    }

    // Fetch cartItems on the basis of customerID
    @GetMapping("/customer/{customerID}")
    public ResponseEntity<?> getByCustomerID(@PathVariable Long customerID) {
        List<CartItems> items = cartItemsServices.getByCustomerId(customerID);
        return ResponseHandler.createResponse("Items found", HttpStatus.OK, items);
    }


    @GetMapping("/customer_id/{id}")
    public ResponseEntity<?> getByCustomer(@PathVariable Long id) {
        List<Product> products = cartItemsServices.getCustomerCart(id);
        return ResponseHandler.createResponse("Items found", HttpStatus.OK, products);
    }


}
