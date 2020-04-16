package gongchang.cxgongchang;

import gongchang.cxgongchang.color.Color;
import gongchang.cxgongchang.shape.Shape;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @Date 2020/2/18 23:13
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("red");
        color1.fill();
    }
}
