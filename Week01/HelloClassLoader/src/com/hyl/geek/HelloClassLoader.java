package com.hyl.geek;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clazz = new HelloClassLoader().findClass("Hello");
            Method method= clazz.getMethod("hello");
            method.invoke(clazz.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {

        FileInputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        int tempbyte = 0;
        try {
            in = new FileInputStream("Hello.xlass");
            while ((tempbyte = in.read()) != -1) {
               out.write(255 - tempbyte);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content = out.toByteArray();


        return defineClass(name,content,0,content.length);
    }
}
