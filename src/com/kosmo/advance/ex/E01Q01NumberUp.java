package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BtnHandler implements ActionListener {
    private JLabel label;
    public BtnHandler(JLabel label){
        this.label=label;
    }
    //필드,생성자(객체의 초기값을 정의),함수
    int a=10; //new BtnHandler().a ==>10  필드
    //다른 클래스를 그대로 가져와 사용하고 싶다!! ==> extends
    //건물을 만들고 싶은데 기초설계도(interface 구현x)를 가져오고 싶어!! ==> implements
    //건물의 기초설계도를 가져왔는데..따르지 않으면 오류 (규칙을 꼭 지켜야함)
    int sum(int [] arr){
        int sum=0;
        /// ???????
        return  sum;
    } //함수 new BtnHadler().sum(new int []{10,20})
    @Override //콜백함수의 설계도 == 콜백함수
    public void actionPerformed(ActionEvent e) {
        //클릭, 엔터 등의 이벤트로 동작하는 콜백함수
        //System.out.println("안녕!!");
        String num=label.getText();
        int i=Integer.parseInt(num); //"1"=>1 (오류가 뜰가능성이 있음)
        label.setText(i+1+"");

    }
}

public class E01Q01NumberUp {
    public static JLabel label=null;
    //static (클래스 변수,정적멤법)
    // 누구나다 접근가능, jvm이 실행되는 동시에 데이터로 존재

    public static void main(String[] args) {
        //swing  GUI
        JFrame frame=new JFrame("NumberUp");
        //hd : x=1980 X y=1080
        JLabel label=new JLabel("0",SwingConstants.CENTER);
        //변수는 타입을 쓰면 선언으로 생성!
        JButton btn=new JButton("숫자 1씩 증가");

        //BtnHandler 가 지역변수 label 을 접근할 수 없다!!
        //1. label을 클래스멤버로 변경
        //2. BtnHandler 생성자에 전달
        //3. BtnHandler 를 사용하지 않고 람다식이나 익명클래스 사용!!
        btn.addActionListener(new BtnHandler(label));
        ///ActionListener(인터페이스) 타입이 콜백함수의 기초 설계도

        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        frame.add(btn, BorderLayout.NORTH);
        frame.add(label,BorderLayout.CENTER);

        frame.setSize(200,200);
        frame.setLocation(0,0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
