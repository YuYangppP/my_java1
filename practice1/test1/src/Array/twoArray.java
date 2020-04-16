package Array;
/*
题目：将两个有序数组合并成一个有序数组
基本思路
　　  1.若不满足1中的情况，则表明数组需要拆分，拆分的方法如下：

　　　（1）拆分前，默认两个数组以及最终输出数组的索引均为0；

　  　（2）将 两个数组 对应索引下的元素进行比较，小的一方 放入最终数组中的当前索引下的位置，并使小的一方数组的索引+1；

　　　（3）检查是否有数组已经遍历完毕，若有（即该数组的元素已经完全分配到结果数组中），则将另一个数组的剩余元素依次放入最终数组中，直接输出即可。

　　  （4）最终数组的索引+1，并重复（2），直到两个数组均完成索引任务。

 */
public class twoArray {
    public static void main(String[] args) {
        int[] a = new int[] {1,4,7,8};
        int[] b = new int[] {2,5,9,12,23};
        int[] c = sort(a, b);
        for(int i = 0; i<c.length; i++){
            System.out.print(c[i]+" ");
        }

    }
    public static int[]  sort(int[] a,int[] b){
            int[] c = new int[a.length+b.length];
            int i=0,j=0,k = 0;
            while (i<a.length&&j<b.length){
                if(a[i]>=b[j]){
                    c[k++] = b[j++];

                }else {
                    c[k++] = a[i++];
                }
            }

            while (j<b.length){
                c[k++] = b[j++];
            }
            while (i<a.length){
                c[k++] = a[i++];
            }
            return c;
        }
}
