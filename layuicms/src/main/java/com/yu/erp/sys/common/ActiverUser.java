package com.yu.erp.sys.common;

import com.yu.erp.sys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ActiverUser.java
 * @Description TODO
 * @Date 2020/3/21 13:18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser {
    private User user;
    private List<String> roles;
    private List<String> permissions;
}
