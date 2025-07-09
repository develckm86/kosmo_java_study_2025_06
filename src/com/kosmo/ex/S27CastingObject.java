package com.kosmo.ex;

public class S27CastingObject {
    /*

참조형 형변환 수업 정리: L28CastingObject.java

⸻

1. 자바의 자료형 구분

구분	예시	설명
기본형	int, float, char	값 자체를 저장, 연산 중심
참조형	String, 배열, 사용자 정의 클래스	객체의 주소(참조) 저장


⸻

2. 자료형(객체형) 데이터 생성 방법

방식	예시
1. new 연산자	new Dog(), new int[3]
2. 배열 리터럴	{1,2,3} (배열만 가능)
3. 문자열 리터럴	"안녕"

String h = "안녕";
String h2 = "안녕";
String h3 = new String("안녕");
System.out.println(h == h2); // true (문자열 풀 상수 영역)
System.out.println(h == h3); // false (new로 새 객체 생성)

	•	문자열은 특수하게 + 연산 가능
	•	String은 char[] 배열 기반이므로 문자와도 결합 가능

⸻

3. 사용자 정의 클래스 예시

class Animal {
    String name;
    int birth;
}

class Dog extends Animal {
    String tail;
}

class Cat extends Animal { }

	•	Animal: 부모 클래스
	•	Dog, Cat: 자식 클래스 (상속)

⸻

4. 객체 생성 및 필드 설정

Animal ani = new Animal(); // 기본 Animal 객체
ani.name = "기린";
ani.birth = 1986;

Dog dog = new Dog(); // 자식 클래스 Dog
dog.name = "코에";
dog.birth = 2022;
dog.tail = "반토막";


⸻

5. 참조형 형변환

(1) Upcasting (자동 형변환)

Animal aniDog = dog;

	•	Dog → Animal : 자동 형변환
	•	aniDog는 Animal 타입이므로, name, birth는 접근 가능하지만 tail은 접근 불가

(2) Downcasting (강제 형변환)

Dog dog2 = (Dog) aniDog;

	•	다시 자식 타입으로 되돌리기: 강제 형변환(casting)
	•	aniDog가 실제로 Dog 타입이라면 안전

(3) 잘못된 다운캐스팅 (컴파일은 가능, 실행 시 오류)

Cat cat = (Cat) aniDog; // 런타임 오류 발생 (ClassCastException)

	•	aniDog는 실제로 Dog 객체이므로 Cat으로 형변환 불가
	•	instanceof 검사로 방지 가능

if (aniDog instanceof Cat) {
    Cat cat2 = (Cat) aniDog;
}


⸻

정리 요약

개념	설명
업캐스팅	자식 → 부모, 자동 형변환
다운캐스팅	부모 → 자식, 강제 형변환 필요
형변환 조건	실제 객체 타입이 변환하려는 타입과 일치해야 함
오류 방지	instanceof로 타입 체크 필요
참조형 형변환과 기본형 형변환의 차이	참조형은 “주소”를 공유, 기본형은 “값”만 변환


*/
}
