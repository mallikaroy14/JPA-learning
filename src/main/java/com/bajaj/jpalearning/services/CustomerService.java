package com.bajaj.jpalearning.services;


//only for business login

import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

//    public getCustomerById(id){
//        Optional<Customer> customer = customerRepository.findById(id);
////
////        if (customer.isPresent()) {
////            return customer.get();
////        } else {
////            return "Customer not found";
////        }
//    }


    public Optional<Customer> get(Long id) {
        return customerRepository.findById(id);
    }

    //post
    public Object create(Customer customer) {
        if (customerRepository.findByEmailId(customer.getEmailId()).isEmpty()) {
            Customer newCustomer =  customerRepository.save(customer);
            customer.setPassword(null);
            return newCustomer;
        }else {
            return null;
        }
    }
}
