package com.yjy.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

public class ConsumerTestAsync {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTestAsync.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer-async.xml"});
        context.start();
        logger.info("服务开始运行...");

        DemoService demoService = (DemoService) context.getBean("demoService");
        // 此调用会立即返回null
        demoService.sayHello("Async");
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        Future<String> demoFuture = RpcContext.getContext().getFuture();
        // 如果结果已返回，直接拿到返回值，否则线程wait住，等待结果返回后，线程会被notify唤醒
        String result = demoFuture.get();

        logger.info("result：" + result);
    }
}
