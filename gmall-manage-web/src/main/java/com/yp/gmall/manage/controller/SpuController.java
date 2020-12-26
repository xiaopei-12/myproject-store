package com.yp.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yp.gmall.bean.PmsProductInfo;
import com.yp.gmall.manage.util.PmsUploadUtil;
import com.yp.gmall.service.SpuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/26/下午 12:58
 * @Description;
 **/
@Controller
@CrossOrigin
@Slf4j
public class SpuController {

    @Reference
    SpuService spuService;

    /*
    * 商品信息查询
    * */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String  catalog3Id){
        System.out.println("start  : " + this.getClass());
        System.out.println("catalog3Id : [" +catalog3Id +"]");

        System.out.println("catalog3Id : [" +catalog3Id +"]");
        List<PmsProductInfo>  pmsProductInfo = spuService.spuList(catalog3Id);

        System.out.println("spuControoler return :"+ pmsProductInfo);
        System.out.println("start  : " + this.getClass());
        return pmsProductInfo;
    }

    /**
     * 增加产品销售属性
     * @param catalog3Id
     * @return
     */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        System.out.println("start  : " + this.getClass());
        System.out.println("catalog3Id : [" +pmsProductInfo +"]");

        System.out.println("catalog3Id : [" +pmsProductInfo +"]");
        spuService.saveSpuInfo(pmsProductInfo);
        log.info("pmsProductInfo>{}"+pmsProductInfo);
        log.info("save success ");
        return "success";
    }
    /**
     * 图片信息存储
     * @param catalog3Id
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        System.out.println("start  multipleMaster: " + this.getClass());
        System.out.println("multipleMaster : [" +multipartFile +"]");
        //将图片或者视频传到分布式文件存储系统中

        String imjUrl = PmsUploadUtil.uploadImage(multipartFile);
        //将图片的存储路径返回给页面
        System.out.println("catalog3Id : [" +multipartFile +"]");
        return imjUrl;
    }
}
