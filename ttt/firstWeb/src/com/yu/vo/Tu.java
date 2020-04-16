package com.yu.vo;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Tu.java
 * @Description TODO
 * @Date 2020/2/27 10:50
 */
public class Tu {
    private String label;
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tu{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
