package com.yu.erp.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName DataGridView.java
 * @Description json数据实体
 * @Date 2020/3/21 15:24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {

    private Integer code = 0;
    private String msg = "";
    private Long count = 0L;
    private Object data;

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }

    public DataGridView(Object data) {
        super();
        this.data = data;
    }
}
