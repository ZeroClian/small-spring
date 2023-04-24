package cn.zeroclian.springframework.bean;

import cn.zeroclian.springframework.beans.BeansException;
import cn.zeroclian.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws BeansException {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "ZeroClian");
            hashMap.put("10002", "Justin");
            hashMap.put("10003", "Yang");
            return "你被代理了" + method.getName() + "," + hashMap.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
