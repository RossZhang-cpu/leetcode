package com.code.thread;

public class MyRunThread implements Runnable {
    @Override
    public void run() {
        System.out.println("this is son thread");
    }

    public static void main(String[] args) {
        MyRunThread thread = new MyRunThread();
        new Thread(thread).start();  //้ๆไปฃ็
        System.out.println("main");
    }
}
