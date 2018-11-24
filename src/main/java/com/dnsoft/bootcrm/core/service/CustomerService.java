package com.dnsoft.bootcrm.core.service;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.pojo.Customer;

import java.util.List;

public interface CustomerService {

    //查询客户列表(返回所有客户)
    public Page<Customer> findCustomerList(Integer page,Integer rows,
                                           String custName,String custSource,
                                           String custIndustry,String custLevel);

    //添加客户数据
    public int createCustomer(Customer customer);

    //通过id查询客户
    public Customer getCustomerById(Integer id);

    //更新客户信息
    public int updateCustomer(Customer customer);

    //删除客户信息
    public int deleteCustomer(Integer id);
}
