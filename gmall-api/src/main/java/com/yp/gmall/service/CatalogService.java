package com.yp.gmall.service;

import com.yp.gmall.bean.PmsBaseCatalog1;
import com.yp.gmall.bean.PmsBaseCatalog2;
import com.yp.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/18/上午 9:02
 * @Description;
 **/
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);

}
