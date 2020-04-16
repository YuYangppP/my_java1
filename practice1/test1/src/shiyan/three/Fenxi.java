package shiyan.three;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Fenxi.java
 * @Description TODO
 * @Date 2019/10/28 12:19
 */
public class Fenxi {
    public static double getTotalScore(String s){
        Scanner scanner=new Scanner(s);
        scanner.useDelimiter("[^0123456789.]+");
        double totalScore=0;
        while(scanner.hasNext()){
            try{
                double score=scanner.nextDouble();
                totalScore=totalScore+score;
            }
            catch(InputMismatchException exp){
                String t=scanner.next();
            }
        }
        return totalScore;

    }
}
