package com.yp.gmall.user.service.impl;

import com.yp.gmall.service.UserService;
import com.yp.gmall.bean.UmsMember;
import com.yp.gmall.bean.UmsMemberReceiveAddress;
import com.yp.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.yp.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * create with IDEA
 *
 * @author Administrator
 * @Auther: yinpei
 * @Date : 2020/06/02/下午 22:47
 * @Description;
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    @Override
    public List<UmsMember> getAllUser() {

//     List<UmsMember> umsMember = userMapper.selectAllUser();
     List<UmsMember> umsMember = userMapper.selectAll();
        return umsMember;
    }

    /**
     * 通过 通用mapper 实现 sql查询；不需要再写 *Mapper.xml里的内容了
     *
     * @param memberId
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        UmsMemberReceiveAddress umsMemberReceiveAddress= new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        //使用通用mapper，不需要再写*Mapper.xml里的内容了
        //哪个字段不为空，就根据哪个字段来查询该表数据信息
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(umsMemberReceiveAddress);

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;

    }
}
