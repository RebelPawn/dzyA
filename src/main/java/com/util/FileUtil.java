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


    public void getFileList(String path){
        File file=new File(path);
        File[] fileList=file.listFiles();
        for(File file1:fileList){
            System.out.println(file1.getName());
        }

    }

    private String vidioTest(File source){

        return "";
    }

    public static void main(String[] args) {
        String path="E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\视频";
        FileUtil fileUtil=new FileUtil();
        fileUtil.getFileList(path);
    }

/*    private String ReadVideoTime(File source) {
        Encoder encoder = new Encoder();
        String length = "";
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration()/1000;
            int hour = (int) (ls/3600);
            int minute = (int) (ls%3600)/60;
            int second = (int) (ls-hour*3600-minute*60);
            length = hour+"'"+minute+"''"+second+"'''";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }*/


}
