package com.yjy.consumer;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestGroup {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestGroup.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-group.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        DemoService demoService2 = (DemoService) context.getBean("demoService2"); // 获取远程服务代理
        logger.info("group1：" + demoService.sayHello("1"));
        logger.info("group2：" + demoService2.sayHello("2"));
    }
}
