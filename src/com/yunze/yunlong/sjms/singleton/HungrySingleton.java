package com.yunze.yunlong.sjms.singleton;

public class HungrySingleton {
    /**
     * 设计模式
     * 单例模式
     * 一个类只能生成一个实例，该类提供了一个全局访问点供外部来获取该实例
     * 懒汉式：延时加载，只用在用到的时候才进行实例化
     * 饿汉式：只有在真正主动使用对应的类时，才会触发初始化
     * 【当前类是启动类，Main方法所在的类，直接new，访问静态属性、访问静态方法
     * ，反射访问等】类的初始化阶段就完成了实例的初始化。本质上借助于JVM的
     * 类加载机制，保证实例的唯一性（初始化过程只会执行一次）及线程安全
     * （JVM以同步的形式来完成类的加载过程）
     */

    public static String name = "yunLong";
    private static HungrySingleton instance = new HungrySingleton();


    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
//实现方式

}