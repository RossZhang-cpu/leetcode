package com.code.others;

import com.code.LinkList.ListNode;

public class Solution2 {

    public ListNode findKNode(ListNode head, int k){
        if(head == null || k < 0)
            return null;

        ListNode node = head;
        ListNode kNode = head;
        for(int i = 0; i < k - 1 ; ++i ){
            node = node.next;
        }
        while (node.next != null){
            node = node.next;
            kNode = kNode.next;
        }

        return kNode;
    }

    public String minOrderString(int n, int k, String s){
        int p1 = -1; int p0 = -1;
        char[] chars = s.toCharArray();
        int count = 0;

        for(int i = 0; i < n; ++i){
            if(chars[i] == '1'){
                p1 = i;
                break;
            }
        }

        if(p1 == -1) return s;
        for(p0 = p1 + 1; p0 < chars.length; ++p0){
            if(count >= k) break;
            if(chars[p0] == '0'){
                int times = p0 - p1;
                if(times + count <= k ){
                    count += times;
                }else {
                    times = k - count;
                    count += times;
                    p1 = p0 - times;
                }
                char temp = chars[p0];
                chars[p0] = chars[p1];
                chars[p1] = temp;
                ++p1;
            }
        }
        return String.valueOf(chars);
    }

    public String minSwappedNumber(int n, String s){
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < n - 1; ++i){
            if(chars[i] > chars[i + 1] && chars[i] % 2 != chars[i + 1] % 2){
                 swap(chars, i, i+1);
                 int index = i;
                 while (index > 0){
                     if(chars[index - 1] > chars[index] && chars[index] % 2 != chars[index - 1] % 2)
                            swap(chars,index-1, index);
                     else break;
                     --index;
                 }
            }
        }
        return String.valueOf(chars);
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 20; ++i) {
            long v = (int) (0 + Math.random() * 100000);
            System.out.println(v);
            Solution2 solution2 = new Solution2();
            System.out.println(solution2.minSwappedNumber(String.valueOf(v).length(), String.valueOf(v)));
        }
    }
}
