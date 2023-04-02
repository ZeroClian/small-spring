package cn.zeroclian.springframework.context;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.Aware;

/**
 * @author ZeroClian
 * @date 2023-04-02 15:26
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
