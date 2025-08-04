package com.kosmo.advance;

import java.time.LocalDate;
import java.util.Arrays;

class A{
    int a;
    int b;
    int c;
}
enum E{
    A,B,C
}

enum Day{
    MON("월요일","monday"), TUE("화요일"), WED("수요일"),
    THU("목요일","thursday"), FRI("금요일","friday"), SAT("토요일"),
    SUN("일요일");
    //toString() 이 필드명과 같은 것을 반환
    //MON == Day MON=new Day()
    String koStr;
    String enStr;
    Day(){}
    Day(String koStr){
        this.koStr=koStr;
    }
    Day(String koStr,String enStr){
        this.koStr=koStr;
        this.enStr=enStr;
    }
}
class Plan{ //일정
    String txt;
    Day day;
    LocalDate date;
    public Plan(String txt, Day day, LocalDate date) {
        this.txt = txt;
        this.day = day;
        this.date = date;
    }
}
public class A27Enum2 {
    public static void main(String[] args) {

        Plan plan=new Plan("강아지산책",Day.THU,LocalDate.of(2025,8,7));
         //enum을 사용하면 모든 필드를 반복 탐색에 사용할 수 있음
        for(Day d:Day.values()){
            if(plan.day==d){
                System.out.println("목요일은 삭책하면 안됨");
            }
        }
        System.out.println(plan.day); //"목요일"
        System.out.println(plan.day.koStr); //"목요일"
        System.out.println(plan.day.enStr); //"thursday"

        A obj=new A();//{a:0,b:0,c:0}
        //obj 필드 전체를 탐색??
        //자바는 객체 내부의 필드가 무엇이 있는지 알 수 있는 방법이 없음
        E[] arr=E.values(); //{A,B,C}
        System.out.println(Arrays.toString(arr));


    }
}
