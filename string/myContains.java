package string;

public class myContains {
    public static boolean myContains(String s1,String s2){
        String temp;
        for(int i=0;i<s1.length() - s2.length();i++){
            temp = s1.substring(i,i+s2.length());
            if(temp.equals(s2)){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "hello";
        System.out.println(myContains(s1,s2));
    }
}
