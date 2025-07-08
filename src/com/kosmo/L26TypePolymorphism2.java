package com.kosmo;
class P{
    void show(){
        System.out.println("안녕!");
    }
}
class C extends P{
    ///기능이 수천가지
}
class C2 extends P{
    /// 기능이 수천가지
    void callC2(){}
}

public class L26TypePolymorphism2 {
    public static void main(String[] args) {
        C c=new C();
        C2 c2=new C2();

        P p;
        p=c;
        p.show();

        p=c2;
        p.show();
        //p.callC2();


        //타입의 다형성 : 부모타입의 변수로 객체를 참조
        //부모타입의 변수로 여러 객체를 참조할 수 있어서 편하다.


        //부모타입을 참조하던 변수를 자식타입을 참조하도록 바꾸는 것
        //=>  현변환 (캐스팅 형변환)
        //c2=p;
        c2=(C2)p;
        c2.callC2();
        L26TypePolymorphism2.callShow(c);
        L26TypePolymorphism2.callShow(c2);
        L26TypePolymorphism2.callShow(p);
//        L26TypePolymorphism2.callShow(10);
//        L26TypePolymorphism2.callShow(" ");
        //타입의 다형성을 이용하면 메소드 설계가 유용합니다.
        //객체지향 문법 다형성 : 오버로드, 오버라이드, 타입의 다형성


        //객체 instanceof 타입: 비교연산자 해당 객체가 어떤 타입(부모)인지 비교연산
        String str="안녕";
        System.out.println(str instanceof String);
        //System.out.println(str instanceof L26TypePolymorphism2);
        c2=new C2();
        System.out.println(c2 instanceof C2);
        System.out.println(c2 instanceof P);
        System.out.println(c2 instanceof Object);

        Object obj=new C2();
        System.out.println(obj instanceof String);
        System.out.println(obj instanceof Integer);
        System.out.println(obj instanceof P);
        System.out.println(obj instanceof C2);
        System.out.println(obj instanceof C);



    }
    static void callShow(P c){c.show();}
//    void callShow(C c){ c.show();}
//    void callShow(C2 c){ c.show();}
}
