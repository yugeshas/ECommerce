package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Orders;

public interface OrderRepository  extends CrudRepository<Orders, Integer>{

}
