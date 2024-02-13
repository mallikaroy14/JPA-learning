package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
