package com.store.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.store.dao.AdminDao;
import com.store.dao.AdminProductDao;
import com.store.domain.Category;
import com.store.domain.Order;
import com.store.domain.Product;
import com.store.service.AdminService;
import com.store.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

public class AdminServiceImpl implements AdminService{

	public List<Category> findAllCategory() {
		AdminDao dao = new AdminDao();
		try {
			return dao.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveProduct(Product product) throws SQLException {
		AdminDao dao = new AdminDao();
		dao.saveProduct(product);
	}

	public List<Order> findAllOrders() {
		AdminDao dao = new AdminDao();
		List<Order> ordersList = null;
		try {
			ordersList = dao.findAllOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) {
		AdminDao dao = new AdminDao();
		List<Map<String, Object>> mapList = null;
		try {
			mapList = dao.findOrderInfoByOid(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapList;
	}

	@Override
	public List<Product> findAllProducts() {
		AdminDao dao = new AdminDao();
		List<Product> productList = null;
		try {
			productList = dao.findAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public void delProductByPid(String pid) {
		AdminDao dao = new AdminDao();
		try {
			dao.delProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Product findProductByPid(String pid) throws SQLException {
		AdminDao dao = new AdminDao();
		return dao.findProductByPid(pid);
	}









	@Override
	public List<Category> findAllCategoryList() {
		AdminDao dao = new AdminDao();
		List<Category> categoryList1 = null;
		try {
			categoryList1 = dao.findAllCategoryList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList1;
}

	@Override
	public void delCategoryByCid(String cid) {
		AdminDao dao = new AdminDao();
		try {
			dao.delCategoryByCid(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//将Redis缓存清空，重新生成
		Jedis j = null;
		try {
			j = JedisPoolUtils.getJedis();
			j.del("categoryListJson");
		}catch (Exception e){

		}finally {
			//释放jedis
			JedisPoolUtils.closeJedis(j);
		}
	}

	public void addCategory(Category category) throws SQLException {
		AdminDao dao = new AdminDao();
		dao.addCategory(category);

		//将Redis缓存清空，重新生成
		Jedis j = null;
		try {
			j = JedisPoolUtils.getJedis();
			j.del("categoryListJson");
		}catch (Exception e){

		}finally {
			//释放jedis
			JedisPoolUtils.closeJedis(j);
		}
	}

	@Override
	public void updateCategory(Category category) {
		AdminDao dao = new AdminDao();
		try {
			dao.updateCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Category findCatagoryByCid(String cid) throws SQLException {
		AdminDao dao = new AdminDao();
		return dao.findCatagoryByCid(cid);
	}


}
