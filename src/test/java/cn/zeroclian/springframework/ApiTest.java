package cn.zeroclian.springframework;

import cn.zeroclian.springframework.bean.UserService;
import cn.zeroclian.springframework.context.support.ClassPathXmlApplicationContext;
import cn.zeroclian.springframework.event.CustomEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author Justin
 */
public class ApiTest {

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService01);
        System.out.println(userService02);
        System.out.println(userService01 + " 16进制哈希: " + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：");
        userService.queryUserInfo();
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
