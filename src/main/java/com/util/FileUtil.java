package com.util;

import java.io.File;
import java.util.List;

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

    private String vidioTest(File source){

        return "";
    }

    public static void main(String[] args) {
        String path="E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\test\\";
        FileUtil fileUtil=new FileUtil();
        fileUtil.renameFile(path);
    }



}
