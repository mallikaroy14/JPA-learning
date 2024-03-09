package com.bajaj.jpalearning.services;


//only for business login

import com.bajaj.jpalearning.exceptions.EntityAlreadyExistsException;
import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.models.CustomCustomersDetails;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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

    public Customer get(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer;
//            customer.setAddresses(addressRepository.findByCustomer(customer));
        }
        throw new EntityNotFoundException("Customer with this given id not present");
    }

    //create customer with password Encoder

    public Customer create(Customer customer){
        if(customerRepository.findByEmailId(customer.getEmailId()).isEmpty()){
            Customer newCustomer = customerRepository.save(customer);
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            return newCustomer;
        }else{
            throw new EntityAlreadyExistsException("Customer with this email already exists");
        }
    }

//    //post
//    public Customer create(Customer customer) {
//        if (customerRepository.findByEmailId(customer.getEmailId()).isEmpty()) {
//            Customer newCustomer = customerRepository.save(customer);
//            customer.setPassword(null);
//            return newCustomer;
//        } else {
//            throw new EntityAlreadyExistsException("Customer with this email already exists");
//        }
//    }

    //Update customer name by id

    public Customer updateCustomer(Customer customer) {

        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());

        if (customerOptional.isPresent()) {
            customerOptional.get().setName(customer.getName());
            Customer updateCustomer = customerRepository.save(customerOptional.get());
            return updateCustomer;
        } else {
            throw new EntityAlreadyExistsException("Customer with this email already exists");
        }
//        Optional<Customer> customerOptional = customerRepository.updateCustomerById(id, name);
//        return customerOptional;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findByUsername(username);
        if (customerOptional.isEmpty()){
            throw new EntityNotFoundException("Customer Details Exists");
        }
        return new CustomCustomersDetails(customerOptional.get());
    }


    // fetch cart Items
    // fetch ProductId and customersId
    //JWT login

}
