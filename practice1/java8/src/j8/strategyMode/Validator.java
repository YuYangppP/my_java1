package j8.strategyMode;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Validator.java
 * @Description TODO
 * @Date 2019/10/21 19:51
 */
public class Validator {
    private final ValitationStrategy valitationStrategy;

    public Validator(ValitationStrategy v) {
        this.valitationStrategy = v;
    }

    public boolean validate(String s){
        return valitationStrategy.excute(s);
    }
}
