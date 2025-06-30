package com.kosmo;

public class L04Integer {
    public static void main(String[] args) {
        int i=10;
        //자바는 정수를 입력하면 int 타입의 정수를 생성
        //자바는 다른 타입의 정수도 존재한다.
        //자바는 20억까지의 수는 그냥 작성할 수 있다. 이때 int 타입이 된다.
        //20억 이상의 수를 작성할 때 L,l 를 쓰는데 이때 long 타입이 된다.
        byte b=-128; //1byte
        short s=32767; //2byte
        i=2147483647; //4byte
        long l= 900000000000000000l; //8byte
        l=900000000000000000L;
        l=10;
        l=2147483648L;


    }
}
