package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName LIS.java
 * @Description TODO
 * @Date 2019/10/12 12:49
 */
public class LIS
{
    public static void main(String[] args)
    {
        //int[] a = {1, -1, 2, -3, 4, -5, 6, -7};
        int[] b = {1,3,4,2,5,6,7};
       // find1(a);
        find1(b);
    }

    // [1, -1, 2, -3, 4, -5, 6, -7]
    // [1, 1, 2, 1, 3, 1, 4, 1]
    /**时间复杂度:O(N*N)**/
    public static void find1(int[] a)
    {
        int length = a.length;
        int[] list = new int[length];
        // 存储第i个元素之前的最长递增序列值
        List<Integer> result = new ArrayList<Integer>();
        // 存储最长递增序列
        for (int i = 0; i < length; i++)
        {
            list[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (a[j] < a[i] && list[j] + 1 > list[i])
                {
                    list[i] = list[j] + 1;
                    if (result.isEmpty())
                    {
                        result.add(list[j]);
                    }
                    if (!result.contains(list[i]))
                    {
                        result.add(list[i]);
                    }
                }
            }
        }
        // 寻找list中最大值
        int max = list[0];
        for (int i = 0; i < length; i++)
        {
            if (list[i] > max)
            {
                max = list[i];
            }
        }
        System.out.println("最长递增序列长度：" + max);
        System.out.println("最长递增序列：" + result);
    }
}