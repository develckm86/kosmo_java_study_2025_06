package com.kosmo.advance;

public class A29Synchronized2 {
    public static int A=0; //공유자원

    public static final Object lock=new Object();
    //람다식 내부 싱커로 블럭의 락을 걸어주는 객체

    public static void main(String[] args) throws InterruptedException {
        //synchronized : 멀티스레드 환경에서 공유자원의 일관성 보장

        Thread t=new Thread(()->{
            for (int i=0; i<100000;  i++){
                synchronized (lock){
                    A++;
                }
            }
        });
        t.start();

        Thread t2=new Thread(()->{
            for (int i=0; i<100000;  i++){
                synchronized (lock){
                    A++;
                }
            }
        });
        t2.start();

        Thread t3=new Thread(()->{
            for (int i=0; i<100000;  i++){
                synchronized (lock){
                    A++;
                }
            }
        });
        t3.start();

        //main==static this가 없다 => 이럴때 락객체를 만들어 사용
        Thread t4=new Thread(()->{
            for (int i=0; i<100000;  i++){
                synchronized (lock){
                    A++;
                }
            }
        });
        t4.start();

        Thread t5=new Thread(()->{
            for (int i=0; i<100000;  i++){
                synchronized (lock){
                    A++;
                }
            }
        });
        t5.start();
        t.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println(A); //    500000 == Synchronized(공유자원이 안전)
        //288575,320272  == 공유자원이 안전하게 참조되지 않음
        //멀티스레드가 동시에 공유자원을 참조할때 발생하는 문제
        //기본형 데이터 타입이 제일 많이 문제를 일으킴!!

        //list.add(),Map.put(),Set ... 공유자원으로 안전하지 않음

        //1. 안전한(Synchronized) 타입사용  int => AtomicInteger,ArrayList=>Vector
        //2. synchronized 블럭을 사용 후 참조 (***)
        //3. synchronized된 메서드 사용(인스턴스의 메소드,static 메소드는 안됨)
    }
}
