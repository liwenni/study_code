package java0305;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        //1.判断特殊情况
        if(head == null){
            return null;
        }
        //2.寻找待删除节点的前一个节点prev
        ListNode prev = head;
        ListNode toDelet = head.next;
        while(toDelet != null){
            if(toDelet.val == val){
                //3.删除当前值为val的节点cur
                prev.next = toDelet.next;
                toDelet = prev.next;
            }else{
                prev = prev.next;
                toDelet = toDelet.next;
            }
        }
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }
}
