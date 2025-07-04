package com.kosmo.ex;
//
class Animal{ //클래스는 파스칼 규칙
    String  id;//관리번호;
    String species;//종
    String name;//이름
    int year; //탄생년 !!!!
    //변수명 메소드명 필드명 : 낙타표기법 (약속)
    //생성자는 약속된 형태가 존재 : 인텔리제이에서 자동완성 제공-> 마우스오른쪽 => 생성 => 생성자
    //오버라이딩 : 기존의 toString을 덮어서 다른걸로 바꾼다.
//    public String toString(){
//        return "동물 정보 :"+this.id+","+this.name+","+this.year+","+this.species;
//    }

    public Animal(String id, String species, String name, int year) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
public class S20This {
    //동물원 관리 어플
    public static void main(String[] args) {
        //동물 자료를 관리하는 타입(Animal)을 만들어 주세요,
        //동물의 자료로 관리번호,종,이름,탄생년도를 만들겁니다.
        //곰(검둥이), 토끼(하양이), 두루미(빨간머리) 1마리씩 관리할 예정입니다.
        //만들어진 정보를 객체를 출력하면 바로 정보(필드)를 볼 수 있게 해주세요.
        Animal bear=new Animal("S1234","곰","검둥이",2024);
        Animal bear2=new Animal("S1235","곰","점박이",2024);
        Animal rabit=new Animal("S2222","토끼","하양이",2025);
        Animal crane=new Animal("S0010","두루미","빨간머리",2015);
        System.out.println(bear); //com.kosmo.ex.Animal@5f184fc6 : toString 기본값

    }
    /*
    * 좋아. 상속과 오버라이드를 아직 다루지 않았으니, 그 부분은 제외하고 지금 수업에 맞게 클래스, 생성자, this에 대한 내용을 “왜 필요한지” 중심으로 정리해줄게.

⸻

📘 자바 수업 정리 – 클래스, 생성자, this 키워드

1. 클래스란 무엇인가?
	•	클래스는 객체를 만들기 위한 설계도다.
	•	예를 들어 학생 정보를 저장하려면, 이름, 학번, 생년 같은 정보를 담을 구조가 필요하다.
	•	이럴 때 Stu 클래스처럼 필드(데이터)를 정의해 놓고, 여러 명의 학생 데이터를 만들 수 있다.

class Stu {
    String 학번;
    String 이름;
    int 탄생;
}

	•	클래스는 새로운 **자료형(Type)**을 만든다고 이해해도 된다.

⸻

2. 왜 생성자가 필요한가?
	•	new Stu()처럼 객체를 만들면, 필드는 기본값으로 비어 있다.
	•	그런데 학생을 만들 때마다 이름, 학번, 생년을 일일이 입력해야 한다면 번거롭다.

그래서 객체를 만들 때 초기 데이터를 넣을 수 있는 방법이 필요하고, 그 역할을 하는 것이 **생성자(Constructor)**이다.

Stu3 영주 = new Stu3("a202233", "송영주", 2000);

	•	위처럼 생성자를 만들면, 객체를 만들자마자 값을 자동으로 넣을 수 있어서 편리하다.
	•	생성자는 객체가 생성될 때 자동으로 실행된다.

⸻

3. this 키워드는 왜 필요한가?
	•	생성자나 메서드 안에서 **전달받은 변수(파라미터)**와 클래스의 필드 이름이 같을 때, 둘을 구분할 필요가 있다.

Stu3(String 학번, String 이름, int 탄생) {
    this.학번 = 학번;
    this.이름 = 이름;
    this.탄생 = 탄생;
}

	•	여기서 this.학번은 객체 안에 있는 필드,
학번은 생성자로 전달받은 **지역 변수(파라미터)**다.
	•	this는 객체 자신을 가리키는 키워드다.
즉, this.학번은 new Stu3(...)로 만든 그 객체의 학번 필드를 의미한다.
	•	왜 this를 쓰는가?
→ 이름이 같을 때 구분해주기 위해서,
→ 객체 내부에서 자신의 필드를 정확하게 가리키기 위해서

⸻

4. toString() 메서드
	•	객체를 출력하면 일반적으로 메모리 주소처럼 보인다.
	•	그런데 객체가 어떤 데이터로 구성되었는지 사람이 읽기 좋게 출력하고 싶을 때 toString()이라는 메서드를 만들어 사용할 수 있다.

public String toString() {
    return "이름: " + this.이름 + ", 학번: " + this.학번 + ", 탄생: " + this.탄생;
}

	•	이렇게 하면 System.out.println(객체명); 으로 객체 정보를 출력할 수 있다.

⸻

요약

개념	역할	왜 필요한가?
클래스	객체를 만들기 위한 설계도	여러 개의 같은 구조의 데이터를 쉽게 만들기 위해
생성자	객체 생성 시 데이터를 초기화	객체를 만들자마자 데이터를 넣기 위해
this	객체 자기 자신을 가리킴	필드와 파라미터를 구분하거나 객체 내부 요소를 명확히 참조하기 위해
toString()	객체 정보를 문자열로 표현	객체를 사람이 읽을 수 있게 출력하기 위해


⸻

this 키워드 관련 문제

문제 1. 다음 중 this 키워드의 설명으로 올바른 것은?

A. this는 현재 메서드를 의미한다
B. this는 static 메서드 안에서 사용할 수 있다
C. this는 현재 객체 자신을 가리킨다
D. this는 항상 null이다

⸻

문제 2. 아래 생성자에서 this.name = name; 코드가 의미하는 것은?

class Book {
    String name;

    Book(String name) {
        this.name = name;
    }
}

A. 생성자의 name 값을 무시한다
B. 파라미터 값을 객체의 name 필드에 저장한다
C. 에러가 발생한다
D. 객체를 생성할 수 없다

⸻

문제 3. 다음 코드에서 잘못된 부분은?

class User {
    String id;

    public User(String id) {
        id = id;
    }
}

A. 변수명이 잘못되었다
B. this를 사용하지 않아 객체의 id가 초기화되지 않는다
C. 생성자는 파라미터를 가질 수 없다
D. 클래스 내부에서 필드 사용이 금지된다

⸻

문제 4. 다음 코드의 출력 결과는?

class Car {
    String model;

    public Car(String model) {
        this.model = model;
    }

    public void printModel() {
        System.out.println(this.model);
    }
}

public class Test {
    public static void main(String[] args) {
        Car c = new Car("Sonata");
        c.printModel();
    }
}

A. 컴파일 에러
B. Sonata
C. null
D. this.model

⸻

문제 5. 다음 중 this 키워드가 사용될 수 없는 경우는?

A. 객체의 필드를 참조할 때
B. 객체 자신을 다른 메서드에 인자로 넘길 때
C. static 메서드 안에서 사용할 때
D. 생성자 안에서 사용할 때

⸻

추가: 코드 완성 문제

문제 6. 다음 코드에서 this 키워드를 이용하여 생성자 코드를 완성하시오.

class Student {
    String name;
    int age;

    Student(String name, int age) {
        // 여기에 코드를 작성하세요
    }
}


⸻
.*/
}
