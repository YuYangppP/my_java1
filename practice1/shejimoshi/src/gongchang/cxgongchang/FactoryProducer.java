package gongchang.cxgongchang;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName FactoryProducer.java
 * @Description TODO
 * @Date 2020/2/18 23:08
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }else if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }
        return null;
    }
}
