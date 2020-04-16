package Test1;

import java.util.concurrent.TimeUnit;

/**
 * @author:yuyang
 * @data:2019-05-27 19:40
 **/
public class ThreadInterrupt {
    public static void main(String[] args) {
        System.out.println("Main thread is interrupt? "+Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupt? "+Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("I will be interrupted still.");
        }
        
    }
}
