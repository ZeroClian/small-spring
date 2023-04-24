package cn.zeroclian.springframework.util;

/**
 * @author Justin
 */
public class ClassUtil {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassUtil.class.getClassLoader();
        }
        return cl;
    }
}
