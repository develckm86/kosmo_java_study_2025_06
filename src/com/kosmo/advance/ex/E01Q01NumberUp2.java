package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E01Q01NumberUp2 extends JFrame {
    //필드간의 접근은 자유롭기 때문에 컴포넌트를 필드로 정의
    private JButton btn; //증가버튼
    private JButton resetBtn; //리셋버튼
    private JLabel label;
    private int num=0;
    class BtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ++num;
            label.setText(num+"");
        }
    }
    public E01Q01NumberUp2(){
        //super();//this.super=new JFrame(); : 무조건 맨 상단에 자동완성!
        super("NumberUp2"); //this.super=new JFrame("NumberUp2");
        //super 를 호출하면 부모의 기본(default) 생성자를 호출하지 않는다!

        label=new JLabel("카운터",SwingConstants.CENTER);
        label.setFont(new Font("",Font.ITALIC,40));

        btn=new JButton("증가 버튼");
        btn.addActionListener(new BtnHandler());

        resetBtn=new JButton("리셋 버튼");
        resetBtn.addActionListener((e)->{
            num=0;
            label.setText(num+"");
        });
        JPanel p=new JPanel();
        p.setLayout(new FlowLayout()); //배치 마법사 : 컴포넌트를 배치
        p.add(btn);
        p.add(resetBtn);

        super.add(label);
        super.add(p, BorderLayout.NORTH);



        //E01Q01NumberUp2 this=new E01Q01NumberUp2(); //this 의 실체
        this.setSize(400,200);
        this.setLocation(0,0);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        new E01Q01NumberUp2();
//        E01Q01NumberUp2 frame=new E01Q01NumberUp2();
//        frame.setSize(200,200);
//        frame.setLocation(0,0);
//        frame.setVisible(true);
    }
}
