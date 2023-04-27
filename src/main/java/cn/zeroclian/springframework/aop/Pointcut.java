package cn.zeroclian.springframework.aop;

/**
 * @author Justin
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
