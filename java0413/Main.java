package java0413;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int MoreThanHalfNum_Solution(int [] array) {
        int num = array.length / 2 + 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : array){
            Integer value = map.get(a);
            if(value == null){
                map.put(a,1);
            }else{
                map.put(a,value + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= num){
                return entry.getKey();
            }
        }
        return 0;
    }
}
//import java.util.*;
//import java.lang.String;
//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int num = scanner.nextInt();
//            //String string = scanner.next();
//            int[] arr = new int[6];
//            for(int i = 0;i < num;i++){
//                arr[i] = scanner.nextInt();
//        }
//            int i = 1;
//            int count = 0;
//            while(i < arr.length){
//                if(arr[i - 1] >= arr[i]){
//                    while(i < arr.length){
//                        if(arr[i - 1] < arr[i]){
//                            count++;
//                            i++;
//                        }
//                        //i++;
//                    }
//                }else{
//                    while(i < arr.length){
//                        if(arr[i - 1] > arr[i]){
//                            count++;
//                            i++;
//                        }
//                        //i++;
//                    }
//                }
//                i++;
//            }
//            System.out.println(count);
//        }
//    }
//}
//import java.util.Scanner;
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String string = scanner.nextLine();
//            String[] s = string.split(" ");
//            String[] s1 = new String[s.length];
//            for(int i = 0;i < s.length;i++){
//                s1[i] = s[s.length - i - 1];
//            }
//            for(int i = 0;i < s1.length;i++){
//                System.out.print(s1[i]+" ");
//            }
////            String s2 = new String(s1+"");
////            System.out.println(s2+"");
//        }
//        System.out.println();
//    }
//
//}

//class base{
//    base(){
//        System.out.println("base");
//    }
//}
//public class Main extends base{
//    public static void main(String[] args) {
//        new Main();
//        new base();
//    }
//}
