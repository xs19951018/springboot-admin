package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.Account;
import com.my.springbootadmin.service.IAccountJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountJService accountService;

    @RequestMapping("/findAll")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @RequestMapping("/getById")
    public Account getById(@Param("id") int id){
        return accountService.getAccountById(id);
    }

    @RequestMapping("/save")
    public Integer save(@Param("account") Account account){
        return accountService.save(account);
    }

    @RequestMapping("/deleteById")
    public Integer deleteById(@Param("id") int id){
        return accountService.delete(id);
    }

    @RequestMapping("/updateById")
    public Integer updateById(@Param("account") Account account){
        return accountService.update(account);
    }
}
