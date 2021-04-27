package java0324;

import java.util.Arrays;
import java.util.Stack;

public class sort {
    //插入排序
    public static void insertSort(int[] arr){
        //将整个数组区间分为已排序区间和待排序区间。初始已排序区间可为第一个元素
        //已排序区间 [0,1)
        //待排序区间 [1,arr.length)
        int bound = 1;
        //外层循环表示待排序插入的次数
        for(;bound < arr.length;bound++){
            int v = arr[bound];//待排序的第一个元素
            int cur = bound - 1;//已排序的最后一个元素
            //里层循环寻找待排序元素要插入的位置
            for(;cur >= 0;cur--){
                if(arr[cur] > v){
                    //比待排序元素大，需往后搬移一个位置
                    arr[cur + 1] = arr[cur];
                }else{
                    //当前cur位置的元素 < 待排序元素小,即已找到插入位置，循环结束
                    break;
                }
            }
            //将元素插入到cur后面一个位置
            arr[cur + 1] = v;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while(gap >= 1){
            _shellSort(arr,gap);
            gap = gap / 2;
        }
    }
    //进行分组直接插入排序
    public static void _shellSort(int[] arr,int gap){
        int bound = gap;
        for(;bound < arr.length;bound++){
            int v = arr[bound];
            int cur = bound - gap;
            for(;cur >= 0;cur -= gap){
                if(arr[cur] > v){
                    arr[cur + gap] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur + gap] = v;
        }
    }

    //选择排序
    public static void seletSort(int[] arr){
        //已排序区间[0,bound)
        //待排序区间[bound,arr.length)
        int bound = 0;
        for(;bound < arr.length;bound++){
            for(int cur = bound + 1;cur < arr.length;cur++){
                if(arr[cur] < arr[bound]){
                    int tmp = arr[cur];
                    arr[cur] = arr[bound];
                    arr[bound] = tmp;
                }
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr){
        //1、创建堆
        createHeap(arr);
        int heapSize = arr.length;
        //2、删除堆顶元素（交换堆顶和最后一个元素，再size--）
        //交换后，数组最后一个元素就为最大值，size--,堆长度-1，将最大值从堆顶删除，
        //此时再对堆进行向下调整，再取下一个最大值，依次循环使得数组从后往前依次有序......
        while(heapSize > 0) {
            swap(arr, 0, heapSize - 1);
            heapSize--;//heapSize--,对数组长度不产生影响
            shiftDown(arr,heapSize,0);
        }
    }
    //向下调整
    public static void shiftDown(int[] arr,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            if(child + 1 < size && arr[child + 1] > arr[child]){
                child = child + 1;
            }
            if(arr[parent] < arr[child]){
                swap(arr,parent,child);
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    //创建堆
    public static void createHeap(int[] arr){
        for(int i = (arr.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(arr,arr.length,i);
        }
    }
    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        //外层循环控制比较趟数,每一趟完都将最大元素放到最后一位
        for(int i = 0;i < arr.length;i++){
            //里层循环进行相邻两元素的比较和交换操作
//            for(int j = 1;j < arr.length;j++){
//                if(arr[j - 1] > arr[j]){
//                    swap(arr,j - 1,j);
//                }
//            }
            for(int j = arr.length - 1;j > 0;j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr,j,j - 1);
                }
            }
        }
    }
    //快速排序（递归实现）
    public static void quickSort(int[] arr)
    {
        _quickSort(arr,0,arr.length - 1);
    }
    public static void _quickSort(int[] arr,int left,int right){
        if(left >= right){
            //只有一个元素或没有元素，不需要排序
            return;
        }
        //[left,right]
        int index = partition(arr,left,right);
        _quickSort(arr,left,index - 1);
        _quickSort(arr,index + 1,right);
    }
    //partition方法返回值表示整理完当前区间后，基准值所在的位置，
    //即遍历过程中left和right重合的位置
    public static int partition(int[] arr,int left,int right) {
        int q = arr[right];//选取最后一个元素为基准值
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[i] <= q) {
                i++;
            }   //循环结束，i指向一个比基准值大的元素

            while (i < j && arr[j] >= q) {
                j--;
            }   //循环结束，j指向一个比基准值小的元素
            //找到左侧比基准值大的元素和右侧比基准值小的元素后，将两元素交换
            swap(arr, i, j);
        }   //循环结束，i 和 j 重合
        //交换重合位置元素和基准元素，使得基准值左侧元素均比基准值小，右侧元素均比基准值大
        swap(arr,i,right);
        return i;
    }

    //快速排序（非递归） 相似与二叉树的非递归先序遍历
    public static void quickSortByLoop(int[] arr){
        //1、创建栈，保存当前每一个待处理的区间
        Stack<Integer> stack = new Stack<>();
        //2、将第一组要处理的区间入栈（将根节点入栈）
        stack.push(0);
        stack.push(arr.length - 1);
        //3、循环取栈顶元素的区间，进行partition操作
        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right){
                continue;
            }
            //4、调用partition方法，进行整理
            int index = partition(arr,left,right);
            //5、将得到的子区间入栈[left,index - 1] [index + 1,right]
            //（右子树入栈）
            stack.push(index + 1);
            stack.push(right);
            //（左子树入栈）
            stack.push(left);
            stack.push(index - 1);
        }
    }

