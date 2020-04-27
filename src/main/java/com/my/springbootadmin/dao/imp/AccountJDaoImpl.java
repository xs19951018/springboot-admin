package com.my.springbootadmin.dao.imp;

import com.my.springbootadmin.dao.IAccountJDao;
import com.my.springbootadmin.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository("accountJDao")
public class AccountJDaoImpl implements IAccountJDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer save(Account model) {
        return jdbcTemplate.update("insert into account(id,user_code,user_name,password) values(?,?,?,?)",
                model.getId(), model.getUserCode(), model.getUserName(), model.getPassword());
    }

    @Override
    public Integer delete(int id) {
        return jdbcTemplate.update("delete from account where id=?", id);
    }

    @Override
    public Integer update(Account model) {
        return jdbcTemplate.update("update account set user_code=?,password=?",
                model.getUserCode(), model.getPassword());
    }

    @Override
    public Account getAccountById(int id) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id=?",
                new Object[]{id}, new BeanPropertyRowMapper(Account.class));
        if(!CollectionUtils.isEmpty(accountList)){
            return accountList.get(0);
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account",
                new Object[]{}, new BeanPropertyRowMapper(Account.class));
    }
}
