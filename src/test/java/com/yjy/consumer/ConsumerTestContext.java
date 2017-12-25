package com.yjy.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTestContext {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestContext.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-context.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService");
        logger.info(demoService.sayHello("World"));

        // 本端是否为消费端，这里会返回true
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
        logger.info("isConsumerSize：" + isConsumerSide);
        // 获取最后一次调用的提供方IP地址
        String serverIP = RpcContext.getContext().getRemoteHost();
        logger.info("serverIP：" + serverIP);
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        logger.info("application：" + application);


    }
}
