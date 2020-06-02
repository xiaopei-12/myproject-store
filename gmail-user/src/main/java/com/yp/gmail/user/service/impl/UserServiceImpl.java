package com.yp.gmail.user.service.impl;


import com.yp.gmail.user.mapper.UserMapper;
import com.yp.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/06/02/下午 22:47
 * @Description;
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
}
