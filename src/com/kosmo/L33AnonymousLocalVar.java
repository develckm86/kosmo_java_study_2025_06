package com.kosmo;
interface Carable{
    void drive();
}
class CarCasper{

    int y=0;
    //인스턴스변수(필드) : 객체가 존재하는 한 계속 존재합니다.
    void run(){
        int x=0; //메소드 내부의 변수
        // local 변수 : 메소드가 호출될때만 메모리로 존재함
        //Carable 타입을 객체로 꼭 사용해야합니다.

        Carable carable=new Carable() {
            @Override
            public void drive() {
                // 익명클래스에서 로컬변수를 참조하면 로컬변수는 final 로 바껴서
                // 변수가 다른데이터를 참조하지 못하게 한다.
                System.out.println("현제 위치는 :"+x+","+y);
                //++x;
                ++y;
            }

        };
        carable.drive();
    }
}


public class L33AnonymousLocalVar {
    public static void main(String[] args) {
        //익명클래스로 타입 재작시 로컬변수를 참조하는 경우 주의해야할 점
        //여기서 호출하는 데이터를 스택메모리에 보낸다.!!
    }
}
