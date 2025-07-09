package com.kosmo;

class Out{
    //static : 클래스 변수,메소드 (**독립적,객체와 관련이 없음)
    int a=10;
    In in =new In();
    //new Out() {a:10, in: new Int()}
    static int b=20;
    //{a:10, in: new Int(),b:20} : (xxxxx)

    class In{ //inner(nested) class :내부클래스
        //내부클래스 : class 내부에서만 사용하려고 만든 자료형
        //Out.java => Out.class
        //         => Out$In.class
        int score;
        String num;
    }
    //Out.A
    //Out$A.class
    static class A{} //정적 내부 클래스 : 밖의 클래스의 이름만 가져다 쓰는 독립적 class
}

public class L29InnerClass {
    public static void main(String[] args) {
        //Out.In in =new Out.In(); //내부클래스는 외부 클래스에 소속된 형태 (독립적이지 않다.)
        //In in =new In(); //내부클래스는 외부 클래스에 소속된 형태 (독립적이지 않다.)

        Out out=new Out();
        Out.In in=out.new In(); //이렇게 사용하는 목적이 아니다.(작성이 불편)
        Out.In in2=new Out().new In();

        System.out.println(new Out().a);
        System.out.println(Out.b); //static 는 독립적이라 객체 생성없이 데이터로 존재






        System.out.println("인너클래스 시작");

        //Out.In in3=new Out.In();
        //Out.In in3=new Out().new In();
        Out.A a=new Out.A();
    }
}
