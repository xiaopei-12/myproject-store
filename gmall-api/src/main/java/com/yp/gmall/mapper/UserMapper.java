package com.yp.gmall.mapper;

import com.yp.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * create with IDEA
 * 数据库映射
 * @Auther: yinpei
 * @Date : 2020/06/02/下午 22:50
 * @Description;
 **/
public interface UserMapper  extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
