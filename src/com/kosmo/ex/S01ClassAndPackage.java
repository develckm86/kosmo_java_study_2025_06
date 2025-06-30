package com.kosmo.ex;

public class S01ClassAndPackage {
    /*
## ✅ \[개념 문제] 자바 컴파일과 실행 순서

---

### 📘 문제 1. 다음 중 자바 소스 코드가 실행되기까지의 **올바른 순서**를 고르세요.
A. 실행 → 컴파일 → 클래스 파일 생성 → 결과 출력
B. 클래스 파일 생성 → 컴파일 _→ 실행 → 결과 출력
C. 소스 코드 작성 → 컴파일 → 클래스 파일 생성 → 실행 → 결과 출력
D. 소스 코드 작성 → 실행 → 클래스 파일 생성 → 결과 출력


### 📘 문제 2. 자바 파일을 컴파일할 때 사용하는 명령어는 무엇인가요?
javac Hello.java => Hello.class
(주관식)

### 📘 문제 3. 자바 프로그램을 실행할 때 사용하는 명령어는 무엇인가요?
java Hello
(주관식)


### 📘 문제 4. 다음 중 자바의 `.java` 파일을 컴파일하면 생성되는 파일의 확장자는 무엇인가요?
(객관식)
B
A. `.txt`
B. `.class`
C. `.exe`
D. `.jar`

### 📘 문제 5. L01Hello.java 자바 프로그램을 터미널에서 실행하는 순서를 나열해보세요.

(서술형)
javac L01Hello.java
java L01Hello
---

### 📘 문제 6. 다음 설명 중 맞지 않는 것은?

(객관식)

A. `.java` 파일은 사람이 읽을 수 있는 코드이다.
B. `javac` 명령어는 자바 코드를 클래스 파일로 바꾼다.=>컴파일러
C. `.class` 파일은 자바 컴파일러가 실행하는 파일이다.=> java(jre,jvm) 가 실행
D. JVM은 `.class` 파일을 읽어 실행한다.




---
### 📘 문제 7. 다음 중 JDK(Java Development Kit)의 구성요소가 아닌 것은?
(객관식)
A. 컴파일러 (javac)
B. 실행 엔진 JVM (JRE)
C. 자바 언어로 만든 게임 (X)
D. 기본 패키지와 라이브러리 java.lang.*; String, System, Math

### 📘 문제 8. JRE(Java Runtime Environment)에 대한 설명으로 알맞은 것은?
(객관식)
A. 자바 코드를 컴파일하는 도구이다.
B. 자바 코드를 실행하는 환경이다. (O)
C. 자바 코드를 작성하는 IDE(Integrated Development Environment)이다.=> 인텔리제이,이클립스
D. 외부 라이브러리를 설치하는 도구이다.

### 📘 문제 9. 패키지를 사용하는 주된 목적은 무엇인가요?
(서술형)
클래스 이름을 유일하게 하기 위해 사용합니다. (디렉터리 구조를 이용해 패키징을 합니다.)

### 📘 문제 10. 아래 코드에서 `Math.pow(2, 10)`은 어떤 의미인가요?
(객관식)
A. 2를 10으로 나눈다
B. 2의 10제곱을 계산한다
C. 10의 2제곱을 계산한다
D. 오류가 발생한다

### 📘 문제 11. `java.lang` 패키지의 특징으로 옳은 것은?

(객관식, 복수 정답 가능)
A. 자동으로 import된다 (O)
B. System, Math 등의 클래스가 포함되어 있다 (O)
C. 사용하려면 반드시 import 문을 써야 한다 (X)
D. 자바 실행과 관련된 필수 기능을 포함한다 (O)

### 📘 문제 12. 다음 중 모두 클래스 이름인 것은?
(객관식)

A. Math
B. System
C. pow (함수)
D. String

### 📘 문제 13. 아래 코드의 실행 결과를 예측하세요.
(코드 이해 문제)
public class Test {
    public static void main(String[] args) {
        System.out.println(Math.pow(3, 2)); => 9.0
    }
}

### 📘 문제 14. 패키지가 충돌하는 경우, 자바에서는 어떻게 구분할 수 있나요?
(서술형)
클래스 앞에 패키지 명을 명시합니다.
java.lang.Math
com.ckm.Math

### 📘 문제 15. 다음 중 자바의 기본 제공 패키지로 자동 import되는 것은?

(객관식)
A. java.util
B. java.io
C. java.lang
D. java.net

    *
    * */
}
