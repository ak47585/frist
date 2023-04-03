package zhurui.ssm.controller;

import zhurui.ssm.pojo.Customer;
import zhurui.ssm.pojo.Dictionary;
import zhurui.ssm.pojo.User;
import zhurui.ssm.service.CustomerService;
import zhurui.ssm.service.DictService;
import zhurui.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private DictService dictService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    private void initPage(HttpServletRequest request) {
        List<Dictionary> customerSources = dictService.findDict("学生系别");
        List<Dictionary> customerIndustry = dictService.findDict("学生班级");
        List<Dictionary> customerLevel = dictService.findDict("学生性别");
        request.setAttribute("customerSources", customerSources);
        request.setAttribute("customerIndustry", customerIndustry);
        request.setAttribute("customerLevel", customerLevel);

        List<User> userList = userService.userList();
        request.setAttribute("userList", userList);
    }

    @RequestMapping("/addCustomerPage")
    public String findDictByCustomer(HttpServletRequest request) {
        initPage(request);
        return "add_customer";
    }

    @RequestMapping("/add")
    public String addCustomer(Customer customer, HttpServletRequest request) {
        System.out.println("添加学生：" + customer);
        String name = customer.getName();
        String phone = customer.getPhone();
        if (name == null || name.trim().length() == 0) {
            request.setAttribute("error", "学生名不能为空");
            request.setAttribute("customer", customer);
            return "forward:/customer/addCustomerPage";
        }
        if (phone == null || !phone.matches("^13\\d{9}$")) {
            request.setAttribute("error", "学号格式错误");
            request.setAttribute("customer", customer);
            return "forward:/customer/addCustomerPage";
        }
        User user = (User) request.getSession().getAttribute("user");
        customerService.addCustomer(customer, user.getId());
        return "redirect:/customer/select/1";
    }

    private static final int PAGE_SIZE = 5;
    @RequestMapping("/select/{pageNum}")
    public String selectCustomer(Customer customer, @PathVariable("pageNum") int pageNum, HttpServletRequest request) {
        int totalPage = customerService.getTotalPage(PAGE_SIZE);

        List<String> pageNav = new ArrayList<>();
        if (pageNum == 1) {
            pageNav.add("<li class='disabled'><a href='javascript:;'>上一页</a></li>");
        } else {
            pageNav.add("<li><a href='/customer/select/" + (pageNum - 1) + "'>上一页</a></li>");
        }
        for (int i = 1; i <= totalPage; i++) {
            pageNav.add("<li " + (i == pageNum ? "class='active'" : "") + "><a href='/customer/select/" + i + "'>" + i + "</a></li>");
        }
        if (pageNum == totalPage) {
            pageNav.add("<li class='disabled'><a href='javascript:;'>下一页</a></li>");
        } else {
            pageNav.add("<li><a href='/customer/select/" + (pageNum + 1) + "'>下一页</a></li>");
        }
        request.setAttribute("pageNav", pageNav);

        request.setAttribute("customerList", customerService.selectCustomer(customer,
                pageNum, PAGE_SIZE));
        initPage(request);
        return "customer_list";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable("id") Long customerId, HttpServletRequest request) {
        request.setAttribute("customer", customerService.findCustomer(customerId));
        initPage(request);
        return "update_customer";
    }

    @RequestMapping("/update")
    public String update(Customer customer, HttpServletRequest request) {
        System.out.println("修改学生：" + customer);
        String name = customer.getName();
        String phone = customer.getPhone();
        if (name == null || name.trim().length() == 0) {
            request.setAttribute("error", "学生名不能为空");
            request.setAttribute("customer", customer);
            return "forward:/customer/updatePage/" + customer.getId();
        }
        if (phone == null || !phone.matches("^13\\d{9}$")) {
            request.setAttribute("error", "学号格式错误");
            request.setAttribute("customer", customer);
            return "forward:/customer/updatePage/" + customer.getId();
        }
        customerService.updateCustomer(customer);
        return "redirect:/customer/select/1";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/select/1";
    }
}
