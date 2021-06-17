package string;

import java.util.Arrays;

public class mySplit {
    public static void main(String[] args) {
        String string = "abd-def-ghi";
        MySplit(string,'-');
    }

    private static void MySplit(String string, char c) {
        //统计字符串中分隔符的个数
        int count = 0;
        for(int i=0;i<string.length();i++){
            if(c == string.charAt(i)){
                count++;
            }
        }
        //创建字符串类型的数组
        String[] result = new String[count + 1];
        Arrays.fill(result,"");
        char temp = ' ';
        int t = 0;

        //截取字符串
        for(int i = 0;i<string.length();i++){
            if(c != string.charAt(i)){
                temp = string.charAt(i);
                result[t] += temp;
            }else
                t++;
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
