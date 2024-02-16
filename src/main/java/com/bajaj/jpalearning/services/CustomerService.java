package com.bajaj.jpalearning.services;


//only for business login

import com.bajaj.jpalearning.exceptions.EntityAlreadyExistsException;
import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

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


//    public Customer get(Long id)
//    {
//        Optional<Customer> customer= customerRepository.findById(id);
//        if (customer.isPresent()){
//          return customer.get();
//        }
//        throw new CustomerNotFoundException("Customer with this given id not present");
//    }

    public Customer get(Long id)
    {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            return customer;
//            customer.setAddresses(addressRepository.findByCustomer(customer));
        }
        throw new EntityNotFoundException("Customer with this given id not present");
    }

    //post
    public Customer create(Customer customer) {
        if (customerRepository.findByEmailId(customer.getEmailId()).isEmpty()) {
            Customer newCustomer =  customerRepository.save(customer);
            customer.setPassword(null);
            return newCustomer;
        }else {
            throw new EntityAlreadyExistsException("Customer with this email already exists");
        }
    }


    // fetch cart Items
    // fetch ProductId and customersId

}
