package com.dnsoft.bootcrm.core.service.impl;

import com.dnsoft.bootcrm.core.dao.UserDao;
import com.dnsoft.bootcrm.core.pojo.User;
import com.dnsoft.bootcrm.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//用户Service接口实现类
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    //注入UserDao
    @Autowired
    private UserDao userDao;

    //通过账号和密码查询用户
    @Override
    public User findUser(String usercode, String password) {
        User user = this.userDao.findUser(usercode,password);
        return user;
    }

}
