package com.kosmo;

public class L06Operator {
    public static void main(String[] args) {
        int i=10;
        //산술연산자 (Arithmetic Operator)+,-,*,/,%
        System.out.println(i+10); //20
        System.out.println(i-3); //7
        System.out.println(i*7); //70
        System.out.println(i/4); //2
        System.out.println(i%3); //1
        //증감(대입)연산자 (증가+감소 Increment+Decrement)
        // int b=10;
        // b=b+1; === ++b
        // b++,++b b--,--b
        System.out.println(i++);
        //증감연산자가 뒤에 있으면 앞에 연산(println)을 먼저하고 증감
        System.out.println(i);
        System.out.println(--i);

        //대입연산자 (Assignment Operator)
        // = , += , -=, *=, /=, %=
        int a=10; //대입연산자 (*** 오른쪽이 먼저 연산되고 결과를 대입)
        a+=2; //a=a+2;
        System.out.println(a); //12
        a*=3;
        System.out.println(a); //36

        a%=5;
        System.out.println(a);


        //비트연산자 (Bitwise Operator)
        //~ :보수연산,not 연산
        System.out.println(~0);
        // 0000 => 1111
        // 1001 => 0110
        System.out.println(~5); //-6
        System.out.println(~1111111111); //-1111111112
        //쉬프트 연산
        // << : 왼쪽 쉬프트 연산
        // >> : 오른쪽 쉬프트 연산
        //  1111 << 1  1110
        //  0010 << 1  0100
        //  0100 << 2  0000

        byte b=127;
        // 01111 1111
        System.out.println(b<<1); //254
        //1이 int 기때문에  byte와 연산한 결과가 int가 됨

        i=1;
        System.out.println(i<<1);
        // 0001 => 0010
        System.out.println(i<<2);
        // 0001 => 0100
        System.out.println(i>>1);
        // 0001 => 0000

        //합집합(더하기,OR) 교집합(곱하기,AND)
        //0*0 = 0
        //1*0 = 0
        //1*1 = 1

        //1+1 = 1
        //1+0 = 1
        //0+0 = 0
        // 10 & 5
        // 1010
        // 0111 = 1111
        System.out.println(10&5);
        System.out.println(10&7);

        System.out.println(10|5);
        System.out.println(10|7); //15 17

        // XOR (Exclusive OR)
        // 0 ^ 0  = 0
        // 1 ^ 0  = 1
        // 0 ^ 1  = 1
        // 1 ^ 1  = 0
        //10 ^ 7
        // 1010
        // 0111
        // 1101
        System.out.println(10^7);
        //비트연산
        // |, &, ^, <<, >>, ~


    }
}
