package cn.zeroclian.springframework.beans.factory;

import cn.zeroclian.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author Justin
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 bean 实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
