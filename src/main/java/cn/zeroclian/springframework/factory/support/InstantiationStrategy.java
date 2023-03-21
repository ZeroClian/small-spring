package cn.zeroclian.springframework.factory.support;

import cn.zeroclian.springframework.BeansException;
import cn.zeroclian.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Justin
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
