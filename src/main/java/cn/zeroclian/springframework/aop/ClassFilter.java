package cn.zeroclian.springframework.aop;

/**
 * @author Justin
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
