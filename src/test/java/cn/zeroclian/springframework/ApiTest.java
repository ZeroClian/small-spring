package cn.zeroclian.springframework;

import cn.zeroclian.springframework.bean.UserService;
import cn.zeroclian.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author Justin
 */
public class ApiTest {

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println("测试结果:" + userService);
    }
}
