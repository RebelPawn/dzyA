package com.num.controller;

import java.util.Random;

public class NumDao {
    static class StopMsgException extends RuntimeException {
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
    public int[] getNum(int numSize, double average,int min,int max){
        int test[] = new NumDao().createNum(numSize, average,min,max);
        int total = 0;
        if(test[numSize-1]>max||test[numSize-1]<min){
            getNum(numSize, average, min, max);

        }else {
           /* for (int i = 0; i < test.length; i++) {
                //System.out.println("第" + (i + 1) + "个数：" + test[i]+" ");
                total += test[i];
            }
*/
            //System.out.println("总和：");

        }

        return test;
    }
    public int[] getNum1(double avg){
        NumDao nd=new NumDao();
        int[] num1=nd.getNum(4,avg,1,5);
        return num1;
    }
}
