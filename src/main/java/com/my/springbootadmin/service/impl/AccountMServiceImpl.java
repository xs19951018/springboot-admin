package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.dao.IAccountMDao;
import com.my.springbootadmin.dao.IAccountMapper;
import com.my.springbootadmin.model.Account;
import com.my.springbootadmin.service.IAccountMService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountMServiceImpl implements IAccountMService {

    @Resource
    private IAccountMapper accountMapper;
    @Resource
    private IAccountMDao accountMDao;

    @Override
    public Integer save(Account model) {
        return accountMapper.save(model);
    }

    @Override
    public Integer delete(int id) {
        return accountMapper.delete(id);
    }

    @Override
    public Integer update(Account model) {
        return accountMapper.update(model);
    }

    @Override
    public Account getAccountById(int id) {
        return accountMapper.getAccountById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public Integer insert(Account model) {
        return accountMDao.insert(model);
    }

    @Override
    public List<Account> findAll_M() {
        return accountMDao.findAll();
    }
}
