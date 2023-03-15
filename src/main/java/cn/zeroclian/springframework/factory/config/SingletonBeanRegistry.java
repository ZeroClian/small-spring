package cn.zeroclian.springframework.factory.config;

/**
 * @author Justin
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String name);

}
