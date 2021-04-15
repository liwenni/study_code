package java0305;

public class Solution5 {
    //1.求解链表长度
    public int getLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    public ListNode middleNode(ListNode head) {
        //处理特殊情况
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        //2. length / 2
        int length = getLength(head);
        int half = length / 2;
        //3.创建引用从链表头部开始往后走length / 2 步。
        ListNode cur = head;
        for(int i = 0;i < half;i++){
            cur = cur.next;
        }
        return cur;
    }
}
