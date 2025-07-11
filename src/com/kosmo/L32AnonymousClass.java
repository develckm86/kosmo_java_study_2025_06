package com.kosmo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@FunctionalInterface //추상메서드가 1개 뿐이야 (람다식을 쓸수 있어)
interface Testable{
    void test();
    //void test2();
}
/*
L32AnonymousClass.class
L32AnonymousClass$Test.class
L32AnonymousClass$1.class //익명클래스 (숫자이름)
*/

public class L32AnonymousClass {
    //Testable 를 사용하기 위해 보통 내부클래스를 작성
    //L32AnonymousClass$Test
    class Test implements Testable{
        @Override
        public void test() {
            System.out.println("테스트 중입다.");
        }
    }
    //컴파일러가 몰래~~~~

    void run(){
        Test t=new Test();
        //L32AnonymousClass$Test
        t.test();
    }
    void run2(){
        //Testable을 구현하지 않고 객체로 바로 만들고 싶어!!
        //Testable을 구현한 객체를 한번만 쓰고 다시는 사용하지 않을 거야
        //그런데 Test 클래스를 만들필요가 있을까????
        Testable t=new Testable(){
            //L32AnonymousClass$1
            @Override
            public void test() {
                System.out.println("테스트 중입니다.");
            }
        };
        //내(자바)가 그럼 바로 인터페이스를 객체로 만들어줄께
        //대신 추상메서드를 객체 만들면서 바로 구현해!!

        //익명클래스 개념
        //추상메서드를 포함하는 인터페이스나 추상클래스를 객체로 만들 수 없는데
        //개발자 편의를 위해 추상 메서드를 구현하면서 객체를 생성하는 문법을 지원합니다.
        //이때 컴파일러 구현한 코드를 익명클래스에 반영합니다.
        t.test();
    }
    void run3(){
        Testable t2=new Testable(){
            @Override
            public void test() {

            }
        };
        //람다식 ()->{} == test(){}
        Testable t=()->{

        };

    }

    static class BtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //버튼이 누르면 ~~을 하라!!!!!
        }
    }
    public static void main(String[] args) {
        //new Testable();

        JButton btn=new JButton("클릭");
        btn.addActionListener(new BtnHandler());
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //버튼이 눌리는 기능
            }
        });

//L32AnonymousClass$Test.class
//L32AnonymousClass$1.class
//L32AnonymousClass$2.class
//L32AnonymousClass$BtnHandler.class
    }
}
