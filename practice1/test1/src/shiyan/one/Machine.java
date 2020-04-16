package shiyan.one;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Machine.java
 * @Description TODO
 * @Date 2019/10/28 12:39
 */
public class Machine {
    Goods[] goods;
    public void checkBag(Goods goods) throws DangerException{
        if(goods.isDanger){
          DangerException danger=new DangerException();
          throw danger;
        }
        else{
            System.out.print(goods.getName()+"不是危险品！");
        }
    }
}
