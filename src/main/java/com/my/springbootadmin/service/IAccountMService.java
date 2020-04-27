package com.my.springbootadmin.service;

import com.my.springbootadmin.model.Account;

import java.util.List;

public interface IAccountMService {

    Integer save(Account model);

    Integer delete(int id);

    Integer update(Account model);

    Account getAccountById(int id);

    List<Account> findAll();

    //mybaits   mapper.xml测试
    Integer insert(Account model);

    List<Account> findAll_M();
}
