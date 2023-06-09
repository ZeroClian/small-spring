package cn.zeroclian.springframework.core.io;

/**
 * @author Justin
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
