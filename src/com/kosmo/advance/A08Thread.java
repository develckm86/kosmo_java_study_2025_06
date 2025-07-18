package com.kosmo.advance;

import java.time.LocalDateTime;

public class A08Thread {
    public static void main(String[] args) {
        //main 어플은 1개의 스레드 가진다.
        //스레드 == 일꾼
        //일꾼이 1명 => 1개씩 일을 진행
        //일꾼이 2명 => 2개씩 일을 진행

        //스레드가 1개 있는 언어를 1개씩 순서대로 실행된다해서 순차적 언어라 한다.
        //일꾼을 여러개 만들 수 있는 언어를 Thread를 지원한다. (자바는 Thread를 지원하는 언어)

        System.out.println("실행1");
        System.out.println("실행2");
        System.out.println("실행3");
        System.out.println("실행4");

        boolean isTime=true;
        while (isTime){ //화면에 시간을 출력
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
            //sleep : 일꾼이 쉬면 일꾼 충돌이 생길수 있어 예외처리를 강제함
            LocalDateTime now=LocalDateTime.now(); // 년-월-일T시:분:초.
            System.out.println(now.toString());
        }
        //1~100 까지 수를 더하기
        int sum=0;
        for (int i=1; i<=100; i++){
            sum+=i;
        }
        System.out.println(sum);


    }
}
