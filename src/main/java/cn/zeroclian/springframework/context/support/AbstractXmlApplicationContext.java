package cn.zeroclian.springframework.context.support;

import cn.zeroclian.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.zeroclian.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author Justin
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
