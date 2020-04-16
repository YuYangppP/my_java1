package test;

import java.util.stream.Stream;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName T1.java
 * @Description TODO
 * @Date 2019/10/18 13:46
 */
public class T1 {
    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }
}
