package java0202;

public class Solution {
    public static boolean canThreePartsEqualSum(int[] arr){
        //数组的和不是3的倍数，返回false
        //遍历数组并累加，累加值每等于数组和的三分之一，counter++
        //若i<length-1之前找到两段（counter == 2），则必有第三段，返回false
         if(arr.length==0){
            return false;
        }
        int sum = 0;
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
        }

        if (sum % 3 != 0) {
            return false;
        }
       int sub = sum / 3;
        int subSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            subSum += arr[i];
            if (subSum == sub) {
                count++;
                if (count == 2) {
                    return true;
                }
                subSum = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(arr));

    }
}
