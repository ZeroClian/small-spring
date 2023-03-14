package cn.zeroclian.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Justin
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanFactory = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanFactory.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanFactory.put(name, beanDefinition);
    }
}
