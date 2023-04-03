package zhurui.ssm.dao;

import zhurui.ssm.pojo.Customer;

import java.util.List;

public interface CustomerDao {
    void add(Customer customer);
    void update(Customer customer);
    void delete(Long id);
    List<Customer> findList(Customer customer);
    Customer findById(Long id);
    Integer count();
}
