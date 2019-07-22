package com.wz.test.SpringbootTest;

import com.wz.test.SpringbootTest.aop.ApplicationBean;
import com.wz.test.SpringbootTest.bean.BeanUser;
import com.wz.test.SpringbootTest.bean.ConditionBean;
import com.wz.test.SpringbootTest.bean.DataSourceBean;
import com.wz.test.SpringbootTest.bean.SimpleBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
//@EnableCaching
//@MapperScan("com.wz.test.SpringbootTest.mybatis.mapper")
//@ImportResource("classpath:beanConfig.xml")
//@EnableAutoConfiguration
//@ComponentScan
@EnableAspectJAutoProxy
public class MainApplication {

   // @RequestMapping("/")
    String home(){
        return "hello！zabbix";
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class,args);
 //       SimpleBean sb1 = (SimpleBean) ctx.getBean("simpleB1");
//        SimpleBean sb2 = (SimpleBean) ctx.getBean("simpleB3");
//        SimpleBean sb3 = (SimpleBean) ctx.getBean("simpleB2");
//        SimpleBean sb4 = (SimpleBean) ctx.getBean("simpleB2");
//
//        System.out.println(sb1.name);
//        System.out.println(sb2.name);
//        System.out.println(sb3.name);
//        System.out.println(sb1==sb2);
//        System.out.println(sb1==sb3);
//        System.out.println(sb3==sb4);

//        SimpleBean sbxml = (SimpleBean) ctx.getBean("simpleXmlBean");
//        System.out.println(sbxml.name);
//        System.out.println(sbxml.getAge());
//        BeanUser beanUser = (BeanUser) ctx.getBean(BeanUser.class);
//        beanUser.init();
//
//        DataSourceBean dataSourceBean = ctx.getBean(DataSourceBean.class);
//        System.out.println(dataSourceBean.getEnv());
//
//        ConditionBean conditionBean = ctx.getBean(ConditionBean.class);
//        System.out.println(conditionBean.getName());

        ApplicationBean applicationBean = ctx.getBean(ApplicationBean.class);
        applicationBean.watchMove();

        ctx.close();
    }
}
