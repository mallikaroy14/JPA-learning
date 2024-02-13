package com.bajaj.jpalearning.controller;

import com.bajaj.jpalearning.CustomerRepository;
import com.bajaj.jpalearning.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

//    @GetMapping("/customers")
//    public String getCustomers() { // method name should be starts from get
//
//        return "This is a customer Api call";
//    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}") // id is variable that's why it should be in {}
    public Object getCustomerByItsId(@PathVariable Long id) {

        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        } else {
            return "Customer not found";
        }
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return "Customer deleted";
    }

}
