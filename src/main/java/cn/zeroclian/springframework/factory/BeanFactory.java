package cn.zeroclian.springframework.factory;

import cn.zeroclian.springframework.BeansException;

/**
 * @author Justin
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}