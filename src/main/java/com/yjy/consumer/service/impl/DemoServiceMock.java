package com.yjy.consumer.service.impl;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceMock implements DemoService {
    private static Logger logger = LoggerFactory.getLogger(DemoServiceMock.class);

    @Override
    public String sayHello(String name) {
        // 你可以伪造容错数据，此方法只在出现RpcException时被执行
        logger.info("invoke mock...");
        return "容错数据";
    }
}
