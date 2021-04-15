package java0305;

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        if(A == null){
            return true;
        }
        if(A.next == null){
            return true;
        }
        //1.复制链表
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        for(ListNode cur = A;cur != null;cur = cur.next){
            newTail.next = new ListNode(cur.val);
            newTail = newTail.next;
        }
        ListNode B = newHead.next;
        //2.逆置链表B
        ListNode prev = null;
        ListNode cur = B;

        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                B = cur;
            }
            //逆置
            cur.next = prev;
            //更新循环变量
            prev = cur;
            cur = next;
        }
        //3.对比两个链表是否相同
        ListNode cur1 = A;
        ListNode cur2 = B;
        while(cur1 != null && cur2 != null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
}
