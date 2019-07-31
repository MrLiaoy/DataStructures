package com.mrl.sparseArray;

public class SparseArray {
    public static void main(String[] args) {
        int[][] arr=new int[10][10];
        arr[1][3]=3;
        arr[3][2]=12;
        arr[4][8]=4;
        arr[2][3]=4;
        arr[5][4]=4;
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

        for (int i=0;i<4;i++){
            System.out.println(sparse[i][0]+"\t"+sparse[i][1]+"\t"+sparse[i][2]+"\t");
        }

        int[][] arr2=new int[sparse[0][0]][sparse[0][1]];

        for (int i=1;i<sparse.length;i++){
            arr2[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }

        for (int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[i].length;j++){
                System.out.print(arr2[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
