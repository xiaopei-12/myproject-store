package com.yp.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yp.gmall.bean.PmsProductImage;
import com.yp.gmall.bean.PmsProductInfo;
import com.yp.gmall.bean.PmsProductSaleAttr;
import com.yp.gmall.bean.PmsProductSaleAttrValue;
import com.yp.gmall.manage.mapper.PmsProductImageMapper;
import com.yp.gmall.manage.mapper.PmsProductInfoMapper;
import com.yp.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.yp.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.yp.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/26/下午 13:11
 * @Description;
 **/
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        System.out.println("spu查询input : ："+catalog3Id);
        System.out.println("gmall.manage.service -start " + this.getClass() );

        PmsProductInfo pmsProductInfo= new  PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);

        List<PmsProductInfo> pmsProductInfoList= pmsProductInfoMapper.select(pmsProductInfo);
        System.out.println("gmall.manage.service -end " + this.getClass().getName() );
        System.out.println("spu查询 return ："+pmsProductInfoList);
        return pmsProductInfoList;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {

        // 保存商品信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        // 生成商品主键
        String productId = pmsProductInfo.getId();

        // 保存商品图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        // 保存销售属性信息
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            // 保存销售属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
    }
}
