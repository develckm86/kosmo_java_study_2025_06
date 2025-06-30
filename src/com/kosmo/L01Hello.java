package com.kosmo;
//com.kosmo.L01Hello
//import 경민.Math;
//import 세종.Math;
import java.lang.*;

public class L01Hello {
    //경민 연구소( ckm.com ) 만든 Math
    //세종 회사 (bsj.com) 만든 Math
    //java 에서 기본으로 제공하는 Math
    public static void main(String [] args) {
        //System.out.println(com.bsj.Math.pow(2,10));
        //System.out.println(com.ckm.Math.pow(2,10));
        System.out.println( Math.pow(2,10));
        //package : 클래스를 유일하게 만드는 페키징

        //jdk (Java Development Kit : 자바의 개발자 도구)
        //자바의실행도구(Java Runtime Environment == java), 컴파일러 (javac), 기본패키지

        //jre : 자바를 실행하는 엔진
        //컴파일러 : java 문서를 jre가 실행하기 편하게 class 문서로 변환(컴파일)하는 도구
        //기본패키지 : 개발자를 위한 기본 패키지를 라이브러리로 제공
        //라이브러리  : 외부에서 제공하는 것을 사용할 수 있도록 가공된 형태 == 도구
        //패키지 : 라이브러를 폴더 단위로 묶은 것 => 배포(deploy)에 유리
        //배포  : 작성한 코드를 외부에 보내는 행위 모든 것

        //java.lang 패키지
        //main 함수가 실행될 때 자동으로 import 되는 패키지


        //class(System, Math), main이 포함된 클래스 (L01Hello)
        //1. main 이 포함된 클래스는 자바 어플(크롬,메모장,인텔리j)로 jre에 의해 실행됩니다.
        //2. Math.pow 처럼 자주 사용하는 도구를 미리 정의하고 재사용**
        //3. System 처럼 실행되는 것을 참조하고 제어할 수 있다. 재사용**
    }
}
