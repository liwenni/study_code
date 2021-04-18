package java0309;

public class MyQueueByArrayList {
    //用顺序表实现队列
    //有效区间 [head,tail） 循环队列
    private int[] data = new int[100];
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    //1.入队列
    public boolean offer(int val){
        if(size == data.length){
            return false;
        }
        //将新元素放到tail下标上
        data[tail] = val;
        tail++;
        //tail到达数组末尾后，置tail = 0；
        if(tail == data.length){
            tail = 0;
        }
        size++;
        return true;
    }
    //2.出队列
    public Integer poll(){
        if(size == 0){
            return null;
        }
        int ret = data[head];
        head++;
        if(head == data.length){
            head = 0;
        }
        size--;
        return ret;
    }
    //3.取队首元素
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return data[head];
    }
}
