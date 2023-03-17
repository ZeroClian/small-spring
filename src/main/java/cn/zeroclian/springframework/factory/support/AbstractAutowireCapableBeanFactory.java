package cn.zeroclian.springframework.factory.support;

import cn.zeroclian.springframework.BeansException;
import cn.zeroclian.springframework.factory.config.BeanDefinition;

/**
 * @author Justin
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(name, bean);
        return bean;
    }
}
