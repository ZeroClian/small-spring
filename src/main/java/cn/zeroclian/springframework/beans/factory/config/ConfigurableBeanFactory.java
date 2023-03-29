package cn.zeroclian.springframework.beans.factory.config;

import cn.zeroclian.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author Justin
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
