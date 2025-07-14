package com.kosmo.ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@FunctionalInterface //추상함수가 1개뿐인 인터페이스야! 그러니 람다식을 쓸수 있어!!
interface TestTestable{
    void a();
}
class TestTestImp implements TestTestable{
    @Override
    public void a() {

    }
}
class One implements TestTestable{
    @Override
    public void a() {

    }
}
public class S30AnonyClassLambda {


    public static void main(String[] args) {
        //new TestTestable();
        new TestTestImp();
        new TestTestable(){
            @Override
            public void a() {

            }
        }; //익명클래스로 객체를 생성
        new One();

        TestTestable rambdaT=()->{};//익명클래스가 귀찮아서 나온 문법 (함수형언어:함수가객체인 언어,전달하는 데이터로 바로 함수를 보냄)
        //new Button().addActionListener(//매개변수는 무조건 데이터: 객체,기본형);
        new Button().addActionListener((e)->{

        }); //함수형 언어인 척하는 문법,자바는 객체지향 문법이라 무조건 객체를 전달.

        new Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /*
📘 자바 익명 클래스(Anonymous Class)와 람다식 수업 정리

🔷 1. 추상 메서드와 @FunctionalInterface

@FunctionalInterface
interface Testable {
    void test();
}

	•	@FunctionalInterface는 추상 메서드가 1개만 존재하는 인터페이스임을 명시
	•	이 조건을 만족하면 람다식 사용 가능
	•	Runnable, ActionListener, Comparator 등도 대표적인 함수형 인터페이스

⸻

🔷 2. 내부 클래스(Inner Class)

class Test implements Testable {
    @Override
    public void test() {
        System.out.println("테스트 중입다.");
    }
}

	•	클래스 내부에 정의된 일반 클래스
	•	보통 특정 클래스 내부에서만 사용할 도우미 역할로 정의됨
	•	컴파일되면: L32AnonymousClass$Test.class

⸻

🔷 3. 익명 클래스 (Anonymous Class)

Testable t = new Testable() {
    @Override
    public void test() {
        System.out.println("테스트 중입니다.");
    }
};

	•	이름 없이 인터페이스나 추상 클래스를 구현하며 객체를 바로 생성
	•	일회용 구현체가 필요할 때 사용
	•	클래스 파일 이름은 L32AnonymousClass$1.class와 같이 번호로 생성됨
	•	주로 이벤트 리스너나 콜백 구현에 사용

⸻

🔷 4. 람다식 (Lambda Expression)

Testable t = () -> {
    System.out.println("람다로 구현!");
};

	•	익명 클래스보다 더 간결한 표현
	•	단, @FunctionalInterface 인터페이스만 람다로 구현 가능
	•	메서드가 1개일 때만 사용 가능
	•	자바 8부터 지원

⸻

🔷 5. 이벤트 리스너와 익명 클래스

JButton btn = new JButton("클릭");
btn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼 클릭됨!");
    }
});

	•	ActionListener도 추상 메서드가 1개 → 함수형 인터페이스
	•	익명 클래스를 통해 버튼 동작을 바로 정의 가능
	•	코드가 간결하며 여러 버튼마다 다른 동작을 지정하기에 편리

⸻

🔷 6. 컴파일 결과 클래스 파일

클래스명	역할
L32AnonymousClass.class	메인 클래스
L32AnonymousClass$Test.class	내부 클래스
L32AnonymousClass$1.class	첫 번째 익명 클래스
L32AnonymousClass$2.class	두 번째 익명 클래스
L32AnonymousClass$BtnHandler.class	내부 static 클래스


⸻

✅ 핵심 요약

문법	                특징	                            사용 목적
내부 클래스	        클래스 내부에서만 사용하는 클래스	    보조 역할
익명 클래스	        클래스 없이 일회용 객체 생성	        이벤트 처리, 콜백
람다식	            함수형 인터페이스를 간단하게 구현	    코드 간결화
함수형 인터페이스	    추상 메서드 1개	                람다식 대상


*
📘 익명 클래스 & 추상 메서드 & 함수형 인터페이스 문제 10제

문제 1

다음 중 추상 메서드의 특징으로 옳은 것은?
D

A. 본문이 있는 메서드다 //본문이 없는
B. static으로 선언해야 한다. //static 메서드는 추상일 수 없다.(무조건 본문이 존재해야함{})
C. 객체 생성 없이 사용할 수 있다 //구현할때까지 사용불가
D. 반드시 자식 클래스에서 오버라이딩해야 한다 //O

⸻

문제 2
new Interfaceable(){
}
다음 중 익명 클래스(Anonymous Class)의 설명으로 틀린 것은?
C
A. 클래스 이름이 없다
B. 추상 클래스나 인터페이스를 구현하며 객체를 생성한다
C. 재사용이 많은 클래스에 적합하다 //재사용 불가 : 재사용할 일 없는 객체에 사용
D. 추상 메서드를 즉시 구현할 수 있다 //O

⸻

문제 3

다음 중 함수형 인터페이스(@FunctionalInterface)의 조건으로 옳은 것은?
C
A. public 메서드를 2개 이상 정의해야 한다
B. static 메서드만 있어야 한다
C. 추상 메서드가 반드시 1개만 있어야 한다
D. 인터페이스는 클래스처럼 객체를 생성할 수 있어야 한다

⸻

문제 4

람다식으로 변환 가능한 인터페이스의 조건으로 알맞은 것은?
D
A. 추상 메서드가 없어야 한다
B. 오직 static 메서드만 있어야 한다
C. 추상 메서드가 2개 이상 있어야 한다
D. 추상 메서드가 1개여야 한다

⸻

문제 5

다음 코드의 설명으로 옳은 것은?
B
Testable t = new Testable() {
    @Override
    public void test() {
        System.out.println("테스트 중입니다.");
    }
};

A. 람다식 구현이다
B. 익명 클래스이며 객체를 생성하고 있다
C. 추상 클래스는 사용할 수 없다
D. 내부 클래스의 사용 예시다

⸻

문제 6

다음 중 익명 클래스를 사용할 수 있는 상황은?
B
A. 일반 클래스의 객체를 반복적으로 생성해야 할 때
B. 단 한 번만 사용할 인터페이스 구현이 필요할 때
C. static 메서드를 정의할 때
D. 클래스를 반드시 이름으로 재사용해야 할 때

⸻

문제 7

다음 코드에서 생성되는 클래스 파일 이름은 무엇인가?
C
class A{
   class 1 implements Testable{} A$1
    void sum(){
        Testable t = new Testable() {
            @Override
            public void test() {}
        };
    }
}
A. Testable$1.class
B. A$Test.class
C. A$1.class
D. Test.class

⸻

문제 8

람다식은 다음 중 어떤 인터페이스에서만 사용할 수 있는가?
C
A. 메서드가 없는 인터페이스
B. 추상 메서드가 여러 개인 인터페이스
C. 추상 메서드가 하나인 함수형 인터페이스
D. 상속된 모든 인터페이스

⸻

문제 9

다음 중 @FunctionalInterface 어노테이션의 역할은?

A. 클래스 내부에만 사용 가능하다
B. 추상 클래스에 붙이는 어노테이션이다
C. 추상 메서드가 1개인지 컴파일 시 검사한다
D. 자동으로 람다식으로 변환해 준다

⸻

문제 10

다음 코드에서 btn.addActionListener()에 전달된 것은 무엇인가? (addActionListener의 매개변수는)
D
btn.addActionListener(new ActionListener() {//new 1() ActionListener를 구현한 익명클래스
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("클릭됨");
    }
});

A. static 클래스
B. 람다식
C. 내부 클래스
D. 익명 클래스

⸻
* 1번: D, 2번: C, 3번: C, 4번: D, 5번: B, 6번: B, 7번: C, 8번: C, 9번: C, 10번: D
* */
}
