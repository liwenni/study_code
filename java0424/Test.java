package java0424;

public class Test {
    public static void add(Byte b){
        b = b++;
    }
    public static void test(){
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a+" ");
        add(b);
        System.out.println(b+" ");
    }

    public static void main(String[] args) {
        test();
    }
}
