package sort;

public class shellSort {
    public static void shellSort(int[] arr){
        //int[] arr = {2,5,3,7,4,1,6,9};8
        //             0 1 2 3 4 5 6 7
        int len = arr.length;
        if(len == 1) return;
        int step = len/2;
        while(step >= 1){
            for(int i = step;i < len;i++){
                int tmp = arr[i];
                int j = 0;
                for(j = i-step;j >=0;j = j-step){
                    if(tmp < arr[j]){
                        arr[j+step] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+step] = tmp;
            }
            step = step / 2;
        }
    }
    public static void main(String[] args){
        int[] arr = {2,5,3,77,4,1,3,4,6};
        shellSort(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }
}
