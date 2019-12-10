package com.util;

public class FileUtil {

    //输入字符串，将其中所有的字符替代为空格
    public String lineReplace(String line){
        //特殊处理符号￥
        line=line.replace("￥"," ");
        return line.replaceAll("[\\pP\\p{Punct}]", " ");
    }


}
