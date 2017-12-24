package com.yjy.consumer;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestToken {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestToken.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-token.xml"});
        context.start();
        logger.info("服务开始运行...");

        // 采用注册中心，验证token
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        logger.info(demoService.sayHello("World"));

        // 采用直连，不验证token
        try {
            DemoService demoService2 = (DemoService) context.getBean("demoService2"); // 获取远程服务代理
            logger.info(demoService2.sayHello("World"));
        } catch (Exception e) {
            logger.error("token验证失败", e);
        }

    }
}
