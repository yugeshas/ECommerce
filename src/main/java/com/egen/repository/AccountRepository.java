package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Account;

public interface AccountRepository  extends CrudRepository<Account, Integer>{

}
