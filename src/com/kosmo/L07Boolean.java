package com.kosmo;

public class L07Boolean {
    public static void main(String[] args) {
        boolean b=true; //true ==> 1인 데이터
        //자바의 논리형은 산술적 연산이 불가
        //System.out.println(true+1);
        b=false; //0인 데이터
        //논리형인 boolean 의 데이터의 크기는 1bit 지만 주소체계가 1byte 단위기 때문에
        //1byte 크기에 기본형 데이터 타입 입니다.

        // 논리형은 비교연산의 결과로 반환되는 데이터

        // ==, !=,  >, < , >=, <=  (기본형의 연산)
        // <> : 사용불능

        // 자료형의 비교연산
        // ==, != (사용할 수 있지만 하지않는 것을 권장)
        int [] nums={1,2,3,4};
        int [] nums2={1,2,3,4};
        System.out.println(nums==nums2);
        System.out.println(nums==nums);
        char [] chars={'h','e','l','l','o'};
        char [] chars2={'h','e','l','l','o'};
        System.out.println(chars==chars2);
        String str="hello";
        String str2="hello";
        System.out.println(str==str2);//false=> true
        //자료형 중에 문자열만 ""(리터럴하게) 정의하면 똑같은 문자열을 찾아서 참조한다.
        //문자열은 통신과 같은 특수한 상황에서 기준 문자열을 찾지 않고 새로 만들기 때문에
        //false를 반환할 가능성이 있다. 때문에 문자열을 == 비교하는 것은 좋지않다.

        //자료형의 equals 는 자료 내의 모든 값을 비교해서 같을 때만 true를 반환
        //자료형은 무조건 equals 를 사용합니다.
        System.out.println(str.equals(str2));


        //논리 연산자
        // && (AND 연산 ) , || (OR 연산), ! (NOT 연산)
        // true 1  false 0

        // false || false = false
        // true || false  = true
        // true || true = true

        // true && false  = false
        // false && false = false
        // true && true = true

        // ! true = false
        // ! false = true

        System.out.println( ( 1>0 ) && ( 10<2 ) ); //false
        System.out.println( ( 1>0 ) || ( 10<2 ) ); //true
        System.out.println( ( 1>0 ) && !( 10<2 ) ); //true

    }
}
