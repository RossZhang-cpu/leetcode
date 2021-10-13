package com.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CanJump {

    public boolean canJump(int[] nums){
       int max = 0;
       for(int i = 0; i < nums.length; ++i){
           if(max >= i && nums[i] + i > max){
               max = nums[i] + i;
           }
           if(max > nums.length) break;
       }
       return max >= nums.length;

//        Hashtable
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //定义一个包含int的链表
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        //获取链表的add方法，注意这里是Object.class，如果写int.class会抛出NoSuchMethodException异常
        Method m = al.getClass().getMethod("add", Object.class);
        //调用反射中的add方法加入一个string类型的元素，因为add方法的实际参数是Object
        m.invoke(al, "hello");
        System.out.println(al.get(2));

    }

}
