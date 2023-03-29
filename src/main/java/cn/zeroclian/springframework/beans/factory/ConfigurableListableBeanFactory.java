package cn.zeroclian.springframework.beans.factory;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;
import cn.zeroclian.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author Justin
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
