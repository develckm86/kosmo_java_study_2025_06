package com.kosmo.ex;
import com.kosmo.L21AccessModifiers;

public class S21Access {
    public static void main(String[] args) {
        L21AccessModifiers a=new L21AccessModifiers(1000);
        //a.a=999; //private class 내부만 접근 가능
        a.b=9999; //public 어느 패키지의 class라도 가능
        //a.c=99999; //같은 패키지의 class 에서만 접근 가능
        System.out.println(a);
    }
}
