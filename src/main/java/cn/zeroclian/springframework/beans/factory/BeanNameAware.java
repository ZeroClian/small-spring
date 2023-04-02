package cn.zeroclian.springframework.beans.factory;

/**
 * @author ZeroClian
 * @date 2023-04-02 15:24
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}
