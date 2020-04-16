package shiyan.five;

import java.sql.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TurnMoney.java
 * @Description TODO
 * @Date 2019/10/28 13:57
 */
public class TurnMoney {
    public static void main(String[] args) {
        Connection con = null;
        Statement sql;
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(""+e);
        }
        try{
            double n = 100;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","123456");
            con.setAutoCommit(false);
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * FROM card1 WHERE number = 'zhangsan'");
            rs.next();
            double amountOne = rs.getDouble("amount");
            System.out.println("转账之前zhangsan的钱数额:"+amountOne);
            rs = sql.executeQuery("SELECT * FROM card2 WHERE number = 'xidanShop'");
            rs.next();
            double amountTwo = rs.getDouble("amount");
            System.out.println("转账之前xidanShop的钱数额："+amountTwo);
            amountOne = amountOne-n;
            amountTwo = amountTwo+n;
            sql.executeUpdate("UPDATE card1 SET amount ="+amountOne+"WHERE number='zhangsan'");
            sql.executeUpdate("UPDATE card2 SET amount ="+amountTwo+"WHERE number='xidanShop'");
            con.commit();
            con.setAutoCommit(true);

            rs = sql.executeQuery("SELECT * FROM card1 WHERE number = 'zhangsan'");
            rs.next();
            amountOne = rs.getDouble("amount");
            System.out.println("转账之后zhangsan的钱数额:"+amountOne);
            rs = sql.executeQuery("SELECT * FROM card2 WHERE number = 'xidanShop'");
            rs.next();
            amountTwo = rs.getDouble("amount");
            System.out.println("转账之后xidanShop的钱数额："+amountTwo);
            con.close();

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException exp) {
                System.out.println(e.toString());
            }
        }
    }
}
