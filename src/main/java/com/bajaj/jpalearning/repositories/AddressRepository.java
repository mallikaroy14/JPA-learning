package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.models.Address;
import com.bajaj.jpalearning.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByCustomer(Customer customer);

}
