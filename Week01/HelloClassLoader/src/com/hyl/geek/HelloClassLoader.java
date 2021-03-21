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

        BufferedInputStream in = null;
        byte[] temp = new byte[1024];
        int size = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        try {
            in = new BufferedInputStream(new FileInputStream("Hello.xlass"));
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, 255-size);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content = out.toByteArray();


        return defineClass(name,content,0,content.length);
    }
}
