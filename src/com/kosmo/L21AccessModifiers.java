package com.kosmo;
class Access{
    //접근 지정자 : 필드나 함수의 접근 권한을 지정 => 캡슐화
    private int a=10;// class 내부에서 접근 가능
    public int b=20;// 누구나 모두 다(다른 패키지 모두) 접근 가능
    int c=23; // default(기본) : 패키지가 같은 클래스는 접근 가능
    //이름이 같은데 여러개 있는 것 => 오버라이드(딩)
    Access(){}
    Access(int a){
        this.a=a;
    }
    @Override
    public String toString() {
        return "Access{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

public class L21AccessModifiers {
    private int a=10;
    public int b=20;
    int c=30; //다른 패키지에서 되냐!!

    public L21AccessModifiers(int a) {
        this.a = a;
    }
    @Override
    public String toString() {
        return "L21AccessModifiers{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    public static void main(String[] args) {
         L21AccessModifiers a=new L21AccessModifiers(1000);
         a.a=999;
         a.b=9999;
         a.c=99999;
         System.out.println(a);





        Access access=new Access();
        //access.a=20; //java: a has private access in com.kosmo.Access
        Access access2=new Access(1000);

        access2.b=999;
        access2.c=9999; //다른 패키지의 클래스는 접근 불가능


        System.out.println(access2);

    }
}
