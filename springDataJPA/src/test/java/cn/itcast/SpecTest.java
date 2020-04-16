package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName SpecTest.java
 * @Description TODO
 * @Date 2019/12/2 20:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testSpec(){

        //使用匿名内部类的方式，创建一个Specification的实现类，并实现toPredicate方法
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 *  root：查询的根对象（查询的任何属性都可以从根对象中获取）
                 *  CriteriaQuery：顶层查询对象，自定义查询方式（了解：一般不用）
                 *  CriteriaBuilder：查询的构造器，封装了很多的查询条件
                 */
                //1.获取比较的属性
                Path<Object> custName = root.get("custName");
                //2.构造查询条件
                Predicate predicate = criteriaBuilder.equal(custName, "人工智能");
                return predicate;
            }
        };
        Customer customer = customerDao.findOne(spec);
        System.out.println(customer);
    }

    @Test
    public void testSpecs(){
        final Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("custName");
                Path<Object> custId = root.get("custId");
                Predicate equal1 = criteriaBuilder.equal(custId, 1l);
                Predicate equal2 = criteriaBuilder.equal(name, "人工智能");
                Predicate and = criteriaBuilder.and(equal1, equal2);
                return and;
            }
        };

        Customer one = customerDao.findOne(spec);
        System.out.println(one);

    }

    @Test
    public void testSpecLike(){
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("custName");

                Predicate like = criteriaBuilder.like(name.as(String.class), "哈%");

                return like;
            }
        };

        List<Customer> list = customerDao.findAll(spec);
        for (Customer l : list){
            System.out.println(l);
        }
    }

    @Test
    public void testSort(){
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("custName");

                Predicate like = criteriaBuilder.like(name.as(String.class), "哈%");

                return like;
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC,"custId");

        List<Customer> list = customerDao.findAll(spec,sort);
        for (Customer l : list){
            System.out.println(l);
        }
    }

    @Test
    public void testPage(){
        Specification spec =null;
        PageRequest pageRequest = new PageRequest(0,2);
        Page<Customer> page = customerDao.findAll(null, pageRequest);
        System.out.println(page.getContent());
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());

    }
}
