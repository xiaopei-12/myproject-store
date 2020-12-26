package com.yp.gmall.manage.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.yp.gmall.bean.PmsBaseAttrInfo;
import com.yp.gmall.bean.PmsBaseAttrValue;
import com.yp.gmall.bean.PmsBaseSaleAttr;
import com.yp.gmall.manage.mapper.PmsBaseAttrInfoMpper;
import com.yp.gmall.manage.mapper.PmsBaseAttrValueMpper;
import com.yp.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.yp.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/18/下午 17:14
 * @Description;
 **/
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrValueMpper pmsBaseAttrValueMpper;
    @Autowired
    PmsBaseAttrInfoMpper pmsBaseAttrInfoMpper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    /**
     * 根据idc查询平台属性信息
     *
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        System.out.println("start gmall.manage.service|attrInfoList" + ">>" + this.getClass().getName());

        System.out.println("查询产品属性信息-》》Input: " + catalog3Id);
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMpper.select(pmsBaseAttrInfo);

        System.out.println("The NED>>>>> \n 输出信息：" + pmsBaseAttrInfos);
        return pmsBaseAttrInfos;
    }

    /***
     * 增加修改平台属性信息和属性值信息
     * @param pmsBaseAttrInfo
     * @return
     */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        System.out.println("start gmall.manage.service|attrInfoList" + ">>" + this.getClass().getName());

        System.out.println("查询产品属性信息-》》Input: " + pmsBaseAttrInfo);

        String id = pmsBaseAttrInfo.getId();
        //如果id为空则代表 新增，有值得话，代表
        if (StringUtils.isBlank(id)) {
            System.out.println("new insert------");
            //保存属性
            System.out.println("insert 商品属性 信息 ");
            pmsBaseAttrInfoMpper.insertSelective(pmsBaseAttrInfo);
            //保存属性值

            List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrValueList) {

                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                System.out.println("insert 商品属性值信息 ：" + pmsBaseAttrValue);
                pmsBaseAttrValueMpper.insert(pmsBaseAttrValue);

            }
        } else {
            System.out.println("修改--------");

            //修改属性
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id", pmsBaseAttrInfo.getId());//根据id修改
            //updateByExampleSelective 代表空值不修改，不为空则进行修改；
            pmsBaseAttrInfoMpper.updateByExampleSelective(pmsBaseAttrInfo, example);
//            修改属性值

//            先删除id对应的所有属性值
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMpper.delete(pmsBaseAttrValue);
            //再进行插入
            List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue baseAttrValue : pmsBaseAttrValueList) {
                baseAttrValue.setId(null);
                baseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMpper.insertSelective(baseAttrValue);
            }

            System.out.println("修改完成---");
        }


        return "success";
    }

    /***
     * 根据三级ID 查询并返回 属性值信息的集合
     * @param attrId
     * @return
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        System.out.println("start gmall.manage.service|attrInfoList" + ">>" + this.getClass().getName());

        System.out.println("查询产品属性信息-》》Input: " + attrId);
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> PmsBaseAttrValues = pmsBaseAttrValueMpper.select(pmsBaseAttrValue);

        System.out.println("The NED>>>>> \n 输出信息：" + PmsBaseAttrValues);
        return PmsBaseAttrValues;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        System.out.println("start gmall.manage.service|attrInfoList" + ">>" + this.getClass());

        List <PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrMapper.selectAll();

        System.out.println("end >>>"+  this.getClass());
        return pmsBaseSaleAttrs;
    }


}
