package com.kosmo;

public class L14For {
    public static void main(String[] args) {
        int n=0; //선언문
        while(n<3){ //조건문
            System.out.println("반복문:"+n);
            n++; //증감문
        }
        //선언문,조건문,증감문으로 반복의 횟수를 지정할 수 있음
        //i==index : 순서**,목차
        //for(선언문; 조건문; 증감문)
        System.out.println("for 반복문");
        for(int i=0;i<3;i++){
            System.out.println("반복문:"+i);
        }

        //for 반복문과 배열 탐색(순회)
        int [] arr={13,14,21,22,33,44,56,101,-3,-5};
        int [] scores= {88,77,100,99,55,89,50};//f가 2개이상이면 학사경고

        //arr 수 중에 홀수인 것의 수를 구하세요.
        int cnt=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==1) ++cnt;
        }
        System.out.println("훌수의 수는 "+cnt);

        cnt=0;
        for (int i=0; i<scores.length; i++){
            if(scores[i]<60) ++cnt;
        }
        if(cnt>=2){
            System.out.println("학생은 학사경고 대상입니다.");
        }else{
            System.out.println("학기를 무사히 마쳤습니다.");
        }

    }
}
