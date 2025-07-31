package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class A25MoveBlockCanvas extends JFrame {
    int x=0; //분기마다 변경 후 캔버스를 다시 그리려고
    javax.swing.Timer timer; //x의 위치를 0.1초 분기마다 이동
    final int WIDTH=500;
    final int HEIGHT=500;
    int keyCode=KeyEvent.VK_RIGHT; //기본은 오른쪽

    //start()시작, stop()멈춤
    class MyCanvas extends Canvas{

        public MyCanvas(){
            //KeyListener : 키보드 이벤트를 받는 인터페이스
            //Typed : 누르고 놓는 것 (문자열), Press : 누르기만 하는 것, Released :누른 상태에서 놓는 것
            //KeyAdapter : KeyListener를 구현한 추상클래스 (여러개의 추상메서드 중에 한개만 구현가능)
            //람다식은 인터페이스가 한개의 추상메서드가 있을때만 가능!!
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    //e  : 이벤트 정보
                    keyCode=e.getKeyCode();
                }
            });
        }


        @Override
        public void paint(Graphics g) {
            //블럭(color,x,y,w,h)을 객체로 만들어서 2개이상 출력

            g.setColor(Color.BLUE);
            g.fillRect(x,200,50,50);
        }
    }


    private Canvas canvas;
    public A25MoveBlockCanvas(){
        super("블럭을 움직이는 캔버스");

        canvas=new MyCanvas();
        canvas.setBackground(new Color(200,200,250));

        this.add(canvas);

        //0.1 초마다 블럭을 오른쪽으로 이동 (블럭의 x를 오른쪽(+=10)으로 이동하고 새로그림(repaint))
        //1. 스레드를 만들고 0.1 초 쉬었다가
        //2. java.util.Timer 로 0.1초 분기마다 실행되는 스레드 생성 후
        //3. javax.swing.Timer 로  EDT 에게 0.1초 분기마다 실행되는 콜백함 수 정의

        //1,2 : 멀티스레드 (EDT 가 아닌 스레드가 그래픽을 새롭게 그리면 충돌(깜박임))
        //3 : 원래 존재하는 EDT 에게 일시키기 (권장)


        timer=new Timer(100,(e)->{//분기마다 실행할 함수
            switch (keyCode){
                case KeyEvent.VK_RIGHT -> x+=10;
                case KeyEvent.VK_LEFT -> x-=10;
            }//위 아래 가능하게

            canvas.repaint(); //paint()를 다시 호출해서 그림 (paint 직접호출 금지)
            //y축의 최대,최소
            if(x>=(WIDTH-50)){ //최소
                //return; //타이머는 계속 실행되지만 콜백함수의 다음 코드는 실행안됨
                //timer.stop(); //타이머 자체를 멈춤
                return;
            }
            //x+=10;

        });
        timer.start();
        canvas.setFocusable(true);
        this.setBounds(-1920,0,WIDTH,HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);
    }

    public static void main(String[] args) {
//        new A25MoveBlockCanvas();
        SwingUtilities.invokeLater(()->{ //EDT window를 생성 (EDT와 main 충돌(깜박임) 예방)
            new A25MoveBlockCanvas();
        });
    }

}
