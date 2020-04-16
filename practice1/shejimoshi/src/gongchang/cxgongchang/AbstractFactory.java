package gongchang.cxgongchang;

import gongchang.cxgongchang.color.Color;
import gongchang.cxgongchang.shape.Shape;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName AbstractFactory.java
 * @Description TODO
 * @Date 2020/2/18 22:57
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
