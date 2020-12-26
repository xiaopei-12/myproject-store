package com.yp.gmall.manage.util;

import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/12/26/上午 9:43
 * @Description;
 **/
@Slf4j
public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile)  {
        System.out.println("upload file or image start.......");
        log.info("log upload file or image start.......");
        String imgUtil = "http://192.168.127.12";
        //获取配置文件的路径 ,配置fdfs全局连接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();
        //获得一个trakerserver 的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过一个tracker获取一个storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //上传下载

        try {
            //获取上传的二进制对象
            byte[] bytes = multipartFile.getBytes();
            //获取文件的后缀
            String originalFilename  = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");

            String excName= originalFilename.substring(i + 1);
            String[] jpgs = storageClient.upload_file(bytes, excName, null);

            System.out.println("jpgs :"+jpgs);
            for(String uploadinfo: jpgs){
                imgUtil = imgUtil + "/"+ uploadinfo;

                System.out.println("imgUtil: "+imgUtil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return imgUtil;
    }
}
