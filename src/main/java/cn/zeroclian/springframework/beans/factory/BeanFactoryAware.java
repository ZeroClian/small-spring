package cn.zeroclian.springframework.beans.factory;

import cn.zeroclian.springframework.beans.BeansException;

/**
 * @author ZeroClian
 * @date 2023-04-02 15:20
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
