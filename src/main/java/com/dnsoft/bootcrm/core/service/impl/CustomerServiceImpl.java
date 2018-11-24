package com.dnsoft.bootcrm.core.service.impl;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.dao.CustomerDao;
import com.dnsoft.bootcrm.core.pojo.Customer;
import com.dnsoft.bootcrm.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    //声明DAO并注入
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource,
                                           String custIndustry, String custLevel) {
        //创建Customer对象
        Customer customer1 = new Customer();

        //指定查询条件
        if(StringUtils.isNotBlank(custName)){
            customer1.setCust_name(custName);
        }
        if(StringUtils.isNoneBlank(custSource)){
            customer1.setCust_source(custSource);
        }
        if(StringUtils.isNoneBlank(custIndustry)){
            customer1.setCust_industry(custIndustry);
        }
        if(StringUtils.isNoneBlank(custLevel)){
            customer1.setCust_level(custLevel);
        }

        //设置当前页起始数据的行
        customer1.setStart((page-1)*rows);

        //设置每页数
        customer1.setRows(rows);

        List<Customer> customers = customerDao.selectCustomerList(customer1);

        //查询总客户数
        Integer count = customerDao.selectCustomerListCount(customer1);

        //创建Page对象，并且返回
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);

        return result;
    }

    public int createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }
}
