package j8.point;

import org.junit.Test;

import java.util.Comparator;

import static java.util.Comparator.comparing;
import static org.junit.Assert.assertEquals;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Point.java
 * @Description TODO
 * @Date 2019/10/21 21:18
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x){
        return new Point(this.x +x,this.y);
    }

    public final static Comparator<Point> compareByXAndThenY = comparing(Point::getX).thenComparing(Point::getY);
}


