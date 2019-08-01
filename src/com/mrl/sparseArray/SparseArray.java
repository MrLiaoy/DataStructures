package com.mrl.sparseArray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        int[][] arr=new int[10][10];
        arr[1][3]=3;
        arr[3][2]=12;
        arr[4][8]=4;
        arr[2][3]=4;
        arr[5][4]=4;
        //将数组转换为稀疏数组
        int[][] sparse = setSparse(arr);

        //对数组进行序列化
        Serialization(sparse);


        //对保存的数据反序列化
        int[][] spa = Deserialization();

        //将稀疏数组转换为普通数组
        int[][] arr2 = getArray(spa);

        for (int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[i].length;j++){
                System.out.print(arr2[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void Serialization(int[][] sparse) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("sparase.data"));
            objectOutputStream.writeObject(sparse);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i<4;i++){
            System.out.println(sparse[i][0]+"\t"+sparse[i][1]+"\t"+sparse[i][2]+"\t");
        }
    }

    private static int[][] Deserialization() {
        ObjectInputStream objectInputStream=null;
        int[][] spa=null;
        try {

            objectInputStream=new ObjectInputStream(new FileInputStream("sparase.data"));
          spa= (int[][]) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return spa;
    }

    private static int[][] getArray(int[][] sparse) {
        int[][] arr2=new int[sparse[0][0]][sparse[0][1]];

        for (int i=1;i<sparse.length;i++){
            arr2[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        return arr2;
    }

    private static int[][] setSparse(int[][] arr) {
        int row=0;
        for(int i=0 ; i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0)
                    row++;
            }
        }
        System.out.println(row);

        int[][] sparse=new int[row+1][3];
        sparse[0][0]=10;
        sparse[0][1]=10;
        System.out.println(row);
        sparse[0][2]=row;
        System.out.println( sparse[0][2]);
        int count=0;
        for(int i=0 ; i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    count++;
                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=arr[i][j];

                }
            }
        }
        return sparse;
    }
}
