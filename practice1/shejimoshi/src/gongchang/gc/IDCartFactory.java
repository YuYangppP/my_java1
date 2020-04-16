package gongchang.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName IDCartFactory.java
 * @Description TODO
 * @Date 2020/2/21 13:49
 */
public class IDCartFactory extends Factory {
    private List owners = new ArrayList();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}
