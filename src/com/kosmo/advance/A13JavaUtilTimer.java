package com.kosmo.advance;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;


public class A13JavaUtilTimer {
    public static void main(String[] args) {
        //1초마다 현재 시간을 콘솔에 출력하는 어플
        //대부분의 무한반복문에 텀을 작성하는 이유: cpu 과다 사용(StackOverFlow)을 막기위해
        Thread t=new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("스레드 인터럽 오류");
                }
                LocalTime now=LocalTime.now();
                System.out.println(now);
            }
        });
        //t.start();
        //쉬면서 스레드 생성하는 클래스 제공: java.util.Timer
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                System.out.println("안녕!!");
                System.out.println(LocalDateTime.now());
            }
        },0,1000);
        //timer.cancel(); == 스레드 종료!!
        //delay 기간동안 쉬었다가 period 마다 실행 (start 필요없음)
        System.out.println("내가 실행되면 무한 반복은 스레드 생성후 실행됨");

        //Swing의 스레드와 충돌 위험이 있어서 사용 중복해서 사용하면 안됨

    }
}
