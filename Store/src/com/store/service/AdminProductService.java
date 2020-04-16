package com.store.service;

import com.store.domain.Product;

import java.sql.SQLException;

/**
 * @author:yuyang
 * @data:2019-06-15 20:37
 **/
public interface AdminProductService {
    void updateProduct(Product product) throws SQLException;
}
