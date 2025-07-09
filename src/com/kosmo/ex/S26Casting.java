package com.kosmo.ex;

public class S26Casting {
    /*
형변환 수업 코드 정리: L27Casting.java

1. 변수와 데이터의 개념

int a = 10;

	•	10: 정수 데이터(리터럴)
	•	a: 변수 → 데이터를 담는 이름
	•	=: 참조 대입 연산자, 오른쪽 값을 왼쪽 변수에 저장

⸻

2. 참조형 데이터 예시 (Object)

Object object = new Object();
Object var = new Object();
Object 경민 = new Object();

	•	Object: 모든 클래스의 최상위 클래스
	•	참조형 변수는 실제 데이터를 “참조”하여 관리
	•	변수명은 카멜 표기법(예: myObject, userName)을 따르는 것이 관례

⸻

3. 기본형 vs 참조형 (Wrapper 클래스)

byte b = 127;
Byte bObj = 127; // auto-boxing

	•	byte: 기본형 데이터
	•	Byte: 랩퍼 클래스 (객체형), byte를 객체로 다룰 수 있게 해 줌
	•	기본형에는 메서드가 없기 때문에, 기능이 필요한 경우 래퍼 클래스를 사용

System.out.println(b); // 127
System.out.println(bObj.byteValue()); // 객체에서 기본형으로 꺼냄


⸻

4. 정수 → 16진수 출력

int i = 10;
System.out.println(Integer.toHexString(10)); // "a"

	•	Integer.toHexString(int): 정수를 16진수 문자열로 반환

⸻

5. Wrapper 클래스 연산

Integer iObj = 10;
++iObj; // auto-unboxing → 기본형으로 연산 후 다시 boxing

	•	자바는 자동으로 Integer → int → 연산 후 → 다시 Integer로 바꿈

int i2 = iObj.intValue();     // Integer → int
double d = iObj.doubleValue(); // Integer → double


⸻

6. 자동 형변환 (작은 타입 → 큰 타입)

int i = 1000000;
long l = i; // int → long (자동 형변환)

float f = l; // long → float (자동 형변환)
double d = f; // float → double (자동 형변환)

	•	정수 → 실수도 자동 형변환 가능
	•	실수가 더 큰 범위를 표현 가능 (정수보다 큰 값을 저장 가능)

⸻

7. 강제 형변환 (큰 타입 → 작은 타입)

i = 32770;
short s = (short) i; // 강제 형변환 → 데이터 손실 발생
System.out.println(s); // -32766 (오버플로우)

	•	short의 최대값은 32767
	•	이보다 큰 값을 대입하면 데이터 손실 발생 (원형 반복처럼 돌아감)

⸻

8. 실수의 오버플로우 및 무한대

d = 1.0E300;
f = (float) d; // 너무 큰 값 → float 범위 초과
System.out.println(f); // Infinity

d = d * d * d * d * d * d * d * d * d * d;
System.out.println(d); // Infinity

	•	double이 float보다 범위가 큼
	•	실수 범위 초과 시 Infinity 출력됨 (무한대)

⸻

9. 문자 → 정수 변환

char c = '가';
System.out.println((int) c); // 44032

	•	char는 내부적으로 **유니코드 번호(int)**를 가짐
	•	형변환하면 문자에 해당하는 코드값이 출력됨

⸻

정리 요약

구분	설명
기본형 → 참조형	int → Integer, 자동 boxing
참조형 → 기본형	.intValue() 등 메서드로 변환
자동 형변환	작은 타입 → 큰 타입 (손실 없음)
강제 형변환	큰 타입 → 작은 타입 (손실 가능)
실수 형변환	float, double 간 변환 시 무한대 주의
문자 ↔ 숫자	char ↔ int 형변환 가능 (유니코드 기반)


*/
}
