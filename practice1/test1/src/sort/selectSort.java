package sort;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4,6,8,10,11};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //选择排序
    public static void selectSort(int[] arr){
        //遍历所有的数
        for(int i=0; i<arr.length; i++){
            int min = i;
            //把当前便利的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for(int j=i+1; j<arr.length; j++){
                //如果后面比较的数比记录的最小的数小
                if(arr[j]<arr[min]){
                    //记录最小的那个数的下标
                    min = j;
                }
            }
            //如果最小的数和当前遍历数的下标不一致，说明下标为min的数比当前便利的数更小
            if(i!=min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
