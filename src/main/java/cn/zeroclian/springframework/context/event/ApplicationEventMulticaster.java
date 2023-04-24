package cn.zeroclian.springframework.context.event;

import cn.zeroclian.springframework.context.ApplicationEvent;
import cn.zeroclian.springframework.context.ApplicationListener;

/**
 * @author Justin
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
