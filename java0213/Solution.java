package java0213;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>0;j--){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
       return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target));

    }
}
//    public static String addBinary(String a, String b) {
//        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
//    }
//
//    public static void main(String[] args) {
//        String a="1010";
//        String b = "1011";
//        System.out.println(addBinary(a,b));
//    }
//}
//    public static int[] plusOne(int[] digits) {
//        int[] a = digits;
//        int end = a[a.length-1];
//        int start = a[a.length-1];
//        if(end<9){
//            a[a.length-1] = end + 1;
//            return a;
//        }
//        while(start>0){
//            start = start / 10;
//        }
//        end = a[a.length-1];
//        while(end>0){
//            end = end % 10;
//        }
//        if(end<9){
//            a[a.length-1] = end;
//            a[0] = start;
//            return a;
//        }else if(end == 9){
//            a[a.length-1] = 0;
//            a[0] = start + 1;
//            return a;
//        }
//return a;
//    }
//
//    public static void main(String[] args) {
//        int[] a = {1,2};
//        System.out.println(plusOne(a));
//    }
//}
//    public static int pivotIndex(int[] nums) {
//        int sum = 0,leftSum = 0;
//        for(int i = 0;i<nums.length;i++){
//            sum += nums[i];
//        }
//        for(int i = 0;i<nums.length;i++){
//            if(leftSum * 2==sum - nums[i] ){
//                return i;
//            }
//            leftSum += nums[i];
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        System.out.println(pivotIndex(nums));
//    }
//}
//    public static String reverseOnlyLetters(String S) {
//            char[] ch = S.toCharArray();
//            char temp;
//            int start = 0,end = ch.length - 1;
//            while(start < end){
//                if(!Character.isLetter(ch[start])){
//                    start++;
//                }
//                if(!Character.isLetter(ch[end])){
//                    end--;
//                }
//                if(Character.isLetter(ch[start]) && Character.isLetter(ch[end])){
//                    temp = ch[start];
//                    ch[start] = ch[end];
//                    ch[end] = temp;
//                    start++;
//                    end--;
//                }
//            }
//            return new String(ch);
//    }
//
//    public static void main(String[] args) {
//        String s = "a-bC-dEf-ghIj";
//        System.out.println(reverseOnlyLetters(s));
//    }
//}
    //给定一个非负整数数组 A ，返回一个数组，在该数组中，
    // A 的所有偶数元素之后跟着所有奇数元素
   // public static int[] sortArrayByParity(int[] A) {
//        int[] B = new int[A.length];
//        B = A;
//        int i, j, temp;
//        for (i = 0; i < A.length; i++) {
//            for (j = i + 1; j < A.length; j++) {
//                if (A[j] % 2 == 0) {
//                    temp = A[i];
//                    A[i] = A[j];
//                    A[j] = temp;
//                }
//            }
//        }
//       return B;
//    }
//
//    public static void main(String[] args) {
//        int[] A={0,1,2,3,4,5,6};
//        System.out.println(sortArrayByParity(A));
//    }
//
//}

//    public static String reverseOnlyLetters(String S) {
//        char[] datas = S.toCharArray();
//        char temp = 'a';
//
//        for(int i = 0;i <= datas.length/2;i++){
//            if((datas[i] >= 97 && datas[i] <= 122) || (datas[i] >= 65&&datas[i] <= 90)){
//
//                temp = datas[i];
//                datas[i] = datas[datas.length-1-i];
//                datas[datas.length-1-i] = temp;
//
//            }
//        }
//        String string = String.valueOf(datas);
//        return string;
//    }
//
//    public static void main(String[] args) {
//        String s = "a-bC-dEf-ghIj";
//        System.out.println(reverseOnlyLetters(s));
//
//    }
//}
//    public static int[] sortedSquares(int[] nums) {
//        for(int i = 0;i<nums.length;i++){
//            if(nums[i] < 0){
//                nums[i] = Math.abs(nums[i]);
//            }
//            nums[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(nums);
//        return nums;
//    }
//
//    public static void main(String[] args) {
//        int[] nums ={-1,0,4,2,1,-3};
//        System.out.println(sortedSquares(nums));
//    }
//}
//    public static boolean isLongPressedName(String name, String typed) {
//        char[] nameChar = name.toCharArray();
//        char[] typedChar = typed.toCharArray();
//       int i=0,j=0;
//       while(i<nameChar.length){
//            while(j<typedChar.length)
//                if (nameChar[i] == typedChar[j]) {
//                    i++;
//                    j++;
//            } else if (j > 0 && typedChar[j] == typedChar[j - 1]) {
//                j++;
//            } else
//                return false;
//        }
//         return i == nameChar.length;
//
//
//    }
//    public static void main(String[] args) {
//        String name = "";
//        String typed = "vttkgnn";
//        System.out.println(isLongPressedName(name,typed));
//    }
//}
    //给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数返回 true。如果数组中
    //每个元素都不相同，则返回 false。
//    public static boolean containsDuplicate(int[] nums){
//        for(int i =0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i] == nums[j]){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int[] nums={1,2,1,1};
//        System.out.println(containsDuplicate(nums));
//
//    }
//}

//    public static int lengthOfLastWord(String s) {
//        s = s.trim();
//        String[] result = s.split(" ");
//        return  result[result.length -1].length();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("  "));
//    }
//}
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//       int[] newNums1 = new int[nums1.length + n];
//        int i, j;
//        for (i = 0; i < nums1.length; i++) {
//            newNums1[i] = nums1[i];
//        }
//        for (i = m, j = 0; i < newNums1.length && j < n; i++, j++) {
//            newNums1[i] = nums2[j];
//        }
//        Arrays.sort(newNums1);
//        nums1 = newNums1;
//        for (i = 0; i < nums1.length; i++) {
//            System.out.println(nums1[i]);
//
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums1 ={1,2,3};
//        int[] nums2 = {2,5,6};
//        merge(nums1,nums1.length,nums2,nums2.length);
//    }

    //给定一个整数数组，判断是否存在重复元素。
    // 如果任何值在数组中出现至少两次，函数返回 true。
    // 如果数组中每个元素都不相同，则返回 false。
//    public boolean containsDuplicate(int[] nums) {
//        for(int i=0;i<nums.length;i++){
//            nums[i]&nums[i+1];
//        }
//    }


    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
    // 使得 num1 成为一个有序数组.
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] newNums1 = new int[nums1.length + n];
//        int i, j;
//        for (i = 0; i < nums1.length; i++) {
//            newNums1[i] = nums1[i];
//        }
//        for (i = m, j = 0; i < newNums1.length && j < n; i++, j++) {
//            newNums1[i] = nums2[j];
//        }
//        Arrays.sort(newNums1);
//        nums1 = newNums1;
//        for (i = 0; i < nums1.length; i++) {
//            System.out.println(nums1[i]);
//
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums1 ={1,2,3};
//        int[] nums2 = {4,7,0,5};
//        merge(nums1,nums1.length,nums2,nums2.length);
//    }
//    }

    //给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    // 如果不存在最后一个单词，请返回 0.
//    public static int lengthOfLastWord(String s) {
//        if(s == null || s == " "){
//            return 0;
//        }
//        String[] result = s.split(" ");
//        String lastWord = result[result.length - 1];
//        return lastWord.length();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord(" "));

//    public static boolean isPalindrome(int x) {
//        String s = Integer.toString(x);
//        StringBuffer s1 = new StringBuffer(s);
//        String s3 = s1.reverse().toString();
//        if(s.equals(s3)){
//        return true;
//        }
//        return false;
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//
//    }

