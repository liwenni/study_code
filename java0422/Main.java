package java0422;

import java.util.*;

public class Main{
    public static int fib(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while(fib(i) < n){
            i++;
        }
        int j = 0;
        int result = fib(i);
        while(result != n){
            result--;
            j++;
        }
        int v = 0;
        int result1 = fib(i - 1);
        while(result1 != n){
            result1++;
            v++;
        }
        if(j < v){
            System.out.println(j);
        }
        System.out.println(v);
    }
}
