package com.yjy.consumer.service.impl;

import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceStub implements DemoService {
    private static Logger logger = LoggerFactory.getLogger(DemoServiceStub.class);

    private final DemoService demoService;

    // 构造函数传入真正的远程代理对象
    public DemoServiceStub(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public String sayHello(String name) {
        // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        try {
            logger.info("return：" + demoService.sayHello(name));
            throw new Exception("测试出错");
        } catch (Exception e) {
            // 你可以容错，可以做任何AOP拦截事项
            return "容错数据";
        }
    }
}
