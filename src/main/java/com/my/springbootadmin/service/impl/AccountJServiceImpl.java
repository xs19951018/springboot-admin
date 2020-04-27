package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.dao.IAccountJDao;
import com.my.springbootadmin.model.Account;
import com.my.springbootadmin.service.IAccountJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountJServiceImpl implements IAccountJService {

    @Autowired
    private IAccountJDao accountJDao;

    @Override
    public Integer save(Account model) {
        return accountJDao.save(model);
    }

    @Override
    public Integer delete(int id) {
        return accountJDao.delete(id);
    }

    @Override
    public Integer update(Account model) {
        return accountJDao.update(model);
    }

    @Override
    public Account getAccountById(int id) {
        return accountJDao.getAccountById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountJDao.findAll();
    }
}
