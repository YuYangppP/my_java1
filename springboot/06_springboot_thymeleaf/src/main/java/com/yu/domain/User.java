package com.yu.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @Date 2020/4/5 12:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //@JsonProperty(value = "userid")
    @JSONField(name = "userid1")
    private Integer id;
    private String name;
    private String address;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;
}
