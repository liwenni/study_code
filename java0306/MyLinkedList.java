package java0306;

class Node{
    int val;
    Node prev = null;
    Node next = null;

    public Node(int val){
        this.val = val;

    }
}
public class MyLinkedList {
    //记录头和尾节点的位置
    private Node head;
    private Node tail;
    //记录链表元素个数
    private int length = 0;

    public MyLinkedList(){
        head = null;
        tail = null;
    }
    public int length(){
        return this.length;
    }

    //插入节点
    //头插
    public void addFirst(int val){
        //创建新节点
        Node newHead = new Node(val);
        //空链表头插
        if(head == null){
            head = newHead;
            tail = newHead;
            length++;
            return;
        }
        //非空链表头插
        newHead.next = head;
        head.prev = newHead;
        //更新head，使其指向新节点
        head = newHead;
        length++;
        return;
    }
    //尾插
    public void addLast(int val) {
        Node newHead = new Node(val);
        //空链表尾插
        if(head == null){
            head = newHead;
            tail = newHead;
            length++;
            return;
        }
        //非空链表尾插
        tail.next = newHead;
        newHead.prev = tail;
        //更新tail的指向
        tail = newHead;
        length++;
    }
    //指定位置插入
    public void add(int index,int val){
        if(index < 0 || index > length){
            return;
        }
        if(index == 0){
            //相当于头插
            addFirst(val);
            return;
        }
        if(index == length){
           //相当于尾插
           addLast(val);
           return;
        }
        //往中间插入，先找到下标对应的节点
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;
        Node newHead = new Node(val);

        prevNode.next = newHead;
        newHead.prev = prevNode;

        newHead.next = nextNode;
        nextNode.prev = newHead;
        length++;


    }

    //删除节点
    //头删
    public void removeFirst(int index){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            length = 0;
            return;
        }
        //删除第一个节点
        Node nextNode = head.next;
        nextNode.prev = null;
        head = nextNode;
        length--;

    }
    //尾删
    public void removeLast(int index){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            length = 0;
            return;
        }
        Node prevNode = tail.prev;
        prevNode.next = null;
        tail = prevNode;
        length--;

    }
    //按照值删除
    public void removeByValue(int val){
        int index = indexOf(val);
        if(index == -1){
            return;
        }
        //找到下标后直接调用删除操作
        removeByIndex(index);
    }
    //按照指定位置删除
    public void removeByIndex(int index){
        //处理特殊情况
        if(index < 0 || index >= length){
            return;
        }
        if(index == 0){
            //头删
            removeFirst(index);
            return;
        }
        if(index == length - 1){
            //尾删
            removeLast(index);
            return;
        }
        //根据下标找到位置
        Node toRemove = getNode(index);
        //记录前后节点的位置
        Node prevNode = toRemove.prev;
        Node nextNode = toRemove.next;
        //删除节点
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        length--;

    }

    //查找节点
    //根据下标找节点
    public Node getNode(int index){
        if(index == 0 || index >= length){
            return null;
        }
        Node cur = head;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        return cur;
    }
    //给定下标找元素
    public int get(int index){
        return getNode(index).val;

    }
    //给定元素找下标
    public int indexOf(int value){
        Node cur = head;
        for(int i = 0;i < length;i++){
            if(cur.val == value){
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    //修改元素
    public void set(int index,int value){
        Node node = getNode(index);
        node.val = value;
    }
}
