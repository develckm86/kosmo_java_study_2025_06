package com.kosmo.ex;

public class S16ClassObejct {
/*

# 자바 수업 정리: 클래스, 객체, 자료형, 타입

## 1. 클래스(Class)란

* 사용자 정의 자료형
* 속성(필드)과 동작(메서드)을 함께 정의하는 설계도
* 객체를 생성하기 위한 틀

예시:

```java
class Calc {
    String name = "계산기";
    public double plus(double a, double b) {
        return a + b;
    }
}
```

## 2. 객체(Object)란

* 클래스를 기반으로 생성된 실제 메모리상의 인스턴스
* 클래스는 타입이고, 객체는 값(인스턴스)
* 객체는 new 키워드로 생성되고, Heap 영역에 저장된다

예시:

```java
Calc calc = new Calc();
System.out.println(calc.name);
System.out.println(calc.plus(1.0, 2.0));
```

## 3. 자료형과 타입

자료형은 데이터를 저장하는 방식이며, 타입은 해당 자료의 종류이다.

기본 자료형:

* int, double, boolean 등
* 값 자체를 저장
* Stack 메모리 영역에 저장됨

참조 자료형:

* String, 배열, 사용자 정의 클래스 등
* 주소를 저장하고 실제 데이터는 Heap에 저장됨

사용자 정의 자료형:

* class로 만든 자료형 (예: Calc, Calculator 등)

## 4. 생성자(Constructor)

* 객체가 생성될 때 자동으로 호출되는 특수한 메서드
* 객체의 필드를 초기화하는 역할
* 파라미터에 따라 여러 개 정의 가능 (오버로딩)

예시:

```java
public Calc() {}

public Calc(String name) {
    this.name = name;
}
```

## 5. 접근 지정자

| 접근 지정자    | 설명                 |
| --------- | ------------------ |
| public    | 어디서든 접근 가능         |
| default   | 같은 패키지 내에서만 접근 가능  |
| protected | 같은 패키지 또는 상속 관계 접근 |
| private   | 클래스 내부에서만 접근 가능    |

## 6. 필드와 메서드

필드: 객체의 상태(데이터)를 저장하는 변수
메서드: 객체의 동작(기능)을 정의하는 함수

예시:

```java
class A {
    public int n = 10;
    private String name = "최경민";
    public void callName() {
        System.out.println(name);
    }
}
```

객체 사용 예:

```java
A a = new A();
System.out.println(a.n);
a.callName();
```

private 필드는 외부에서 접근 불가능하다.


## 7. 실습 예시 요약

```java
Calculator c = new Calculator();
Calculator c2 = new Calculator("키티 계산기");

System.out.println(c.name);
System.out.println(c2.name);

int[] arr = {111, -222, 2000, 333, 123};
int sum = c.arrSum(arr);
System.out.println(sum);
```

## 8. 메서드의 구성 요소

1. 매개변수(Parameter): 동작에 필요한 입력값
2. 영역(Scope): 중괄호 {} 로 구성된 실행 블록
3. 이름(Name): 호출 시 사용
4. 반환값(Return): 처리 결과를 반환

예시:

```java
int add(int a, int b) {
    return a + b;
}
```

---
---

## 클래스와 객체 관련 문제

### 문제 1

다음 중 클래스에 대한 설명으로 옳지 않은 것은?

A. 클래스는 객체를 생성하기 위한 설계도이다.
B. 클래스 내부에는 필드와 메서드를 정의할 수 있다.
C. 클래스 이름은 소문자로 시작하는 것이 자바의 관례이다.
D. 클래스로부터 객체를 만들기 위해서는 new 키워드를 사용한다.

---

### 문제 2

다음 중 객체 생성 후 해당 필드에 접근하는 코드로 올바른 것은?

```java
class Dog {
    public String name = "멍멍이";
}
```

A. Dog.name
B. Dog.name()
C. new Dog().name
D. new Dog.name()

---

### 문제 3

다음 코드의 실행 결과는?

```java
class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("홍길동");
        System.out.println(p.name);
    }
}
```

A. null
B. 홍길동
C. 에러 발생
D. this.name

---

## 생성자, 접근지정자 관련 문제

### 문제 4

다음 중 생성자에 대한 설명으로 옳지 않은 것은?

A. 생성자는 클래스 이름과 같아야 한다.
B. 생성자는 반환 타입이 있어야 한다.
C. 생성자는 객체가 생성될 때 자동으로 호출된다.
D. 생성자를 오버로딩할 수 있다.

---

### 문제 5

다음 중 private으로 선언된 필드에 접근할 수 있는 경우는?

A. 같은 클래스 내부의 메서드에서
B. 다른 패키지의 클래스에서
C. 상속받은 하위 클래스에서
D. static 메서드에서

---

## 사용자 정의 자료형과 메서드 활용 문제

### 문제 6

다음 중 사용자 정의 자료형으로 올바르게 정의된 클래스는?

A.

```java
class A {
    int a = 10;
    void print() {
        System.out.println(a);
    }
}
```

B.

```java
A a = new A();
```

C.

```java
int A() {}
```

D.

```java
public void A;
```

---

### 문제 7

다음 중 메서드 정의로 적절하지 않은 것은?

A.

```java
public int add(int a, int b) {
    return a + b;
}
```

B.

```java
public void print() {
    System.out.println("Hello");
}
```

C.

```java
public int show(String s) {
    return s;
}
```

D.

```java
public boolean isTrue() {
    return true;
}
```

---

### 문제 8

다음 클래스 정의를 보고 객체 생성 후 "Hello"가 출력되도록 하는 코드를 작성하시오.

```java
class Hello {
    String msg;

    // 생성자 작성 필요
}
```

---

### 문제 9

다음 중 this 키워드에 대한 설명으로 옳은 것은?

A. 정적(static) 메서드에서만 사용 가능하다.
B. 클래스의 이름을 가리킨다.
C. 현재 객체 자신의 필드나 메서드를 가리킨다.
D. 객체를 비교하기 위한 연산자이다.

---

### 문제 10

다음 코드 실행 결과를 작성하시오.

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result = c.add(5, 7);
        System.out.println(result);
    }
}
```

---

좋습니다. 아래는 자바 클래스 정의 및 객체 사용 연습을 위한 **직접 클래스 만들기 문제**입니다. 기초적인 수준부터 메서드 활용까지 점차 확장하는 형식으로 구성했습니다. 실습 과제로 활용하기 좋습니다.

---

## 클래스 만들기 문제

### 문제 1. 기본 클래스 만들기

학생 정보를 저장하는 `Student` 클래스를 정의하시오. 다음 필드를 포함해야 한다.

* 이름 (name, 문자열)
* 학번 (id, 정수)
* 학년 (grade, 정수)

Main 메서드에서 객체를 생성하고 각 필드 값을 출력하시오.

---

### 문제 2. 생성자 사용

문제 1의 `Student` 클래스에 생성자를 추가하여, 객체 생성 시 필드값을 바로 초기화할 수 있도록 하시오.

```java
Student s = new Student("홍길동", 10101, 3);
```

객체를 생성하고 모든 필드값을 출력하는 메서드 `printInfo()`도 작성하시오.

---

### 문제 3. 메서드 정의

`Rectangle` 클래스를 정의하고 다음 필드를 선언하시오.

* 가로 (width, 정수)
* 세로 (height, 정수)

생성자를 이용해 가로와 세로를 초기화하고, 다음 메서드를 작성하시오.

* 넓이를 반환하는 `getArea()`
* 둘레를 반환하는 `getPerimeter()`

Main에서 객체를 만들어 넓이와 둘레를 출력하시오.

---

### 문제 4. 조건이 있는 메서드 만들기

`Person` 클래스를 정의하고 다음 필드를 포함하시오.

* 이름 (String)
* 나이 (int)

다음 메서드를 추가하시오.

* `isAdult()` : 나이가 20세 이상이면 true 반환, 아니면 false 반환

Main에서 두 사람의 객체를 만들어 성인 여부를 출력하시오.

---

### 문제 5. 배열을 활용한 클래스

정수 배열을 받아 평균을 계산하는 `ScoreAnalyzer` 클래스를 정의하시오.

* 필드: 점수 배열 (int\[])
* 메서드: 평균을 반환하는 `getAverage()` 작성

Main에서 객체를 만들고, 다음 배열을 넣은 후 평균을 출력하시오.

```java
int[] scores = {70, 80, 90, 85, 95};
```

---

*/
}
