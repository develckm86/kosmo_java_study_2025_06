package com.kosmo;

public class L27Casting {
    public static void main(String[] args) {
        //변수, 데이터
        //데이터 : 저장되는 것
        //변수 : 데이터를 담는(참조) 것
        int a=10;
        //10이라는 정수 데이터를 생성
        //a 이름의 정수 타입을 참조하는 변수를 생성
        // = : 참조 대입연산자
        //변수를 사용하는 이유 :데이터를 재사용하려고

        Object object=new Object();
        //object
        Object var=new Object();
        Object 경민=new Object();
        //개발자간의 약속 카멜규칙이면 좋겠어.
        // = : 참조 할당 대입 연산자

        //기본형데이터: 수로된 데이터로 변수를 정의할때 무조건 소문자로 작성
        byte b=127; //=> 수(기본데이터로)로 b가 참조
        Byte bObj=127; //127 => 객체로 만들어서 bObj 참조
        //Boolean, Byte, Short, Integer, Long, Float, Double, Character
        //기본형의 객체형태 : 기본형은 연산만 가능해서 도와(함수)줄 클래스가 필요함
        //랩퍼클래스가 존재합니다.
        System.out.println(b);
        System.out.println(bObj.byteValue());
        int i=10; //16진수
        System.out.println(i);
        Integer iObj=10;
        System.out.println(Integer.toHexString(10));

        //기본형데이터가 => 자료형데이터로 형변환
        //변수가 자료형이면 자동으로 형변환됩니다.
        //자료형 => 기본형 (연산할때 자동으로 형변환)
        ++iObj; //자동으로 형변환
        ++i;
        int i2=iObj.intValue(); //대입 연산
        double d=iObj.doubleValue();


        //작은 수가 큰수로 바뀔때 형변환 (자동)
        i=1000000;
        long l=i; //작은 수를 큰 수로 바꿀 때 (자동 형변환)
        l=1000000000000000000l;
        float f=l;
        //실수(지수부) 데이터 타입이 정수 데이터 타입보다 더 큰수를 표현
        f=100000000000000000000000000000000000000f;
        d=f;
        System.out.println(Short.MAX_VALUE);
        i=32770;
        //큰 수가 작은 수로 바뀔때 형변환 (casting=>강제형변환)
        short s=(short) i;
        System.out.println(s);
        //정수!!!는 강제로 형이 바뀔때 데이터 손실이 일어날 수 있다.
        //거꾸로 반복하는 행위로

        d=1.0E300;
        f=(float) d;
        System.out.println(f);
        d= d*d*d*d*d*d*d*d*d*d;
        System.out.println(d);

        //실수는 데이터 손실이 일어났을 때 무한대 (Infinity)

        //char => 정수로 형변환 (인코딩 라벨의 번호를 출력)
        char c='가';
        System.out.println((int)c);


    }
}
