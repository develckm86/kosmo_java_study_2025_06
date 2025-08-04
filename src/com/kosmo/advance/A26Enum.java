package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
//인터페이스 내부에 정의된 전역변수가 클래스멤버로 상수가 되는지 설명!!
interface Direct{
    int NORTH=0;//public static final
    public static final int SOUTH=1;
    //인터페이스 내부의 필드는 왜 ??? public static final 이 붙을까??
    //인터페이스 필드(인스턴스의 정보)를 가질 수 없다.
    // 때문에 인터페이스 내부에 정의된 변수는 자동으로 static 필드인 클래스 멤버가 된다.
    // 인터페이스 내부에 정의된 모든 것은 public 이 붙는다. : 설계도기 때문
    //void sum();
    // 클래스 멤버는 정적메모리에 저장, 누구나다 접근 후 바꿀 수 있음 => 문제를 야기할 수 있음(final)
}
enum DirectEnum{
    //타입, 접근지정자, 상수 를 작성할필요가 없다.
    NORTH,SOUTH;
}
public class A26Enum {
    ///class 1 implements Direct{}

    ///Direct d=new Direct(); //인터페이스는 설계도일 뿐이지 객체가 될 수 없다.
    Direct d=new Direct(){}; //new 1() 익명클래스가 객체가 됨

    public static final int NORTH=10;
    public static final int SOUTH=11;
    public static void main(String[] args) {
        //열거형 enum == 타입 : 정보로서의 상수 정의용
        //상수(Constant,cont) : 처음 참조한 값을 바꾸지 못하는 것,정보(바뀌지 않는 사실)로 사용 됨
        //변수(Variable,val) : 참조한 값을 계속 바꿀 수 있는 것
        int a=10;
        a=20;//변수
        final int B=20;
        //B=30;
        int r=2;
        //원의 둘래 : 반지름*2*3.14
        System.out.println(Math.PI); //3.141592653589793
        System.out.println(r*2*Math.PI);
        //public static final double PI = 3.141592653589793
        //public : 다른 패키지 누구나 다 사용 (private: 클래스 내부, default: 같은 패키지)
        //static : 클래스멤버, JVM 이 시작될때 데이터가 되어라!, 정적 메모리 영역인 메소드 영역에서 계속 유지
        //public static final : 정보로 사용되기 위해 누구나 다 사용 가능해야 하고 선언된 즉시 호출 가능

        //상수의 사용 목적
        //1.데이터의 상태를 나타내기 위해
        //2.조건의 상태를 나타내기 위해
        //3.약속된 수학적 수를 사용하기 위해 (PI)

        //1, 2는 큰 문제를 안고 있음 : 약속된 상태를 수나 문자열로 표현
        new JFrame().add(new JButton(), BorderLayout.NORTH);
        new JFrame().add(new JButton(), "NORTH"); //문자열이면 아무거나 대입가능
        int code=11;
        new JFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        new JFrame().setDefaultCloseOperation(22);
        switch (code){
            case Direct.NORTH -> System.out.println("위로이동");
            case Direct.SOUTH -> System.out.println("아래로이동");
        }
        //정수로 상태를 표현하면 조건의 분기 타입을 어떤 것이든 사용가능하게 됨!
        //고유 상태를 갖는 상수 타입을 만들자!-> enum

        //enum의 지역변수는 클래스 멤버로 고유값을 갖는다.
        DirectEnum direct=DirectEnum.NORTH;
        switch (direct){
            case NORTH -> System.out.println("위로위로 이동");
            case SOUTH -> System.out.println("아래아래로 이동");
        }
        //switch  : 조건으로 기본형데이터와 문자열과 열거형(enum) 외의 자료형을 사용할 수 없음

    }
}
