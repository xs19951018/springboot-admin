package com.my.springbootadmin.service;

import com.my.springbootadmin.model.CoreAccount;

/**
 * 账户service
 */
public interface CoreAccountService {

    /**
     * 通过姓名+密码，查找用户
     * @param model
     * @return
     */
    CoreAccount selectByNameAndPwd(CoreAccount model);
}
