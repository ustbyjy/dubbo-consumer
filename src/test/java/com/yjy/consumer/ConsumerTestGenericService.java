package com.yjy.consumer;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestGenericService {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestGenericService.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-generic.xml"});
        context.start();
        logger.info("服务开始运行...");

        GenericService demoService = (GenericService) context.getBean("demoService"); // 获取远程服务代理
        Object result = demoService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"World"});
        logger.info((String) result);
    }
}
