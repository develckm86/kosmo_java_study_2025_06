package com.kosmo;

import java.util.Arrays;

public class L15TowDimArray {
    public static void main(String[] args) {
        String [] strs={"안녕","잘가","잘자"};
        char[][] charTwos={
                {'안','녕'},
                {'잘','가'},
                {'잘','자'}
        };
        int [][] scoreTwos={
                {88,77,99},
                {100,66,89},
                {81,100,100}
        };
        //3명의 학생의 3과목씩 저장된 배열
        int [][] arr=new int[2][3];
        // {{0,0},{0,0},{0,0}} new int[3][2];
        // {{0,0,0},{0,0,0}} (o)
        System.out.println(Arrays.toString(arr));

        //{ {null,null,null,null}, {null,null,null,null}} String
        String [][] strs2=new String[2][4];
        //{ {0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0}}
        double [][] doubles=new double[4][3];
        //배열을 리털럴하게 표기할때 ({ }) : 꼭 선언과 동시에 대입
        arr=new int[][]{};
        int ns[]={1,2,3,4};
        //ns={5,6,7}; //선언과 동시에 대입이 아니라 오류
        ns=new int[]{5,6,7}; //변수에 다시 리터럴할게 선언하는 방법

        //{  {88,77,99},  {100,66,89},  {81,100,100}  };
        //2차원 배열 탐색은 반복문을 중복해서 2개 사용
        for(int i=0; i<scoreTwos.length; i++){
            //i==0  {88,77,99} 99=>scoreTwos[0][2]
            //i==1  {100,66,89}
            //i==2  {81,100,100}
            for (int j=0; j<scoreTwos[i].length; j++){
                System.out.print(scoreTwos[i][j]+" ");
            }
            System.out.println();
        }

    }
}
