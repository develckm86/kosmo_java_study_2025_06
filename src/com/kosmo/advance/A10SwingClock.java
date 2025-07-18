package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class A10SwingClock extends JFrame {
    private JButton startBtn;
    private JButton stopBtn;
    private JLabel label;
    private boolean isClock;
    public A10SwingClock(){
        startBtn=new JButton("시계 시작");
        startBtn.addActionListener((e)->{
            //Thread.stop() : 강제로 일꾼을 종료(권장하지 않음!!)
            //무한반복문의 조건을 false로 바꿔서 천천히 종료하는 것을 권장
            if(isClock) return;//이 다음 코드는 실행하지 않고 종료!!

            isClock=true;
            new Thread(()->{
                while (isClock){
                    try {Thread.sleep(1000);} catch (InterruptedException ex) {}
                    label.setText(LocalDateTime.now().toString());
                }
            }).start();
        });

        stopBtn=new JButton("시계 종료");
        stopBtn.addActionListener((e)->{
            isClock=false;
        });
        label=new JLabel(LocalDateTime.now().toString());
        this.add(startBtn, BorderLayout.WEST);
        this.add(stopBtn, BorderLayout.EAST);
        this.add(label);

        this.setBounds(0,0,400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);
    }
    public static void main(String[] args) {
        new A10SwingClock();
    }
}
