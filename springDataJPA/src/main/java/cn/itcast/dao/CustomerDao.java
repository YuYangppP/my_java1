package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {

    /**
     * 原生sql查询全部
     * @return customer
     */
    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Customer> findsql();

    /**
     * jpql查询全部
     * @return customer
     */
    @Query(value = "from Customer")
    public List<Customer> findJpql();

    @Query(value="update Customer set custName = ?1 where custId = ?2")
    @Modifying

    public void update1(String custName,long custId);

    @Query(value="select * from cst_customer where cust_name like ?1",nativeQuery = true)
    public List<Customer> findSql1(String name);
}
