package com.kosmo.advance.ex;


import javax.swing.*;

/*2. 클릭 카운터 앱 (Medium)

목표: 버튼을 여러 번 클릭한 횟수를 저장하고 출력
	•	기능:
	•	누른 횟수 누적 (클릭 수: 25)
	•	리셋
	•	클릭 속도 계산 (선택 사항)
	•	도전:
	•	Timer 사용해서 초당 클릭 수 계산

*/
public class S01ClickCounter {
    public static void main(String[] args) throws InterruptedException {

        //주의 javax.swing.Timer (java.util.Timer 아님)
        Timer timer =new Timer(1000,(e)->{
            System.out.println("1초마다 실행됨");
        });
    }


}
