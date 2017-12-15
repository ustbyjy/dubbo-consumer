package com.yjy.consumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yjy.provider.service.DemoService;

public class ConsumerConfig {

    public static void main(String[] args) {

        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer-of-hello-world-app");

        // 引用远程服务
        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(applicationConfig);
        reference.setUrl("dubbo://127.0.0.1:10080/com.yjy.provider.service.DemoService");
        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");

        // 和本地bean一样使用xxxService
        DemoService demoService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        System.out.println(demoService.sayHello("world"));
    }
}
