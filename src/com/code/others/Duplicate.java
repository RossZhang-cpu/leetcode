package com.code.others;

public class Duplicate {
//   public static void main(String[] args){
//       int a[] = {2,3,1,0,2,5,3};
//       System.out.println(duplicate(a));
//   }

   public static int duplicate(int[] a){
       if(a == null || a.length == 0)
           return -1;

       int num = -1;
       for(int index = 0; index < a.length; ++index) {
           while (a[index] != index) {

                   if (a[index] == a[a[index]]) {
                       num = a[index];
                       return num;
                   } else {
                       int pos = a[index];
                        a[index] = a[a[index]];
                        a[pos] = pos;
                   }
               }
       }

       return num;
   }
}
