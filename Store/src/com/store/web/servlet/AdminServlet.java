package com.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.store.domain.Category;
import com.store.domain.Order;
import com.store.domain.Product;
import com.store.service.AdminService;
import com.store.service.impl.AdminServiceImpl;
import com.store.utils.BeanFactory;
import com.store.utils.CommonsUtils;
import org.apache.commons.beanutils.BeanUtils;

public class AdminServlet extends BaseServlet {

	private AdminService service = new AdminServiceImpl();
	//根据订单id查询订单项和商品信息
	public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//获得oid
		String oid = request.getParameter("oid");

		List<Map<String,Object>> mapList = service.findOrderInfoByOid(oid);
		
		Gson gson = new Gson();
		String json = gson.toJson(mapList);
		System.out.println(json);
		/*[
		 * 	{"shop_price":4499.0,"count":2,"pname":"联想（Lenovo）小新V3000经典版","pimage":"products/1/c_0034.jpg","subtotal":8998.0},
		 *  {"shop_price":2599.0,"count":1,"pname":"华为 Ascend Mate7","pimage":"products/1/c_0010.jpg","subtotal":2599.0}
		 *]*/
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
		
	}
	
	//获得所有的订单
	public void findAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所有的订单信息----List<Order>

		List<Order> orderList = service.findAllOrders();
		
		request.setAttribute("orderList", orderList);
		
		request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);
		
	}

	//查询所有列别--更新商品信息时查询商品类别
	public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//提供一个List<Category> 转成json字符串
		List<Category> categoryList = service.findAllCategory();
		
		Gson gson = new Gson();
		String json = gson.toJson(categoryList);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
		
	}








	//查询所有商品列表
	public void findAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所有的订单信息----List<Order>

		List<Product> productList = service.findAllProducts();

		request.setAttribute("productList", productList);

		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);

	}

	//根据pid删除商品
	public void delProductByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要删除的pid
		String pid = request.getParameter("pid");

		//传递pid到service层
		service.delProductByPid(pid);
		response.sendRedirect(request.getContextPath()+"/admin?method=findAllProducts");

	}










	//查询所有分类列表--后台
	public void findAllCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所有的订单信息----List<Order>

		List<Category> categoryList1 = service.findAllCategoryList();

		request.setAttribute("categoryList1", categoryList1);

		request.getRequestDispatcher("/admin/category/list.jsp").forward(request, response);

	}


	//添加分类--后台
	public void adminAddCategoryServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1、获取数据
		Map<String, String[]> parameterMap = request.getParameterMap();
		//2、封装数据
		Category category = new Category();
		try {
			BeanUtils.populate(category,parameterMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		category.setCid(CommonsUtils.getUUID());

		//此位置Product已经封装完毕----将表单的数据封装完毕
		//手动设置表单中没有数据
		//3、传递数据给service层
		try {
			service.addCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/admin?method=findAllCategoryList");

	}
	//根据cid删除分类--后台
	public void delCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要删除的pid
		String cid = request.getParameter("cid");

		//传递pid到service层
		service.delCategoryByCid(cid);
		response.sendRedirect(request.getContextPath()+"/admin?method=findAllCategoryList");

	}

	//更新商品类别--后台
	public void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//1、获取数据
		Map<String, String[]> properties = request.getParameterMap();
		//2、封装数据
		Category category = new Category();
		try {
			BeanUtils.populate(category, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		//3、传递数据给service层
		service.updateCategory(category);

		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/admin?method=findAllCategoryList");

	}

	//更新类别时回显类别
	public void updateCategoryUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cid = request.getParameter("cid");
		Category category = null;
		try {
			category = service.findCatagoryByCid(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("category", category);
		request.getRequestDispatcher("/admin/category/edit.jsp").forward(request, response);

	}

}
