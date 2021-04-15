package java0305;

public class Solution6 {
    //求链表长度
    public int getLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    public ListNode FindKthToTail(ListNode head,int k) {

        //1.处理特殊情况
        if(head == null){
            return null;
        }
        int length = getLength(head);
        if(k <= 0){
            return null;
        }
        if(k > length){
            return null;
        }
        //2. 创建引用，让其从头开始走 length - k 步
        ListNode cur = head;
        for(int i = 0;i < length - k;i++){
            cur = cur.next;
        }
        return cur;
    }
}
