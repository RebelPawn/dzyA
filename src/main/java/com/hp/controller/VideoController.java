package com.hp.controller;

import com.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoController {

    //获取视频的信息
    public List<String[]> getList(String path){

        FileUtil fileUtil=new FileUtil();
        fileUtil.renameFile(path);
        File[] files=fileUtil.getFileList(path);
        List<String[]> infos=new ArrayList<>();
        String[] info={"",""};
        for(int index=0;index<files.length;index++){

            String fileName=files[index].getName();
            int length=fileUtil.videoTime(path+fileName);
            info[0]=fileName;
            info[1]=String.valueOf(length);
            infos.add(index,info);
        }

        return  infos;
    }

    public void add(List<String[]> videoInfos){

        for (String[] info:videoInfos){
            int num=Integer.parseInt(info[0].split(" ")[0]);
            String fileName=info[0].split(" ")[1];
            System.out.println(num+"-----"+fileName+"----"+info[1]);
        }
    }
    public static void main(String[] args) {
        VideoController vc=new VideoController();

        String path="E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\test\\";
        List<String[]> infos=vc.getList(path);

        vc.add(infos);
    }
}
