package java0424;

import java.util.*;


public class Main{
    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 2;
        int min = num;
        boolean flag =false;
        int tmp = 0;
        while(i <= num/2){
            if(isPrimeNumber(i)&& isPrimeNumber(num - i)) {
                int result = num - i - i;
                if (result < min) {
                    min = result;
                    flag = true;
                    tmp = i;
                }

            }
            i++;
        }
        if(flag) {
            System.out.println(tmp);
            System.out.println(num - tmp);
        }

    }
}
