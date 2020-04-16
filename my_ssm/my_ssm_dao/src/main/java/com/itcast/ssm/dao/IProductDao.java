package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-13 19:43
 **/
public interface IProductDao {


    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 添加产品
     * @param product
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;
}
