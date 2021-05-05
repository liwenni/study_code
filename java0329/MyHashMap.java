package java0329;

class HashNode{
    public int key;
    public int value;
    public HashNode next;

    public HashNode(int key,int value) {
        this.key = key;
        this.value = value;
    }
}
//哈希表：数组上的每个元素是一个链表
//采用开散列/哈希桶的方式来处理哈希冲突
public class MyHashMap {
    private HashNode[] array = new HashNode[16];
    private int size = 0;


    //1.插入键值对
    public void put(int key,int value){
        //根据key,计算下标位置
        int index = key % array.length;
        //查看index位置的链表中是否存在key，存在直接修改value，不存在插入新节点。
        for(HashNode cur = array[index];cur != null;cur = cur.next){
            if(cur.key == key){
                cur.value = value;
                return;
            }
        }
        //循环结束，即没找到，需创建新节点插入到链表中（此处采用头插）
        HashNode newNode = new HashNode(key,value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;

        if(loadFactor() > 0.75){
            resize();
        }
    }
    private double loadFactor(){
        return size / array.length;
    }
    private void resize(){
        //创建一个更长的新数组，将原数组拷贝进去
        HashNode[] newArray = new HashNode[2 * array.length];
        for(int i = 0;i < array.length;i++){
            HashNode next = null;
            //外层循环拷贝数组
            //for(HashNode cur = array[i];cur != null;cur = cur.next){
            for(HashNode cur = array[i];cur != null;cur = next){
                next = cur.next;//修改cur之前需提前备份之前的位置，
                // 下面的cur.next已指向的是新链表，不能当做循环条件中的旧链表指向了
                //里层循环拷贝i下标位置的链表
                int indexNew = cur.key % newArray.length;
                cur.next = newArray[indexNew];
                newArray[i] = cur;
            }
        }
        array = newArray;
    }
    //2.根据key获取value
    public Integer get(int key){
        int index = key % array.length;
        //遍历哈希表寻找key
        for(int i = 0;i < array.length;i++){
            for(HashNode cur = array[index];cur != null;cur = cur.next){
                if(cur.key == key){
                    return cur.value;
                }
            }
        }
        return null;
    }

    //3.删除key
    public void remove(int key){
        int index = key % array.length;
        for(int i = 0;i < array.length;i++){
            HashNode prev = array[index];
            while(prev != null && prev.next != null && prev.next.key == key){
                prev = prev.next;
            }
            if(prev == null && prev.next == null){
                return;
            }
            HashNode cur = prev.next;
            prev.next = cur.next;
        }

    }
}
