package cn.zeroclian.springframework.common;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.PropertyValue;
import cn.zeroclian.springframework.beans.PropertyValues;
import cn.zeroclian.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;
import cn.zeroclian.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author Justin
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为:字节跳动"));
    }
}
