package com.yjy.consumer;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestEchoService {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestEchoService.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-echo.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService");
        EchoService echoService = (EchoService) demoService;
        Object result = echoService.$echo("OK");
        logger.info((String) result);
    }
}
