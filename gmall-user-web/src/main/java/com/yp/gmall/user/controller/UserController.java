package com.yp.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yp.gmall.bean.UmsMember;
import com.yp.gmall.bean.UmsMemberReceiveAddress;
import com.yp.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * create with IDEA
 *
 * @author Administrator
 * @Auther: yinpei
 * @Date : 2020/06/02/下午 22:45
 * @Description;
 **/
@Controller
public class UserController {

    //@Autowired
    @Reference
    UserService userService;

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddress = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddress;
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }
    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }
}
