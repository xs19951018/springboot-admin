package com.my.springbootadmin.dao;

import com.my.springbootadmin.model.Account;

import java.util.List;

public interface IAccountJDao {

    Integer save(Account model);

    Integer delete(int id);

    Integer update(Account model);

    Account getAccountById(int id);

    List<Account> findAll();
}
