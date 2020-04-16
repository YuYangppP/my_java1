package gongchang.gc;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName IDCard.java
 * @Description TODO
 * @Date 2020/2/21 13:46
 */
public class IDCard extends Product {
    private String owner;
    IDCard(String owner){
        System.out.println("制作"+owner+"的ID卡");
        this.owner = owner;
    }
    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
