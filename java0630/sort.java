package java0630;

import java.util.Arrays;

public class sort {
    //二分查找(前提：数组有序)
    public static int searchSort(int[] arr,int k){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (end+start)/2;
            if(arr[mid] > k){
                end = mid-1;
            }else if(arr[mid] < k){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void bubbleSort(int[] arr){
        for(int bound = 0;bound < arr.length;bound++){
            for(int end = arr.length-1;end>bound;end--){
                if(arr[end-1]>arr[end]){
                    swap(arr,end-1,end);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,1,4,6,3,8};
        //bubbleSort(arr);
        System.out.println(searchSort(arr,3));
        //System.out.println(Arrays.toString(arr));
    }
}
