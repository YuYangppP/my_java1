package com.yu.erp.sys.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TreeNode.java
 * @Description TODO
 * @Date 2020/3/21 15:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private Integer id;
    @JsonProperty("parentId")
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private List<TreeNode> children = new ArrayList<TreeNode>();

    //0 不选，1：选

    private String checkArr ="0";

    public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
        super();
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

    /**
     * dtree的数据格式
     * @param id
     * @param pid
     * @param title
     * @param spread
     */
    public TreeNode(Integer id, Integer pid, String title, Boolean spread) {
        super();
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
    }

    /**
     * dtree复选树
     * @param id
     * @param pid
     * @param title
     * @param spread
     * @param checkArr
     */
    public TreeNode(Integer id, Integer pid, String title, Boolean spread, String checkArr) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }
}
