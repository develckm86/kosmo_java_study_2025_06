package com.kosmo;

public class L28CastingObject {
    public static void main(String[] args) {
        //** 기본형과 자료형은 형변환이 다르다!!!!!!
        //자료 데이터 : 데이터를 저장하는 용도
        // 배열Array([]),class : 자료 데이터 타입
        //자료 데이터 생성 방법
        //1. new 연산자로 생성자를 호출하는 방법, new ClassName();, new Type[3];
        //2. {} : new Type[길이] 생략하고 선언하는 배열의 리털럴 표기
        //3. "안녕" : 문자열 자료형 데이터를 리터럴하게 표기하는 방법 (**)
        String h = "안녕";
        String h2 = "안녕";
        String h3 = new String("안녕");
        System.out.println(h == h2);
        System.out.println(h == h3);
        //문자열 데이터는 자료형 중에 유일하게 + 더하기 연산이 가능
        System.out.println(h + "," + h2 + ',' + h3);
        //문자열은 문자의 배열형태인 자료기 때문에 문자와도 더하기 연산이 가능

        //배열을 제외하고 자료형은 모두 class로 생성되기 때문에 이름이 대문자로 시작


        Animal ani = new Animal(); //{name: null, birth:0 }
        ani.name = "기린";
        ani.birth = 1986;
        //{name: "기린", birth:1986 } //객체 == 자료 == 인스턴스

        Dog dog = new Dog(); //{super.name: null, super.birth:0, this.tail:null }
        dog.name = "코에";
        dog.birth = 2022;
        dog.tail = "반토막";
        //{name: "코에", birth:2022, tail:"반토막" }

        //자료형의 형변환
        //1.변수를 객체와 동일한 타입으로 생성(정상)
        //2.변수를 선언할 때 부모(super)타입으로 선언 => up casting
        //3. 2일 때 다시 1번으로 바꾸는 경우 => down casting
        // 객체를 부모타입의 변수로 참조(upcasting)중에 다시 자식타입으로 바꾸는 것
        // 이때 자식을 다른 타입으로 잘못 작성할 수 있어서 강제 형변환(casting)

        Animal aniDog = dog;
        //{Animal.name: "코에", Animal.birth:2022, Dog.tail:"반토막" }
        //객체에서 Animal 타입에 선언된 필드만 참조하겠다.

        Dog dog2 = (Dog) aniDog;
        Cat cat = (Cat) aniDog;

        //Cat cat2=(Cat) new Dog();
        //Cat cat2=(Cat) new Animal();


    }
}

//사용자 정의 자료형
//필드(자료 데이터의 자료), 메소드(동작), 생성자(자료를 만들때 초기값 제공)
class Animal {
    String name;
    int birth;
}

//상속 (타입을 재사용)
class Dog extends Animal { //끌어와 사용하는 타입을 부모(super)
    //Dog == this
    //Animal ==super

    String tail;
}

class Cat extends Animal {

}
