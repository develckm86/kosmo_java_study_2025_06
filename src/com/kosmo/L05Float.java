package com.kosmo;

public class L05Float {
    public static void main(String[] args) {
        //자바는 2개의 실수 데이터 타입을 갖는다 (float,double)
        //3.14 => double 형
        //3.14f, 3.14F => float 형

        //1 => int
        //1l => long
        //float 4byte 실수형 데이터
        float f=3.14f;
        //double 8byte 실수형
        double d=3.14;
        //자바는 실수가 8byte는 되어야 쓸만하다 생각하고 실수의 기본 타입으로 double을 지정

        System.out.println(Integer.MAX_VALUE);

        f=2147483647;
        System.out.println(f);
        //2147483647.
        //2.147483647 * 10^9 : 위의 수와 같지만 표기법이다름
        //2.147483647E9
        //2.1474836E9 : 부동소수점 == float

        f=123456789012345678901234567890123456789f;
        System.out.println(f); //1.2345679E38
        //실수 데이터는 지수부와 가수부로 나누는데
        //가수부로 표현할 수 없는 수는 반올림으로 잘라낸다(0으로 바꾼다).
        //엄청 큰수나 작은 수를 표현할 수 있다.
        //float 는 4byte를 지수부 가수부로 나누고 있기 때문에 수의 정밀도가 떨어진다.
        //때문에 8byte 실수인 double을 자바의 기본 실수로 지정하고 있다.
        d=123456789012345678901234567890123456789.0f;
        //float는 더블보다 작은 수기때문에 더블 변수가 참조할 수 있다.
        d=1234567890123456789012345678901234567890123456790123456789012345678901234567890.0;
        System.out.println(d); //1.2345678901234568E78
        System.out.println(Double.MAX_EXPONENT); //2^1023
        System.out.println(Float.MAX_EXPONENT);//2^127

        System.out.println(Double.MAX_VALUE);
        System.out.println(Float.MAX_VALUE); //2^127  1.7*10^38

        //실수는 천문학적인 수를 표현 => 무한대

        System.out.println(d*d*d*d);
        System.out.println(f*f);
        System.out.println(-d*d*d*d);
        System.out.println(-f*f);


    }
}
