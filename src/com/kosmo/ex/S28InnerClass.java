package com.kosmo.ex;
import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SonataCar{
    String model="소나타";
    static class Nested{
        //정적 중첩 클래스 SonataCar 라는 이름이 필요해서 존재
        //사용자 정의용이 아닌 시스템 정의용
        public void start(){
            //System.out.println(model);
        }
    }

    class Engine{ //내부클래스
        public void start(){
            System.out.println(model+"가 달린다!!!");
        }
    }
    public void run(){
        Engine engine=new Engine();
        engine.start();
    } //소나타가 달린다!!!
}






class Memo extends JFrame{
    JButton btn;
    class BtnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("안녕!!!");
            btn.setBackground(Color.MAGENTA);
            btn.setOpaque(true);
//            btn.setContentAreaFilled(true);
        }//핸들러:동작을 정의하겠다.
    }
    //중첩클래스
    Memo(){
        //JFrame frame=new JFrame("메모장");
        super("메모장");
        this.setSize(200,200);
        this.setLocation(-1500,300);
        btn=new JButton("클릭");
        btn.addActionListener(new BtnHandler()); //누를때 동작을 정의

        this.add(btn);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}




public class S28InnerClass { //외부클래스
    //S28InnerClass$Nested
    int a=10;
    class Nested{ //중첩 클래스
        int a=10;
        void mult(){
            this.a++; //new Nested().a //중첩클래스가 객체일때는 무조건 외부클래스가 객체일때기 때문
            S28InnerClass.this.a++; //new S28InnerClass().a
        }
    }
    //외부클래스 내부에서 특정 타입(외부클래스에서만 사용하는.. )이 필요한때 작성

    void sum(){
        Nested n=new Nested(); //보통 클래스와 같다.
    }

    //외부 : static은 독립적인 존재 (S28InnerClass의 외부)
    public static void main(String[] args) {
        ++new S28InnerClass().a;
        //++this.a; //S28InnerClass의 내부에 작성된 main이지만 static 은 독립적이기 때문에 필드로 접근 불가

        //S28InnerClass.Nested nested=new Nested();
        //S28InnerClass.Nested nested=new S28InnerClass.Nested();
        S28InnerClass.Nested nested=new S28InnerClass().new Nested();

        //java swing GUI(마우스로 그래픽을 누르는 인터페이스 제공)
        //mac vs window =>
        //apple ios(스마트)  vs 안드로이드 (조잡, 어려움)

//        JFrame frame=new JFrame("중첩클래스 수업");
//        frame.setSize(200,200); //픽셀
//        frame.setLocation(-1500,300);
//
//        JButton btn=new JButton("클릭");
//        frame.add(btn);
//
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //x 버튼을 누르면 종료되게 구현

        new Memo(); //window 창은 무한 반복 =>close를 호출하지 않으면 종료되지 않음

    }


