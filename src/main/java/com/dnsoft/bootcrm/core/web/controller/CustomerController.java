package com.dnsoft.bootcrm.core.web.controller;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.pojo.BaseDict;
import com.dnsoft.bootcrm.core.pojo.Customer;
import com.dnsoft.bootcrm.core.pojo.User;
import com.dnsoft.bootcrm.core.service.BaseDictService;
import com.dnsoft.bootcrm.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    //客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;

    //客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;

    //客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/toCustomer.action")
    public String toCustomer(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer rows,
                             String custName,String custSource,String custIndustry,
                             String custLevel,Model model){

        //客户来源
        List<BaseDict> fromType = baseDictService.findBaseDictByTypeCode(FROM_TYPE);

        //客户所属行业
        List<BaseDict> industryType = baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);

        //客户级别
        List<BaseDict> levelType = baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);

        //查询客户信息
        Page<Customer> customers = customerService.findCustomerList(page,rows,custName,
                                                                    custSource,custIndustry,custLevel);

        //添加页面参数
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("page",customers);

        return "customer";
    }

    //创建客户
    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){
        //指定cust_user_id
        customer.setCust_user_id(18);

        //获取Session中的当前用户信息
        User user = (User)session.getAttribute("USER_SESSION");
        //将当前用户id存储在客户对象中
        customer.setCust_create_id(user.getUser_id());
        //创建Date对象
        Date date = new Date();

        //创建Timestamp,并设置customer创建时间
        Timestamp timestamp = new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);

        int rows = customerService.createCustomer(customer);

        if(rows > 0){
            return "OK";
        }else{
            return "FAIL";
        }
    }

    //通过id获取客户信息
    @RequestMapping("getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    //更新客户信息
    @RequestMapping("update.action")
    @ResponseBody
    public String customerUpdate(Customer customer){
        System.out.println(customer.getCust_id());
        int rows = customerService.updateCustomer(customer);
        if(rows>0){
            return "OK";
        }else{
            return "FAIL";
        }
    }

    //删除客户
    @RequestMapping("/customer/delete.action")
    @ResponseBody
    public String customerDelete(Integer id){
        int rows = customerService.deleteCustomer(id);
        if(rows > 0){
            return "OK";
        }else {
            return "FALL";
        }
    }
}
