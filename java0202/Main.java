package java0202;

public class Main {
    //创建链表 1.创建节点 2.
    public static Node creatList(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;//头结点代表整个链表
    }
    public static void main(String[] args) {
        Node head = creatList();
        //遍历链表
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.println(cur.val);
        }
        //找链表最后一个节点
        Node cur = head;
        while(cur != null && cur.next != null){
            cur = cur.next;
        }
        System.out.println("最后一个元素为："+cur.val);
        //找倒数第二个节点
        Node cur1 = head;
        while(cur1 != null && cur1.next !=null && cur1.next.next != null){
            cur1 = cur1.next;
        }
        System.out.println("倒数第二个元素为："+cur1.val);
        //链表的第 n 个结点
        int n = 2;
        Node cur2 = head;
        for(int i = 1;i<n;i++){
            cur2 = cur2.next;
        }
        System.out.println("链表第"+n+"个节点为："+cur2.val);
        //计算链表中元素的个数
        int count = 0;
        for(Node cur3 = head;cur3 !=null;cur3 = cur3.next){
            count++;
        }
        System.out.println("链表中的元素个数为："+count);
        //找到链表中是否包含某个元素
        Node e = new Node(5);
        for(Node cur4 = head;cur4 !=null;cur4 = cur4.next){
            if(cur4.val == e.val){
                System.out.println("此链表包含 "+e.val);
                break;
            }
            if(cur4.next==null)
                System.out.println("此链表不包含 "+e.val);
        }
    }
}
