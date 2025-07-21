package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class A14JavaxSwingTimer {
    public static void main(String[] args) throws InterruptedException {
        //javax.swing.Timer : java.util.Timer 처럼 스케줄링 스레드 작성에 사용됨
        //사용방법이 다름
        //EDT(Event Dispatch Thread) : 이벤트를 스레드에게 배달, 이벤트를 처리하는 일꾼 !!
        //동작 원리 : 이벤트 큐 (초밥의 달인처럼 일을 진행=>1개의 스레드가 멀티스레드처럼 동작)
        //JFrame 에 존재하는 EDT 로 동작하기 때문에 JFrame 객체가 화면에 없으면 동작하지 않음

        Timer time=new Timer(1000,(e)->{
            System.out.println("안녕!");
        });

         //time.start();
        JFrame frame=new JFrame("Timer 실습");
        JButton btn=new JButton("시계");
        JLabel label=new JLabel("시간 출력!");
        frame.add(label);
        frame.add(btn, BorderLayout.NORTH);

        Timer t=new Timer(1000,(ea)->{
            label.setText(LocalDateTime.now().toString());
        });

        btn.addActionListener((e)->{
            t.start();
        });
        frame.setBounds(-1980,0,200,200);
        frame.setVisible(true);
        Thread.sleep(1000*10);
        t.stop();

    }
}
