package com.code.reflection;

import java.lang.reflect.Method;

public class Apple {
        private int price;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        /*
            反射机制
         */
    public static void main(String[] args) throws Exception {
//        Class clz = Class.forName("com.code.java.reflection.Apple");
////        Method method = clz.getMethod("setPrice", int.class);
////        Constructor constructor = clz.getConstructor();
////        Object object = constructor.newInstance();
////        method.invoke(object, 14);
////        Method getMethod = clz.getMethod("getPrice");
////        System.out.println("Apple price:" + getMethod.invoke(object));
////        BackTracking backTracking = new BackTracking();
////        String str = "bfce";
////        char[][] chars = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j','d','e', 'h'}};
////        backTracking.backTracking(chars, str);
//        Class cs = String.class;

        /**
         * 利用反射获取成员变量
        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"
         */

        /**
         * 利用反射进行赋值
        Person m = new Person("xiao zhang");
        Class mc = m.getClass();
        System.out.println(mc.getName());
        Field mf = mc.getDeclaredField("name");
        mf.setAccessible(true);
        mf.set(m, "henry");
        System.out.println(m.getName());
         */

        /**
         * 利用反射调用方法
        String s = "Hello world";
        Method method = String.class.getMethod("substring", int.class, int.class);
        String r = (String) method.invoke(s, 1, 6);
        System.out.println(r);
         */

        /**
         * 利用反射调用静态方法
        Method m = Integer.class.getMethod("parseInt",  String.class);
        Integer n = (Integer) m.invoke(null, "124567");
        System.out.println(n);

        Person p = new Person();
        Method mp = p.getClass().getDeclaredMethod("setName", String.class);
        mp.setAccessible(true);
        mp.invoke(p, "zhangsan");
        System.out.println(p.getName());
         */

        /**
         * 多态
         */
//       Method m = Person.class.getMethod("hello");
//       m.invoke(new Student());
        Person p = new Person();
        Method hello = p.getClass().getMethod("hello");
        hello.invoke(new Student());
    }
}

class Person {
    private String name;

    public Person(){
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student extends Person {
    public void hello() {
        System.out.println("Student:hello");
    }
}



