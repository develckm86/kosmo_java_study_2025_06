package com.kosmo;
class Parent{
    String name="부모";
    String birth="1986-05-25";

    public String toString(){
        return "Parent{ name :"+this.name+", birth :"+this.birth+" }";
    }
}
//extends : 상속
//상속 하는 대상을 부모, 상속 받는 대상을 자식이라 부르고
//자식은 부모의 필드 모두를 물려받는다.
class Child extends Parent{
    String name="자식"; //부모가 물려준 것을 바꾼다. (필드 재정의)

    @Override
    public String toString() {
        return "Child{" +
                "name='" + this.name + '\'' +
                ", birth='" + this.birth + '\'' +
                '}';
    }
}
public class L22Inheritance {
    public static void main(String[] args) {
        Parent p=new Parent();
        System.out.println(p);
        Child c=new Child();
        System.out.println(c);
    }
}
