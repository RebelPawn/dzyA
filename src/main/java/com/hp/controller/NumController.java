package com.hp.controller;

import java.util.Random;

public class NumController {

    /**
     * 计算平均数
     *
     * @param numSize 随机的数字个数
     * @param average 平均值
     * @return 随机数数组
     */
    public int[] test(int numSize, int average) {
        int max=5;
        int min=1;
        Random rand = new Random();

        //生成的数字放到数组中
        int result[] = new int[numSize];
        if (numSize % 2 == 0) {
            //偶数个数
            for (int i = 0; i < numSize; i = i + 2) {
                int rand1 = rand.nextInt(max)%(max-min+1) + min;
                int leave1 = average - rand1;
                int leave2 = average + rand1;
                result[i] = leave1;
                result[i + 1] = leave2;
            }
        } else {
            //奇数个数
/*            for (int i = 0; i < numSize - 1; i = i + 2) {
                int rand1 = rand.nextInt(max)%(max-min+1) + min;
                int leave1 = average - rand1;
                int leave2 = average + rand1;
                result[i] = leave1;
                result[i + 1] = leave2;
            }
            result[numSize - 1] = average;*/
        }
        return result;
    }

    public int[] createNum(int numSize, int average,int min,int max ){
        int sum=0;
        Random rand = new Random();

        //生成的数字放到数组中
        int result[] = new int[numSize];
        for (int i = 0; i < numSize - 1; i = i + 1) {
            int rand1 = rand.nextInt(max)%(max-min+1) + min;
            result[i] = rand1;
            sum+=rand1;
        }
        result[numSize - 1] = average*numSize-sum;

        return result;
    }

    public void getNum(int numSize, int average,int min,int max){
        int test[] = new NumController().createNum(numSize, average,min,max);
        int total = 0;
        if(test[numSize-1]>max){
            getNum(numSize, average, min, max);
        }else {
            for (int i = 0; i < test.length; i++) {
                System.out.println("第" + (i + 1) + "个数：" + test[i]);
                total += test[i];
            }

            System.out.println("总和：" + total);
        }
    }

    public static void main(String[] args) {
        NumController nc=new NumController();
        for (int index=0;index<50;index++){
            nc.getNum(6,4,1,5);
        }


    }


}
