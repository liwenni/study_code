package java0305;

public class Solution1 {
    public int getLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }
        if (headB == null) {
            return null;
        }
        int l1 = getLength(headA);
        int l2 = getLength(headB);
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                cur1 = cur1.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; i++) {
                cur2 = cur2.next;
            }
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }else{
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return null;
    }
}
