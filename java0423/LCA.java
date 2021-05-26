package java0423;

import java.util.*;


public class LCA {
    public static int lca = 1;
    public static int getLCA(int a, int b) {
        find(1,a,b);
        return lca;
    }
    public static boolean find(int x,int a,int b){
        int max = a > b ? a : b;
        int mid = 0;
        int left = 0;
        int right = 0;
        if(x <= max) {
             mid = (x == a || x == b) ? 1 : 0;
             left = find(2 * x, a, b) ? 1 : 0;
             right = find(2 * x + 1, a, b) ? 1 : 0;
        }
        if(mid + left + right == 2){
            lca = x;
        }
        return (mid + left + right) > 0;
    }

    public static void main(String[] args) {
        System.out.println(getLCA(2,3));
    }
}