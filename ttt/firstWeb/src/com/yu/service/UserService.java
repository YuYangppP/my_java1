package com.yu.service;

import com.yu.dao.BuMenDao;
import com.yu.dao.UserDao;
import com.yu.vo.BuMen;
import com.yu.vo.PageBean;
import com.yu.vo.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @Date 2020/2/26 15:15
 */
public class UserService {
    public void addUser(User user) {
        UserDao dao = new UserDao();
        try {
            dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> findAllUser() {
        UserDao dao = new UserDao();
        List<User> userlist = null;
        try {
            userlist = dao.findAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userlist;
    }



/*    public User login(String username, String password) throws SQLException {
        UserDao dao = new UserDao();
        return dao.login(username,password);
    }*/

    public void delUser(int uid) {
        UserDao dao = new UserDao();
        try {
            dao.delUser(uid);
        } catch (SQLException e) {
            System.out.println("hh");
        }
    }

    public List<BuMen> findAllBuMen1() {
        BuMenDao dao = new BuMenDao();
        List<BuMen> buMenList = null;
        try {
            buMenList =  dao.findAllBuMen1();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buMenList;

    }

    public User updateUserUI(int uid) {
        UserDao dao = new UserDao();
        User user = null;
        try {
             user = dao.updateUserUI(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        UserDao dao = new UserDao();
        try {
            dao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*    public BuMen findBuMenById(String bmid) {
        UserDao dao = new UserDao();
        BuMen bname = null;
        try {
            bname = dao.findBuMenById(bmid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bname;
    }*/

    public PageBean findUserListByCid(int currentPage, int currentCount) {

        UserDao dao = new UserDao();

        //封装一个PageBean 返回web层
        PageBean<User> pageBean = new PageBean<User>();

        //1、封装当前页
        pageBean.setCurrentPage(currentPage);
        //2、封装每页显示的条数
        pageBean.setCurrentCount(currentCount);
        //3、封装总条数
        int totalCount = 0;
        try {
            totalCount = dao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setTotalCount(totalCount);
        //4、封装总页数
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);

        //5、当前页显示的数据
        // select * from product where cid=? limit ?,?
        // 当前页与起始索引index的关系
        int index = (currentPage-1)*currentCount;
        List<User> list = null;
        try {
            list = dao.findProductByPage(index,currentCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setList(list);


        return pageBean;
    }

    public void delAllUser(int id) {
        UserDao dao = new UserDao();
        try {
            dao.delAllUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
