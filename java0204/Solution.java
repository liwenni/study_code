package java0204;

class ListNode {
    public int val;
    public ListNode next = null;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution{
    //反转单链表
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode prevNode = null;
        ListNode curNode = head;
        ListNode newHead = null;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;

            prevNode = curNode;
            curNode = nextNode;
        }
        newHead = curNode;
        return newHead;
    }
    //删除链表中等于给定值 val 的所有节点。
    //创建两个节点，一个指向要删除的元素，一个指向要删除元素的前一个元素。
    //先处理中间元素，后处理头元素等于val的情况。防止1,2个元素均为要删除元素，而跳过删除第二个元素
    //﻿循环比较是否等于val，等于则删除,不等于则prev和toDelet均向后移动
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode toDelet = head.next;

        while(toDelet != null ){
            if(toDelet.val == val){
                prev.next = toDelet.next;
                toDelet = prev.next;
            }else{
                prev = prev.next;
                toDelet = toDelet.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }
}
