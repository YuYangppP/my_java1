package com.store.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.store.domain.Category;
import com.store.domain.Order;
import com.store.domain.Product;
import com.store.utils.DataSourceUtils;

public class AdminDao {


	/**查询所有类别
	 *
	 * @return List<Category>
	 * @throws SQLException
	 */
	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return runner.query(sql, new BeanListHandler<Category>(Category.class));
	}

	/**添加商品
	 *
	 * @param product
	 * @throws SQLException
	 */
	public void saveProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),
				product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid());
	}

	/**
	 * 查询所有订单
	 * @return List<Order>
	 * @throws SQLException
	 */
	public List<Order> findAllOrders() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders";
		return runner.query(sql, new BeanListHandler<Order>(Order.class));
	}

	/**查询订单详情
	 *
	 * @param oid
	 * @return map
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findOrderInfoByOid(String oid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select p.pimage,p.pname,p.shop_price,i.count,i.subtotal from orderitem i,product p where i.pid=p.pid and i.oid=? ";
		return runner.query(sql, new MapListHandler(), oid);
	}


	/**查询所有商品
	 *
	 * @return
	 * @throws SQLException
	 */
    public List<Product> findAllProducts() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		return runner.query(sql, new BeanListHandler<Product>(Product.class));
    }

	/**删除商品
	 *
	 * @param pid
	 * @throws SQLException
	 */
	public void delProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where product.pid=?";
		runner.update(sql, pid);
	}


	/**修改商品时回显商品信息
	 *
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}


	/**添加分类
	 *
	 * @param category
	 * @throws SQLException
	 */
    public void addCategory(Category category) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into category values(?,?)";
        runner.update(sql, category.getCid(),category.getCname());
    }

	/**修改分类
	 *
	 * @param category
	 * @throws SQLException
	 */
	public void updateCategory(Category category) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update category set cname=? where cid=?";
		runner.update(sql,category.getCname(),category.getCid());
	}

	/**修改分类时回显类别名称
	 *
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public Category findCatagoryByCid(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category where cid=?";
		Category category = runner.query(sql, new BeanHandler<Category>(Category.class), cid);
		return category;
	}

	/**删除分类
	 *
	 * @param cid
	 * @throws SQLException
	 */
	public void delCategoryByCid(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from category where cid=?";
		runner.update(sql, cid);
	}

	/**查询所有分类列表
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAllCategoryList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return runner.query(sql, new BeanListHandler<Category>(Category.class));
	}


}
