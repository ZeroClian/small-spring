package cn.zeroclian.springframework;

import cn.zeroclian.springframework.Bean.UserService;
import cn.zeroclian.springframework.factory.config.BeanDefinition;
import cn.zeroclian.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author Justin
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService);
        userService.queryUserInfo();

        //4.第二次获取
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        System.out.println(userService);
        userService_singleton.queryUserInfo();
    }
}
