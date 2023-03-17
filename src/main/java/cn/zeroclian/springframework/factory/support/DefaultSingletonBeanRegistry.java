package cn.zeroclian.springframework.factory.support;

import cn.zeroclian.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Justin
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    public void addSingleton(String name, Object beanDefinition) {
        singletonObjects.put(name, beanDefinition);
    }
}
