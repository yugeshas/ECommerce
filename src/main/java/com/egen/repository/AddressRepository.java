package com.egen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.egen.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	
}
