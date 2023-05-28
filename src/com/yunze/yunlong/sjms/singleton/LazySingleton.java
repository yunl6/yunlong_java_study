package com.yunze.yunlong.sjms.singleton;

import java.io.Serializable;

public class LazySingleton {
    /**
     * 懒汉式
     * 需要考虑线
     * 1.线程安全问题
     * 2.double check 加锁优化
     * 3.加Volatile关键字，防止编译器和CPU对指令重排
     * <p>
     * <p>
     * 【创建一个对象  new   会先经过开辟内存空间，赋默认值，初始化对象三个过程】
     */
    private volatile static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }

        }
        return lazySingleton;
    }





}