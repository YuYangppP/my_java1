package com.yu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @Date 2020/4/6 15:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private Date birth;
}
