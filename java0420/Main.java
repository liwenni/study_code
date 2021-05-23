package java0420;

import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int len = arr.length;
        while (len > 0) {
            int i = 0;
            for (; i < len; i++) {
                if (len == 1) {
                    System.out.println(arr[i]);
                }
                if (i + 3 < len) {
                    arr[i + 2] = arr[i + 3];
                }
            }
            len = len / 3;
        }
    }
}



//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        String[] ch = string.split(" ");
//        int arr[] = new int[ch.length - 1];
//        int k = Integer.parseInt(ch[ch.length - 1]);
//        for(int i = 0;i < ch.length - 1;i++) {
//            arr[i] = Integer.parseInt(ch[i]);
//        }
//        Arrays.sort(arr);
//        for(int i = 0;i < k;i++){
//            System.out.print(arr[i]+" ");
//        }
//    }
//}