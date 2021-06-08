package java0424;

public class BinInsert {
    public static int binInsert(int n, int m, int j, int i) {
        // write code here
        int result = n + m * j * j;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binInsert(1024,19,2,6));
    }
}
