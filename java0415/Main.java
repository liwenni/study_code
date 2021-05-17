package java0415;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length = 0;
        int max = 0;
        int end = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String string = scanner.nextLine();
            //char[] ch = string.toCharArray();
            for(int i = 0;i < string.length();i++){
                if(string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                    length++;
                    if(length > max){
                        end = i;
                        max = length;
                    }
                }else{
                    length = 0;
                }
            }
            System.out.println(string.substring(end - max + 1,end + 1));
        }
    }
}
