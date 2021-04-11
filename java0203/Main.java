package java0203;

public class Main {
    public static Node creatList(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;
    }

    //按值删除节点
    public static Node remove(Node head,int value){
        //找到此值对应节点的位置prev.next 和 前一个节点的位置prev
        Node prev = head;
        while(prev != null && prev.next != null && prev.next.val != value){
            prev = prev.next;
        }
        if(prev == null || prev.next == null){
            System.out.println("没有找到值为"+value+"的节点");
            return null;
        }
        Node toDelet = prev.next;//用toDelet指向即将删除的节点
        prev.next = toDelet.next;
        return head;
    }

    //按位置删除节点
    public static Node remove1(Node head,Node toDelet){
        //找toDelet的前一个节点位置prev
        Node prev = head;
        while(prev != null &&  prev.next != toDelet){
            prev = prev.next;
        }
        if(prev == null){
            return null;
        }
        //删除toDelet
        prev.next = toDelet.next;
        return head;
    }

    //计算链表长度
    public static int size(Node head){
        int size = 0;
        for(Node cur = head;cur != null;cur = cur.next){
            size++;
        }
        return size;
    }

    //按给定下标删除节点
    public static Node remove2(Node head,int index){
        if(index < 0 || index >= size(head)){
            return null;
        }
        //找要删除节点的前一个位置
        Node prev = head;
        for(int i=0;i<index-1;i++){
            prev = prev.next;
        }
        Node toDelet = prev.next;
        prev.next = toDelet.next;

        return head;
    }



    public static void main(String[] args) {

        Node head = creatList();

        //1、2之间插入一个节点
        Node prev = head.next;//①找到插入点的前一个节点的位置prev
        Node newNode = new Node(10);//创建新节点
        newNode.next = prev.next;
        prev.next = newNode;
        System.out.print("在节点1、2之间插入一个节点：");
        for(Node cur = head;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();

        //在链表头部插入一个节点
        Node newNode1 = new Node(100);
        newNode1.next = head;
        head = newNode1;
        System.out.print("在链表头部插入一个节点： ");
        for(Node cur = head;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();

        //在链表尾部插入一个节点
        Node newNode2 = new Node(1000);
        Node prevend = head;
        if(prevend == null){
            System.out.println(newNode2);
        }
        //找到最后一个节点
        while(prevend.next!=null){
            prevend = prevend.next;
        }
        prevend.next = newNode2;
        System.out.print("在链表尾部插入一个节点： ");
        for(Node cur = head;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();

        head = remove(head,1);
        System.out.print("删除值为1的节点：");
        for(Node cur = head;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();

        head = remove1(head,head.next.next);
        System.out.print("删除第三个节点：");
        for(Node cur = head;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();

        head = remove2(head,2);
        System.out.print("删除下标为2的节点：");
        for(Node cur = head;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }
}
