package cn.zeroclian.springframework.beans.factory.config;

import cn.zeroclian.springframework.beans.BeansException;

/**
 * @author Justin
 */
public interface BeanPostProcessor {

    /**
     * 在 bean 对象执行初始化方法之前执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 bean 对象执行初始化方法之后执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
