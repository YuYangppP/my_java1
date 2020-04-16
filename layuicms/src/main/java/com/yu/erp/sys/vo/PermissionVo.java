package com.yu.erp.sys.vo;

import com.yu.erp.sys.domain.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName PermissionVo.java
 * @Description TODO
 * @Date 2020/3/21 15:27
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

}
