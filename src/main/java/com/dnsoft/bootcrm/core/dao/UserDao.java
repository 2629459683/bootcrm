package com.dnsoft.bootcrm.core.dao;

import com.dnsoft.bootcrm.core.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    //通过账号和密码查询用户
    public User findUser(@Param("usercode") String usercode,
                         @Param("password") String password);
}
