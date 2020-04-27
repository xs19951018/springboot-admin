package com.my.springbootadmin.dao;

import com.my.springbootadmin.model.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAccountMapper {

    @Insert("insert into account(id,user_code,user_name,password,telphone) " +
            "values(#{id},#{userCode},#{userName},#{password},#{telphone})")
    Integer save(Account account);

    @Delete("delete from account where id=#{id}")
    Integer delete(int id);

    @Update("update account set user_code=#{userCode},password=#{password} where id=#{id}")
    Integer update(Account account);

    @Select("select * from account where id=#{id}")
    Account getAccountById(int id);

    @Select("select * from account")
    List<Account> findAll();
}
