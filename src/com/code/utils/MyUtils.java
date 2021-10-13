package com.code.utils;

public class MyUtils<T> {

    public void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void swap(T a, T b){
        T temp = a;
        a = b;
        b = temp;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
