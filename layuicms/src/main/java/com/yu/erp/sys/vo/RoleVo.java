package com.yu.erp.sys.vo;

import com.yu.erp.sys.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName RoleVo.java
 * @Description TODO
 * @Date 2020/3/26 17:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends Role {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;
}
