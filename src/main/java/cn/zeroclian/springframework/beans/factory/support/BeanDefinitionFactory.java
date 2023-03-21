package cn.zeroclian.springframework.beans.factory.support;

import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;

/**
 * @author Justin
 */
public interface BeanDefinitionFactory {

    /**
     * 向注册表注册 BeanDefinition
     *
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
