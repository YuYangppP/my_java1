package test;

import java.util.Scanner;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Pd.java
 * @Description TODO
 * @Date 2019/10/14 22:09
 */

class Judge{
        void f(char c){
            if(c >=47 && c <=58){
                System.out.println("是数字");
            }else {
                System.out.println("不是数字");
            }
        }
}

public class Pd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char s = sc.next().charAt(0);
        Judge p = new Judge();
        p.f(s);

    }
}
