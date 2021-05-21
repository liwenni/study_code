package java0417;

import java.util.*;
import java.lang.String;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int count = 0;
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();

            for(int i = 0;i <= str1.length();i++){
                StringBuffer str = new StringBuffer();
                str.append(str1);
                str.insert(i,str2);
                if(isHW(str)){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
    public static boolean isHW(StringBuffer str){

//        String newStr = (str.reverse()).toString();
//        if(newStr.equals(str.toString())){
//            return true;
//        }
//        return false;
        return (new StringBuffer(str).reverse()).toString().equals(str.toString());
    }
}
