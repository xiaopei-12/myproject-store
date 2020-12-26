package com.yp.gmall.service;

import com.yp.gmall.bean.PmsBaseAttrInfo;
import com.yp.gmall.bean.PmsBaseAttrValue;
import com.yp.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/18/下午 17:12
 * @Description;
 **/
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();

}
