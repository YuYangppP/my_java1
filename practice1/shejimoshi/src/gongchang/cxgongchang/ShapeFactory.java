package gongchang.cxgongchang;

import gongchang.cxgongchang.color.Color;
import gongchang.cxgongchang.shape.Circle;
import gongchang.cxgongchang.shape.Rectangle;
import gongchang.cxgongchang.shape.Shape;
import gongchang.cxgongchang.shape.Square;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ShapeFactory.java
 * @Description TODO
 * @Date 2020/2/18 22:58
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null){
            return null;
        }
        if (shape.equalsIgnoreCase("circle")){
            return new Circle();
        }else if(shape.equalsIgnoreCase("square")){
            return new Square();
        }else if(shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
