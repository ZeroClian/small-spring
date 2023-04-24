package cn.zeroclian.springframework.context;

import cn.zeroclian.springframework.beans.factory.HierarchicalBeanFactory;
import cn.zeroclian.springframework.beans.factory.ListableBeanFactory;
import cn.zeroclian.springframework.core.io.ResourceLoader;

/**
 * @author Justin
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
