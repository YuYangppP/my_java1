package com.store.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.store.dao.AdminDao;
import com.store.domain.Category;
import com.store.domain.Order;
import com.store.domain.Product;

public interface AdminService {

	public List<Category> findAllCategory();

	public void saveProduct(Product product) throws SQLException;

	public List<Order> findAllOrders();

	public List<Map<String, Object>> findOrderInfoByOid(String oid);

	public List<Product> findAllProducts();

    public void delProductByPid(String pid);

    public List<Category> findAllCategoryList();

	public void delCategoryByCid(String cid);

	public Product findProductByPid(String pid) throws SQLException;

	public void addCategory(Category category) throws SQLException;

	void updateCategory(Category category);

	Category findCatagoryByCid(String cid) throws SQLException;
}
