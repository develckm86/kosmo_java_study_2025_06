package com.kosmo.advance.ex;

public class S13Canvas {
    /*
⸻

- Canvas란?

Canvas는 java.awt.Canvas 클래스로 제공되는 그리기 전용 컴포넌트입니다.
사용자가 직접 그림(선, 도형, 이미지, 문자열 등)을 그릴 수 있는 빈 도화지 역할을 하며,
 paint(Graphics g) 메서드를 오버라이드하여 캔버스가 생성될 때 그립니다.

⸻

- Canvas와 일반 컴포넌트(Component)의 차이
	•	JButton, JLabel 등 일반 컴포넌트
        •	이미 정의된 UI 기능을 수행 (버튼 클릭, 텍스트 출력 등)
        •	기본 이벤트 처리 포함
        •	자동으로 UI 요소가 그려짐
	•	Canvas
        •	UI 요소 없이, 그림 그리기 전용
        •	사용자가 직접 화면을 갱신하거나 다시 그리는 로직을 작성해야 함
        •	더 자유롭고 낮은 수준의 그래픽 표현 가능

⸻

- Canvas 사용법 기본 구조

public class MyCanvas extends Canvas {
    public void paint(Graphics g) {
        // 그리기 작업
        g.drawLine(10, 10, 100, 100);
    }
}


⸻

    - 주요 그림 그리기 함수 (Graphics 클래스)

    - 선 그리기

    g.drawLine(int x1, int y1, int x2, int y2)

        •	(x1, y1)에서 (x2, y2)까지 직선을 그림.
        •	예시:
        g.setColor(Color.RED);
        g.drawLine(10, 10, 100, 100); → 좌상단에서 우하단으로 빨간색 대각선

    ⸻

    - 사각형(Rectangle)

    g.drawRect(int x, int y, int width, int height)
    g.fillRect(int x, int y, int width, int height)

        •	drawRect: 테두리만 있는 사각형
        •	fillRect: 내부가 채워진 사각형
        •	(x, y)는 좌측 상단 꼭짓점 위치
        •	예시:

        g.drawRect(50, 50, 100, 80);
        g.fillRect(200, 50, 100, 80);



    ⸻

    - 원/타원(Oval)

    g.drawOval(int x, int y, int width, int height)
    g.fillOval(int x, int y, int width, int height)

        •	drawOval: 타원의 테두리
        •	fillOval: 내부 채움
        •	(x, y)는 외접 사각형의 좌상단, width, height는 타원의 가로, 세로
        •	width == height이면 원(circle)
        •	예시:

        g.drawOval(50, 150, 100, 100); // 원
        g.fillOval(200, 150, 120, 60); // 타원

    ⸻ 호(Arc)를 그리는 함수

    g.drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
    g.fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)

        •	타원의 일부분(부채꼴 혹은 호 형태)을 그림
        •	(x, y)는 외접 사각형의 좌상단
        •	startAngle: 시작 각도 (0도는 3시 방향, 시계 반대 방향이 양수)
        •	arcAngle: 호의 크기 (양수는 반시계, 음수는 시계 방향)
        •	예시:

        g.setColor(Color.BLUE);
        g.drawArc(50, 50, 100, 100, 0, 90);      // 0도부터 90도까지 그리는 호
        g.fillArc(200, 50, 100, 100, 90, 180);   // 반원(90도부터 180도)

    ⸻

    - 다각형(Polygon)

    g.drawPolygon(int[] xPoints, int[] yPoints, int nPoints)
    g.fillPolygon(int[] xPoints, int[] yPoints, int nPoints)

        •	각각의 꼭짓점 좌표를 배열로 전달
        •	nPoints는 꼭짓점 개수
        •	예시:

        int[] x = {100, 150, 200};
        int[] y = {200, 100, 200};
        g.drawPolygon(x, y, 3); // 삼각형

        g.fillPolygon(x, y, 3); // 내부 채운 삼각형



    ⸻

    - 문자열 출력

    g.drawString(String str, int x, int y)

        •	(x, y)는 문자열 베이스라인 기준 (문자 기준선 아래쪽)
        •	예시:
        Font title=new Font("맑은 고딕",Font.BORD,30)
        Font content=new Font("맑은 고딕",null,10)

       paint(){

            g.setColor(Color.BLUE)
            g.setFont(title)
            g.drawString("Hello Canvas!", 50, 250);

            g.setColor(Color.GREEN)
            g.setFont(content)
       }



    ⸻

    - 이미지 출력

    g.drawImage(Image img, int x, int y, ImageObserver observer)

        •	이미지를 (x, y)에 출력
        •	observer는 일반적으로 this 사용 (Canvas 또는 Component)
        •	예시:

        //같은 이미지를 paint()에서 계속 불러오면 안됨!!(필드로 정의)
        Image img = Toolkit.getDefaultToolkit().getImage("player.png");
        g.drawImage(img, 50, 50, this);

        이미지가 비동기적으로 생성되고 paint가 호출될 수 있으므로
        ImageObserver를 활용하여 로딩 상태를 관리해야 정확함.

        mageObserver는 자바에서 **이미지 로딩 상태를 감시(관찰)**하기 위해 사용하는 인터페이스입니다.
        자바의 drawImage()는 이미지가 **비동기적(Async == 멀티스레드 )**으로 로딩되는 방식이라,
        아직 이미지가 완전히 메모리에 로드되지 않았을 때도 drawImage()가 호출될 수 있습니다. 이때,
        ImageObserver를 통해 그 진행 상황을 감지하고 업데이트할 수 있습니다.


    ⸻
    - 색상 지정

    g.setColor(Color c)

        •	이후 그리기 동작에 적용될 색상을 설정
        •	Color 클래스의 상수 사용 또는 RGB 직접 지정
        •	예시:

        g.setColor(Color.RED); // 미리 정의된 색
        g.setColor(new Color(100, 200, 255)); // RGB 값 직접 지정



    ⸻

    - 폰트 변경

    g.setFont(new Font(String name, int style, int size))

        •	그리기 전에 폰트를 설정
        •	스타일: Font.PLAIN, Font.BOLD, Font.ITALIC
        •	예시:

        g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
        g.drawString("폰트 테스트", 50, 300);



    ⸻

    - 화면 지우기 (초기화용)

    g.clearRect(int x, int y, int width, int height)

        •	지정한 영역을 배경색으로 덮어서 지움
        •	애니메이션 등에서 이전 도형을 지우고 새로 그릴 때 사용
        •	예시:

        g.clearRect(0, 0, getWidth(), getHeight());



    ⸻

    - 클리핑 영역 설정 (선택 영역 그리기 제한)

    g.setClip(int x, int y, int width, int height)
    g.getClipBounds() // 현재 클리핑 영역

        •	그리기 영역 제한
        •	필요 시 특정 영역만 다시 그릴 때 사용



- Canvas 초기화 및 사용 예

import java.awt.*;
import javax.swing.*;

public class CanvasTest extends JFrame {
    public CanvasTest() {
        setTitle("Canvas 예제");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyCanvas canvas = new MyCanvas();
        add(canvas); // JFrame에 추가

        setVisible(true);
    }

    class MyCanvas extends Canvas {
        public void paint(Graphics g) {
            g.setColor(Color.BLUE);
            g.drawLine(50, 50, 150, 50);
            g.drawRect(50, 70, 100, 50);
            g.setColor(Color.RED);
            g.fillOval(50, 140, 100, 50);
            g.setColor(Color.BLACK);
            g.drawString("Hello Canvas!", 50, 220);
        }
    }

    public static void main(String[] args) {
        new CanvasTest();
    }
}


⸻

- 그림 갱신 시 주의점
	•	paint(Graphics g)는 OS가 호출
	•	수동으로 다시 그리려면 **repaint() 사용 (내부적으로 update() → paint() 호출됨)
	•	부드러운 움직임을 위해 Thread 또는 Timer와 함께 repaint() 사용 가능

⸻

- 실시간 애니메이션을 위한 기본 흐름

class MyCanvas extends Canvas implements Runnable {
    int x = 0;

    public void run() {
        while (true) {
            x += 5;
            repaint();
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight()); // 이전 그림 지우기
        g.fillOval(x, 100, 30, 30); // 공 그리기
    }
}

- 1. Toolkit vs ImageIcon 차이

Image img=Toolkit.getDefaultToolkit().getImage(“경로”)
img. : 아직 다불러오지 못함
	•	운영체제와 연결된 기본 툴킷을 통해 이미지를 불러옵니다.
	•	비동기 방식: 이미지가 완전히 로드되기 전에 객체가 반환됩니다.
	•	paint에서 사용할 때 이미지 로딩이 덜 되었을 수 있어 깜빡임이 생기기도 함.

Image img=new ImageIcon(“경로”).getImage();
img. : 이미지가 다 불러올때까지 기다렸다가 실행
	•	ImageIcon은 이미지 로딩이 완료된 후 객체를 반환함.
	•	동기 방식: 로딩이 완료될 때까지 기다렸다가 반환.
	•	즉, 이미지가 안정적으로 표시되길 원하면 ImageIcon이 더 나음.
⸻
- 2. 원본 크기로 출력 vs 줄여서 출력
    g.drawImage(image, x, y, this);
        •	이미지가 원본 크기로 그려짐.
    g.drawImage(image, x, y, width, height, this);
        •	원하는 크기(width, height)로 축소 또는 확대해서 그림.

자바에서 SwingUtilities.invokeLater()를 사용하는 이유
**“스윙은 단일 스레드(UI 스레드)에서만 안전하게 동작하기 때문”**입니다.

- Swing은 싱글 스레드 기반이다 (단일 스레드 UI 모델)

Swing은 내부적으로 Event Dispatch Thread(EDT,이벤트 리스너)라는 전용 UI 스레드에서 모든 GUI 이벤트(버튼 클릭, 키 입력, repaint 등)를 처리합니다.
⸻
- invokeLater()의 핵심 역할

SwingUtilities.invokeLater(Runnable r);

	•	전달한 Runnable 작업을 EDT 큐에 등록하고, 비동기적으로 실행시킵니다.
⸻

- 왜 필요한가? 예시로 이해하기

예시 1: main()에서 GUI 생성

public class MyApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("직접 생성");  // ❌ 위험할 수 있음
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

	•	위 코드는 EDT가 아닌 일반 main 스레드에서 JFrame을 생성함
	•	실제로 동작할 수도 있지만, 버전/플랫폼에 따라 불안정하거나 예외 발생 가능성 있음

✅ 안전한 코드:

public class MyApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("invokeLater 사용");
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}

	•	이 코드는 Runnable 내부의 작업을 EDT에서 실행함 → 완전히 안전

⸻

- invokeLater()와 스레드 충돌 문제 예방

GUI 프로그램에서 백그라운드 작업(예: 네트워크, 타이머, 게임 루프)을 하다가 GUI를 수정하려고 하면 다음처럼 문제가 발생할 수 있음:

// 예: 게임 루프 스레드 내부
player.setX(player.getX() + 5);
canvas.repaint();  // ❌ EDT 외부에서 repaint 호출

이럴 땐 반드시 이렇게 호출해야 함:

SwingUtilities.invokeLater(() -> canvas.repaint());


⸻
*/
}
