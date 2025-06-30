package com.kosmo;
//deploy(배포) : 서비스,라이브러리
//public class : import 가능한 클래스 ???
//import  : 프로그램이 실행시 라이브러리를 가져와서 같이 실행

import java.lang.*; //자바 어플이 실행될때 꼭 필요한 클래스의 집합
//System  : 자바어플 실행하는 터미널을 접근 (모든 os는 터미널이 어플을 실행)
//Integer,Double,Short,Character... : 랩퍼클래스(기본형 데이터를 돕는 클래스)

public class L13Review {
    //main 함수가 있어야 자바 어플이 된다.
    public static void main(String[] args) throws InterruptedException {
        int i=10; //데이터 10이 생기고
        //int i 변수가 데이터 10을 참조
        //정수형 : byte short int(**) long
        //i=10l;
        //수를 리터럴하게 작성하면 int=>자바의 정수 기본형을 int로 사용
        //리터럴 : 자연스럽게, 있는그대로
        //실수형 : float, double(**)
        double d=10.0;
        float f=10.0f;
        //문자형 : ''  유니코드(utf-16)의 문자표의 번호를 참조
        //문자열형 : ""
        // 0, 1 : bit
        // 0000 0000 : 1byte
        // 0000~1111 : 0~15 ==0~F  16진수
        char c='\u0000'; // 0000 0000 0000 0000
        c='가';// \uAC00  // 1010 1100 0000 0000
        System.out.println((int)c);
        System.out.println(Integer.toHexString(c));
        int a=20;
        boolean b=a>10; //비교,논리 연산의결과인 boolean
        //true == 1,false == 0
        System.out.println(b);

        //변수는 같은 이름을 다시 선언(생성)할 수 없다.
        //선언 : 생성
        //double b=10.9;
        b=false;
        b=true;
        b=(10>20);
        b=true || false;
        //변수 : 데이터를 다른 것으로 참조 가능

        //상수 : 처음 참조한 데이터를 바꿀 수 없는 것 (constant)
        //보통 바뀌지 않는 정보성(약속) 데이터를 정의하기 위해 사용합니다.
        final double PI=3.14123123;
        //PI=1.14;


        //if else if else
        //switch
        //while
        int age=66;
        if(age>=20){ //분기 (조건이 true 일때 실행되는 분기)
            System.out.println("주류 구입");
        }else if(age>=60){
            //else if :복잡한 분기를 생성 (위쪽 분기가 만족되지 않을때 실행)
            System.out.println("주류 할인");
        }else{// 모두 만족하지 않을때
            System.out.println("미성년자는 구입 불가");
        }
        // == != ! >= <= > <
        // || &&
        //20 -> 2 66 ->6
        switch (age/10){
            case 2,3,4,5 :
                System.out.println("주류구입");
                break;
            case 6,7,8,9,10 :
                System.out.println("주류할인");
                break;
            default:
                System.out.println("미성년자 구입 불가");

        }

        while (true){
            Thread.sleep(1000);
            System.out.println("반복문");
        }


    }
}
