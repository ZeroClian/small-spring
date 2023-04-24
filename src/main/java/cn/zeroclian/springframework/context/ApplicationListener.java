package cn.zeroclian.springframework.context;

import java.util.EventListener;

/**
 * @author Justin
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
