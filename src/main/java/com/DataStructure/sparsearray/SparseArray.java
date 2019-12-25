package com.DataStructure.sparsearray;

import com.DataStructure.Array;

public class SparseArray {

    public static void main(String[] args) {
        int[][] arr1= new int[11][11];

        arr1[1][2]=1;
        arr1[3][4]=2;

        for (int[] arr2:arr1){
            for (int a:arr2){
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }

        int sum =0;
        for (int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(arr1[i][j]!=0){
                    sum++;
                }
            }
        }

        int sparseArray[][]=new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        int count=0;
        for(int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if(arr1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=arr1[i][j];
                }
            }

        }

        for(int[] arr2:sparseArray){
            for (int item:arr2){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        //初始化数组
        int chessArr2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];

        for(int a=1;a<sparseArray.length;a++){
            chessArr2[sparseArray[a][0]][sparseArray[a][1]]=sparseArray[a][2];

        }

        for (int[] arr2:chessArr2){
            for (int a:arr2){
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }


    }
}
