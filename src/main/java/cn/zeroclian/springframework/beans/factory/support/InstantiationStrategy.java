package cn.zeroclian.springframework.beans.factory.support;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Justin
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
