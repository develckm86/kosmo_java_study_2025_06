package com.kosmo.ex;

//부모(name,age,gender) 자식 구현(부모 상속(extends) 후 name 재정의)
class 부모{
    String name="경민";
    int age=39;
    char gender='M';
}
class 자식 extends 부모{
    String name="경민 2세";
    public String toString() {
        return "자식 {name:"+this.name+",age:"+this.age+","+this.gender+"}";
    }
}
public class S22Inheritance {
    public static void main(String[] args) {
        자식 child=new 자식(); //자식 {name:경민,age:39,M}
        System.out.println(child);
        //자식 정보 출력
    }
}
