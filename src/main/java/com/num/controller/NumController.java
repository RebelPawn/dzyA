package com.num.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class NumController {
    public void upNum() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

       // List<Nummodel> nums=sqlSession.selectOne("selectSQ");
        int num=sqlSession.selectOne("selNum");
        sqlSession.close();
        System.out.println(num+"----");

       /* for (Nummodel nummodel:nums){
            System.out.println(nummodel);
        }*/
    }

    /**
     * 计算平均数
     *
     * @param numSize 随机的数字个数
     * @param average 平均值
     * @return 随机数数组
     */
  public int[] createNum(int numSize, double average,int min,int max ){
        int sum=0;
        Random rand = new Random();

        //生成的数字放到数组中
        int result[] = new int[numSize];
        for (int i = 0; i < numSize - 1; i = i + 1) {
            int rand1 = rand.nextInt(max)%(max-min+1) + min;
            result[i] = rand1;
            sum+=rand1;
        }
        result[numSize - 1] = (int) (Math.round(average*numSize)-sum);

        return result;
    }

    //获取指定平均数的数组
    public void getNum(int numSize, double average,int min,int max){
        int test[] = new NumController().createNum(numSize, average,min,max);
        int total = 0;
        if(test[numSize-1]>max){
            getNum(numSize, average, min, max);
        }else {
            for (int i = 0; i < test.length; i++) {
                System.out.print(/*"第" + (i + 1) + "个数：" +*/ test[i]+" ");
                total += test[i];
            }

            System.out.println("总和：" + total);
        }
    }

    public static void main(String[] args) throws IOException {
        NumController nc=new NumController();
        /*for (int index=0;index<50;index++){
            nc.getNum(6,4.16666666666667,1,5);
        }*/
        nc.upNum();


    }


}
