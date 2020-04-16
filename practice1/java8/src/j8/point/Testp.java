package j8.point;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Testp.java
 * @Description TODO
 * @Date 2019/10/21 21:35
 */
public class Testp {
   /* @Test
    public void testMoveRightBy() throws Exception {
        Point p1 = new Point(5,5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15,p2.getX());
        assertEquals(5,p2.getY());
    }*/

   @Test
    public void testComparingTwoPoints() throws Exception{
       Point p1 = new Point(10,20);
       Point p2 = new Point(10,20);
       int result = Point.compareByXAndThenY.compare(p1,p2);
       assertEquals(0,result);

   }
}
