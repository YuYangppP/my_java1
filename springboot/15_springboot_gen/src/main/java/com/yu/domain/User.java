package com.yu.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer userid;

    private String username;

    private String userpwd;

    private String sex;

    private String address;

    private static final long serialVersionUID = 1L;
}