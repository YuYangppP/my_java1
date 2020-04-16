package cn.itcast.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Customer.java
 * @Description 客户的实体类
 *              配置映射关系：
 *                  1.实体类和表的映射关系
 *                  2.实体类中属性和表中字段的关系
 *
 * @Date 2019/11/24 16:32
 */

@Data
@Entity
@Table(name = "cst_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    private String custAddress;
    private String custPhone;

}
