package gongchang.cxgongchang;

import gongchang.cxgongchang.color.Blue;
import gongchang.cxgongchang.color.Color;
import gongchang.cxgongchang.color.Green;
import gongchang.cxgongchang.color.Red;
import gongchang.cxgongchang.shape.Shape;
/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ColorFactory.java
 * @Description TODO
 * @Date 2020/2/18 23:02
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null){
            return null;
        }
        if (color.equalsIgnoreCase("red")){
            return new Red();
        }else if(color.equalsIgnoreCase("blue")){
            return new Blue();
        }else if(color.equalsIgnoreCase("green")){
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
