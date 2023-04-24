package cn.zeroclian.springframework.event;

import cn.zeroclian.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @author Justin
 */
public class CustomerEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到: " + event.getSource() + "消息;时间 " + new Date());
        System.out.println("消息: " + event.getId() + ":" + event.getMessage());
    }
}
