package com.yjy.consumer;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestCache {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestCache.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-cache.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        logger.info(demoService.sayHello("World"));
        logger.info("结果缓存中...");

        Thread.sleep(3000);

        logger.info(demoService.sayHello("World"));
    }
}
