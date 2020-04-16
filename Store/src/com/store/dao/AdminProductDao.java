package com.store.dao;

import com.store.domain.Product;
import com.store.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author:yuyang
 * @data:2019-06-15 19:21
 **/
public class AdminProductDao {

    //修改商品
    public void updateProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
        runner.update(sql,product.getPname(),product.getMarket_price(),
                product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
                product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
    }}
