package cn.zeroclian.springframework;

import cn.hutool.core.io.IoUtil;
import cn.zeroclian.springframework.bean.UserDao;
import cn.zeroclian.springframework.bean.UserService;
import cn.zeroclian.springframework.beans.PropertyValue;
import cn.zeroclian.springframework.beans.PropertyValues;
import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;
import cn.zeroclian.springframework.beans.factory.config.BeanReference;
import cn.zeroclian.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.zeroclian.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.zeroclian.springframework.core.io.DefaultResourceLoader;
import cn.zeroclian.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Justin
 */
public class ApiTest {
    private DefaultResourceLoader resourceLoader;

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3.UserService设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        // 4.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 5.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "Justin");
        System.out.println(userService);
        userService.queryUserInfo();
    }

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/ZeroClian/cloud-coupon/blob/master/README.md");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadDeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);

        userService.queryUserInfo();
    }
}
