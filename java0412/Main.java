package java0412;
////They are students.
////aeiou
////Thy r stdnts.
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int maxLength=0;//记录最长的数字的串的长度
        int count=0;//记录连续数字的个数
        int end=0;//记录数字结束的位置
        String s=null;
        while(in.hasNext()){
            s=in.nextLine();
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    count++;
                    if(count>maxLength){
                        end=i;
                        maxLength=count;

                    }

                }else{
                    count=0;
                }
            }
        }
        System.out.println(s.substring(end-maxLength+1,end+1));

    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String string1 = scanner.nextLine();
//            String string2 = scanner.nextLine();
//            char[] ch1 = string1.toCharArray();
//            char[] ch2 = string2.toCharArray();
//            int i = 0;
//            while(i < ch1.length){
//                //for(int i = 0;i < ch1.length;i++){
//                for(int j = 0;j < ch2.length;j++){
//                    if(ch1[i] == ch2[j]){
//                        i++;
//                        break;
//                    }
//                }
//
//                System.out.print(ch1[i]);
//
//            }
//            System.out.println();
//        }
//    }
//}
            //int i = 0;
//            while(i < ch1.length){
//                int j = 0;
//                while(j < ch2.length){
//                    if(ch1[i] == ch2[j]){
//                        j++;
//                    }else{
//                        System.out.println(ch1[i]);
//                    }
//                }
//                i++;
//            }
//            System.out.println();
//        }
//    }
//}
//public class Main{
//    public static void main(String[] args) {
//        int score = 0;
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//        int num = scanner.nextInt();
//        if(num == 0){
//            System.out.println(0);
//        }
//        int[] team = new int[3 * num];
//        for(int i = 0;i < team.length;i++){
//            team[i] = scanner.nextInt();
//        }
//        Arrays.sort(team);
//        for(int i = num;i < team.length-1;i+=2){
//            score += team[i];
//        }
//        //System.out.println(Arrays.toString(team));
//        System.out.println(score);
//    }
//}
//}
//
////They are students.
////aeiou
////Thy r stdnts.
//import java0305.ListNode;
//
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String string1 = scanner.nextLine();
//            String string2 = scanner.nextLine();
//            char[] ch1 = string1.toCharArray();
//            char[] ch2 = string2.toCharArray();
//            List<Character> linkedList = new LinkedList<>();
//            //char[] ch3 = new char[ch1.length - ch2.length];
//            int i = 0;
//            while(i < ch1.length){
//                int j = 0;
//                while(j < ch2.length){
//                    if(ch1[i] == ch2[j]){
//                        j++;
//                    }
//                }
//                linkedList.add(ch1[i]);
//                i++;
//            }
//            for(int num = 0;num < linkedList.size();num++){
//                System.out.print(linkedList.get(num));
//            }
//            System.out.println();
//        }
//    }
//}
////import java.util.*;
////public class Main {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        while(scanner.hasNext()){
////            String string1 = scanner.nextLine();
////            String string2 = scanner.nextLine();
////            char[] ch1 = string1.toCharArray();
////            char[] ch2 = string2.toCharArray();
////            Set<Character> setDelete = new HashSet<>() ;
////            for(char ch : ch2){
////                setDelete.add(ch);
////            }
////            Set<Character> setResult = new HashSet<>();
////            for(char ch : ch1){
////                if(setDelete.contains(ch)){
////                    continue;
////                }else{
////                    setResult.add(ch);
////                }
////            }
////            for(char ch : setResult){
////                System.out.print(ch);
////            }
////            System.out.println();
////        }
////    }
////}
