package com.yjy.consumer;

import com.yjy.consumer.callback.impl.DemoServiceNotifyImpl;
import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class ConsumerTestCallback {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestCallback.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-callback.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService");
        for (int i = 0; i < 10; i++) {
            demoService.sayHello("World");
        }

        DemoServiceNotifyImpl demoServiceCallback = (DemoServiceNotifyImpl) context.getBean("demoServiceCallback");
        for (Map.Entry<String, String> entry : demoServiceCallback.getResults().entrySet()) {
            logger.info("param=" + entry.getKey() + "，result=" + entry.getValue());
        }
    }
}
