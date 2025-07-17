package com.kosmo.advance.ex;

public class S01Swing {
    /*
    *
	•	Swing의 등장 배경
AWT(Abstract Window Toolkit)는 자바 최초의 GUI 툴킷으로, 운영체제(OS) 의존적인 컴포넌트를 사용합니다.
이식성이 떨어지고, GUI 표현이 OS마다 달라 일관성이 부족했습니다.
이를 보완하기 위해 Java 1.2부터 Swing이 등장했습니다.
Swing은 순수 자바로 구현되어 OS와 무관한 일관된 GUI 제공이 가능하며, 더 풍부한 컴포넌트와 이벤트 처리를 지원합니다.

⸻

	•	Swing의 구성 요소
	•	JFrame: 윈도우 창 (기본 프레임)
	•	JPanel: 내부 구성용 패널
	•	JLabel: 텍스트 출력
	•	JButton: 버튼
	•	JTextField, JTextArea: 텍스트 입력
	•	JCheckBox, JRadioButton: 선택 UI
	•	JTable, JList, JComboBox: 목록 및 테이블 등 복잡한 컴포넌트
	•	모두 javax.swing 패키지에 포함되어 있음

⸻
*
*

	•	컨테이너(Container)란?
        자바 GUI에서 컨테이너는 다른 컴포넌트를 담을 수 있는 객체입니다.
        예를 들어 버튼이나 텍스트 필드 등을 포함할 수 있는 GUI 구성 요소입니다.

* 자바에서는 다음과 같은 클래스들이 대표적인 컨테이너입니다:
	•	JFrame (최상위 컨테이너)
	•	JDialog
	•	JPanel (중간 컨테이너)
	•	JScrollPane, JTabbedPane 등

⸻

	•	컴포넌트(Component)란?
        사용자와 상호작용하는 개별 UI 요소
        예: 버튼(JButton), 텍스트 필드(JTextField), 레이블(JLabel), 체크박스 등
        이들은 모두 java.awt.Component 클래스를 상속합니다.

⸻

	•	컨테이너와 컴포넌트의 관계
	•	모든 컴포넌트는 컨테이너에 포함되어야 화면에 표시됩니다.
	•	컨테이너는 컴포넌트 또는 다른 컨테이너를 포함할 수 있습니다.
	•	예를 들어 JFrame은 JPanel을 포함하고, JPanel은 다시 JButton을 포함할 수 있습니다.
	*
관계 구조 예시:

JFrame (최상위 컨테이너)
 └── JPanel (중간 컨테이너)
      ├── JButton (컴포넌트)
      └── JTextField (컴포넌트)
⸻

	•	컨테이너 클래스 계층 구조 (중요 개념)
        자바에서 모든 GUI 구성 요소는 java.awt.Component를 기반으로 하며,
        그 위에 다음과 같은 계층이 존재합니다:

java.awt.Component (모든 UI 요소의 최상위 클래스)
   └── java.awt.Container (컴포넌트를 담을 수 있는 클래스)
       ├── javax.swing.JComponent (AWT를 확장한 Swing 기반 UI 요소)
       │    ├── JButton, JLabel, JTextField 등
       │    └── JPanel (다른 컴포넌트를 담을 수 있는 Swing 컨테이너)
       └── java.awt.Window
            └── java.awt.Frame
                 └── javax.swing.JFrame

⸻

	•	요약
	•	컴포넌트: 화면에 표시되고 사용자와 상호작용하는 단위
	•	컨테이너: 컴포넌트를 담는 그릇 (자체도 컴포넌트임)
	•	중첩 가능: 컨테이너는 또 다른 컨테이너(예: JPanel)를 포함할 수 있어 복잡한 UI를 계층적으로 구성 가능


•	레이아웃 매니저
    컴포넌트를 어떤 방식으로 배치할지 결정하는 객체

    대표적인 레이아웃 매니저
    •	FlowLayout:
        컴포넌트를 왼쪽에서 오른쪽으로 순서대로 나열
        기본적으로 JPanel의 기본 레이아웃
        줄 바꿈도 자동 처리
	•	BorderLayout:
        동서남북(center 포함) 5개의 영역에 컴포넌트를 배치
        JFrame의 기본 레이아웃
        add(comp, BorderLayout.NORTH) 형태로 지정
	•	GridLayout:
        행 × 열 형태의 격자 구조로 모든 셀에 같은 크기로 컴포넌트 배치
        new GridLayout(2, 3) → 2행 3열
	•	GridBagLayout:
        가장 유연하고 복잡한 레이아웃
        셀 병합, 비대칭 배치 가능 (실무에서 많이 사용됨)
	•	CardLayout:
        여러 개의 화면을 카드처럼 겹쳐 놓고 하나씩 보여줌
        탭 전환, 마법사(wizard) UI에 유용
	•	null 레이아웃:
        레이아웃 매니저 없이 수동 배치 (setBounds())
        복잡한 디자인 가능하지만 화면 크기 변경에 취약 → 잘 사용하지 않음
⸻

	•	이벤트 리스너 구조
        Swing은 이벤트 기반 구조이며, 사용자의 행동(버튼 클릭 등)에 반응해야 함
        주요 이벤트 리스너 인터페이스:

	•	ActionListener: 버튼, 메뉴 등 클릭 이벤트
	•	MouseListener, MouseMotionListener: 마우스 동작
	•	KeyListener: 키보드 입력
	•	WindowListener: 창 열기/닫기 등 창 관련 이벤트
사용 예:

JButton btn = new JButton("클릭");
btn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼이 눌렸습니다.");
    }
});

⸻
	•	콜백 함수의 개념과 사용
	•	콜백 함수란 이벤트가 발생했을 때 호출되는 사용자 정의 함수입니다.
	•	리스너 객체에 전달되어, 이벤트 발생 시 자동 호출됩니다.
	•	자바에서는 익명 클래스나 람다식을 통해 콜백 정의 가능
예:

btn.addActionListener(e -> System.out.println("람다식 콜백"));

*

⸻

✅ 과제로 만들기 좋은 응용 아이디어 (난이도 순)

⸻

1. 숫자 증가 게임 (Easy)

목표: 버튼을 누를 때마다 숫자가 1씩 올라가고, 100이 되면 “완료!” 표시
	•	기능:
	•	숫자 증가 버튼
	•	리셋 버튼
	•	100 이상일 때 메시지 출력 (JOptionPane)
	•	학습 포인트: 상태 관리, 조건 분기, 레이블 갱신

⸻

2. 카운터 앱 (Medium)

목표:  숫자를 증가시키는 카운터입니다.
* 버튼 3개는 1,10,100 씩 수를 증가시키는 버튼이고 리셋버튼으로 0으로 바꿀수 있습니다.
*
	•	기능:
	•	1 씩 증가하는 버튼
	•	10씩 증가하는 버튼
	•	100 씩 증가하는 버튼
	•	0으로 수를 리셋하는 버튼
	•	수를 출력하는 라벨

⸻

3. Up/Down 버튼으로 숫자 조작 (Medium)

목표:
	•	“▲ 증가”, “▼ 감소” 버튼으로 숫자 조절
	•	마우스 휠로도 조작 가능 (보너스) ** Label 에 마우스 휠 이벤트 사용
	•	최대/최소 범위 제한

⸻

4. 1~50 랜덤 숫자 맞추기 게임 (Higher)

목표:
	•	텍스트 입력창에 수를 입력하여 “정답 숫자”를 맞추는 간단한 미니게임
	•	정답에 도달하면 “축하합니다!” 표시
	*   기회 3번 (도전)
	*   게임 다시 시작(도전)

⸻
* 힌트1 랜덤 수  : Random rand = new Random();
int answer = rand.nextInt(50) + 1;  // 1~50 사이의 정수
* 힌트2 입력창 : JTextField inputField = new JTextField(10);  // 입력 필드 생성
* 힌트3 입력창 엔터 이벤트 : addActionListener()
* 힌트4 입력받은 문자열을 수로 형변환 : Integer.parsInt()


5. 스탑워치 타이머 (Advanced)

목표:
	•	시작, 정지 버튼으로 시간 측정
	•	javax.swing.Timer 사용
	•	시간 포맷 출력 (mm:ss)

⸻

💡 추천 과제 예시 (수업용 피드백 잘 받는 유형)

“숫자 누적기” 앱
	•	버튼 클릭 시 1씩 증가
	•	증가량을 사용자가 설정할 수 있음 (+1, +5, +10)
	•	누적값 초기화 가능
	•	수치가 특정 조건(예: 50 초과)이 되면 경고 메시지 출력

이 과제는:
	•	ActionListener 기본
	•	JLabel을 동적으로 바꾸는 방법
	•	JOptionPane 사용법
	•	단순한 GUI 흐름
	•	조건문과 변수 상태 관리
→ 모두 포함하고 있어서 스윙 기초 수업을 복습하는 데 아주 좋습니다.

⸻

    * */
}
