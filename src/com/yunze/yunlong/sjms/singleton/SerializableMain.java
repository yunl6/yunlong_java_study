package com.yunze.yunlong.sjms.singleton;

import java.io.*;

public class SerializableMain {

    //使用序列化，反序列化创建单例，需要保证类的唯一性

    //TODO 1.把类序列化2.把类反序列化（保证是单例的）

    /**
     * 序列化需要实现Serializable接口，
     * 设置SerializableUID
     * 使用JDK自带的 ObjectOutputStream 把类序列化到磁盘上
     */

    public static void main(String[] args) {
        try {
            //获取实体
            LazySingleton instance = LazySingleton.getInstance();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("name"));
            oos.writeObject(instance);

            //反序列化实体

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("name"));

            LazySingleton lazySingleton = (LazySingleton)ois.readObject();
            System.out.println(lazySingleton == instance);  //输出true

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    class LazySingleton implements Serializable {
        private static final long serialVersionUID = 1L;

        private volatile static LazySingleton instance = null;

        private LazySingleton() {

        }

        public static LazySingleton getInstance() {
            if (null == instance) {
                synchronized (LazySingleton.class) {
                    if (null == instance) {
                        instance = new LazySingleton();
                    }
                }
            }
            return instance;
        }
        //反序列化的时候，生成实体时执行此处代码
        private Object readResolve() throws ObjectStreamException {
            return getInstance();
        }

    }
}
