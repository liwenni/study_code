package string;

public class myReplace {
    public static String Replacechar(String s, String t, String r) {
        String string = "";
        int time = 0;  //匹配次数计数器
        try {
            char s1[] = s.toCharArray();
            char t1[] = t.toCharArray();
            int i = 0, j = 0;

            while (i < s1.length && j < t1.length) {
                if (s1[i] == t1[j]) {
                    i++;
                    j++;
                    if (j == t1.length) {
                        time++;
                        string += r;
                        j = 0;
                    }
                } else {
                    i = i - j + 1;
                    j = 0;
                    string += String.valueOf(s1[i - 1]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }if(time==0){
            System.out.println("原字符串中不存在此字串！");
            return  s;
        }else {
            return string;
        }
    }

    public static void main(String[] args) {
        String s = "hello world";
        String t = "world";
        String r = "java";
        System.out.println(Replacechar(s,t,r));
    }
}
