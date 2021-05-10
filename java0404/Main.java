package java0404;

import java.util.Scanner;

public class Main {
    public static int fib(int a){
        if(a == 0 || a== 1){
            return 1;
        }
        return fib(a - 1) + fib(a - 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        int i = 0;

        while(i < num){
            int fibnum = fib(i);
            if(fibnum == num){
                System.out.println(count);
                break;
            }else if(fibnum > num){
                num = num + 1;
                count++;
            }else if(fibnum < num){
                num = num - 1;
                count++;
            }
            i++;
        }

        //System.out.println(count);
    }
}
