package com.kosmo.advance;

public class A28Synchronized {

    public static int A=0;

    public static void main(String[] args) throws InterruptedException {
        //synchronized : 멀티스레드 환경에서 공유자원의 일관성 보장
        //!=스레드간 비동기와 다른 뜻
        //스레드간 비동기
        int a=0;
        for (int i=0; i<10;i++){
            a++;
        }
        System.out.println(a);
        //스레드가 1개라 코드간의 동기화(위에 코드가 끝나면 아래코드가 실행: 실행의 결과가 예상됨) 됨

        a=0;
        //멀티스레드 환경
        Thread thread=new Thread(()->{
            for (int i=0; i<10; i++){
                A++;
            }
        }); //새로운 일꾼 만들어서 할일 정의
        thread.start(); //일꾼이 일을 시작

        thread.join(); //Thread thread 가 일을 끝낼때 까지 기다려! => 스레드간 동기화

        System.out.println(A);
        //A가 10이면 멀티스레드간 동기화 됨
        //A가 10이 아니면 멀티스레드간 비동기화 됨

        //synchronized 와는 다른 이야기 중....
    }
}
