package java0309;

class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
//用链表实现栈
public class MyStackByLinkedList {
    //不带傀儡节点的链表
    ListNode head = null;
    //1.入栈(头插)
    public void push(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    //2.出栈(头删)
    public Integer pop(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            Integer ret = head.val;
            head = null;
            return ret;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }
    //3.取栈顶元素
    public Integer peek(){
        if(head == null){
            return null;
        }
        return head.val;
    }

}
