package zuoye2;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Trapezoid.java
 * @Description TODO
 * @Date 2019/10/16 14:21
 */
public class Trapezoid {
    double upperBottom,lowerBottom,height;
    public double getArea(){
        double area = (upperBottom + lowerBottom)*height/2;
        return area;
    }

    public void setUpperBottom(double upperBottom) {
        this.upperBottom = upperBottom;
    }

    public void setLowerBottom(double lowerBottom) {
        this.lowerBottom = lowerBottom;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
