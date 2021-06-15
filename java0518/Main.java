package java0518;

// write your code here
import java.util.*;

public class Main{
    public static void main(String[] args){
        //Scanner scanner = new Scanner(System.in);
        //while(scanner.hasNext()){
            //int num = scanner.nextInt();
        int num = 24;
            int ret = num;
            int result = 0;
            while(ret >= 10){
                while(num > 0){
                    ret = num % 10;
                    ret = ret + result;
                    num = num / 10;
                    result = ret;
                }
                //result = ret;
            }
            System.out.println(ret);
        }
    //}
}
