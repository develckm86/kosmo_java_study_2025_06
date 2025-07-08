package com.kosmo.ex;

//부모(name,age,gender) 자식 구현(부모 상속(extends) 후 name 재정의)

//1. 부모가 name을 초기화하도록 구현하세요!
//=> 자식 클래스가 문제가 생기면 해결하세요!
//=> main 함수의 문제도 해결하세요!
class 부모{
    String name;
    int age=39;
    char gender='M';
    부모(String name){
        this.name=name;
    }
}
class 자식 extends 부모{
    String name="경민 2세";
    //자식(){ super();}
    자식(String name){
        super(name);
        this.name=name;
        //항상 부모 생성자 호출은 코드의 맨 윗줄에서만 작성할 수 있다.
        //부모의 필드를 정의해야 자식이 재정의 할 수 있어서 (부모가 없는데 자식이 만들어짐 )
    }
    public String toString() {
        return "자식 {name:"+this.name+",age:"+this.age+","+this.gender+"}";
    }
}
public class S22Inheritance {
    public static void main(String[] args) {
        자식 child=new 자식("부모님"); //자식 {name:경민,age:39,M}
        System.out.println(child);
        //자식 정보 출력
    }
}
/*
⸻
class A{...기능 수천가지(필드,메서드)}=>부모(super class)
new B()
class B extends A{
    B(){
        super(); new A(); <= super
    }

...A처럼 구현해야할때...

} =>자식
📘 자바 상속(Inheritance) & super() 생성자 호출 수업 정리

⸻


1. 상속 기본 개념

✅ 정의
	•	상속(Inheritance): 기존 클래스(부모)의 필드와 메서드를 새로운 클래스(자식) 에 물려주는 기능
	•	extends 키워드 사용

✅ 용어 정리

용어	설명
부모 클래스	상속해주는 클래스 (super class)
자식 클래스	상속받는 클래스 (sub class)
extends	상속을 명시하는 키워드
super	부모의 멤버 또는 생성자를 가리키는 키워드

⸻

2. 필드 재정의 (이름 겹칠 때의 처리)

🔎 예시 코드

class Parent {
    String name = "부모";
    String birth = "1986-05-25";

    public String toString() {
        return "Parent{ name :" + this.name + ", birth :" + this.birth + " }";
    }
}

class Child extends Parent {
    String name = "자식"; // 필드 재정의 (부모의 name을 숨김)

    @Override
    public String toString() {
        return "Child{ name :'" + this.name + "', birth :'" + this.birth + "' }";
    }
}

✅ 개념 정리
	•	자식 클래스에서 부모와 같은 이름의 필드를 선언하면 → 부모 필드는 가려짐(숨겨짐)
	•	this.name → 자식 클래스의 name 참조
	•	부모의 name을 사용하고 싶으면 super.name 사용 가능

⸻

3. super() 생성자 호출

🔎 예시 코드

class 슈퍼 {
    int a;

    public void sum(){}

    슈퍼(int a) {
        this.a = a;
    }
}

class 디스 extends 슈퍼 {
    int a=10; //재정의 => 변수 숨김

    @Override
    public void sum(){} //재정의 => 오버라이딩

    디스(int a) {
        super(a); // 반드시 부모 생성자를 호출해야 함
    }
}

✅ 개념 정리
	•	자식 객체가 생성되면 반드시 부모 객체도 함께 생성되어야 한다
	•	부모 클래스에 매개변수가 있는 생성자만 존재한다면 → 자식 클래스는 반드시 super(값)으로 호출해야 함
	•	자식 생성자에서 super()를 가장 먼저 호출해야 함 (자동 또는 수동)

⸻

4. super 키워드의 용도 요약

사용 위치	의미
super()	부모 클래스의 생성자 호출
super.필드	부모의 필드 접근
super.메서드()	부모의 메서드 호출

⸻

5. 실행 결과 요약

Parent p = new Parent();
System.out.println(p);
// 출력: Parent{ name :부모, birth :1986-05-25 }

Child c = new Child();
System.out.println(c);
// 출력: Child{ name :'자식', birth :'1986-05-25' }

→ 자식 클래스가 toString()을 오버라이딩 했기 때문에 Child 인스턴스는 자식 쪽 출력 형식으로 보여짐

⸻

✍️ 보충 설명
	•	자식 클래스가 부모의 생성자를 사용할 수 있는 이유는 super() 덕분
	•	필드 재정의는 변수 숨김(variable hiding)이라고 하며, 메서드 오버라이딩과는 다름

⸻
*/
