package com.yjy.consumer;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestMultiVersion {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestMultiVersion.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-version.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        DemoService demoService2 = (DemoService) context.getBean("demoService2"); // 获取远程服务代理
        logger.info(demoService.sayHello("1"));
        logger.info(demoService2.sayHello("2"));
    }
}
