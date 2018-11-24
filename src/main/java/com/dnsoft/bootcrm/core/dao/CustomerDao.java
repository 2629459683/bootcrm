package com.dnsoft.bootcrm.core.dao;

import com.dnsoft.bootcrm.core.pojo.Customer;

import java.util.List;

//CustomerDao接口
public interface CustomerDao {
    //客户列表
    public List<Customer> selectCustomerList(Customer customer);

    //创建客户
    public int createCustomer(Customer customer);

    //客户数
    public  Integer selectCustomerListCount(Customer customer);

    //通过id查询客户
    public Customer getCustomerById(Integer id);

    //更新客户信息
    public int updateCustomer(Customer customer);

    //删除客户
    public int deleteCustomer(Integer id);
}
