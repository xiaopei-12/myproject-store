package com.yp.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yp.gmall.bean.PmsBaseCatalog1;
import com.yp.gmall.bean.PmsBaseCatalog2;
import com.yp.gmall.bean.PmsBaseCatalog3;
import com.yp.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * create with IDEA
 *  一二三级分类目录查询
 * @Auther: yinpei
 * @Date : 2020/07/12/下午 19:09
 * @Description;
 **/
@Controller
@CrossOrigin
public class CatalogController {
    //@CrossOrigin 跨域注解，不同的ip和端口前后端相互访问时需要增加跨域注解,增加双方互相信任
    //增加上注解跨域后，返回报文头会加上以下两个头
    //Access-Control-Allow-Credentials: true
    // Access-Control-Allow-Origin: http://127.0.0.1:8888
    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3( String catalog2Id){
        System.out.println("getCatalog3--"+"["+catalog2Id+"]"+"--->"+"gmall-manage-web-->CatalogController");
        List<PmsBaseCatalog3> catalog3s  =catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2( String catalog1Id){
        System.out.println("getCatalog2--"+"["+catalog1Id+"]"+"--->"+"gmall-manage-web-->CatalogController");
        List<PmsBaseCatalog2> catalog2s  =catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        System.out.println("getCatalog1--"+"gmall-manage-web-->CatalogController");
        List<PmsBaseCatalog1> catalog1s  =catalogService.getCatalog1();
        return catalog1s;
    }

}
