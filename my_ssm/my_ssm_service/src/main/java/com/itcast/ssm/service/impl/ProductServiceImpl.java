package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.IProductDao;
import com.itcast.ssm.domain.Product;

import com.itcast.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-13 19:46
 **/
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    /**
     * 添加产品
     * @param product
     */
    @Override
    public void save(Product product) {
        productDao.save(product);
    }

}
