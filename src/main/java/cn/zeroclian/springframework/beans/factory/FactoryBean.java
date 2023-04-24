package cn.zeroclian.springframework.beans.factory;

import cn.zeroclian.springframework.beans.BeansException;

/**
 * @author Justin
 */
public interface FactoryBean<T> {

    T getObject() throws BeansException;

    Class<?> getObjectType();

    boolean isSingleton();
}
