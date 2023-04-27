package cn.zeroclian.springframework;

import cn.zeroclian.springframework.aop.AdvisedSupport;
import cn.zeroclian.springframework.aop.TargetSource;
import cn.zeroclian.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.zeroclian.springframework.aop.framework.Cglib2AopProxy;
import cn.zeroclian.springframework.aop.framework.JdkDynamicAopProxy;
import cn.zeroclian.springframework.bean.IUserDao;
import cn.zeroclian.springframework.bean.UserService;
import cn.zeroclian.springframework.bean.UserServiceInterceptor;
import org.junit.Test;

/**
 * @author Justin
 */
public class ApiTest {

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserDao userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.zeroclian.springframework.bean.IUserDao.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserDao proxy_jdk = (IUserDao) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserDao proxy_cglib = (IUserDao) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

}
