package cn.zeroclian.springframework.context;

import cn.zeroclian.springframework.beans.BeansException;

/**
 * @author Justin
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     */
    void refresh() throws BeansException;
}
