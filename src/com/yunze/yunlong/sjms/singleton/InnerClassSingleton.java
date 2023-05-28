package com.yunze.yunlong.sjms.singleton;

public class InnerClassSingleton {
    /**
     * 当访问静态name属性时，不会加载instance的初始化，
     * 只有真正使用到对应的类时，才会初始化，
     * 例如调用InnerClassSingleton.getInstance()。
     */
    public static String name = "yunLong";

    private InnerClassSingleton() {

    }

    private static class SingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

}