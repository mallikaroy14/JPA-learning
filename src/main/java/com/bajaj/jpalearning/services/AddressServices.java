package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.models.Address;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServices {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Object create(Address address) {
        Address newAddress = addressRepository.save(address);
        return newAddress;
    }

    public Address get(Long id)
    {
        Optional<Address> customerOptional = addressRepository.findById(id);
        if (customerOptional.isPresent()){
            Address address = customerOptional.get();
            return address;
        }
        throw new EntityNotFoundException("Address with this given id not present");
    }
}
