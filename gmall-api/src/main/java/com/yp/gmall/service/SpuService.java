package com.yp.gmall.service;

import com.yp.gmall.bean.PmsProductInfo;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/26/下午 13:09
 * @Description;
 **/
public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
}
