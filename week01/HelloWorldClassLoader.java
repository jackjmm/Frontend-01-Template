package com.example.demo.classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jiangmingming on 2021/3/20 15:27
 */
public class HelloWorldClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Object obj = new HelloWorldClassLoader().findClass("Hello").newInstance();
            Method method = obj.getClass().getMethod("hello");
            //method.setAccessible(true);
            method.invoke(obj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //读取文件
        File file = new File("E:\\java进阶\\week1\\Hello.xlass");
        //获取文件的字节数组
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(file.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //数组转换255-x
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
