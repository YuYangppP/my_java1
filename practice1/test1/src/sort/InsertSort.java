package sort;

import java.util.Arrays;

public class InsertSort {


    public static void  sort(int[] arr) {
            // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
            //int[] arr = {2,5,3,77,4,1,6};
//                         0 1 2 3  4 5 6
            for (int i = 1; i < arr.length; i++) {
                for(int j = i; j>0 && arr[j]<arr[j-1];j-- ){
                    swap(arr,j,j-1);
                }
             }
        }
    static void swap(int[] arr,int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
    }
    public static void main(String[] args){
            int[] arr = {2,5,3,77,4,1,3,4,6};
            sort(arr);
            System.out.print(Arrays.toString(arr));

    }
}
