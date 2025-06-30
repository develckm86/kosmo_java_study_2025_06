package com.kosmo.ex;

public class S07Boolean {
    /*

## ✅ 수업 내용 요약: 자바의 논리형(boolean)과 논리 연산자

### 1. 논리형(boolean)

* 값은 `true`(참) 또는 `false`(거짓)만 가짐
* 산술 연산 불가 (`true + 1` 등 불가능)
* 내부적으로 1bit로 표현되나, JVM 메모리상 기본 1byte 크기

### 2. 비교 연산자

* `==`, `!=`, `>`, `<`, `>=`, `<=`
* `<>`는 자바에서 사용 불가

### 3. 객체 비교 시 주의사항

* 배열 등 참조형 비교는 `==`가 주소 비교(내용 비교 아님)
* 문자열은 리터럴 풀에 있으면 주소가 같을 수 있으나,
  **일반적으로 문자열 비교는 `.equals()`를 사용**해야 함

### 4. 논리 연산자

* `&&` (AND), `||` (OR), `!` (NOT)
* `true` = 1, `false` = 0 개념
* 연산 규칙:

  * `false || false` = `false`
  * `true || false` = `true`
  * `true && false` = `false`
  * `!true` == `false` 등

---

## 🧪 연습문제 (정답 제외)

**1.** 자바에서 boolean 타입이 가질 수 있는 값은 무엇인가?
true,false
---

**2.** 다음 코드가 컴파일 오류가 나는 이유를 설명하시오.
자바는 논리형 산술 연산이 불가능
```java
System.out.println(true + 1);
```

---

**3.** 다음 배열 두 개에 대해 `==` 연산을 했을 때 결과가 왜 `false`가 되는지 설명하시오.
자료형을 선언하면 매번 새로운 자료가 생성되기 때문에 두 배열 자료는 다르다.
컴퓨터는 기본적으로 자료형을 비교할때 자료형 내부의 데이터(필드)를 하나씩 비교해서
같은지 반환하지 않는다.
```java
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(a == b); false
```

---

**4.** 문자열 비교 시 `==`와 `.equals()`의 차이는 무엇인가?
** .equals() 는 내부적으로 재정의 해야 사용가능
자료형의 내부 필드가 모두 같은지 확인하는 함수

---

**5.** 다음 코드 출력 결과를 예상하시오.
문자열 자료형 데이터만 특이하게도 문자열을 ("")리터럴(있는 그대로)하게 선언할때
메모리에 동일한 데이터가 있는지 확인하고 있으면 참조한다.

```java
String s1 = "hello"; =>"hello"가 메모리에 있는지 확인=> 없어서 생성 (@123)
String s2 = "hello"; =>"hello"가 메모리에 있는지 확인=> 있어서 @123을 참조
System.out.println(s1 == s2); true
System.out.println(s1.equals(s2)); ture
```

---

**6.** 다음 중 올바른 비교 연산자가 아닌 것은? B
A. `!=`
B. `<>`
C. `<=`
D. `==`
---
**7.** 논리 연산자 `&&`와 `||`의 차이점과 사용하는 상황을 간략히 설명하시오.
곱연산, 합연산
---

**8.** 다음 표현식의 결과는 무엇인가?

```java
(5 > 3) && (2 < 1)
true && false => false
```

---

**9.** 다음 표현식의 결과는 무엇인가?

```java
!(10 == 5) || (7 > 9)
```
true || //자바는 이순간 연산을 멈춘다! =>true 를 반환
---


**10.** `false && true || !false` 표현식의 결과를 계산해보시오.
false && true =>  false
false || true => true
---

필요하면 각 문제에 대한 상세 해설과 정답지도 만들어 드릴 수 있습니다.
*/
    public static void main(String[] args) {
        String a="hello"; //리터럴하게 자료형 생성
        String b="hello"; //리터럴하게 자료형 생성
        String c=new String("hello");//명시적 자료형 생성
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(false && true || !false);

    }
}
