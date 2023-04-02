package cn.zeroclian.springframework.beans.factory;

/**
 * @author ZeroClian
 * @date 2023-04-02 15:23
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
