package com.kosmo.ex;

public class S33Generic {
    /*
⸻

📘 자바 제네릭(Generic) 정리

⸻

1. 제네릭(Generic 일반화->구체적)이란?

클래스, 인터페이스, 메서드 등에 사용할 수 있는 타입 매개변수

	•	타입을 일반화하여 코드의 재사용성 증가
	•	컴파일 시점에 타입을 결정 → 타입 안정성 보장
	•	Object로 처리하던 타입들을 명확하게 구체화할 수 있음

⸻

2. 제네릭을 쓰지 않은 경우의 한계

Object o; //변수는 참조하는 데이터가 바뀔수 있다는 뜻
o = 10;
o = "Hello";
o=new A(); //사용하기 편한상태

int sum= (int)o + 10

// 타입을 알 수 없어 캐스팅 필요, 오류 가능성 존재

	•	모든 타입을 Object로 다룰 수 있지만 캐스팅 필요 + 타입 오류 위험

⸻

3. 제네릭 클래스 선언
new GenericClass();
new GenericClass<Integer>();
new GenericClass<String>();
//재사용성 : 다시 사용하는 빈도
//구현난이도 : 제네릭이 높다.(여러타입을 고려), 개발자가 제네릭을 직접 만드는 일은 없다!!!


class GenericClass<T> {
    T t; // T는 타입 매개변수
    void callGeneric(T t) {
        System.out.println(t.toString());
    }

}

	•	T는 객체 생성 시 구체 타입으로 대체됨
	•	예: GenericClass<String>, GenericClass<Number>

⸻

4. 제네릭 사용 예

GenericClass<String> g = new GenericClass<>();
g.callGeneric("Hello"); // T → String

	•	T가 String으로 바뀜 → 타입 안정성 확보
	•	g.callGeneric(123) 등은 컴파일 오류

⸻

5. 제네릭 타입 제한 (extends)

class GenericExtends<T extends Number> {
    void call(T t) { ... }
}

	•	T는 Number 및 그 하위 타입만 허용
	•	예: Integer, Double, Long 가능
	•	❌ GenericExtends<String> → 컴파일 오류

⸻

6. 제네릭과 Object 차이점

구분	                Object 사용	                        제네릭 사용 (<T>)
타입 안정성	        없음 (런타임 오류 가능)	                있음 (컴파일 오류로 방지)
캐스팅 필요 여부	    있음	                                없음
유연성	            매우 높음 (모든 객체 가능)	            타입 제한 가능 ( extends )


⸻

7. 제네릭 필드 종류 비교

Object o;     // 어떤 타입이든 OK
Aable a;      // Aable 구현체만 가능
T t;          // 객체 생성 시 결정된 타입만 가능


⸻

8. 제네릭 객체 생성

GenericClass<Number> g1 = new GenericClass<>();
GenericClass<String> g2 = new GenericClass<>();
GenericClass g3 = new GenericClass(); // T는 Object로 간주됨

•	Java 7부터 제네릭 도입!! 우변 제네릭 생략 가능 (다이아몬드 연산자)

⸻

9. 제네릭 제한 예시 (extends Number)

GenericExtends<Integer> g = new GenericExtends<>(); // OK
GenericExtends<Boolean> g2 = new GenericExtends<>(); // ❌ 오류: Boolean은 Number의 하위 타입 아님


⸻

10. 자료형만 제네릭으로 가능 ( 기본 타입은 제네릭으로 사용 불가(**))
Integer i=10;
int sum= i+20;

// GenericClass<int> g = new GenericClass<int>(); // ❌ 오류
GenericClass<Integer> g = new GenericClass<>();   // ✅ 래퍼 타입 사용

	•	제네릭은 오직 참조형 타입만 사용 가능
	•	기본형은 래퍼 클래스 (int → Integer, double → Double)로 대체

⸻

✅ 핵심 요약

항목                      설명
<T>	                    타입 매개변수 선언
GenericClass<T>	        타입을 일반화한 클래스
T extends X	            T는 X를 상속한 타입만 가능
제네릭도입	                Java 7부터 타입 추론 가능
기본형	                사용 불가, 래퍼클래스 사용 (int → Integer)

⸻

🧠 자주 나오는 실수
	•	super는 클래스 선언에서 사용할 수 없음 → class Box<T super String> ❌ → List<? super String> 은 OK
	•	기본형 타입(int 등)은 제네릭에 사용할 수 없음 → 래퍼 클래스(Integer 등)로 대체해야 함
	•	제네릭 미지정시 T는 Object로 간주됨

⸻

📘 자바 제네릭 기초 이론 문제 (객관식, 참/거짓)

⸻

1. 제네릭(Generic)을 사용하는 가장 큰 이유는?
B
A. 실행 속도를 빠르게 하기 위해
B. 다양한 자료형을 처리하면서도 타입 안정성을 확보하기 위해
C. 객체를 자동으로 생성하기 위해
D. 변수명을 간단하게 하기 위해

⸻

2. 제네릭 클래스의 선언 형식으로 올바른 것은?
C

A. class Box<>
B. class Box[T]
C. class Box<T>
D. class<T> Box

⸻

3. 다음 설명 중 틀린 것은?
C
A. 제네릭은 클래스, 메서드, 인터페이스에 사용할 수 있다
B. 제네릭을 사용하면 캐스팅을 줄일 수 있다
C. 제네릭은 기본형 타입(int, double 등)도 바로 사용할 수 있다
D. 제네릭은 컴파일 시 타입을 검사한다

⸻

4. 다음 중 올바른 제네릭 객체 생성 방식은?
B
A. Box box = new Box<String>();
B. Box<String> box = new Box<>();
C. Box<int> box = new Box<int>();
D. Box<String> box = new Box<Object>();

⸻

5. 제네릭 클래스에 타입 제한을 주려면 어떤 키워드를 사용해야 하는가?
A
A. extends
B. instanceof
C. super
D. implements

⸻

6. 다음 중 제네릭을 사용하지 않은 코드의 단점은?
D
A. 타입 안정성이 낮다
B. 캐스팅을 자주 해야 한다
C. 런타임 오류가 발생할 수 있다
D. 모두 맞다

⸻

정답 1.	B
	2.	C
	3.	C
	4.	B
	5.	A
	6.	D

*/
}
