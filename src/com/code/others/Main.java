package com.code.others;

import com.code.LinkList.ListNode;
import com.code.quickSort.NextPermutation;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        Class<? extends List> aClass = list.getClass();
//        aClass.getMethod("add", Object.class).invoke(list, 1);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }S
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }

    }


    public void formatSql(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int i = 0;
        if (sc.hasNextLine()){
            if(i == 0)
             sb.append("'" + sc.nextLine() + "'");
            else
             sb.append(",'" + sc.nextLine() + "'");
            ++i;
        }
        System.out.println(sb);
    }



    public String character_auto_complete (String str) {
        // write code here
        if(str == null || str.length() == 0) return "No match";
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<String>();
        list.add("Monday");
        map.put("M", new ArrayList<String>(list));
        list.clear();

        list.add("Tuesday");
        list.add("Thursday");
        map.put("T", new ArrayList<String>(list));
        list.clear();

        list.add("Wednesday");
        map.put("W", new ArrayList<String>(list));
        list.clear();

        list.add("Friday");
        map.put("F", new ArrayList<String>(list));
        list.clear();

        list.add("Saturday");
        list.add("Sunday");
        map.put("S", new ArrayList<String>(list));
        list.clear();

        String result = "No match";
        if(map.get(str) != null){
            result = "";
            int i = 0;
            for (String s : map.get(str)) {
                if(i == 0) result += s;
                else  result += " " + s;
                ++i;
            }
        }
        return result;


    }
        /**
         * find median in two sorted array
         * @param arr1 int?????????????????? the array1
         * @param arr2 int?????????????????? the array2
         * @return int??????
         */
    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int n = arr1.length * 2;
        int middle = n / 2 - 1 ;
        int i = 0; int j = 0;
        int min = 0;
        while (middle >= 0){
            if(arr1[i] < arr2[j]){
                min = arr1[i];
                ++i;
            }else {
                min = arr1[j];
                ++j;
            }
            --middle;
        }
        return min;
    }

    public String changeFormatNumber (String number) {
        // write code here
        if(number == null || number.length() == 0) return null;
        Pattern pattern = Pattern.compile("^-?\\d+$");
        Matcher mc = pattern.matcher(number);
        if(!mc.matches()) return "????????????";

        int num = Integer.parseInt(number);
        if(num >= Math.pow(2, 15) || num < -Math.pow(2, 16)) return "NODATA";

        char[] chars = new char[16];
        int count = 0;
        StringBuilder binary = new StringBuilder("");
        int res = 0;
        int temp = Math.abs(num);
        while (temp!=0){
            res = temp % 2;
            temp = temp / 2;
            binary.append(res);

        }

        int len = 16 - binary.length();
        StringBuilder sb = new StringBuilder("");
        sb.append("0".repeat(Math.max(0, len)));
        String ans = String.valueOf(sb.append( binary));
        System.out.println(ans);

        if(num < 0) {
            char[] chars1 = ans.toCharArray();
            for(int i = 0; i < 16; ++i) {
                if(chars1[i] == '0') chars1[i] = '1';
                else chars1[i] = '0';
            }
            
            chars1[0] = '1';
            ans = String.valueOf(chars1);

        }
        return ans;
    }

    public ListNode lineUp (ListNode head) {
        // write code here
        if(head == null) return null;

        ListNode p = head;   //??????
        ListNode rear = head;
        ListNode q = head;  //??????
        ListNode front  = head.next;

        while(q != null && q.next != null){
            q = q.next;
            p = q.next;

            rear.next = p;
            q.next = q.next.next;
            rear = rear.next;
            rear.next = null;
        }
        rear.next = front;

        return head;
    }
}


