package com.yp.gmall.manage.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.yp.gmall.bean.PmsBaseCatalog1;
import com.yp.gmall.bean.PmsBaseCatalog2;
import com.yp.gmall.bean.PmsBaseCatalog3;
import com.yp.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.yp.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.yp.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.yp.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/18/上午 9:06
 * @Description;
 **/
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        System.out.println("gmall.manage.service"+ this.getClass().getPackage()+">>" + this.getClass().getName() );
        System.out.println("查询商品信息：");
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        System.out.println("gmall.manage.service--"+ this.getClass().getPackage()+">>" + this.getClass().getName() );
        System.out.println("查询2级数据信息: input ["+catalog1Id+"]");
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);

        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);

        System.out.println("pmsBaseCatalog2s:  >>>>>>>>>>>>>");
        System.out.println(pmsBaseCatalog2s+"\n");
        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        System.out.println("gmall.manage.service--"+ this.getClass().getPackage()+">>" + this.getClass().getName() );
        System.out.println("查询3级数据信息: input ["+catalog2Id+"]");
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);

        List<PmsBaseCatalog3> PmsBaseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);

        System.out.println("PmsBaseCatalog3s:  >>>>>>>>>>>>>");
        System.out.println(PmsBaseCatalog3s+"\n");
        return PmsBaseCatalog3s;
    }


}
