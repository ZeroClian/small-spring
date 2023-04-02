package cn.zeroclian.springframework.beans.factory.config;

/**
 * @author Justin
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String name);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
