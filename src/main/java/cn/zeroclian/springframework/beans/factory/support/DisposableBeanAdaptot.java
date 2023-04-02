package cn.zeroclian.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.DisposableBean;
import cn.zeroclian.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author ZeroClian
 * @date 2023-04-01 17:47
 */
public class DisposableBeanAdaptot implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destoryMethodName;

    public DisposableBeanAdaptot(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destoryMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        //1.实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        // 配置信息 destroy-method {判断是为了避免二次执行而销毁}
        if (StrUtil.isNotEmpty(destoryMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destoryMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destoryMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Could not find a destroy method named '" + destoryMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
