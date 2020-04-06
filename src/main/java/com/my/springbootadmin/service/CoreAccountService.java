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

    /**
     * 通过姓名，查找用户
     * @param model
     * @return
     */
    CoreAccount selectByName(CoreAccount model);

    /**
     * 通过姓名更新密码
     * @param model
     * @return
     */
    Integer updatePasswordByName(CoreAccount model);
}
