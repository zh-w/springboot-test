package com.wz.test.SpringbootTest;

import com.wz.test.SpringbootTest.MainApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MainApplication.class})// 指定启动类
public class TestBase {

}