    /*
⸻

1. 내부 클래스란?

class Out {
    class In {
        int score;
        String num;
    }
}

	•	**내부 클래스 (inner class)**는 외부 클래스 안에 정의된 클래스
	•	Out.In은 Out 클래스에 소속된 자료형으로 동작
	•	보통 외부 클래스의 기능을 보조하기 위해 사용됨
	•	컴파일 시 Out$In.class로 별도 파일 생성됨

⸻

2. 내부 클래스의 특징

항목	내용
접근 방식	new Out().new In() 형태로 접근
외부 클래스의 인스턴스 필요	예 (반드시 필요함)
사용 목적 외부 클래스의 기능을 보조하기 위해 사용됨
예	GUI 이벤트 처리, 특정 객체 안에서만 쓰는 자료형 등

Out out = new Out();
Out.In in = out.new In(); // 내부 클래스 인스턴스 생성


⸻

3. 정적 내부 클래스 (static nested class)

static class A {}

	•	static으로 선언된 내부 클래스
	•	외부 클래스와는 이름만 공유, 독립적인 클래스로 취급
	•	외부 클래스의 인스턴스 없이도 사용 가능

Out.A a = new Out.A(); // 직접 생성 가능


⸻

4. static 멤버와의 관계

static int b = 20; // 클래스(static) 변수
System.out.println(Out.b); // 객체 없이 접근 가능

	•	static 멤버는 객체 생성 없이 클래스명으로 접근
	•	Out.b처럼 클래스명으로 바로 사용 가능

⸻

5. 정리: 내부 클래스 vs 정적 내부 클래스

구분	내부 클래스 (class In)	정적 내부 클래스 (static class A)
외부 클래스 인스턴스 필요	필요 (new Out().new In())	불필요 (new Out.A())
외부 클래스 멤버 접근	가능	정적 멤버만 접근 가능
사용 목적	외부 객체 내부 보조용	구조적 조직, 유틸리티 목적
컴파일 결과	Out$In.class	Out$A.class


⸻

6. 출력 예시 코드 요약

System.out.println(new Out().a);   // 인스턴스 변수
System.out.println(Out.b);         // static 변수
Out.A a = new Out.A();             // 정적 내부 클래스 인스턴스 생성


⸻

7. 실습 팁
	•	내부 클래스는 외부 클래스와 강하게 연결된 구조
	•	정적 내부 클래스는 독립적으로 동작
	•	내부 클래스를 많이 사용할 경우 코드 복잡성이 증가할 수 있음 → 적절한 캡슐화 필요

⸻

✅ 자바 내부 클래스(Inner Class) 문제 10선

⸻
class A{
    class B{}
    static class C{}
}
1. 내부 클래스(Inner Class)의 정의로 올바른 것은?

B
A. 클래스 안에 선언된 메서드를 말한다
B. 클래스 안에 선언된 다른 클래스를 말한다
C. 메서드 안에 선언된 클래스만을 말한다
D. 상속받은 클래스를 말한다

⸻
class A{
    int i=10; //필드 (인스턴스 변수 : new A().i)
    class B{//내부 클래스
        B(){
            ++i;
        }
    }
}

2. 내부 클래스의 일반적인 특징은?
C
A. 항상 static이어야 한다
B. 외부 클래스의 인스턴스 없이 생성할 수 있다 // 없다.
C. 외부 클래스의 인스턴스 변수(필드)에 직접 접근 가능하다 //가능
D. main 메서드 내에서만 사용 가능하다

⸻

3. 내부 클래스의 인스턴스(객체)를 생성할 때 올바른 방법은?
C
class Outer {
    class Inner {}
}

A. Outer.Inner in = new Inner();
B. Inner in = new Outer().new Inner();
C. Outer.Inner in = new Outer().new Inner();
D. Outer.Inner in = Outer.new Inner();

⸻
4.보기 예제
class Outer {
    int a = 10; //외부클래스의 인스턴스 변수(필드)
    static int b=20; //외부클래스의 static 멤버(클래스 변수)

    this==new Outer()

    static class Inner {
        void print() {
            Outer.this (X)
            new Outer()
            System.out.println(Outer.this.a); //정적 내부 클래스에서 인스턴스 변수를 접근할 수 있나요? 없다.
            System.out.println(new Outer().a); //가능

            System.out.println(b); //정적 내부 클래스에서 static 멤버를 접근할 수 있나요?
        }
    }
}

4. 다음 중 정적(static) 내부 클래스의 특징으로 옳은 것은?

A. 외부 클래스의 인스턴스 변수에 접근할 수 있다 (X)
B. 외부 클래스의 객체를 반드시 생성해야 정적 내부 클래스 객체를 생성할 수 있다 (X)
C. 외부 클래스의 static 멤버만 접근할 수 있다 (O)
D. static 내부 클래스는 추상 클래스여야 한다(X)

⸻

5. 다음 코드의 컴파일 결과는?
B
class A {
    class B {}
}
A.B b = new A.B();
A.B b = new A().new B();
A. 정상 실행
B. 컴파일 오류
C. 런타임 오류
D. 추상 클래스 오류

⸻

6. 다음 코드 중 내부 클래스를 잘못 생성한 경우는?

class Out {
    class In {}
    static class SIn {}
}

A. Out.In in = new Out().new In(); (o)
B. Out.SIn sin = new Out().new SIn(); (x)
C. Out.SIn sin = new Out.SIn(); (o)
D. Out.In in = new Out.In(); (X)

⸻

7. 보기 예제
class Outer {
    int a = 10; //외부클래스의 인스턴스 변수(필드)
    class Inner {
        void print() {
            System.out.println(a); // 내부 클래스에서 인스턴스 변수를 접근할 수 있나요?
        }
    }
    static class SInner {
        void print() {
            System.out.println(a); //정적 내부 클래스에서 인스턴스 변수를 접근할 수 있나요?
        }
    }
}


7. 외부 클래스의 인스턴스 변수 a에 내부 클래스에서 접근하려면 어떤 조건이 필요한가?

A. 내부 클래스가 static이면 가능 (x)
B. 내부 클래스가 외부 클래스 안에만 선언되면 가능 (x)(정적 내부 클래스, 내부 클래스 둘다 접근 가능)
C. 외부 클래스의 인스턴스를 통해 생성된 내부 클래스에서만 가능 (o) (내부 클래스만 가능)
D. 내부 클래스는 외부 클래스 변수에 접근할 수 없다 (x)

⸻

8. 내부 클래스가 주로 사용되는 상황은?
C
A. 상속 대신 사용하기 위해
B. 외부에서 독립적으로 사용하기 위해
C. 외부 클래스의 기능을 보조하는 작은 클래스가 필요할 때 (메모앱에 btn의 클릭 기능 구현)
D. static 변수만 저장하려 할 때

⸻

9. 다음 중 내부 클래스가 바이트코드로 컴파일될 때의 클래스 파일 이름은?
A
class Out {
    class In {}
}

A. Out$In.class
B. In$Out.class
C. Out-In.class
D. Out.In.class

⸻

10. 다음 코드에서 static 내부 클래스를 올바르게 생성한 문장은?
A
class Outer {
    static class Inner {}
}

A. Outer.Inner i = new Outer.Inner();
B. Outer.Inner i = new Outer().new Inner();
C. Inner i = new Inner();
D. Outer.Inner i = Outer.new Inner();

⸻

✅ 내부 클래스 문제 정답

번호	정답
1	B
2	C
3	C
4	C
5	B
6	B,D
7	C
8	C
9	A
10	A

*/
}
