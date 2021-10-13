package com.code.others;
import com.code.LinkList.ListNode;

public class MaxSubArrayProduct {


//    {1,2,2,3,5} --> {1, 2, 3, 5}
    /**
     * 删除重复
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null)
            return null;

        ListNode front = head;
        ListNode rear = head.next;
        int times = 0, temp = head.val;
        boolean eq = false;

        while (rear != null) {
            if (temp != rear.val) {         //当前不重复
                ++times;                     //不重复值的个数
                eq = true;
                if (times == 2) {           //前后指针的距离
                    front = front.next;
                    --times;
                }
                if (front.next != rear) {             //中间存在重复值
                    front.next = rear;
                }
            }else eq = true;
            temp = rear.val;            //记录当前值
            rear = rear.next;
        }
        if(eq){
            if(times == 1) {
                front = front.next;
                front.next = null;
            }
            if(times == 0) front.next = null;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode();
        node5.next = null;
        node5.val = 3;

        ListNode node4 = new ListNode();
        node4.next = node5;
        node4.val = 3;
        ListNode node3 = new ListNode();
        node3.next = node4;
        node3.val = 2;
        ListNode node2 = new ListNode();
        node2.next = node3;
        node2.val = 1;
        ListNode node1 = new ListNode();
        node1.next = node2;
        node1.val = 1;

        MaxSubArrayProduct product = new MaxSubArrayProduct();
        ListNode node = product.deleteAllDuplicates(node1);
        while (node!= null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public int maxSubArrayProduct (int[] nums) {
        // write code here
        // 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
        int iMin, iMax, max;
        iMax = nums[0];
        iMin = nums[0];
        max = nums[0];

        for(int i = 1; i < nums.length; ++i){
            int tempmax = iMax; int tempmin = iMin;
            iMax = Math.max(iMax * nums[i] , Math.max(nums[i] * tempmin,  nums[i]));
            iMin = Math.min(nums[i] * iMin, Math.min(nums[i] * tempmax,  nums[i]));   //用来保存发生负负得正的情况
            max = Math.max(iMax, max);
        }
        return max;
    }

    //删除链表的所有重复节点
    public ListNode deleteAllDuplicates (ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            if (head.val == head.next.val) {
                while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                return deleteAllDuplicates(head.next);
            } else {
                head.next = deleteAllDuplicates(head.next);
                return head;
            }
        }
}