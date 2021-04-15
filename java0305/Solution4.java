package java0305;

public class Solution4 {
    public ListNode reverseList(ListNode head) {
        //1.判断特殊情况
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = null;
        //2.创建引用
        ListNode prevNode = null;
        ListNode curNode = head;

        while(curNode != null){
            ListNode nextNode = curNode.next;
            if(nextNode == null){
                //curNode指向链表的最后一个元素
                newHead = curNode;
            }
            //3.反转
            curNode.next = prevNode;
            //4.更新引用位置
            prevNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }
}
