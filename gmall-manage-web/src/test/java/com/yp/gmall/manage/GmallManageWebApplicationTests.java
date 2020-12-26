package com.yp.gmall.manage;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        log.info("upload file test ........");
        //获取配置文件的路径 ,配置fdfs全局连接地址
        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();

        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();
        log.info("trackerClient=={}",trackerClient);
        //获得一个trakerserver 的实例
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        log.info("trackerServer :{}}",trackerServer);
        //通过一个tracker获取一个storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);
        log.info("storageClient->{}",storageClient);
        //上传下载
        String[] jpgs = storageClient.upload_file("D:\\text\\javatest\\tmp\\magic\\se\\小米10-1.jpg", "jpg", null);

        String url = "http://192.168.127.12";
        System.out.println("jpgs :"+jpgs);
        for(String uploadinfo: jpgs){
            url = url + "/"+ uploadinfo;

            System.out.println("url: "+url);
        }
    }

}
