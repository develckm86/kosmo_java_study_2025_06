package com.kosmo.advance;
class Game{
    int x; //AtomicInteger를 사용해도 완전히 안전한 공유자원이 될 수 없음
    int y;
    public synchronized void incrementX(){
        x++; //Game.this가 lock 객체
    }
    class MoveThread extends Thread{
        @Override
        public void run() {
            for (int i=0; i<500000; i++){
                ///x++;
                //incrementX();//this==MoveThread
                synchronized (Game.this){ //lock 객체는 x를 포함하는 객체
                    //내부클래스에서 외부클래스의 필드를 접근할때 lock 객체를 외부클래스로 지정(주의!!)
                    x++;
                }
            }
        }
    }
    public Game() throws InterruptedException {
        //1.Thread 재정의
        Thread t1=new MoveThread();
        Thread t2=new MoveThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x);//1000000 => 568689

//        //2.Runnable 재정의
//        Runnable moveXThread=new MoveXThread();
//        Thread t3=new Thread(moveXThread);
//        Thread t4=new Thread(moveXThread);
//        t3.start();
//        t4.start();
//        //3. Runnable를 람다식으로 재정의
//        Thread t5=new Thread(()->{});
//        t5.start();
    }

}


public class A30SynchronizedMethod {
    public static void main(String[] args) {
        try {
            Game game=new Game();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
