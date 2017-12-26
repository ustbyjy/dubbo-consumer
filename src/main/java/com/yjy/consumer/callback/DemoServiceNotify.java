package com.yjy.consumer.callback;

public interface DemoServiceNotify {
    void onReturn(String result, String param);

    void onThrow(Throwable ex, String param);
}
