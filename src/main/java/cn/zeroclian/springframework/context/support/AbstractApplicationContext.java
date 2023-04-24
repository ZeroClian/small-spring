package cn.zeroclian.springframework.context.support;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.zeroclian.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.zeroclian.springframework.beans.factory.config.BeanPostProcessor;
import cn.zeroclian.springframework.context.ConfigurableApplicationContext;
import cn.zeroclian.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @author Justin
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1，创建 BeanFactory 并加载 BeanDefinition
        refreshBeanFactory();
        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 添加 ApplicationContextAwareProcessor ，让继承自 ApplicationContextAware 的bean对象都能够感知到所属的ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 4. 在 Bean 实例化之前执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanFactoryPostProcessors(beanFactory);
        // 6. 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return getBeanFactory().getBean(name, requireType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
