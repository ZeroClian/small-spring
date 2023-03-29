package cn.zeroclian.springframework;

import cn.zeroclian.springframework.bean.UserService;
import cn.zeroclian.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.zeroclian.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.zeroclian.springframework.common.MyBeanFactoryPostProcessor;
import cn.zeroclian.springframework.common.MyBeanPostProcessor;
import cn.zeroclian.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author Justin
 */
public class ApiTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadDeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println("测试结果:" + userService);
    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println("测试结果:" + userService);
    }
}
