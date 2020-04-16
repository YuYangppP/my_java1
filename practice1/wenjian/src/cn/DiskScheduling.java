package cn;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 磁盘调度FCFS、SSTF、SCAN、CSCAN
 *
 * @author yuyang
 * @version1.8
 * @data 2019年12月25日
 */

public class DiskScheduling {
    public static void main(String[] args) {
        int choice = -1;
/*
        int[] track = {55, 72, 100, 88, 93, 66}; //用来存磁道号
*/

        int[] track = {58, 155, 93, 61, 161, 29, 68, 0};

        //int[] track = new int[6];
        int i = -1;     //全局变量i
        int[] str = new int[6];

        System.out.println("随机得到的磁道序列为：");

        for (i = 0; i < track.length; i++) {
            System.out.print(track[i] + "  ");
        }
        System.out.println();
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("          1. 先来先服务                 ");
            System.out.println("          2. 最短寻道时间优先            ");
            System.out.println("          3. 扫描调度                  ");
            System.out.println("          4. 循环扫描                   ");
            System.out.println("          5. 退出菜单                  ");
            System.out.println("--------------------------------------");
            System.out.print("请选择算法：");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice == 5) {
                System.err.println("已成功退出程序！");
                break;
            }
            switch (choice) {
                case 1:
                    FCFS(track, track.length);
                    break;
                case 2:
                    SSTF(track, track.length);
                    break;
                case 3:
                    SCAN(track, track.length);
                    break;
                case 4:
                    CSCAN(track, track.length);
                    break;
                default:
                    System.err.println("请输入1-5之间的数字");
            }
        }
    }

    /**
     * 先来先服务
     *
     * @param track
     * @param s
     */
    public static void FCFS(int track[], int s)   //磁道号数组，个数为s
    {
        int now = -1;     //当前磁道号
        int sum = 0;     //总寻道长度
        int i;
        float ave = 0.0f;
        System.out.println("磁盘请求序列为：");
        for (i = 0; i < s; i++) {
            System.out.print(track[i] + "  ");
        }
        System.out.println();
        System.out.print("请输入当前的磁道号：");
        Scanner input = new Scanner(System.in);
        now = input.nextInt();
        sum += Math.abs(track[0] - now);//求当前输入磁道和第一要访问磁道的距离 例如：now为45  求的是45~58的距离    58,155,93,61,161,29,68,0
        System.out.println("磁盘扫描序列为：");
        for (i = 0; i < s; i++)   //输出磁盘扫描序列
        {
            System.out.print(" " + track[i]);
        }
        for (i = 0; i < s - 1; i++)   //求平均寻道长度
        {
            //58,155,93,61,161,29,68,0 依次求每两个之间的距离
            sum += Math.abs(track[i + 1] - track[i]);
            ave = (float) sum / s;
        }
        System.out.println();
        System.out.println("寻道总数：" + sum);
        System.out.println("平均寻道长度：" + ave);
    }

    /**
     * 最短寻道时间优先
     *
     * @param track
     * @param s
     */
    public static void SSTF(int track[], int s) {
        //用于第三种情况找到当前磁道号在排序好序列的位置
        int k = 1;
        int now = -1, left = -1, right = -1;
        int i, j, sum = 0;
        float ave;
        Arrays.sort(track);
        System.out.print("请输入当前的磁道号：");
        Scanner input = new Scanner(System.in);
        now = input.nextInt();
        if (track[s - 1] <= now) {
            System.out.println("磁盘扫描序列为：");
            for (i = s - 1; i >= 0; i--)
                System.out.print("  " + track[i]);
            sum = now - track[0];
        }
        if (track[0] >= now) {
            System.out.println("磁盘扫描序列为：");
            for (i = 0; i < s; i++) {
                System.out.print("  " + track[i]);
            }
            sum = track[s - 1] - now;
        }
        if (now > track[0] && now < track[s - 1]) {
            System.out.println("磁盘扫描序列为：");
            while (track[k] < now) {
                k++;
            }
            //表示此时位置的左边逻辑下标
            left = k - 1;
            //表示此时位置的右边逻辑下表
            right = k;
            //当前磁道在请求序列范围内
            while ((left >= 0) && (right < s)) {
                if ((now - track[left]) <= (track[right] - now))       //58,155,93,61,161,29,68,0
                                                                         // 0 29 58 61 68 93 155 161  例如45 选择与当前磁道最近的请求给予服务，
                {                                     //例如29和58比较谁和45比较看谁距离短就先给哪个服务
                    System.out.print("  " + track[left]); //这是左边距离近的情况
                    sum += now - track[left];
                    now = track[left];
                    left = left - 1;
                } else {  //System.out.print(now);
                    System.out.print("  " + track[right]);  //这是右边距离近的情况
                    sum += track[right] - now;
                    now = track[right];
                    right = right + 1;
                }
            }
            if (left == -1)   //磁头移动到序列的最小号，返回内侧扫描仍未扫描的磁道
            {
                for (j = right; j < s; j++) {
                    System.out.print(" " + track[j]);
                }
                sum += track[s - 1] - track[0];
            } else      //磁头移动到序列的最大号，返回外侧扫描仍未扫描的磁道
            {
                for (j = left; j >= 0; j--) {
                    System.out.print(" " + track[j]);//例如55 66 72 88 93 100假设当前磁道90
                }                                      //则按前面的算法会有90-->88-->93-->100,此时到100时right+1=6跳出循环
                sum += track[s - 1] - track[0];              //来到了else这个分支，把磁头转到之前left的位置循环输出
            }                                         //那个sum直接等于最后一个减去第一个，因为他总是会扫描到最外侧的磁道号
        }                                             //和（100-72）+（72-66）+（66-55）= 100-55 = 45 是一样的

        ave = sum / (float) (s);
        System.out.println();
        System.out.println("寻道总数：" + sum);
        System.out.println("平均寻道长度： " + ave);
    }

    /**
     * 扫描调度
     *
     * @param track
     * @param s
     */
    public static void SCAN(int track[], int s)    //先要给出当前磁道号和移动臂的移动方向
    {
        int k = 1;
        int now, left = -1, right = -1, choice = -1;
        int i, j, sum = 0;
        float ave = 0.0f;
        Arrays.sort(track);
        System.out.print("请输入当前的磁道号：");
        Scanner input = new Scanner(System.in);
        now = input.nextInt();
        //第一种情况：若当前磁道号大于请求序列中最大者，则直接由内向外依次给予各请求服务
        if (track[s - 1] <= now) {
            System.out.println("磁盘扫描序列为：");
            for (i = s - 1; i >= 0; i--) {
                System.out.print("  " + track[i]);
            }
            sum = now - track[0];   //反正都要扫描到最外侧，直接减最小的那个得的距离和一个一个减在相加是等价的
        }
        //第二种情况：若当前磁道号小于请求序列中最小者，则直接由外向内依次给予各请求服务
        if (track[0] >= now) {
            System.out.println("磁盘扫描序列为：");
            for (i = 0; i < s; i++) {
                System.out.print("  " + track[i]);
            }
            sum = track[s - 1] - now;        //同理
        }
        //第三种情况：若当前磁道号大于请求序列中最小者且小于最大者
        if (now > track[0] && now < track[s - 1]) {
            while (track[k] < now) {
                k++;
            }
            left = k - 1;
            right = k;
            System.out.println("请输入当前移动臂的移动的方向 (1 表示向内 ，0表示向外) : ");
            Scanner input2 = new Scanner(System.in);
            choice = input2.nextInt();
            if (choice == 0) {   //选择移动臂方向向外，则先向外扫描
                System.out.println("磁盘扫描序列为：");
                //往磁道号小的方向扫描，即向外扫描
                for (j = left; j >= 0; j--) {
                    System.out.print("  " + track[j]);
                }
                //磁头移动到最小号，则改变方向向内扫描未扫描的磁道
                for (j = right; j < s; j++) {
                    System.out.print("  " + track[j]);
                }
                //58,155,93,61,161,29,68,0
                sum = now - 2 * track[0] + track[s - 1]; //还是拿0 29 58 61 68 93 155 161举例子，当前磁道号是45，那么45先会往内扫描，扫描到最小号
            }                                //然后在转回到了right=58处，又再一次经过了now,然后向右扫描到最大号
            //所以可以这么算sum =(now-track[0])*2 + (track[s-1]-now)

            else     //选择移动臂方向向内，则先向内扫描
            {
                System.out.println("磁盘扫描序列为：");
                for (j = right; j < s; j++) {
                    System.out.print("  " + track[j]);
                }
                for (j = left; j >= 0; j--)    //磁头移动到最大号，则改变方向向外扫描未扫描的磁道
                {
                    System.out.print("  " + track[j]);
                }                                           //58,155,93,61,161,29,68,0     还是拿0 29 58 61 68 93 155 161举例子，当前磁道号是45，那么45先会往外扫描，扫描到最大号
                sum = -now - track[0] + 2 * track[s - 1]; //同理sum =(track[s-1]-now)*2 + (now - track[0])
            }
        }
        ave = sum / (float) (s);
        System.out.println();
        System.out.println("寻道总数：" + sum);
        System.out.print("平均寻道长度： " + ave);
    }

    /**
     * 循环扫描
     *
     * @param track
     * @param s
     */
    public static void CSCAN(int track[], int s)        //我默认是扫描方向是先向磁道号变小的方向进行，即从内到外
    {
        int k = 1;
        int now = -1, left = -1, right = -1;
        int i, j, sum = 0;
        float ave;
        Arrays.sort(track);
        System.out.println("排序后：");
        for (int n = 0; n < track.length; n++) {
            System.out.print(track[n] + "  ");
        }
        System.out.println();
        System.out.print("请输入当前的磁道号：");
        Scanner input = new Scanner(System.in);
        now = input.nextInt();
        //第一种情况：若当前磁道号大于请求序列中最大者，则直接将移动臂移动到最小号磁道依次向内给予各请求服务
        if (track[s - 1] <= now) {
            System.out.println("磁盘扫描序列为：");
            for (i = s - 1; i >= 0; i--) {
                System.out.print("  " + track[i]);
            }
            //和SCAN算法一样 55 66 72 88 93 100 当前磁道号为101
            sum = now - track[0];
        }

        //第二种情况：若当前磁道号小于请求序列中最小者，则移动磁道到最大位置由外向内依次给予各请求服务,
        if (track[0] >= now) {
            System.out.println("磁盘扫描序列为：");
            for (i = s - 1; i >= 0; i--) {
                System.out.print("  " + track[i]);
            }
            //55 66 72 88 93 100 当前磁道号54
            sum = 2 * track[s - 1] - now - track[0];
        }                        //sum = (track[s-1] - now) + (track[s-1]-track[0])

        //第三种情况：若当前磁道号大于请求序列中最小者且小于最大者
        if (now > track[0] && now < track[s - 1]) {
            System.out.println("磁盘扫描序列为：");
            //同上，先找到当前磁道号的位置
            while (track[k] < now) {
                k++;
            }
            left = k - 1;
            right = k;
            //例：55 66 72 88 93 100 当前磁道号90
            for (j = left; j >= 0; j--) {
                System.out.print("  " + track[j]);
            }
            //当扫描完最小号磁道，磁头直接移动到最大号磁道，再向外扫描未扫描的磁道
            for (j = s - 1; j > left; j--) {
                System.out.print("  " + track[j]);
            }
            //sum=(now-track[0])+(track[s-1]-track[0])+(track[s-1]-track[right])
            sum = 2 * track[s - 1] - track[right] + now - 2 * track[0];
        }
        ave = sum / (float) (s);
        System.out.println();
        System.out.println("寻道总数：" + sum);
        System.out.println("平均寻道长度： " + ave);
    }

}