package com.yjy.consumer;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestLoadBalance {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestLoadBalance.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        context.start();
        logger.info("服务开始运行...");

        Thread.sleep(3000);

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        logger.info(hello); // 显示调用结果
    }
}
