package cn.zeroclian.springframework.beans.factory.support;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.FactoryBean;
import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;
import cn.zeroclian.springframework.beans.factory.config.BeanPostProcessor;
import cn.zeroclian.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.zeroclian.springframework.util.ClassUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justin
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtil.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object shareInstance = getSingleton(name);
        if (shareInstance != null) {
            return (T) getObjectForBeanInstance(shareInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCacheObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
