package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class E01Q05StopWatch extends JFrame {
    JButton startBtn=new JButton("시작");
    JButton stopBtn=new JButton("멈춤");
    JLabel label=new JLabel("스탑 워치",SwingConstants.CENTER);
    int n=0;
    boolean isStart=false;//스탑 위치가 시작됨??

    public E01Q05StopWatch(){
        super("스탑 워치!");
        label.setFont(new Font("",Font.BOLD,20));
        stopBtn.addActionListener((e)->{
            isStart=false;
        });
//        startBtn.addActionListener((e)->{
//            Runnable run=()->{ //새로 생성한 스레드가 호출할 함수
//                //무한반복문으로 0.01 초 쉬었다가 n을 증가
//                isStart=true;
//                while (isStart){
//                    //오류가 뜨면 실행 중인 어플이 멈추기 때문에 예외(오류) 처리해야합니다.
//                    try {//오류가 뜨면 무시하거나 처리해주는 블럭!!!
//                        Thread.sleep(10); //0.01 일꾼이 쉰다.
//                        n++;
//                        //String.format() //문자열에 수를 추가해주는 포맷을 제공
//                        //"%.4f 입니다", 13.0
//                        String numStr=String.format("%.2f",n/100.0);
//                        label.setText( numStr );
//                    }catch (InterruptedException ex){ //오류가 뜨면 처리하는 블럭!
//                        ex.printStackTrace(); //오류가 뜨는 위치와 오류를 붉은 색으로 출력
//                    }
//                }
//            };
//            Thread t=new Thread(run); //새로 생성할 일꾼이 할일 지정
//            t.start(); //일꾼이 일을 시작
//        });

        //javax.swing.Timer : 분기(밀리초)가 있는 무한 반복문(이벤트 디스패치 스레드 EDT)
        //start, stop 으로 무한 반복문을 시작, 종료해야함.
        ActionListener timerHandler=(e)->{
            n++;
            String nStr=String.format("%.2f",n/100.0);
            label.setText(nStr);
        }; //Timer 가 실행할 콜백함수 정의
        //1 : 0.001
        //10 : 0.01
        Timer timer=new Timer(10,timerHandler);
        //무한반복문+Thread.sleep 은 분기가 있는 무한반복문으로 가독성이 떨어짐 => Timer
        startBtn.addActionListener((e)->{
            timer.start();
        });
        stopBtn.addActionListener((e)->{
            timer.stop();
        });




        this.add(startBtn, BorderLayout.WEST);
        this.add(stopBtn, BorderLayout.EAST);
        this.add(label);

        this.setBounds(0,0,400,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new E01Q05StopWatch();
    }

}
