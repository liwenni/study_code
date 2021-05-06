package java0403;

import java.util.Arrays;

public class MySort {
    //1.插入排序
    public static void insertSort(int[] arr){
        int bound = 1;
        for(;bound < arr.length;bound++){
            int v = arr[bound];
            int i = bound - 1;
            for(;i >= 0;i--){
                if(v < arr[i]){
                    arr[i + 1] = arr[i];
                }else{
                    break;
                }
            }
            arr[i + 1] = v;
        }
    }
    //2.希尔排序
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while(gap > 0){
            _shellSort(arr,gap);
            gap = gap / 2;
        }
    }
    public static void _shellSort(int[] arr,int gap){
        int bound = 1 + gap;
        for(;bound < arr.length;bound+=gap){
            int v = arr[bound];
            int i = bound - gap;
            for(;i > 0;i-=gap){
                if(v < arr[i]){
                    arr[i + gap] = arr[i];
                }else{
                    break;
                }
            }
            arr[i + gap] = v;
        }
    }
    //3.选择排序
    public static void selectSort(int[] arr){
        int bound = 0;
        for(;bound < arr.length;bound++){
            for(int i = bound + 1;i < arr.length;i++){
                if(arr[i] < arr[bound]){
                    swap(arr,i,bound);
                }
            }
        }
    }
    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    //4.堆排序(升序建大堆)
    public static void heapSort(int[] arr){
        createHeap(arr);
        int headSize = arr.length;
        while(headSize > 0){
            //将堆顶元素和最后一个元素交换
            swap(arr,0,headSize - 1);
            headSize--;
            //向下调整
            shiftDown(arr,headSize,0);
        }
    }
    public static void shiftDown(int[] arr,int size,int index){
        int parent = index;
        int child = parent * 2 + 1;
        while(child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            if (arr[parent] < arr[child]) {
                swap(arr, parent, child);
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    public static void createHeap(int[] arr){
        for(int i = (arr.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(arr,arr.length,i);
        }
    }
    //5.冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j =  1;j < arr.length;j++){
                if(arr[j - 1] > arr[j]){
                    swap(arr,j,j - 1);
                }
            }
        }
    }
    //6.快速排序
    public static void quickSort(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        _quickSort(arr,left,right);
    }
    public static void _quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int index = partition(arr,left,right);
        _quickSort(arr,left,index - 1);
        _quickSort(arr,index + 1,right);

    }
    public static int partition(int[] arr,int left,int right){
        int tag = arr[right];
        int l = left;
        int r = right;
        while(l < r) {
            while (l < r && arr[l] <= tag) {
                l++;
            }
            while (l < r && arr[r] >= tag) {
                r--;
            }
            swap(arr,l,r);
        }
        swap(arr,l,right);
        return l;
    }
    //7.归并排序
    public static void mergeSort(int[] arr) {
        _mergeSort(arr, 0, arr.length);

    }
    public static void _mergeSort(int[] arr,int left,int right){
        if(right - left <= 1){
            return;

        }
        int mid = (left + right) / 2;
        _mergeSort(arr,left,mid);
        _mergeSort(arr,mid,right);
        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right){
        if(left >= right){
            return;

        }
        int[] temp = new int[right - left];
        int tempsize = 0;
        int l = left;
        int r = mid;
        while(l < mid && r < right){
            if(arr[l] >= arr[r]){
                temp[tempsize] = arr[r];
                r++;
                tempsize++;
            }else{
                temp[tempsize] = arr[l];
                l++;
                tempsize++;
            }

        }
        while(l < mid){
            temp[tempsize] = arr[l];
            l++;
            tempsize++;
        }
        while(r < right){
            temp[tempsize] = arr[r];
            r++;
            tempsize++;
        }
        for(int i = 0;i < temp.length;i++){
            arr[left + i] = temp[i];

        }
    }
    public static void main(String[] args) {
        int arr[] = {1,4,2,3,6,9,7};
        //insertSort(arr);
        //shellSort(arr);
        //shellSort(arr);
        //heapSort(arr);
        //bubbleSort(arr);
        //quickSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
