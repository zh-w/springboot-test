package com.wz.test.SpringbootTest.mybatis;

import com.wz.test.SpringbootTest.mybatis.entity.Account;
import com.wz.test.SpringbootTest.mybatis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
public class MybatisDemo {

    @Autowired
    private TestMapper  mapper;

    @Transactional
    public void transfer(int a, int b, double amount){

        Account accountA = mapper.getAccountById(a);

        Account accountB = mapper.getAccountById(b);

        mapper.updateAccountById(a,accountA.getAccount()-amount);

        mapper.updateAccountById(b,accountB.getAccount()+amount);

    }
}
