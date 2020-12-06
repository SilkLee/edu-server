package com.silklee.video.pattern.singleton;

import java.io.*;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance1 = null;
        EnumSingleton instance2 = EnumSingleton.getInstance();
        instance2.setData(new Object());

        try {
//            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(instance2);
//            oos.flush();
//            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (EnumSingleton) ois.readObject();
            ois.close();
            System.out.println(instance1.getData());

            System.out.println(instance2.getData());
            System.out.println(instance1.getData() == instance2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
