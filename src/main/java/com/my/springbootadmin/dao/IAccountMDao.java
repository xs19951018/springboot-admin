package com.my.springbootadmin.dao;

import com.my.springbootadmin.model.Account;

import java.util.List;

public interface IAccountMDao {

    Integer insert(Account model);

    List<Account> findAll();
}
