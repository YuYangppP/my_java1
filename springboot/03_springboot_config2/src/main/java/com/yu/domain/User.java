package com.yu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @Date 2020/4/3 17:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
}
