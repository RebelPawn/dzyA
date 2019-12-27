package com.util;



import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;


public class FileUtil {

    //输入字符串，将其中所有的字符替代为空格
    public String lineReplace(String line){
        //特殊处理符号￥
        line=line.replace("￥"," ");
        line=line.replace("'"," ");

        return line.replaceAll("[\\pP\\p{Punct}]", " ");
    }


    //获取文件列表
    public File[] getFileList(String path){
        File file=new File(path);
        File[] fileList=file.listFiles();
        return  fileList;
    }

    //重命名
    public void renameFile(String path){
        FileUtil fileUtil=new FileUtil();
        //获取文件
        File[] files=fileUtil.getFileList(path);

        File newFile=null;
        String newFileName=null;
        for(File file1:files){
            //获取文件名
            String filename=file1.getName();
            //替换
            newFileName=filename.replace("-尚硅谷-老韩图解Java数据结构和算法-"," ");
            //重命名
            newFile=new File(path+newFileName);
            file1.renameTo(newFile);
            //System.out.println(file1.getName());
        }

    }

    //获取视频时间长
    public int videoTime(String sourceURL){
        File source=new File(sourceURL);
        int length = 0;
        try{
            MultimediaObject multimediaObject=new MultimediaObject(source);
            MultimediaInfo result=multimediaObject.getInfo();
            long ls=result.getDuration()/1000;
            length=(int) (ls % 3600) / 60;
            //length=String.valueOf(minute);
        }catch (Exception e){
            e.printStackTrace();
        }


        return length;
    }

    public static void main(String[] args) {
       /* String path="E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\test\\";
        FileUtil fileUtil=new FileUtil();
        fileUtil.renameFile(path);*/

        /*String path="E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\test\\001 几个经典的算法面试题(1).avi";
        FileUtil fileUtil=new FileUtil();
        String length=fileUtil.vidioTime(path);
        System.out.println(length);*/
        String path="E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\test\\";
        FileUtil fileUtil=new FileUtil();
        fileUtil.renameFile(path);
    }



}
