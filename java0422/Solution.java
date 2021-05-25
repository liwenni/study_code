package java0422;
import java.util.*;
    public class Solution {
        public static int countWays(int x, int y) {
            // write code here
            //int arr[][] = new int[x][y];
            int i = 0;
            int j = y - 1;
            int count = 0;
                while(i != x-1){
                    i++;
                    count++;
                }
                while(j != 0){
                    j--;
                    count++;
                }
            return count;
        }
        public static void main(String[] args) {
            System.out.println(countWays(2,3));
        }
    }

