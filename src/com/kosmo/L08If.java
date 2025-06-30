package com.kosmo;

public class L08If {
    public static void main(String[] args) {
        //조건문 if : 프로그램의 분기를 만들때 사용합니다.
        //if(논리형){실행할 블럭}
        if(true){ //{블럭,scope}
            System.out.println("안녕");
        }
        if(false){
            System.out.println("잘가");
        }
        int a=-10;
        if(a>=10) System.out.println("a는 10보다 크거나 같네요");
        //scope 내부의 코드가 한줄일때만 생략 가능
        if(a<0){
            System.out.println("a는 음수 입니다.");
        }else{ //위 조건이 false 이면
            System.out.println("a는 양수 입니다.");
        }
        //if(1+10){} //결과가 논리형인 경우만 작성가능
        //if (1) {} : 1==true 라 생각하는 언어는 가능 (자바는 불가능)
        //if("안녕"){} : 존재하는 것은 true라 하는 언어 (자바는 불가능)
        //if(조건){ 조건이 true 일때 }else{ 조건이 false 일때 }

        //else if() : 분기가 복잡한 경우 사용
        int score=-3;
        // false && t && t && t && t => 자바가 첫번째 연산에서 멈춘다.
        //자바가 단락평가(지연평가, 연산전에 논리연산을 파악하는 단계)를 진행

        if(score>100 || score<0){
            System.out.println("성적을 다시 입력하세요!");
        }else if(score>=90){
            System.out.println("성적이 A입니다.");
        }else if(score>=80){
            System.out.println("성적이 B입니다.");
        }else if(score>=70){
            System.out.println("성적이 C입니다.");
        }else if(score>=60){
            System.out.println("성적이 D입니다.");
        }else{
            System.out.println("성적이 F입니다.");
        }

    }
}
