package cn.zeroclian.springframework.context.event;

import cn.zeroclian.springframework.context.ApplicationContext;
import cn.zeroclian.springframework.context.ApplicationEvent;

/**
 * @author Justin
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
