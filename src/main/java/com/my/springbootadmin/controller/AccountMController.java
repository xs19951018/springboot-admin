package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.Account;
import com.my.springbootadmin.service.IAccountMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountM")
public class AccountMController {

    @Autowired
    private IAccountMService accountMService;

    //mybatis  @mapper测试
    @RequestMapping("/findAll")
    public List<Account> findAll(){
        return accountMService.findAll();
    }

    @RequestMapping("/getById")
    public Account getById(@Param("id") int id){
        return accountMService.getAccountById(id);
    }

    @RequestMapping("/save")
    public Integer save(@Param("account") Account account){
        return accountMService.save(account);
    }

    @RequestMapping("/deleteById")
    public Integer deleteById(@Param("id") int id){
        return accountMService.delete(id);
    }

    @RequestMapping("/updateById")
    public Integer updateById(@Param("account") Account account){
        return accountMService.update(account);
    }

    //mybaits  mapper.xml测试
    @RequestMapping("/findAll_M")
    public List<Account> findAll_M(){
        return accountMService.findAll_M();
    }

    @RequestMapping("/saveM")
    public Integer saveM(@Param("account") Account account){
        return accountMService.insert(account);
    }
}
