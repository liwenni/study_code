package string;

public class myIndexOf {
    public static int myIndexof (String s1,String s2) {
        String temp;
        int length=s2.length();
        for(int i=0;i<s1.length()-length;i++)
        {
            temp = s1.substring(i, i+length);
            if(temp.equals(s2))
                return i;
        }
        return -1;

    }
    public static void main(String[] args) {
        String s1="hello world";
        String s2="wor";
        System.out.println(myIndexof(s1, s2));
    }


}
