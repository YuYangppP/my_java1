package com.yu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ResultObj.java
 * @Description TODO
 * @Date 2020/4/8 11:41
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
    private Integer ststus=200;
    private Object msg;
}
