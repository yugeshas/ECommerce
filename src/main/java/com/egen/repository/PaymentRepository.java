package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Payment;

public interface PaymentRepository  extends CrudRepository<Payment, Integer>{

}
