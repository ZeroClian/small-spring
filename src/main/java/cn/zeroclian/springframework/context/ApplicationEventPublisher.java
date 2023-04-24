package cn.zeroclian.springframework.context;

/**
 * @author Justin
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
