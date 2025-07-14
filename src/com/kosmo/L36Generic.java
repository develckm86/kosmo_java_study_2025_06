package com.kosmo;
interface Aable{}
class Aimp1 implements Aable{}
class Aimp2 implements Aable{}
//제네릭은 해당 타입이(설계도,클래스) 객체가 될 때 필드나 메소드의 매개변수의 타입을 구체화 시키면 좋겠어!!
class GenericClass<T>{

    Object o; //가장 추상화 된 필드
    Aable a; //인터페이스로 일반화한 필드
    T t; //객체가 생성될때 전달된 제네릭으로 일반화한 필드

    void callGeneric(T t){ //new GenericClass<Number => T >()
        System.out.println(t.toString());
    }

    void call(Object o){ //어떤것이든 호출 가능
        System.out.println(o.toString());
    }//매개변수의 타입을 구체화

    void callAable(Aable a){ //부모 타입이 Aable 것은 호출 가능
        System.out.println(a.toString());
    }
}


class GenericExtends<T extends Number>{
    //제네릭 자체에 제한주기 extends Type: Type의 자식만 제네릭으로 사용가능
    void call(T t ){

    }
}

public class L36Generic { //제네럭 제네릭 : 일반화 하기(특징없애기), Object 타입을 구체화 시키기
    public static void main(String[] args) {
        GenericExtends<Double> d=new GenericExtends<>();
        GenericExtends<Long> l=new GenericExtends<>();
        GenericExtends<Short> s=new GenericExtends<>();
        //GenericExtends<Boolean> b=new GenericExtends<>();


        GenericClass g=new GenericClass();
        g.call(10);
        g.call("안녕");
        g.call(new L36Generic());
        //타입의 다형성 : 모든 객체의 부모인 Object 매개변수로 모든 객체를 받고 있습니다.
        //=> 너무 조상 부모의 매개변수를 사용하면 오류(**)를 동반할 수 있음

        g.callAable(new Aimp1());
        g.callAable(new Aimp2());
        g.callAable(new Aable() {
            @Override
            public String toString() {
                return "안녕~ 난 Aable 인터페이스로 생성한 익명클래스야!";
            }
        });
//        g.callAable(1);
//        g.callAable(10.0);
//        g.callAable("안녕!");

        g.callGeneric("안녕"); //<>을 사용하지 않으면 T는 Object 가 된다.

        GenericClass<Number> g2=new GenericClass<>();
        //g2.callGeneric("안녕");
        g2.callGeneric(10.3);
        g2.t=0;
        //g2.t="안녕";
        System.out.println(g2.t); //?? 0 null
        //null.getClass() //오류
        //랩퍼 클래스는 기본값이 null 이다 (랩퍼클래스는 자료형이다.)
        Integer i=null;
        int num=0;


        GenericClass<String> g3=new GenericClass<>();
        //다이아몬드 생성자, 우변제네릭타입 생략, type inference
        //java 7부터 객체 생성시 제네릭을 비우면 타입과 같은 제네릭이된다.

        //g3.callGeneric(10);
        g3.callGeneric("안녕 안녕!!");

        //제네릭은 꼭 자료형 타입만 작성가능(기본형 불가) //메모리 낭비 단점
//        GenericClass<int> g4=new GenericClass<int>(); //오류
        //
    }
}
