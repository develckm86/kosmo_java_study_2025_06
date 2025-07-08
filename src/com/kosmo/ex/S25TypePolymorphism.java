package com.kosmo.ex;

public class S25TypePolymorphism {
    /*
⸻

📘 수업 주제: 타입의 다형성, 업캐스팅/다운캐스팅, instanceof

⸻

1. 기본 클래스 구조

class P {
    void show() {
        System.out.println("안녕!");
    }
}

class C extends P {
    // 수천 개 기능 존재
}

class C2 extends P {
    // 수천 개 기능 존재
    void callC2() {}
}


⸻

2. 업캐스팅 (부모 타입으로 자식 객체 참조)

P p;
p = new C();   // 업캐스팅
p.show();      // C에 오버라이딩이 없다면 P의 show() 실행

p = new C2();  // 업캐스팅
p.show();      // 역시 P의 show() 실행

업캐스팅 특징
	•	부모 타입(P)으로 자식 객체(C, C2)를 참조
	•	자식 객체의 기능이 많더라도, 부모가 가진 기능만 사용 가능

⸻

3. 다운캐스팅 (자식 타입으로 강제 형변환)

c2 = (C2)p;   // 다운캐스팅 (원래 p가 C2를 참조하고 있어야 함)
c2.callC2();  // 이제 C2의 고유 메서드 사용 가능

다운캐스팅 주의:
잘못된 형변환은 ClassCastException 발생 위험 → 반드시 instanceof 검사 필요

⸻

4. 다형성을 활용한 메서드 설계

static void callShow(P c) {
    c.show();  // 어떤 자식 객체가 들어와도 show() 호출 가능
}

callShow(new C());
callShow(new C2());
callShow(p); // 모두 정상 작동

장점:
메서드를 하나의 부모 타입으로 설계하면, 자식 클래스가 여러 개여도 같은 방식으로 호출 가능
→ 유지보수성과 확장성 향상

⸻

5. instanceof 연산자

System.out.println(c2 instanceof C2);     // true
System.out.println(c2 instanceof P);      // true
System.out.println(c2 instanceof Object); // true

Object obj = new C2();
System.out.println(obj instanceof String);     // false
System.out.println(obj instanceof Integer);    // false
System.out.println(obj instanceof P);          // true
System.out.println(obj instanceof C2);         // true
System.out.println(obj instanceof C);          // false

instanceof란?
객체가 특정 클래스 또는 부모 타입인지 검사
→ 다운캐스팅 전에 꼭 검사할 것

⸻

🔑 핵심 개념 요약

개념	설명
업캐스팅	자식 객체를 부모 타입으로 참조 (자동)
다운캐스팅	부모 타입 참조를 자식 타입으로 변환 (강제 형변환 필요)
다형성	부모 타입 변수로 여러 자식 객체를 참조할 수 있는 성질
instanceof	해당 객체가 어떤 타입인지 확인하는 연산자
다형성 활용	하나의 메서드로 다양한 객체 처리 가능 (callShow(P p))


⸻

🧪 실습 과제 아이디어
	1.	Student와 Teacher가 Person을 상속 → showInfo() 호출
	2.	instanceof를 이용해서 Teacher만의 기능 (teach()) 호출

⸻

📝 결론
	•	다형성을 사용하면 코드가 유지보수하기 쉬워지고, 확장성이 생깁니다.
	•	instanceof + 다운캐스팅은 자식 클래스의 고유 기능을 사용할 수 있게 해줍니다.
	•	메서드 설계를 할 때는 부모 타입 매개변수 하나로 다양한 자식 클래스 대응이 가능합니다.

⸻

⸻

✅ 타입의 다형성 관련 문제 10문제

⸻

1. 다음 중 타입의 다형성에 대한 설명으로 가장 적절한 것은?

A. 부모 클래스는 자식 클래스의 모든 메서드를 자동으로 호출할 수 있다
B. 하나의 부모 타입 변수로 여러 자식 객체를 참조할 수 있다
C. 다형성을 사용하면 클래스마다 별도의 메서드를 만들어야 한다
D. 자식 타입으로 부모 객체를 참조할 수 있다

⸻

2. 자바에서 업캐스팅(Upcasting)에 대한 설명으로 옳지 않은 것은?

A. 자식 객체를 부모 타입 변수로 참조하는 것이다
B. 명시적 형변환이 필요하다
C. 부모 클래스가 가진 기능만 사용할 수 있다
D. 컴파일 시 자동으로 일어난다

⸻

3. 다음 코드 실행 결과로 알 수 있는 다형성의 특징은?

P p;
p = new C();
p.show();


⸻

4. 다음 중 instanceof 연산자의 사용 목적을 올바르게 설명한 것은?

A. 객체를 복제할 수 있는지 확인
B. 클래스의 메서드 개수를 확인
C. 어떤 클래스의 인스턴스인지 확인
D. 클래스의 필드 값을 비교

⸻

5. 다음 코드에서 callC2()를 호출하려면 어떤 작업이 필요한가?

P p = new C2();
// p.callC2(); // 오류 발생


⸻

6. Object obj = new C(); 가 있을 때, obj가 C 클래스의 객체인지 확인하고 C 타입으로 형변환 후 show() 메서드를 호출하시오.

⸻

7. 다음 코드에서 오류가 발생하는 이유를 설명하시오.

String s = "hello";
System.out.println(s instanceof Integer);


⸻

8. 다음 중 업캐스팅을 올바르게 사용한 코드를 모두 고르시오.

A. P p = new C();
B. C2 c2 = (C2)new P();
C. P p = new C2();
D. Object obj = new C();

⸻

9. 다형성을 활용한 메서드 설계의 장점에 해당하지 않는 것은?

A. 유지보수가 용이하다
B. 코드 재사용성이 높다
C. 메서드를 여러 개 오버로딩해야 한다
D. 다양한 자식 객체를 하나의 메서드에서 처리할 수 있다

⸻

10. 다음 코드에서 obj instanceof C2가 true일 때 obj를 C2로 형변환하여 callC2() 메서드를 호출하는 코드를 작성하시오.

Object obj = new C2();

⸻

✅ 타입의 다형성 문제 정답 및 해설

⸻

1. 다음 중 타입의 다형성에 대한 설명으로 가장 적절한 것은?

정답: B

해설:
타입의 다형성이란 부모 클래스 타입의 변수로 여러 자식 클래스의 객체를 참조할 수 있는 성질입니다.
다형성의 핵심은 “여러 형태(자식)를 하나의 타입(부모)로 다룬다”는 것입니다.

⸻

2. 자바에서 업캐스팅에 대한 설명으로 옳지 않은 것은?

정답: B

해설:
업캐스팅은 자식 객체를 부모 타입 변수로 참조하는 것으로, 자동으로 형변환됩니다.
명시적 형변환이 필요한 건 다운캐스팅입니다.

⸻

3. 다음 코드 실행 결과로 알 수 있는 다형성의 특징은?

P p;
p = new C();
p.show();

정답:
자식 객체를 부모 타입으로 참조해도, 오버라이딩된 메서드가 실행된다.

해설:
업캐스팅된 객체라도 실제 객체 타입이 C라면, 오버라이딩된 show()가 있다면 그것이 실행됩니다.
이것이 바로 다형성과 동적 바인딩의 핵심입니다.

⸻

4. 다음 중 instanceof 연산자의 사용 목적을 올바르게 설명한 것은?

정답: C

해설:
instanceof는 객체가 특정 클래스나 그 자식 클래스인지 확인하는 연산자입니다.
다운캐스팅 전 안전하게 검사할 때 사용됩니다.

⸻

5. 다음 코드에서 callC2()를 호출하려면 어떤 작업이 필요한가?

P p = new C2();
// p.callC2(); // 오류 발생

정답:
다운캐스팅이 필요하다 → ((C2)p).callC2();

해설:
업캐스팅된 상태에서는 P 타입이므로 C2의 고유 메서드 호출이 불가.
명시적으로 C2로 다운캐스팅해야 메서드 사용 가능합니다.

⸻

6. Object obj = new C(); 가 있을 때, obj가 C 클래스의 객체인지 확인하고 C 타입으로 형변환 후 show() 메서드를 호출하시오.

정답:

if (obj instanceof C) {
    ((C)obj).show();
}

해설:
다운캐스팅 전에 반드시 instanceof를 사용해 검사해야 안전합니다.
검사 없이 형변환하면 ClassCastException이 발생할 수 있습니다.

⸻

7. 다음 코드에서 오류가 발생하는 이유를 설명하시오.

String s = "hello";
System.out.println(s instanceof Integer);

정답:
String과 Integer는 상속 관계가 없어서 컴파일 오류가 발생한다.

해설:
instanceof는 두 타입 사이에 상속 또는 구현 관계가 있어야만 사용할 수 있습니다.
String과 Integer는 아무 관련이 없는 클래스입니다.

⸻

8. 다음 중 업캐스팅을 올바르게 사용한 코드를 모두 고르시오.

정답: A, C, D

해설:
	•	A: P p = new C(); → 올바른 업캐스팅
	•	B: C2 c2 = (C2)new P(); → 잘못된 다운캐스팅 (런타임 오류)
	•	C: P p = new C2(); → OK
	•	D: Object obj = new C(); → OK (Object는 모든 클래스의 조상)

⸻

9. 다형성을 활용한 메서드 설계의 장점에 해당하지 않는 것은?

정답: C

해설:
다형성을 활용하면 오버로딩을 최소화하고, 하나의 메서드로 다양한 객체를 처리할 수 있습니다.
오히려 메서드를 더 적게 만들 수 있는 것이 장점입니다.

⸻

10. 다음 코드에서 obj instanceof C2가 true일 때 obj를 C2로 형변환하여 callC2() 메서드를 호출하는 코드를 작성하시오.

Object obj = new C2();

정답:

if (obj instanceof C2) {
    ((C2)obj).callC2();
}

해설:
instanceof 검사 후 다운캐스팅을 통해 C2 타입의 메서드를 사용할 수 있습니다.

⸻

*/
}
