package zhurui.ssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import zhurui.ssm.dao.CustomerDao;
import zhurui.ssm.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer, Long createId) {
        customer.setCreateId(createId);
        customer.setCreateTime(new Date());
        customerDao.add(customer);
    }

    public List<Customer> selectCustomer(Customer customer, int pageNum, int pageSize) {
        if (customer.getDictSource() != null
              && customer.getDictSource() == -1) {
            customer.setDictSource(null);
        }
        if (customer.getDictIndustry() != null
              && customer.getDictIndustry() == -1) {
            customer.setDictIndustry(null);
        }
        if (customer.getDictLevel() != null
              && customer.getDictLevel() == -1) {
            customer.setDictLevel(null);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Customer> list = customerDao.findList(customer);
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

    public Customer findCustomer(Long id) {
        return customerDao.findById(id);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public void deleteCustomer(Long id) {
        customerDao.delete(id);
    }

    public int getTotalPage(int pageSize) {
        Integer count = customerDao.count();
        int page = count / pageSize;
        if (count % pageSize != 0) {
            page++;
        }
        return page;
    }
}
