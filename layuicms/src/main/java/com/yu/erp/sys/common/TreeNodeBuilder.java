package com.yu.erp.sys.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TreeNodeBuilder.java
 * @Description TODO
 * @Date 2020/3/21 16:19
 */
public class TreeNodeBuilder {
    public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topPid){
        List<TreeNode> nodes = new ArrayList<>();
        for (TreeNode n1 : treeNodes) {
            if (n1.getPid() == topPid){
                nodes.add(n1);
            }
            for (TreeNode n2 : treeNodes) {
                if (n1.getId() == n2.getPid()){
                    n1.getChildren().add(n2);
                }

            }
        }
        return nodes;
    }
}
