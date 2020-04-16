package sort;

public class quickSort {
    public static void main(String []args){
        int[] arr = {6,4,0,100,-10};
        sort(arr,0,arr.length-1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    /*
    快速排序
     */
    public static void sort(int[] arr,int leftBound,int rightBound) {

        if(leftBound >= rightBound){
            return;
        }
        int left = leftBound;
        int right = rightBound;
        int key = arr[left];

        while(left < right){
            while(arr[right] >=key && left < right){
                right--;
            }
            int t = arr[right];
            arr[right] = arr[left];
            arr[left] = t;
             while(arr[left] <= key && left < right){
                left++;
            }
            t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;

        }
        sort(arr, leftBound, left-1);
        sort(arr, left+1, rightBound);
    }
}
