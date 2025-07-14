package com.kosmo;

public class L34Method {
    //[접근지정자] [메모리영역] [반환타입]  [이름] ([매개변수]) : 메소드

    //클래스 변수로 저장된 sum은 매개변수를 더해서 반환하는 기능을 수행하는 코드 집합
    public static int sum(int a, int b){
        int sum=a+b;
        return sum; //함수의 종료 시점
        //++a; //종료된 후에는 실행되지 않음
    }
    //배열 중에 데이터가 모두 수이면 true, 수가 아닌 것이 있으면 false를 반환하는 검사식 함수 생성
    public static boolean isNum(Object o){
        //수인지 아닌지 검사해서 맞으면 true 아니면 false
        //o 수 데이터면
        //20 => Integer > Number
        //20l => Long
        //20.2 => Double
        //20.2f => float
        boolean isNum=false;
        isNum = ( o instanceof Number );
        return isNum;
    }
    //public static boolean isNum(Object arr[]){}

    public static boolean isNum(Object [] arr){
        boolean isNum=false;
        //반복문으로 배열탐색!!!
        for(int i=0; i < arr.length; i++){
            Object o=arr[i];
            System.out.println(i+":"+  (o instanceof Number) );
            isNum=o instanceof Number;
            //break; : for를 종료하는 명령
            //continue; : 해당 지점을 건너뛴다.
            //if(!isNum) break;
            if(!isNum) return false;
        }
        return isNum;
    }
    static public void sum(int []arr){
        return;//다음 코드 작성 불가
        //System.out.println("안녕!");
    }



    public static void main(String[] args) {

        //메소드 : 특정 기능을 수행하는 코드 집합(블럭)
        //메소드 호출 방법 : 이름(매개변수);
        int s=sum(10,20);
        System.out.println(s);
        System.out.println(isNum(10.0)); //true
        System.out.println(isNum("안녕!!")); //false

        Object [] arr={1,2.1,30l,2.0f,40}; //true
        Object [] arr2={1,2.1,"??",'a',30l,2.0f,40}; //false

        boolean isArr2Num=isNum(arr2);

        System.out.println(isArr2Num);
        System.out.println(isNum(arr));
    }
}
