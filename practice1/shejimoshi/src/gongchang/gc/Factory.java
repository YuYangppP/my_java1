package gongchang.gc;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Factory.java
 * @Description TODO
 * @Date 2020/2/21 13:42
 */
public abstract class Factory {
    public final Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
