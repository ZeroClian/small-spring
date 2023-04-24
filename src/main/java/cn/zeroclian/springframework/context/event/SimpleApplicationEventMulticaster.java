package cn.zeroclian.springframework.context.event;

import cn.zeroclian.springframework.beans.factory.BeanFactory;
import cn.zeroclian.springframework.context.ApplicationEvent;
import cn.zeroclian.springframework.context.ApplicationListener;

/**
 * @author Justin
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
