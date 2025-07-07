package com.kosmo;
class 슈퍼{
    int a;
    //슈퍼(){}
    슈퍼(int a){
        this.a=a;
    }
}

class 디스 extends 슈퍼{
    /*디스(){
        super(10);//슈퍼(10)
    }*/
    디스(int a){
        super(a);  //new 슈퍼(10);
        //자식 객체가 생성될 때 부모도 객체로 만들어 진다.
        //부모의 생성자 규칙이 강제되어 있다면 자식이 부모의 생성자를 호출해야합니다.
    }
}

public class L23SuperConstructor {
    public static void main(String[] args) {
        슈퍼 s=new 슈퍼(10);
    }
}
