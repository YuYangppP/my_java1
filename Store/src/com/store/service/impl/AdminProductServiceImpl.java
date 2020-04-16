package com.store.service.impl;

import com.store.dao.AdminProductDao;
import com.store.domain.Product;
import com.store.service.AdminProductService;

import java.sql.SQLException;

/**
 * @author:yuyang
 * @data:2019-06-15 20:37
 **/
public class AdminProductServiceImpl implements AdminProductService {

    @Override
    public void updateProduct(Product product){
        AdminProductDao dao = new AdminProductDao();
        try {
            dao.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
