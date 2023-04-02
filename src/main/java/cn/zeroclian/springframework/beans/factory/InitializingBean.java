package cn.zeroclian.springframework.beans.factory;

/**
 * @author ZeroClian
 * @date 2023-04-01 17:29
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
