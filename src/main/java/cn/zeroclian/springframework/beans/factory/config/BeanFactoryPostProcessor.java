package cn.zeroclian.springframework.beans.factory.config;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author Justin
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
