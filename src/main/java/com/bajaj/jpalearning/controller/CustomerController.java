package com.bajaj.jpalearning.controller;

import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.models.AuthRequest;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.services.CustomerService;
import com.bajaj.jpalearning.services.JWTServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTServices jwtServices;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService = new CustomerService();



//    @GetMapping("/customers")
//    public String getCustomers() { // method name should be starts from get
//
//        return "This is a customer Api call";
//    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.createResponse("Customer found", HttpStatus.OK, customerService.getAll());
    }

//    @GetMapping("/{id}")
//    public Object getCustomersById(@PathVariable Long id){
//        customerRepository.deleteById(Long id);
//        return "";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Customer customer = customerService.get(id);
        return ResponseHandler.createResponse("Customer Found", HttpStatus.OK, customer);
    }

    @PostMapping("/")
    public Object create(@RequestBody Customer customer) {
        Object customer1 = customerService.create(customer);
        return ResponseHandler.createResponse("Found", HttpStatus.CREATED, customer1);
    }

    @PutMapping("/updateCustomer")
    public Object update(@RequestBody Customer customer) {
        Object customer1 = customerService.updateCustomer(customer);
        return ResponseHandler.createResponse("Customer name updated", HttpStatus.OK, customer1);
    }

//    @GetMapping("/customers/{id}") // id is variable that's why it should be in {}
//    public Object getCustomerByItsId(@PathVariable Long id) {
//
//        Optional<Customer> customer = customerRepository.findById(id);
//
//        if (customer.isPresent()) {
//            return customer.get();
//        } else {
//            return "Customer not found";
//        }
//    }
//
//    @DeleteMapping("/customers/{id}")
//    public String deleteCustomer(@PathVariable Long id) {
//        customerRepository.deleteById(id);
//        return "Customer deleted";
//    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtServices.generateToken(authRequest.getUsername());
        } else {
            return "Something went wrong";
        }

    }
}
