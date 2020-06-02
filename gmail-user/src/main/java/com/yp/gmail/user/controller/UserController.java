package com.yp.gmail.user.controller;

import com.yp.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/06/02/下午 22:45
 * @Description;
 **/
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";

    }
}
