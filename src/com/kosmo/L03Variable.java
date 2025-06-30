package com.kosmo;

public class L03Variable {
    public static void main(String[] args) {
        //반지름이 2인 원의  넓이를 구하는 어플
        //반지름이 3인 원의 넓이를 구하는 어플
        //주석 : 실행이 되지 않는 코드
        /*
        * 여러줄 주석
        */
//        System.out.println(2*2*3.14);
//        System.out.println(2*2*Math.PI);
        System.out.println(3*3*3.14);
        System.out.println(3*3*Math.PI);

        //변수 : 데이터를 참조하는 이름, 데이터의 타입을 명시해야합니다.
        //(int,float,double,char,boolean, String, [])
        double r=3; //변수 선언(변수 생성)
        //int r=3; //같은 이름의 변수를 선언할 수 없다.
        //int n=3.0; //변수와 다른 타입의 데이터는 참조할 수 없다.
        //변수가 3 데이터를 참조한다(O) r과 3은 독립적으로 존재,r은 3의 주소를 참조
        // r은 3이다(X)
        // 왼쪽=오른쪽; //오른쪽이 생성되고 왼쪽에 대입(참조)
        System.out.println(r*2*Math.PI);
        System.out.println(r*r*Math.PI);
        //변수를 사용하는 이유 : 데이터를 재사용하기 위해서
        //변수를 참조하고 있는 데이터를 바꿀 수 있다.
        //double r=r/2; //같은 이름의 변수를 한 블럭({})에서 2번 선언할 수 없다.
        r=r/2;
        // 3.0을 2로 나누어서 1.5 로 바뀌는 것이 아니다.
        // 3.0과 2로 나뉘어진 1.5 가 생성 변수 r이 1.5를 참조하는 것
        System.out.println(r*2);

        //final : 상수, 정보성 데이터를 선언 (처음 선언한 값이 바뀌지 않는)
        //상수의 이름은 대문자로만 명시함
        final double PI=3.14;
        System.out.println(Math.PI); //상수
        //PI=1.14; 컴파일 오류(실행을 막는 오류,문법적 오류,디버거)

        //개발자에게 중요한 것 !! 규칙
        //이름작성 규칙

        //파스칼 규칙 : 대문자로 이름 시작, 문자간에 결합시 대문자로 구분,숫자로 시작할 수 없다.
        // (class System,Math,String,L03Variable)
        //  mouse (x) Mouse (o)
        // OpticalMouse (O) opticalmouse (x) opticalMouse (x) option mouse (X)

        //카멜(낙타) 규칙 : 소문자로 이름 시작, 문자간에 결합시 대문자로 구분,숫자로 시작할 수 없다.
        //변수이름, 함수이름(pow(),println())
        //opticalMouse (o)
        //int 01n=3;

        //스네이크 규칙 : 대문자나 소문자로 작성하는데 _로 문자간의 구분
        //OPTICAL_MOUSE, optical_mouse
        //상수 : 대문자 스네이크
        //폴더명 : 소문자 스네이크 (os의 파일시스템 중에 대소문자 구분을 못하는 경우가 존재)

        int Round=10; //(x)
        int round=10; //(o)

        // null
        //변수를 선언할때 데이터를 정의하지 않은 상태 == undefined (정의하지 않음)
        int n; //정수
        double d; //실수
        boolean b; //논리
        char c; //문자
        //System.out.println(n); //정의되지 않은 기본형 데이터는 사용할 수 없다.

        String str;
        //System.out.println(str); //자료형 역시 정의하지 않고 사용할 수 없다.

        //null : 데이터가 비어있다는 명시적 상태 (자료형)
        str=null;
        System.out.println(str);

        //n=null; //기본형은 null로 비어있는 상태를 표현할 수 없다.
        n=0; //기본형의 비어있는 상태
        d=0.0; //0
        b=false;

        //상수가 undefied 로 정의되었다면 처음에 대입하는 값을 초기값으로 인지
        //상수의 undefied 는 초기값이 될 수 없다.
        //상수의 null은 초기값이 될 수 있다.(null==비어있다는 상태)
        final int N;
        N=10;
        //N=20;
        final String S="안녕";
        //S="잘가";
        final Double D;
        D=2.0;
        //D=3.0;
    }
}
