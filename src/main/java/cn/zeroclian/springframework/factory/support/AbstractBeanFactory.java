package cn.zeroclian.springframework.factory.support;

import cn.zeroclian.springframework.BeansException;
import cn.zeroclian.springframework.factory.BeanFactory;
import cn.zeroclian.springframework.factory.config.BeanDefinition;

/**
 * @author Justin
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;
}
