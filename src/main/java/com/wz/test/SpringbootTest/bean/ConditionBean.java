package com.wz.test.SpringbootTest.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-07-07 11:07
 * @Description:
 */
@Component
//@ConditionalOnBean(DataSourceBean.class)
@ConditionalOnBean(name = "dataSourceDev")
public class ConditionBean {

    private String name = "condition";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
