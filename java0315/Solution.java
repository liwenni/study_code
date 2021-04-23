package java0315;

public class Solution {
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1 == null && s2 == null){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for(int i = 0;i < ch1.length;i++){
            for(int j = 0;j < ch2.length;j++){
                if(ch1[i] != ch2[j]){
                    return false;
                }
            }

        }
    return true;}
//    public static boolean isUnique(String astr) {
//        if(astr == null){
//            return true;
//        }
//        char[] ch = astr.toCharArray();
//        for(int i = 0;i < ch.length;i++){
//            for(int j = i + 1;j < ch.length;j++){
//                if(ch[i] == ch[j]){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        String s = " ";
//        System.out.println(isUnique(s));
//    }
}
