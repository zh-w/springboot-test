package com.wz.test.SpringbootTest.mybatis.mapper;

import com.wz.test.SpringbootTest.mybatis.entity.Account;
import com.wz.test.SpringbootTest.mybatis.entity.MetricKey;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

    Account getAccountById(int id);

    Integer updateAccountById(int id ,double amount);

}
