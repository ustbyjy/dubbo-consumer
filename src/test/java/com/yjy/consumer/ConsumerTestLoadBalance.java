package com.yjy.consumer;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestLoadBalance {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestLoadBalance.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-lb.xml"});
        context.start();
        logger.info("服务开始运行...");

        for (int i = 0; i < 100; i++) {
            DemoService demoService = (DemoService) context.getBean("demoService");
            logger.info(demoService.sayHello("Tom"));
        }
    }
}
