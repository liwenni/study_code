package java0305;

public class Solution7 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //处理特殊情况
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //1.创建引用及带傀儡节点的新链表(带傀儡节点的链表可简化代码，
        // 将空链表的情况和非空链表的情况统一)
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(0);//带傀儡节点的新链表
        ListNode newTail = newHead;
        //2.循环比较将较小的插入新链表的尾部
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            }else{
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }

        }
        //循环结束，即有一个链表已到达null，将另一链表插入结尾
        if(cur1 == null){
            newTail.next = cur2;
        }else{
            newTail.next = cur1;
        }
        return newHead.next;//返回除去傀儡节点的新链表
    }
}
