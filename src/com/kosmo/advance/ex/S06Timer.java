package com.kosmo.advance.ex;

public class S06Timer {
    /*
⸻

✅ 차이점 요약 비교

항목	                java.util.Timer	                javax.swing.Timer
소속 패키지	        java.util	                    javax.swing
주 사용 목적	        일반 백엔드 작업, 비동기 스케줄링	    GUI (Swing)용 주기적 이벤트
스레드 방식	        별도의 작업 스레드 생성	            **이벤트 디스패치 스레드(EDT)**에서 실행
UI 접근	            ❌ 직접 UI 접근하면 위험         	⭕ 안전하게 Swing 컴포넌트 접근 가능
쓰레드 안전성	        스레드 직접 관리 필요	            Swing 내부에서 자동 처리
반복 주기 설정	        schedule(...)/cancel()	        start() / stop()
사용 예	            파일 자동 저장, 백업	            시계, 애니메이션, 타이머 이벤트 등


⸻

📌 1. java.util.Timer

용도
	•	일반적인 비동기 작업 스케줄링 (UI 없는 서버나 콘솔 프로그램에서 많이 사용)

예시

import java.util.Timer;
import java.util.TimerTask;

Timer timer = new Timer();
timer.schedule(new TimerTask() {
    public void run() {
        System.out.println("1초마다 실행");
    }
}, 0, 1000); // delay 0ms, 1초마다 반복

❗ GUI 환경(Swing)에서 이 Timer로 UI를 직접 변경하면 스레드 충돌 발생 가능

⸻

📌 2. javax.swing.Timer

용도
	•	Swing GUI 컴포넌트에 안전하게 접근할 수 있는 UI 전용 타이머
	•	**이벤트 디스패치 스레드(EDT)**에서 코드가 실행되므로, UI 컴포넌트 직접 조작 가능

예시

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

Timer swingTimer = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Swing 타이머 실행 중");
        // JLabel.setText() 같은 UI 조작 가능
    }
});
swingTimer.start();


⸻

✅ 어떤 Timer를 더 많이 쓰나?

상황	                                추천 Timer
백엔드/콘솔/서버 작업	                java.util.Timer or ScheduledExecutorService
Swing GUI 환경	                    javax.swing.Timer (우선적으로 사용)

☑ Swing 기반 GUI 프로그램에서는 반드시 javax.swing.Timer 사용
⸻

✅ 요약 정리
	•	javax.swing.Timer: UI 타이머, Swing 전용, UI 업데이트에 안전
	•	java.util.Timer: 일반 타이머, 백그라운드 작업용, UI와 분리되어 있어 위험할 수 있음

⸻

✅ EDT (Event Dispatch Thread)란?

EDT는 자바 Swing에서 사용자 이벤트(버튼 클릭, 마우스 움직임 등)와
화면 그리기(Graphics 업데이트)를 처리하는 유일한 스레드입니다.

예를 들어:
	•	JButton을 클릭했을 때 actionPerformed()가 실행됨 → EDT가 실행시킴
	•	JLabel.setText()로 UI를 바꿀 때 → EDT에서 실행해야 안전함
	•	즉, 모든 GUI 관련 코드는 EDT 안에서 실행되어야 함

⸻

✅ 이벤트 루프는 어떻게 동작하나?

Swing 내부에는 자바스크립트와 비슷한 개념의 **이벤트 큐(queue)**가 있습니다.

동작 방식은 이렇습니다:
	1.	프로그램이 JFrame, JPanel을 띄우면 **EDT(Event Dispatch Thread)**가 자동 생성됨
	2.	이 EDT는 내부적으로 무한 루프를 돌면서 이벤트 큐에 있는 작업을 꺼내 처리함
	3.	사용자의 입력(클릭, 타이핑, 타이머 등)이 생기면 이벤트가 큐에 등록됨
	4.	EDT는 한 번에 하나씩 꺼내서 순차적으로 처리함 → 싱글 스레드임

⸻

✅ 그럼 왜 멀티처럼 느껴질까?

자바스크립트처럼, EDT는 큐에 쌓인 작업을 순차적으로 빠르게 처리합니다.
	•	클릭하고
	•	마우스 움직이고
	•	텍스트를 바꾸고
	•	타이머가 실행되고

이런 이벤트들이 순서대로 큐에 들어가고,
EDT가 1개지만 빠르게 하나씩 처리하기 때문에 “멀티처럼 동작”하는 것처럼 보이는 것입니다.

⸻

✅ 자바스크립트와 Swing의 공통점/차이점

항목	                    JavaScript (브라우저)	                    Java Swing (EDT)
스레드 모델	            싱글 스레드 (이벤트 루프)	                    싱글 스레드 (EDT)
비동기 처리	            setTimeout, Promise, async	            javax.swing.Timer, 백그라운드 스레드
이벤트 큐	                있음	                                    있음
렌더링 및 이벤트 처리	    이벤트 루프가 처리	                        EDT가 처리



⸻

✅ 요약
	•	EDT = 자바 Swing의 이벤트 처리 전용 싱글 스레드
	•	이벤트 루프 구조로 동작 → 큐에 이벤트 쌓고 하나씩 처리
	•	실제는 싱글 스레드지만 빠른 큐 처리로 멀티처럼 보임
	•	자바스크립트 이벤트 루프 모델과 매우 유사함

⸻*/
}