    //归并排序
    public static void mergeSort(int[] arr)
    {
        _mergeSort(arr,0,arr.length);
    }
    //辅助递归方法
    public static void _mergeSort(int[] arr,int left,int right){
        if(right - left <= 1){//[left,right) 区间只有一个元素或没有元素
            return;
        }
        int mid = (left + right) / 2;
        //先让左区间有序[left,mid)
        _mergeSort(arr,left,mid);
        //让右区间有序[mid,right)
        _mergeSort(arr,mid,right);
        //合并两个有序区间
        merge(arr,left,mid,right);
    }

    //此方法将两个有序数组进行归并
    //[left,mid)  [mid,right)
    public static void merge(int[] arr,int left,int mid,int right){
        if(left >= right){
            return;//空区间直接返回
        }
        //创建临时空间数组用来保存归并结果
        int[] temp = new int[right - left];
        int l = left;
        int r = mid;
        int tempIndex = 0;
            while (l < mid && r < right) {
                if (arr[l] <= arr[r]) { //<= 保证稳定性
                    temp[tempIndex] = arr[l];
                    tempIndex++;
                    l++;
                }else{
                    temp[tempIndex] = arr[r];
                    tempIndex++;
                    r++;
                }
            }
            //循环结束后，将剩余元素添加到最终结果中
            while(l < mid){
                temp[tempIndex] = arr[l];
                tempIndex++;
                l++;
            }
            while(r < right){
                temp[tempIndex] = arr[r];
                tempIndex++;
                r++;
            }

        //将temp中的元素返回到arr数组中(保证原地排序)
        //temp对应的是原数组中[left,right)区间的数组
        for(int i = 0;i < temp.length;i++){
            arr[left + i] = temp[i];
        }
    }

    //归并排序（非递归）
    public static void mergeSortByLoop(int[] arr){
        int gap = 1;
        for(;gap < arr.length;gap *= 2){//gap为待归并数组的长度 第一次是长度为1的两个数组归并，
            // 第二次是两个长度为2的数组归并...,即以长度2*gap的两个数组归并
            for(int i = 0;i < arr.length;i += 2*gap){
                //一个数组的长度时gap，每次循环合并两个gap长的数组，
                // 所以下次循环从i+2*gap开始循环
                //确定要归并的两个数组的区间[left,mid)和[mid,right)
                int left = i;
                int mid = i + gap;
                //防止数组溢出，大于数组长度时，置mid = arr.length，此时最后一个区间就为空区间了
                if(mid >= arr.length){
                    mid = arr.length;    //eg:[7,7)为空区间，不必处理
                }
                int right = i + 2 * gap;
                if(right >= arr.length){//同上
                    right = arr.length;
                }
                merge(arr,left,mid,right);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,1,7,2,8,4};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
