package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.repository.CoreAccountRepository;
import com.my.springbootadmin.service.CoreAccountService;
import com.my.springbootadmin.service.CoreTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CoreAccountServiceImp implements CoreAccountService {

    @Autowired
    private CoreAccountRepository accountRepository;

    @Override
    public CoreAccount selectByNameAndPwd(CoreAccount model) {
        return accountRepository.findByCaUserNameAndCaPassword(model.getCaUserName(),
                model.getCaPassword());
    }

    @Override
    public CoreAccount selectByName(CoreAccount model) {
        return accountRepository.findByCaUserName(model.getCaUserName());
    }

    @Transactional
    @Override
    public Integer updatePasswordByName(CoreAccount model) {
        return accountRepository.updatePasswordByName(model.getCaPassword(), model.getCaUserName());
    }

}
