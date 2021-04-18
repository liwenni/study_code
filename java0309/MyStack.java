package java0309;

public class MyStack {
    //用顺序表实现栈
    private int[] data = new int[100];
    private int size = 0;
    //1.入栈
    public void push(int val){
        if(size >= data.length){
            return ;
        }
        data[size] = val;
        size++;
    }
    //2.出栈
    public Integer pop(){
        if(size == 0){
            return null;
        }
        Integer result = data[size - 1];
        size--;
        return result;
    }
    //3.取栈顶元素
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return data[size - 1];
    }
}
