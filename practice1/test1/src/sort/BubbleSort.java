package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,7,2,4,11,0};
        System.out.println("排序前:"+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后:"+ Arrays.toString(arr));

    }
    /*
     冒泡排序
     1,3,5,7,2,4,11,0
     需要比较length-1轮
     */
    public static void bubbleSort(int[] arr){
        //一共比较多少轮
        for(int i=0; i<arr.length-1; i++){
            //比较的次数
            for(int j=0; j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
