package com.kosmo.ex;

public class S28InnerClass {
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

1. 내부 클래스(Inner Class)의 정의로 올바른 것은?

A. 클래스 안에 선언된 메서드를 말한다
B. 클래스 안에 선언된 다른 클래스를 말한다
C. 메서드 안에 선언된 클래스만을 말한다
D. 상속받은 클래스를 말한다

⸻

2. 내부 클래스의 일반적인 특징은?

A. 항상 static이어야 한다
B. 외부 클래스의 인스턴스 없이 생성할 수 있다
C. 외부 클래스의 인스턴스 변수에 직접 접근 가능하다
D. main 메서드 내에서만 사용 가능하다

⸻

3. 내부 클래스를 생성할 때 올바른 방법은?

class Outer {
    class Inner {}
}

A. Outer.Inner in = new Inner();
B. Inner in = new Outer().new Inner();
C. Outer.Inner in = new Outer().new Inner();
D. Outer.Inner in = Outer.new Inner();

⸻

4. 다음 중 정적(static) 내부 클래스의 특징으로 옳은 것은?

A. 외부 클래스의 인스턴스 변수에 접근할 수 있다
B. 외부 클래스의 객체를 반드시 생성해야 사용할 수 있다
C. 외부 클래스의 static 멤버만 접근할 수 있다
D. static 내부 클래스는 추상 클래스여야 한다

⸻

5. 다음 코드의 컴파일 결과는?

class A {
    class B {}
}
A.B b = new A.B();

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

A. Out.In in = new Out().new In();
B. Out.SIn sin = new Out().new SIn();
C. Out.SIn sin = new Out.SIn();
D. Out.In in = new Out.In();

⸻

7. 외부 클래스의 인스턴스 변수 a에 내부 클래스에서 접근하려면 어떤 조건이 필요한가?

A. 내부 클래스가 static이면 가능
B. 내부 클래스가 외부 클래스 안에만 선언되면 가능
C. 외부 클래스의 인스턴스를 통해 생성된 내부 클래스에서만 가능
D. 내부 클래스는 외부 클래스 변수에 접근할 수 없다

⸻

8. 내부 클래스가 주로 사용되는 상황은?

A. 상속 대신 사용하기 위해
B. 외부에서 독립적으로 사용하기 위해
C. 외부 클래스의 기능을 보조하는 작은 클래스가 필요할 때
D. static 변수만 저장하려 할 때

⸻

9. 다음 중 내부 클래스가 바이트코드로 컴파일될 때의 클래스 파일 이름은?

class Out {
    class In {}
}

A. Out$In.class
B. In$Out.class
C. Out-In.class
D. Out.In.class

⸻

10. 다음 코드에서 static 내부 클래스를 올바르게 생성한 문장은?

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
6	B
7	C
8	C
9	A
10	A


⸻
*/
}
