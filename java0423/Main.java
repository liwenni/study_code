package java0423;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            byte n = scanner.nextByte();
            String s = "";
            while (n > 0) {
                s = s + n % 2;
                n = (byte) (n / 2);
            }
            int max = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                } else {
                    if (count >= max) {
                        max = count;
                    } else {
                        count = 0;
                    }
                }
            }
            if (max <= count) {
                max = count;
            }
            System.out.println(max);
        }
    }
}