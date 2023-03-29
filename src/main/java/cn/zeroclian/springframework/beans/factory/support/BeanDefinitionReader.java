package cn.zeroclian.springframework.beans.factory.support;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.core.io.Resource;
import cn.zeroclian.springframework.core.io.ResourceLoader;

/**
 * @author Justin
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadDeanDefinitions(Resource resource) throws BeansException;

    void loadDeanDefinitions(Resource... resources) throws BeansException;

    void loadDeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
