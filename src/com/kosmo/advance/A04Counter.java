package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Frame 만드는 법
//1. class 를 따로 만들고 Frame 을 상속 받는다.
//2. 추가할 컴포넌트를 필드로 정의  => 이벤트와 같은 내부 클래스에서 필드를 참조하기 좋다.
//3. 생성자를 정의
//자바 초급 -> GUI (클래스 문법 연습, 이벤트, 콜백함수)
class Counter extends JFrame{
    private int num=0;
    private JLabel label;//=new JLabel(num+"");
    private JButton btn;

    //  num-- 을 하는 버튼 추가
    //
//    class BtnHandler implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            num++;
//            label.setText(num+"");
//        }
//    }
    public Counter(){
        super("카운터"); //JFrame super =new JFrame("카운터");
        this.label=new JLabel(this.num+"",SwingConstants.CENTER);
        this.btn=new JButton("num++");
        /*btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++num;
                label.setText(num+"");
            }
        });*///익명클래스
        btn.addActionListener((e)->{
            ++num;
            label.setText(num+"");
        });//람다식, 함수형인터페이스(추상함수가 1개있는 인터페이스)
        super.add(label);
        super.add(btn, BorderLayout.NORTH);
        super.setBounds(0,0,500,500);
        super.setVisible(true);
        super.setDefaultCloseOperation(2);
    }

}

public class A04Counter {
    public static void main(String[] args) {
        Counter counter=new Counter();
    }
}
