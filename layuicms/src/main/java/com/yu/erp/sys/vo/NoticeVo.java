package com.yu.erp.sys.vo;

import com.yu.erp.sys.domain.Loginfo;
import com.yu.erp.sys.domain.Notice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName LoginfoVo.java
 * @Description TODO
 * @Date 2020/3/22 12:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVo extends Notice {
    private static final long serialVersionUID = 1L;
    private Integer page = 1;
    private Integer limit = 10;

    private Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
