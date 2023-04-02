package cn.zeroclian.springframework.beans.factory;

/**
 * @author ZeroClian
 * @date 2023-04-01 17:30
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
