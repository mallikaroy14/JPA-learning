package com.bajaj.jpalearning.repositories;


import com.bajaj.jpalearning.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmailId(String emailId); // function parameter should be same as property name of column

    Optional<Customer> findByUsername(String username);
    Optional<Customer> findByEmailIdAndAge(String emailId, int age);

    List<Customer> findByEmailIdOrAge(String emailId, int age);

    @Query("Select c from Customer c where c.name = ?1 and c.age = ?2")
    List<Customer> findCustomers(String name, int age);

//    @Query("UPDATE Customer c set c.name = ?2 where c.id = ?1")
//    Optional<Customer> updateCustomerById( Long id, String name);

}