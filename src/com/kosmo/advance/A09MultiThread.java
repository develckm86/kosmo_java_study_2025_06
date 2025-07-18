package com.kosmo.advance;

import java.time.LocalDateTime;

//Thread Runnable로 구현된 함수만 실행
class DigiClock implements Runnable{
    @Override
    public void run() { //일꾼이 실행할 함수!! (콜백함수)
        while (true){
            try {Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println(LocalDateTime.now());
        }
    }
}
public class A09MultiThread {
    public static void main(String[] args) {
        Thread thread=new Thread(new DigiClock());
        //일꾼생성 및 콜백함수(일꾼이 실행할 코드) 준비
        thread.start();

        int sum=0;
        for (int i=1; i<=100; i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
