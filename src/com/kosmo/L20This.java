package com.kosmo;
class Stu{ //학교 어플에서 학생 데이터 관리 => 자료형 (Stu)
    //"A063015"
    String 학번="A2401231"; //한글이름의 변수나 필드를 작성할 수 있지만 권장하지 않음!!
    String 이름="최경민";
    int 탄생=1986;
} //설계도

class Stu2{
    String 학번="A2300333";
    String 이름="채정호";
    int 탄생=2003;
}

//개발자는 같은 배경(필드)을 갖는 다른 자료를 만들기 위해 타입을 매번 지정하는 멍청하다 생각
class Stu3{
    String 학번;
    String 이름;
    int 탄생;
    //class를 만들면 눈에 보이지 않지만 작성된 생성자가 존재합니다.(기본(default)생성자)
    //public Stu3(){}
    // new Stu3(); =>기본 생성자를 호출하는 중
    // 다른 생성자를 작성하면 기본 생성자를 작성하지 않는다. => 만든 생성자를 실행하도록 강제한다.

    //생성자 : 처음 만들 때 주는 데이터로 객체를 만들거야!
    Stu3(String 학,String 이,int 탄){
        //생성자가 실행(호출)될 때 주는 데이터 == 파라미터(매개변수,전달값)
        //this == new Stu3() 객체와 같다.
        //this : 객체 자신, 필드 접근자 (필드,함수,생성자 접근(==실행,==호출))
        this.학번=학;
        this.이름=이;
        탄생=탄;
        //개발자의 습관 (약속)
        //1. 필드는 this로 접근하자
        //2. 필드값을 바꾸는 변수의 이름은 필드와 똑같이 하자
        System.out.println(this.toString());

    }
    //함수 (함수도 자료의 필드로 동작을 담당한다.)
    public String toString(){ //toString :객체 정보(배경,필드) 출력
        return "학생의 이름은 :"+this.이름+", 학번은:"+this.학번+", 탄생은:"+this.탄생;
    }
}

public class L20This {
    public static void main(String[] args) {
        //일을 시키는 곳
        /// ... 학생을 저장 관리!!
        Stu 경민=new Stu(); //<-Stu 로 만든 자료 데이터
        System.out.println(경민.학번);
        System.out.println(경민.이름);
        System.out.println(경민.탄생);
        경민.이름="최경만";
        System.out.println(경민.이름);

        Stu2 정호=new Stu2(); //정호씨 자료 데이터
        System.out.println(정호.이름);
        System.out.println(정호.학번);
        System.out.println(정호.탄생);
        //개발자는 게이르다!!!
        //Stu3 경만=new Stu3();
        Stu3 영주=new Stu3("a202233","송영주",2000);
        System.out.println(영주.이름);
        System.out.println(영주.학번);
        System.out.println(영주.탄생);
        //System.out.println(영주.toString()); //영주.toSting()
    }
}
