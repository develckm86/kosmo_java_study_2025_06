package com.kosmo;

public class L35RecursiveMethod {
    public static void call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("안녕!");
        call();
    }

    public static int sum(int i){ //10
        int sum=0;
        System.out.println(i);
        if (i==1) return 1;
        return i+sum(i-1);
    }
    public static void main(String[] args) {
        System.out.println("i! :"+sum(10));
        //call(); //StackOverflowError
        //Stack 메모리가 넘쳐서 오류
        //main 이 실행하는 코드는 Stack 메모리에 저장
        //재귀함수 실행속도가 메모리크기보다 빨라서 메모리가 넘쳐 흐르면서 오류
        //재귀함수는 꼭 종료시점을 정하거나(*), 실행속도를 늦춘다
        //1~입력한 수까지 더하는 함수
        // sum(7) => 7+6+5+4+3+2+1 종료
        // 재귀함수로 코드구현은 자바에서 권장하지 않는다 (무한반복에 빠질수 있고,가독성 떨어짐)
        int sum=0;
        for ( int i=7; i>0; i--){
            sum+=i;
        }
        System.out.println(sum);
    }
}
