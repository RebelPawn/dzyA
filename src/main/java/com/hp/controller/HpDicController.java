package com.hp.controller;

import com.util.FileUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

public class HpDicController {

    public void wordImport(String path) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        File file=new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("无此路径 " + file);
        } else {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line=null;
            while ((line=br.readLine())!=null){
                if(line.length() == 0){
                    continue;
                }
                //先用空格代替特殊字符，例如标点
                line=new FileUtil().lineReplace(line);
                //根据空格切割
                String[] words = line.split(" ",-1);
                for(int index=0;index<=words.length;index++){
                    sqlSession.insert("insertWords",words[index]);
                }
            }
            sqlSession.close();
            br.close();

        }


    }

    public void addWord() throws IOException{
        //String path="mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        try{
            int a =sqlSession.selectOne("selectNum");
            System.out.println(a);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    public static void main(String[] args) throws IOException {
/*        String path = HpDicController.class.getClassLoader().getResource("").getPath();
        String path=HpDicController.class.getClass().getResource("/").getPath();
        String resource=path+"mybatis.xml";*/
/*
        String path="mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        try{
            int a =sqlSession.selectOne("selectNum");
            System.out.println(a);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
*/




    }
}
