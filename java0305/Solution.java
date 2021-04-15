package java0305;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode cur = pHead;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            }else{
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
