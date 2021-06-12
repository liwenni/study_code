package java0510;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
//            String str1 = scanner.nextLine();
//            String str2 = scanner.nextLine();
            String str1 ="abcdfghijklmnop";
            String str2 = "abcfjklmnopq";
            StringBuffer str = new StringBuffer();
            int count = 0;
            int maxCount = 0;
            int i = 0;
            int j = 0;
            while(i < str1.length() && j < str2.length()){
                if(str1.charAt(i) == str2.charAt(j)){
                    str.append(str1.charAt(i));
                    count++;
                }else{
                    if(count >= maxCount){
                        maxCount = count;
                    }else{
                        count = 0;
                        str.delete(0,str.length());
                    }
                }
                i++;
                j++;
            }
            if(count > maxCount){
                maxCount = count;
                if(i==str1.length()){
                    str.append(str1.charAt(str1.length()-1));
                }else if(j == str2.length()){
                    str.append(str2.charAt(str2.length()-1));
                }
            }
            System.out.println(str.toString());
        }
    }
}
