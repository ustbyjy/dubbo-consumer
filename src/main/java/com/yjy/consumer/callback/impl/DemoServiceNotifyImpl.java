package com.yjy.consumer.callback.impl;

import com.yjy.consumer.callback.DemoServiceNotify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DemoServiceNotifyImpl implements DemoServiceNotify {
    private static Logger logger = LoggerFactory.getLogger(DemoServiceNotifyImpl.class);

    private Map<String, String> results = new HashMap<String, String>();
    private Map<String, Throwable> errors = new HashMap<String, Throwable>();

    @Override
    public void onReturn(String result, String param) {
        logger.info("onReturn，param=" + param + "，result=" + result);
        results.put(param, result);
    }

    @Override
    public void onThrow(Throwable ex, String param) {
        logger.error("onReturn，param=" + param, ex);
        errors.put(param, ex);
    }

    public Map<String, String> getResults() {
        return results;
    }

    public Map<String, Throwable> getErrors() {
        return errors;
    }
}
