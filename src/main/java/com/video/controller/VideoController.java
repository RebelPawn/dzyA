package com.video.controller;

import com.util.FileUtil;
import com.video.model.VideoInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VideoController {

    //获取视频的信息
    public List<String[]> getList(String path){

        FileUtil fileUtil=new FileUtil();
        fileUtil.renameFile(path);
        File[] files=fileUtil.getFileList(path);
        List<String[]> infos=new ArrayList<>();

        for(int index=0;index<files.length;index++){
            String[] info={"",""};
            String fileName=files[index].getName();
            int length=fileUtil.videoTime(path+fileName);
            info[0]=fileName;
            info[1]=String.valueOf(length);
            infos.add(index,info);
        }

        return  infos;
    }

    public void add(List<String[]> videoInfos) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        for (String[] info:videoInfos){
            int num=Integer.parseInt(info[0].split(" ")[0]);
            String fileName=info[0].split(" ")[1];
            int videoLength=Integer.parseInt(info[1]);
            System.out.println(num+"-----"+fileName+"----"+info[1]);
            VideoInfo videoInfo=new VideoInfo();
            videoInfo.setVideoNum(num);
            videoInfo.setFileName(fileName);
            videoInfo.setVideoLength(videoLength);
            sqlSession.insert("addVideoInfo",videoInfo);
        }
    }
    public static void main(String[] args) throws IOException {
        VideoController vc=new VideoController();

        String path="E:\\尚硅谷Java数据结构和算法\\test\\";
        List<String[]> infos=vc.getList(path);

        vc.add(infos);
    }
}
