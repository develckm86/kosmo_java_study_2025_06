package com.kosmo;

public class L25TypePolymorphism {
    int a=20;
    int b=30;
    //Object.toString() 이 있는데
    //L25TypePolymorphism.toString() 도 작성
    //다형성 : 오버라이딩
    @Override
    public String toString() {
        return "L25TypePolymorphism{" + "a=" + a + ", b=" + b + '}';
    }

    //다형성: 오버로드
    static void sum(int a, int b){
        System.out.println(a+b);
    }
    static void sum(int a, int b,int c){
        System.out.println(a+b+c);
    }

    //정수 곱하는 함수 실수를 곱하는 함수를 만들고 싶어

    static void multiple(Object a,Object b){
        //기본형 int 를 데이터로 보내면 class Integer로 반환
        //기본형 double 를 데이터로 보내면 class Double로 반환
        System.out.println(a.getClass());
        System.out.println(b.getClass());
        //instanceof 객체의 타입을 검사(부모)
        System.out.println(a instanceof Integer);
        System.out.println(b instanceof Double);
        if(
                (a instanceof Integer || a instanceof Double) &&
                (b instanceof Integer || b instanceof Double)
        ){
            //형변환
            //System.out.println(a*b);
            Integer aInteger=(Integer) a;
            Double bDouble=(Double) b;
            System.out.println(aInteger*bDouble);
        }
        //System.out.println(a*b);
    }


    public static void main(String[] args) {
        L25TypePolymorphism.multiple(10,20.1);

        //다형성 : 다양한 형태를 가질 수 있는 것 (컴퓨터 언어가 인간처럼 동작)
        //자바의 다형성 :이름은 1개인데 다양한 형태를 가질 수 있는 것
        //자바의 다형성 :같은 메세지에 대해 다르게 응답하는 것
        //하이 레벨 언어(인간처럼 생각하는 컴퓨터 언어)의 특징
        L25TypePolymorphism.sum(10,20);
        L25TypePolymorphism.sum(10,20,30);


        //변수가 객체를 참조할때 객체의 부모타입을 참조할수 있음 (타입의 다형성)

        String str="안녕";
        Object obj="안녕";

        CCC c=new CCC();
        System.out.println(c.c); //CCC.c
        System.out.println(c.b); //BBB.b
        System.out.println(c.a); //AAA.a
        System.out.println(c.toString());
        //타입의 다형성
        BBB b=c;
//        System.out.println(b.c);
        System.out.println(b.b);
        System.out.println(b.a);
        System.out.println(b.toString());
        AAA a=c;
        System.out.println(a.a);
        System.out.println(a);
        Object o =c;
        System.out.println(o);

        //캐스팅 형변환 : 소괄호로 부모타입을 명시
        //주의!! 객체와 관련없는 타입으로 캐스팅 형변환 할 수 있는데 런터임시 오류가 발생
        System.out.println(o instanceof CCC);
        System.out.println(((CCC)o).c);


        //타입의 다형성을 사용하는 이유 개발과 설계의 편의성을 위해 존재합니다.
        //메소드의 매개변수의 타입을 바꿔서 계속 정의하는 것이 귀찮아서 부모 타입을 한꺼번에 받아 사용

        int i=10;
        Object oi=10;
        Object od=10.0;
        //자바는 타입을 명확하게 사용해야 개발이 더욱 용이함
    }
}
class AAA{
    int a=10;
}
class BBB extends AAA{
    int b=20;
}
class CCC extends BBB{
    int c=30;
}



