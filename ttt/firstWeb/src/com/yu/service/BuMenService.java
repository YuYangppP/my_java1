package com.yu.service;

import com.yu.dao.BuMenDao;
import com.yu.vo.BuMen;
import com.yu.vo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName BuMenService.java
 * @Description TODO
 * @Date 2020/2/26 17:17
 */
public class BuMenService {
    public List<BuMen> findAllBuMen() {
        BuMenDao dao = new BuMenDao();
        List<BuMen> buMenList = null;
        try {
            buMenList = dao.findAllBuMen();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buMenList;
    }


    public void delBuMen(int bid) {
        BuMenDao dao = new BuMenDao();
        try {
            dao.delBuMen(bid);
        } catch (SQLException e) {
            System.out.println("部门有员工，不可以删除");
        }
    }

    public void addBuMen(BuMen buMen) {
        BuMenDao dao = new BuMenDao();
        try {
            dao.addBuMen(buMen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BuMen findBuMenById(int bid) {
        BuMenDao dao = new BuMenDao();
        BuMen buMen = null;
        try {
            buMen = dao.findBuMenById(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buMen;
    }

    public void updateBuMen(BuMen buMen) {
        BuMenDao dao = new BuMenDao();

        try {
            dao.updateBuMen(buMen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
