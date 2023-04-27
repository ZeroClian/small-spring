package cn.zeroclian.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author Justin
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> clazz);
}
