package java0309;

class Node{
    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}
public class MyQueueByLinkedList {
    //用链表实现队列
    private Node head = null;
    private Node tail = head;

    //1.入队列(尾插)
    public boolean offer(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = tail.next;
        return true;
    }
    //2.出队列（头删）
    public Integer poll(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            Integer ret = head.val;
            head = null;
            return ret;
        }
        Integer ret = head.val;
        head = head.next;
        return ret;
    }
    //3.取队首元素
    public Integer peek(){
        if(head == null){
            return null;
        }
        return head.val;
    }
}
