package java0322;

import java.util.Arrays;

public class MyPriorityQueue {
    //用数组array存储堆
    //size表示堆上有效元素的个数
    //index表示开始向下调整的位置
    //1、向下调整
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        //child < size，child存在；
        // child >= size,说明parent已经是叶子节点了
        while(child < size){
            //第一次比较，找出左右子树中的较大值
            //若右子树存在，且右子树 > 左子树，让 child 指向右子树
            //若左子树 > 右子树，child 还是指向 child。保证了child始终指向左右孩子中的较大者
            if(child + 1 < size && array[child + 1] > array[child]){
                child = child + 1;
            }
            //第二次比较，比较parent和child的值，
            // 符合大堆/小堆（此处以大堆为例）要求不交换，否则交换两者

            if(array[parent] < array[child]){
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else{
                break;
            }
            //更新循环变量,从父节点往下继续调整其他节点
            parent = child;
            child = 2 * parent + 1;
        }
    }
    //2、向上调整
    public static void shiftUp(int[] array,int size,int index){
        int child = index;
        int parent = (child - 1) / 2;
        while(child > 0){
            if(array[parent] < array[child]){
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else{
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    //3、创建堆
    public static void createHeap(int[] array){
        for(int i  = (array.length - 1 -1) /2;i >= 0;i--) {
            shiftDown(array,array.length,i);
        }
    }
    //创建成员变量保存堆对应的数组
    public int[] array = new int[100];
    int size = 0;
    public MyPriorityQueue(int[] array,int size){
        this.size = size;
        for(int i = 0; i < size;i++){
            this.array[i] = array[i];
        }
    }

    //4、插入堆
    public void offer(int val){
        if(size > array.length){
            return;
        }
        array[size] = val;
        size++;
        //插入新元素之后，堆结构可能被破坏，可对新元素进行向上调整
        shiftUp(array,size,size - 1);
    }
    //5、取堆顶元素
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return array[0];
    }
    //6、删除堆顶元素
    public Integer poll(){
        if(size == 0){
            return null;
        }
        int top = array[0];
        array[0] = array[size - 1];
        size-- ;
        //进行向下调整
        shiftDown(array,size,0);
        return top;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,8,7,6};
        createHeap(array);
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(array,array.length);
        System.out.println(myPriorityQueue);
        myPriorityQueue.offer(10);
        System.out.println(myPriorityQueue);
        Integer result = myPriorityQueue.poll();
        System.out.println(myPriorityQueue);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0;i < size;i++){
            stringBuilder.append(array[i]);
            if(i < size - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
