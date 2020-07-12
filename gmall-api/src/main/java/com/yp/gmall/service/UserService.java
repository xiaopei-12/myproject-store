package com.yp.gmall.service;

import com.yp.gmall.bean.UmsMember;
import com.yp.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * create with IDEA
 *
 * @author Administrator
 * @Auther: yinpei
 * @Date : 2020/06/02/下午 22:46
 * @Description;
 **/
public interface UserService {

    List<UmsMember> getAllUser();
    /**
     * 根据用户ID活期地址信息
     */
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
