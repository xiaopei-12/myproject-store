package com.yp.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yp.gmall.bean.PmsBaseAttrInfo;
import com.yp.gmall.bean.PmsBaseAttrValue;
import com.yp.gmall.bean.PmsBaseSaleAttr;
import com.yp.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * create with IDEA
 *  描述： 商品属性信息查询
 * @Auther: yinpei
 * @Date : 2020/07/18/下午 16:54
 * @Description;
 **/
@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    /**
     *返回商品属性信息
     * 查询pms_base_attr_info 表数据信息
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){

        System.out.println("start gmall.manage.web--"+">>" + this.getClass().getName() );
        System.out.println("输入信息  catalog3Id = "+catalog3Id);
        List<PmsBaseAttrInfo>   PmsBaseAttrInfos=attrService.attrInfoList(catalog3Id);

        System.out.println("输出信息：PmsBaseAttrInfos = "+PmsBaseAttrInfos);
        System.out.println("end start gmall.manage.web"+"-"+this.getClass().getName());
    return PmsBaseAttrInfos;
    }

    /**
     * 修改或者新增 平台属性信息和属性值信息
     * @param pmsBaseAttrInfo
     * @return
     */
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        System.out.println("start gmall.manage.web--"+">>" + this.getClass().getName() );
        System.out.println("输入信息  pmsBaseAttrInfo  = "+pmsBaseAttrInfo);

        String success = attrService.saveAttrInfo(pmsBaseAttrInfo);

        System.out.println("输出信息：PmsBaseAttrInfos = "+success);
        System.out.println("end start gmall.manage.web"+"-"+this.getClass().getName());
        return success;
    }
    /***
     * 根据三级ID 查询 属性值信息集合
     */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public  List<PmsBaseAttrValue> getAttrValueList(String attrId){

        System.out.println("根据三级ID 产品属性值信息 start "+this.getClass());
        System.out.println("输入信息 input ="+attrId);

        List<PmsBaseAttrValue> PmsBaseAttrValues = attrService.getAttrValueList(attrId);

        System.out.println("end---" +this.getClass());
        return PmsBaseAttrValues;
    }

    /***
     * baseSaleAttrList  商品销售属性名称查询
     */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public  List<PmsBaseSaleAttr> baseSaleAttrList(){

        System.out.println("spu start "+this.getClass());

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attrService.baseSaleAttrList();

        System.out.println("pmsBaseSaleAttrs:::"+pmsBaseSaleAttrs);
        System.out.println("end---" +this.getClass());
        return pmsBaseSaleAttrs;
    }

}
