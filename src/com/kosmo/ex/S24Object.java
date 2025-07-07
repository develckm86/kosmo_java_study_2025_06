package com.kosmo.ex;

public class S24Object {
    /*

📘 자바 Object 클래스 수업 정리

⸻

✅ 1. Object 클래스란?
	•	자바의 최상위 클래스 (The Root Class)
	•	자바에서 모든 클래스는 Object 클래스를 자동으로 상속받는다.
	•	아무것도 상속받지 않아도 실제로는 extends Object가 생략된 것.

class 오브젝트 {
    // 아무것도 상속하지 않아도 실제로는 Object를 상속받고 있음
}


✅ 2. Object 클래스의 존재 이유

“모든 클래스는 Object로부터 상속받는다.”

	•	자바에서 모든 클래스는 Object 클래스의 자식입니다.
	•	직접 extends Object를 쓰지 않아도 자동으로 상속됩니다.
    왜 이런 구조가 필요할까?
    •	자바는 다양한 타입의 객체를 같은 타입으로 다루는 기능이 필요합니다.
    •	그래서 모든 객체를 Object 타입으로 처리할 수 있도록 구조를 만들었어요.

⸻

📌 3. Object 클래스에서 제공하는 주요 메서드

메서드 이름	설명
toString()  객체를 문자열로 표현할 때 호출됨
equals(Object o)    두 객체가 같은지를 비교할 때 사용
hashCode()  객체의 해시값(주소 기반 고유 값)
getClass()  객체의 클래스 정보를 반환
clone()  객체 복제 (주의: Cloneable 인터페이스 필요)
finalize()  가비지 컬렉션 전에 호출되는 메서드 (거의 안 씀)


⸻

🧪 4. toString() 예제 분석

class BB extends AA {
    String name;

    @Override
    public String toString() {
        return super.toString() + "\n BB{name:" + name + "}";
    }
}

	•	super.toString()은 Object 클래스의 toString() 호출 결과:

클래스이름@해시코드
예: BB@4eec7777


	•	그 뒤에 BB{name:...}을 붙여서 정보 출력 형식을 개선함.

BB b = new BB();
b.name = "BB군";
System.out.println(b); // b.toString() 자동 호출됨

👉 요점: toString()을 오버라이드하면 객체 정보를 보기 좋게 출력 가능

⸻

✨ 5. 오버라이드와 오버로딩 구분

구분	설명
오버라이딩(Overriding)	부모의 메서드를 자식이 재정의
오버로딩(Overloading)	같은 이름의 메서드를 매개변수만 다르게 여러 개 정의

@Override
void call() { } // 오버라이딩

void call(int a) { } // 오버로딩


⸻

👀 5. @Override 어노테이션
	•	부모 클래스에 동일한 메서드가 존재하는지 컴파일러가 검사
	•	오타나 시그니처 오류를 컴파일 단계에서 잡아줌
	•	필수는 아니지만 강력히 권장됨

⸻

🧠 핵심 개념 요약
	•	자바의 모든 클래스는 Object 클래스를 자동으로 상속받는다.
	•	Object의 메서드는 모든 클래스가 기본으로 사용할 수 있음
	•	가장 많이 쓰는 메서드: toString(), equals(), hashCode()
	•	toString()을 오버라이드하면 객체 정보를 사람이 이해하기 쉽게 만들 수 있다.

⸻

좋습니다! 정답 없이, 자바 수업에 바로 활용할 수 있도록 상속, super, Object 관련 20문제를 깔끔하게 정리해드릴게요.
학생들이 직접 풀고 발표하거나 복습용으로 활용하기 좋게 구성했습니다.

⸻

📘 자바 상속 · super · Object 문제 20제

⸻

✅ 1~10번: 개념 이해 (객관식/단답)
	1.	자바에서 클래스를 상속할 때 사용하는 키워드는 무엇인가요?
① import ② package ③ implements ④ ?

⸻

	2.	부모 클래스의 생성자를 호출할 때 사용하는 키워드는 무엇인가요?
① this ② super ③ extends ④ override

⸻

	3.	다음 중 자바의 최상위 클래스는 무엇인가요?
① Main ② SuperClass ③ Base ④ ?

⸻

	4.	super()는 자식 클래스의 생성자에서 반드시 어디에 위치해야 하나요?

⸻

	5.	부모 클래스에 기본 생성자가 없는 경우, 자식 클래스는 어떤 동작을 해야 하나요?

⸻

	6.	메서드 오버라이딩을 명확히 하기 위해 사용하는 어노테이션은 무엇인가요?
① @Super ② @Overload ③ @Override ④ @Virtual

⸻

	7.	자바에서 메서드 오버로딩이란 무엇인가요?

⸻

	8.	Object.toString()의 기본 반환 형태는 어떤 구조인가요?
① 객체의 필드 내용
② 클래스 이름과 해시코드
③ 클래스의 부모 이름
④ 주소값 직접 표시

⸻

	9.	equals() 메서드는 어떤 기능을 하나요?

⸻

	10.	부모와 자식 클래스가 동일한 이름의 필드를 가질 경우, this.name과 super.name은 무엇을 의미하나요?

⸻

✅ 11~15번: 코드 빈칸 채우기
	11.	다음 코드의 빈칸을 채우세요:

class Parent {
    String name = "부모";
}

class Child _______ Parent {
    String name = "자식";
}


⸻

	12.	다음은 부모 생성자를 호출하는 코드입니다. 빈칸을 채우세요:

class Parent {
    Parent(int a) {}
}

class Child extends Parent {
    Child(int a) {
        ______(a);
    }
}


⸻

	13.	다음 클래스는 Object의 어떤 메서드를 오버라이드한 걸까요?

@Override
public String toString() {
    return "Hello";
}


⸻

	14.	부모 클래스의 sayHi() 메서드를 자식 클래스에서 그대로 호출하려면?

super.__________();


⸻

	15.	다음 코드에서 오류가 발생하는 이유를 설명하세요:

class Parent {
    Parent(int a) {}
}

class Child extends Parent {
    Child() {
        // 오류 발생
    }
}


⸻

✅ 16~20번: 서술형 / 코드 출력 예측
	16.	다음 코드에서 System.out.println(p);의 출력 결과를 예측해보세요.

class Person {
    String name = "홍길동";
}

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p);
    }
}


⸻

	17.	오버라이딩(Overriding)과 오버로딩(Overloading)의 차이를 간단히 설명해보세요.

⸻

	18.	Object 클래스의 getClass() 메서드는 어떤 정보를 반환하나요?

⸻

	19.	다음 코드의 출력 결과를 예측하세요:

class Parent {
    String name = "부모";
}

class Child extends Parent {
    String name = "자식";

    void print() {
        System.out.println(this.name);
        System.out.println(super.name);
    }
}

public class Main {
    public static void main(String[] args) {
        new Child().print();
    }
}


⸻

	20.	자바에서 모든 클래스가 Object를 상속받도록 만든 이유는 무엇인가요?

⸻

📘 상속 · super · Object 중급 문제 10제

⸻

21. 다음 코드에서 출력 결과를 예상해보세요.

class Parent {
    String name = "부모";
    void show() {
        System.out.println("Parent: " + name);
    }
}

class Child extends Parent {
    String name = "자식";
    void show() {
        System.out.println("Child: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();
        System.out.println("name: " + c.name);
    }
}


⸻

22. super 키워드를 사용하여 자식 클래스에서 부모의 show() 메서드를 그대로 호출하는 코드를 작성해보세요.

class Parent {
    void show() {
        System.out.println("부모입니다.");
    }
}

class Child extends Parent {
    void show() {
        ___________________________;
    }
}


⸻

23. 다음 코드에서 오류가 발생하는 이유를 서술하세요.

class Parent {
    Parent(int a) {}
}

class Child extends Parent {
    Child() {
        System.out.println("자식 생성자");
    }
}


⸻

24. 다음 중 자바의 클래스 구조로 맞는 설명을 모두 고르세요.

① 모든 클래스는 Object 클래스를 상속한다.
② 자식 클래스는 부모의 private 멤버를 직접 접근할 수 있다.
③ 생성자에서 super() 호출은 생략 가능하다.
④ super 키워드는 정적(static) 메서드 안에서도 사용할 수 있다.

⸻

25. Object 클래스의 equals() 메서드는 어떤 기준으로 두 객체를 비교하나요? 이를 바꾸고 싶다면 어떤 작업이 필요할까요?

⸻

26. 다음 코드는 컴파일은 되지만 출력이 이상합니다. 그 이유는 무엇이며, 어떻게 개선할 수 있을까요?

class Book {
    String title = "자바";

    // toString() 오버라이딩 없음
}

public class Test {
    public static void main(String[] args) {
        Book b = new Book();
        System.out.println(b);
    }
}


⸻

27. @Override 어노테이션을 사용하는 이유를 설명하고, 실수로 오타가 날 경우 어떤 장점이 있는지 예시와 함께 설명하세요.

⸻

28. 다음 클래스에서 super.name을 사용하면 어떤 값을 출력할까요?

class A {
    String name = "부모";
}

class B extends A {
    String name = "자식";

    void print() {
        System.out.println(super.name);
    }
}


⸻

29. 다음은 상속 관계에서 생성자 호출 순서를 묻는 코드입니다. 어떤 순서로 출력될까요?

class A {
    A() {
        System.out.println("A 생성자");
    }
}

class B extends A {
    B() {
        System.out.println("B 생성자");
    }
}

public class Test {
    public static void main(String[] args) {
        new B();
    }
}


⸻

30. super()와 this()는 모두 생성자에서 사용됩니다. 두 메서드의 차이점을 설명하고, 아래 코드에서 올바르게 수정해보세요.

class A {
    A(int x) {}
}

class B extends A {
    B() {
        this(); // 오류 발생
    }

    B(int x) {
        super(x);
    }
}


⸻
좋습니다!
지금까지 수업하신 범위(상속, super, 생성자 호출, Object 클래스, 오버라이딩 등)를 바탕으로 직접 코드를 작성하며 개념을 확인할 수 있는 실습형 문제 5개를 아래에 구성해드릴게요.

학생들이 손으로 직접 타이핑하고, 결과를 예측하고, 수정하는 연습을 할 수 있도록 요구사항과 목표를 명확하게 제시했습니다.

⸻

🧪 실습형 자바 문제 (상속 · super · Object)

⸻

🔧 실습 1. 부모 필드 상속 & 재정의

요구사항:
	•	Animal 클래스를 만들고 String name = "동물"; 필드를 정의하세요.
	•	Cat 클래스를 만들고 Animal을 상속받아 name = "고양이"로 필드를 재정의하세요.
	•	Cat 클래스에서 printNames() 메서드를 만들고, this.name, super.name을 모두 출력해보세요.
	•	main()에서 Cat 객체를 생성하고 printNames()를 호출해보세요.

목표: this와 super의 차이, 필드 숨김 이해하기

⸻

🔧 실습 2. 생성자에서 super() 사용하기

요구사항:
	•	Member 클래스를 만들고 Member(String name) 생성자에서 이름을 출력하세요.
	•	Student 클래스를 만들어 Member를 상속받고, Student(String name, String school) 생성자에서 super(name)을 호출한 뒤 학교명을 출력하세요.
	•	main()에서 Student 객체를 생성해보세요.

예상 출력:

이름: 홍길동
학교: 코스모고등학교

목표: 자식 생성자에서 부모 생성자를 명시적으로 호출하는 구조 익히기

⸻

🔧 실습 3. toString() 오버라이딩 실습

요구사항:
	•	Book 클래스를 만들고 title, author 필드를 정의하세요.
	•	toString() 메서드를 오버라이드해서 "제목: OO, 저자: OO" 형식으로 출력되도록 하세요.
	•	main()에서 Book 객체를 만들고 System.out.println(book);을 실행해 결과를 확인하세요.

목표: Object.toString()을 오버라이딩하고 출력 형식을 제어하는 연습

⸻

🔧 실습 4. equals() 오버라이딩 없이 비교하기

요구사항:
	•	User 클래스를 만들고 String id 필드를 가집니다.
	•	두 개의 User 객체를 만들고 id는 같게 설정합니다.
	•	System.out.println(user1.equals(user2));의 결과를 확인하세요.

질문: 왜 false가 나올까요?

추가 실습: equals()를 오버라이딩해서 id 값이 같으면 같은 객체로 간주되도록 바꿔보세요.

목표: Object.equals()의 기본 동작과 오버라이딩의 필요성을 이해

⸻

🔧 실습 5. 상속 관계에서 출력 흐름 실습

요구사항:
	•	Person 클래스: 생성자에서 "Person 생성" 출력
	•	Employee 클래스: Person을 상속받고, 생성자에서 "Employee 생성" 출력
	•	Manager 클래스: Employee를 상속받고, 생성자에서 "Manager 생성" 출력
	•	main()에서 new Manager(); 호출 시 어떤 순서로 출력되는지 확인하세요.

예상 흐름:

Person 생성
Employee 생성
Manager 생성

목표: 상속 관계에서 객체 생성 순서, super() 호출 흐름을 정확히 파악

⸻
좋습니다!
지금까지 수업하신 범위(상속, super, 생성자 호출, Object 클래스, 오버라이딩 등)를 바탕으로 직접 코드를 작성하며 개념을 확인할 수 있는 실습형 문제 5개를 아래에 구성해드릴게요.

학생들이 손으로 직접 타이핑하고, 결과를 예측하고, 수정하는 연습을 할 수 있도록 요구사항과 목표를 명확하게 제시했습니다.

⸻

🧪 실습형 자바 문제 (상속 · super · Object)

⸻

🔧 실습 1. 부모 필드 상속 & 재정의

요구사항:
	•	Animal 클래스를 만들고 String name = "동물"; 필드를 정의하세요.
	•	Cat 클래스를 만들고 Animal을 상속받아 name = "고양이"로 필드를 재정의하세요.
	•	Cat 클래스에서 printNames() 메서드를 만들고, this.name, super.name을 모두 출력해보세요.
	•	main()에서 Cat 객체를 생성하고 printNames()를 호출해보세요.

목표: this와 super의 차이, 필드 숨김 이해하기

⸻

🔧 실습 2. 생성자에서 super() 사용하기

요구사항:
	•	Member 클래스를 만들고 Member(String name) 생성자에서 이름을 출력하세요.
	•	Student 클래스를 만들어 Member를 상속받고, Student(String name, String school) 생성자에서 super(name)을 호출한 뒤 학교명을 출력하세요.
	•	main()에서 Student 객체를 생성해보세요.

예상 출력:

이름: 홍길동
학교: 코스모고등학교

목표: 자식 생성자에서 부모 생성자를 명시적으로 호출하는 구조 익히기

⸻

🔧 실습 3. toString() 오버라이딩 실습

요구사항:
	•	Book 클래스를 만들고 title, author 필드를 정의하세요.
	•	toString() 메서드를 오버라이드해서 "제목: OO, 저자: OO" 형식으로 출력되도록 하세요.
	•	main()에서 Book 객체를 만들고 System.out.println(book);을 실행해 결과를 확인하세요.

목표: Object.toString()을 오버라이딩하고 출력 형식을 제어하는 연습

⸻

🔧 실습 4. equals() 오버라이딩 없이 비교하기

요구사항:
	•	User 클래스를 만들고 String id 필드를 가집니다.
	•	두 개의 User 객체를 만들고 id는 같게 설정합니다.
	•	System.out.println(user1.equals(user2));의 결과를 확인하세요.

질문: 왜 false가 나올까요?

추가 실습: equals()를 오버라이딩해서 id 값이 같으면 같은 객체로 간주되도록 바꿔보세요.

목표: Object.equals()의 기본 동작과 오버라이딩의 필요성을 이해

⸻

🔧 실습 5. 상속 관계에서 출력 흐름 실습

요구사항:
	•	Person 클래스: 생성자에서 "Person 생성" 출력
	•	Employee 클래스: Person을 상속받고, 생성자에서 "Employee 생성" 출력
	•	Manager 클래스: Employee를 상속받고, 생성자에서 "Manager 생성" 출력
	•	main()에서 new Manager(); 호출 시 어떤 순서로 출력되는지 확인하세요.

예상 흐름:

Person 생성
Employee 생성
Manager 생성

목표: 상속 관계에서 객체 생성 순서, super() 호출 흐름을 정확히 파악

⸻

📘 자바 상속 · super · Object 관련 문제 정답 정리

⸻

✅ 1~10번: 개념 이해
	1.	자바에서 클래스를 상속할 때 사용하는 키워드는?
정답: ④ extends
	2.	부모 클래스의 생성자를 호출할 때 사용하는 키워드는?
정답: ② super
	3.	다음 중 자바의 최상위 클래스는?
정답: ④ Object
	4.	super()는 자식 클래스 생성자의 어느 위치에 있어야 하나요?
정답: 첫 줄
	5.	부모에 기본 생성자가 없을 경우, 자식 클래스는 어떻게 해야 하나요?
정답: 부모 생성자를 명시적으로 super(값)으로 호출해야 한다.
	6.	메서드 오버라이딩을 명확히 하기 위해 사용하는 어노테이션은?
정답: ③ @Override
	7.	자바에서 메서드 오버로딩이란?
정답: 같은 이름의 메서드를 매개변수만 다르게 여러 개 정의하는 것
	8.	Object.toString()의 기본 반환 형태는?
정답: ② 클래스 이름과 해시코드
	9.	equals() 메서드는 어떤 기능을 하나요?
정답: 두 객체가 같은지 비교한다.
	10.	this.name vs super.name의 차이?
정답: this는 자식 클래스의 필드, super는 부모 클래스의 필드

⸻

✅ 11~15번: 코드 빈칸 채우기
	11.	Child _______ Parent →
정답: extends
	12.	Child(int a) { ______(a); } →
정답: super
	13.	toString()은 어떤 메서드를 오버라이딩? →
정답: Object.toString()
	14.	super._________(); →
정답: sayHi
	15.	오류 원인?
정답: 부모 클래스에 기본 생성자가 없는데 자식 생성자에서 super() 호출이 생략되어 컴파일 오류

⸻

✅ 16~20번: 코드 이해 · 서술형
	16.	출력 결과:
정답: Person@해시코드 (toString()을 오버라이딩하지 않았기 때문)
	17.	오버라이딩 vs 오버로딩
정답:

	•	오버라이딩: 부모 메서드를 자식이 재정의
	•	오버로딩: 같은 이름의 메서드를 매개변수 다르게 여러 개 정의

	18.	Object.getClass()
정답: 해당 객체의 클래스 정보를 반환 (Class 객체)
	19.	출력 결과:

자식
부모

	20.	모든 클래스가 Object를 상속하는 이유:
정답:
공통된 메서드 사용을 위해 (toString, equals, hashCode 등), 다형성과 범용 처리를 지원

⸻

✅ 21~30번: 중급 문제
	21.	출력 결과:

Child: 자식
name: 자식

	22.	빈칸 채우기:

super.show();

	23.	오류 이유:
정답: 부모에 기본 생성자가 없기 때문에 자식 생성자에서 super() 호출이 생략되어 컴파일 에러 발생
	24.	맞는 설명:
정답: ①, ③
②: private 멤버 직접 접근 불가
④: super는 인스턴스에서만 사용 가능
	25.	equals() 기본 기능:
정답: 참조(주소)를 비교
→ 값을 기준으로 비교하려면 equals() 오버라이딩 필요
	26.	출력이 이상한 이유:
정답: toString()을 오버라이딩하지 않아서 클래스명@해시코드가 출력됨
→ toString()을 재정의해야 의미 있는 출력 가능
	27.	@Override의 장점:
정답:

	•	오버라이딩 의도를 명확히
	•	부모에 메서드가 없으면 컴파일 에러 → 실수 예방

	28.	super.name의 출력 값:
정답: "부모"
	29.	출력 순서:

A 생성자
B 생성자

	30.	오류 원인 및 수정:
정답: this()는 같은 클래스의 다른 생성자를 호출하는 것이며, super()와 this()는 동시에 쓸 수 없음
→ 기본 생성자에서 this(); → this(0); 또는 super(0);로 바꿔야 함

⸻

✅ 실습형 문제 정답 예시

⸻

실습 1. this와 super

class Animal {
    String name = "동물";
}

class Cat extends Animal {
    String name = "고양이";

    void printNames() {
        System.out.println(this.name);  // 고양이
        System.out.println(super.name); // 동물
    }
}


⸻

실습 2. super() 생성자 호출

class Member {
    Member(String name) {
        System.out.println("이름: " + name);
    }
}

class Student extends Member {
    Student(String name, String school) {
        super(name);
        System.out.println("학교: " + school);
    }
}


⸻

실습 3. toString() 오버라이드

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "제목: " + title + ", 저자: " + author;
    }
}


⸻

실습 4. equals() 없이 비교 / 오버라이딩

class User {
    String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return this.id.equals(other.id);
    }
}


⸻

실습 5. 생성자 호출 순서 확인

class Person {
    Person() {
        System.out.println("Person 생성");
    }
}

class Employee extends Person {
    Employee() {
        System.out.println("Employee 생성");
    }
}

class Manager extends Employee {
    Manager() {
        System.out.println("Manager 생성");
    }
}

출력 결과:

Person 생성
Employee 생성
Manager 생성



*/
}
