package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-13 19:45
 **/
public interface IProductService {
    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

    /**
     * 添加产品
     * @param product
     */
    void save(Product product);
}
