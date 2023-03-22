package cn.zeroclian.springframework.beans.factory;

import cn.zeroclian.springframework.beans.BeansException;

/**
 * @author Justin
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requireType) throws BeansException;
}
