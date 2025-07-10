package com.kosmo.ex;

public class S26Casting {
    public static void main(String[] args) {
        System.out.println((byte)129);
        System.out.println((int)12.1234123412341234);
        System.out.println((float)1234567890123456789l);//1.234568E18
        System.out.println((int)3.99);

    }

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


⸻

자바 기본형 형변환 문제 (총 10문제)

⸻

1. 다음 중 자동 형변환이 가능한 경우는?
C

A. int 4→ byte 1
B. long 8→ int 4
C. float 4→ double 8
D. double 8→ float 4

⸻

2. 다음 코드의 출력 결과는?
B
int i = 10; 4 정수
double d = i; 8 실수

System.out.println(d);

A. 10
B. 10.0
C. 0
D. 오류 발생

⸻

3. 다음 중 **강제 형변환(casting)**이 필요한 경우는?
C
A. int i = 20; 4->8실수 double d = i;
B. long l = 100; 8->4실수 float f = l;
C. double d = 3.14; 8실수->4 int i = (double)d;
D. char c = 'A'; 2byte ->4byte int n = c;
//utf-16 인코딩 => 2byte
⸻

4. 다음 코드 중 데이터 손실이 발생할 수 있는 것은?
A

A. int i = 200; byte b = (byte) i;
B. float f = 123.4f; double d = f;
C. short s = 100; int i = s;
D. char c = '가'; int i = c;

⸻

5. 다음 중 char → int 형변환의 결과로 알맞은 설명은?
B
A. 알파벳 대소문자 구분 없이 모두 0으로 바뀐다
B. 문자의 유니코드 정수값이 반환된다
C. 오류 발생
D. 값은 항상 음수가 된다

⸻

6. 실수 double을 int로 변환할 때 발생하는 일은?
C
A. 반올림된다
B. 무작위 값이 된다
C. 소수점 이하가 버려진다
D. 에러가 발생한다

⸻

7. 다음 코드 실행 결과는?
B
double d = 3.99;
int i = (int) d; 3
System.out.println(i);

A. 4
B. 3
C. 오류 발생
D. 0

⸻

8. 다음 중 형변환이 컴파일 오류를 발생시키는 것은?
C

A. int a = (int) 10.5;
B. float f = (float) 20;
C. boolean b = (boolean) 1; //형변환 대상이 아니다.!!
D. char c = (char) 65;

⸻

9. 아래 코드에서 출력될 값은?
B
int i = 290;
byte b = (byte) i;
System.out.println(b);

A. 290
B. 34
C. 오류 발생
D. 0

⸻

10. 다음 중 형변환을 하지 않아도 자동으로 가능한 것은?
B
A. double → int
B. int → double
C. long → short
D. float → byte


⸻

자바 기본형 형변환 - 면접 대비 고급 문제 (10문제)

⸻

1. 다음 코드의 출력 결과는?

byte b = 127;

b = (byte)(b + 1);

System.out.println(b);
C

A. 127
B. 128
C. -128
D. 컴파일 오류

⸻

2. 다음 중 float 4과 double 8의 차이로 인해 발생할 수 있는 문제는?
D

A. float이 더 정밀(가수부의 크기)하다 X
B. double 값을 float로 형변환하면 항상 0이 된다 ??? X
C. float은 double보다 더 큰 값을 저장할 수 있다 X
D. double을 float로 변환하면 정밀도 손실이 발생할 수 있다

⸻

3. 다음 코드에서 result의 값은?

int a = 5;
int b = 2;

double result = a / b;

System.out.println(result);
A
A. 2.0
B. 2.5
C. 2
D. 컴파일 오류

⸻


4. 다음 중 char 2 (2E16-1 0~65535) → byte 1로 형변환 시 반드시 손실이 발생하는 이유는?
A
A. char는 부호가 없고 2바이트지만, byte는 부호 있는 1바이트라서
B. char가 음수를 표현하기 때문
C. byte는 float보다 작기 때문
D. char는 문자열이라 형변환 불가능

⸻
//3.0  double
//3  int
//1.0E10
//1E10 =>???
5. 다음 코드의 결과는?

double d = 1e308;
float f = (float) d; Infinity
System.out.println(f);
B
A. 1.0E308
B. Infinity
C. 0.0
D. 오류 발생

⸻

6. 다음 코드의 실행 결과는?

System.out.println( (char) ('A' + 1) );
B
A. 'A'
B. 'B'
C. ‘2’
D. 오류 발생

⸻

7. 다음 코드의 출력은?

int x = (int) 3.7 + (int) 2.5;

System.out.println(x);
B
A. 6
B. 5
C. 7
D. 6.2

⸻

8. 다음 코드에서 출력될 값은?

int i = 300;
short s = (short) i;
System.out.println(s);
A
A. 300
B. -356
C. 44
D. 컴파일 오류

⸻

9. 다음 중 컴파일은 되지만 런타임 오류가 발생할 수 있는 형변환은?

C (기본형의 형변환은 컴파일러에서 다 문제를 해결!!)

A. double → int
B. int → short
C. (Cat) new Dog()
D. char → int

⸻

10. 다음 중 형변환 없이 + 연산이 가능한 경우는?
A

A. int + char  //jvm이 문자의 저장을 숫자취급 =>연산시 형변환 필요 없음:char =>int
B. boolean + int (X)
C. float + boolean (X)
D. byte + byte //모든 정수는 int로 바꿔서 연산



⸻

자바 기본형 형변환 20문제 정답 요약

번호	정답
1	C
2	B
3	C
4	A
5	B
6	C
7	B
8	C
9	B
10	B

11	C
12	D
13	A
14	A
15	B
16	B
17	B
18	A
19	C
20	A


⸻
*/
}
