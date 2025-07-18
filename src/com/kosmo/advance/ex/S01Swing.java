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
	•	JFrame (최상위 컨테이너=>window)
	•	JDialog
	•	JPanel (중간 컨테이너)
	•	JScrollPane, JTabbedPane 등

⸻

	•	컴포넌트(Component)란?
        사용자와 상호작용하는 개별 UI 요소
        예: 버튼(JButton), 텍스트 필드(JTextField), 레이블(JLabel), 체크박스 등
        이들은 모두 java.awt.Component 클래스를 상속합니다.

*  html  tag 요소 => css = flex, float... grid
* 컨터이너 요소  div, p, ul ..
* 컴포넌트 요소  button, input, i, span
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
       ├── javax.swing.JComponent (AWT를 확장한 Swing 기반 UI 요소)
           ├── JButton, JLabel, JTextField 등

   └── java.awt.Container (컴포넌트를 담을 수 있는 클래스)
       │    └── JPanel (다른 컴포넌트를 담을 수 있는 Swing 컨테이너)
       └── java.awt.Window
             └── javax.swing.JFrame

⸻

	•	요약
	•	컴포넌트: 화면에 표시되고 사용자와 상호작용(EventListener)하는 단위
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

	•	ActionListener: 버튼, 키보드 엔터, 메뉴 등 클릭 이벤트
	•	MouseListener, MouseMotionListener: 마우스 동작
	•	KeyListener: 키보드 입력
	•	WindowListener: 창 열기/닫기 등 창 관련 이벤트
사용 예:

JButton btn = new JButton("클릭");

ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼이 눌렸습니다.");
    }
}
ActionListener al = (e)->{
    System.out.println("버튼이 눌렸습니다.");
}

btn.addActionListener(al);

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

*
*
*Java의 Math 클래스는 수학 관련 기능을 제공하는 java.lang 패키지의 유틸리티 클래스로,
* 인스턴스를 생성하지 않고 클래스 이름으로 직접 접근하는 static 메서드와 상수를 제공합니다.

다음은 Math 클래스에서 제공하는 **주요 필드(상수)**와 **함수(메서드)**를 정리한 내용입니다.

⸻

- 필드 (상수)
	•	Math.PI
        원주율 상수 (≈ 3.141592653589793)
	•	Math.E
        자연로그의 밑 상수 (≈ 2.718281828459045)

⸻

- 기본적인 수학 연산 함수
	•	Math.abs(x)
        절댓값 반환 (int, long, float, double 모두 지원)
	•	Math.max(x, y)
        두 값 중 큰 값 반환
	•	Math.min(x, y)
        두 값 중 작은 값 반환
	•	Math.addExact(x, y)
        정확한 덧셈 (오버플로 시 ArithmeticException 발생)
	•	Math.subtractExact(x, y)
        정확한 뺄셈
	•	Math.multiplyExact(x, y)
        정확한 곱셈
	•	Math.incrementExact(x)
        정확한 증가 (x + 1)
	•	Math.decrementExact(x)
        정확한 감소 (x - 1)
	•	Math.negateExact(x)
        정확한 부호 반전
	•	Math.floorDiv(x, y)
        내림 나눗셈 결과
	•	Math.floorMod(x, y)
        내림 나머지 결과

⸻

- 반올림/버림/올림 관련 함수
	•	Math.round(x)
        반올림 (float → int, double → long)
	•	Math.ceil(x) 1.2=>2
        올림값 반환 (작은 정수 중 가장 큰 값, double 반환)
	•	Math.floor(x)
        버림값 반환 (큰 정수 중 가장 작은 값, double 반환)
	•	Math.rint(x)
        가장 가까운 정수를 double로 반환 (0.5의 경우 짝수로 반올림)
	•	Math.trunc(x) (Java에는 없음)
        → Math.floor(x) 또는 Math.ceil(x)로 조합 가능

⸻

- 제곱/제곱근/지수/로그 함수
	•	Math.pow(a, b)
        a의 b제곱
	•	Math.sqrt(x)
        제곱근
	•	Math.cbrt(x)
        세제곱근
	•	Math.exp(x)
        e^x 계산
	•	Math.expm1(x)
        e^x - 1 계산 (정밀도 높음)
	•	Math.log(x)
        자연로그 (밑 e)
	•	Math.log10(x)
        밑 10 로그
	•	Math.log1p(x)
        log(1 + x) 계산 (정밀도 높음)
	•	Math.hypot(x, y)
        √(x² + y²) — 오버플로우/언더플로우 없이 계산

⸻

- 삼각 함수

(모든 결과는 double 반환, 라디안 단위 사용)
	•	Math.sin(x)
	•	Math.cos(x)
	•	Math.tan(x)
	•	Math.asin(x)
	•	Math.acos(x)
	•	Math.atan(x)
	•	Math.atan2(y, x) — 방향을 고려한 아크탄젠트

⸻

- 난수 및 부호 처리
	•	Math.random()
        0.0 이상 1.0 미만의 double 난수 반환
        0.12312498325409724359
	•	Math.signum(x)
        x가 양수면 1.0, 음수면 -1.0, 0이면 0.0 반환
	•	Math.copySign(magnitude, sign)
        magnitude의 크기에 sign의 부호를 적용

⸻

- 비트 및 정수 관련 특수 함수
	•	Math.toRadians(degrees)
        도(degree) → 라디안(radian)
	•	Math.toDegrees(radians)
        라디안(radian) → 도(degree)
	•	Math.ulp(x)
        x에서 표현 가능한 가장 작은 단위(단정밀도/배정밀도)

* Java의 **래퍼 클래스(Wrapper Class)**는
*  기본형(primitive type)을 객체로 다룰 수 있게 해주는 클래스입니다.
* 각각의 기본형에 대해 대응되는 래퍼 클래스가 존재하며,
* 이 클래스들은 java.lang 패키지에 포함되어 있습니다.

다음은 주요 래퍼 클래스와 함께 자주 쓰이는 유용한 메서드들을 정리한 내용입니다.

⸻

- 기본형과 대응되는 래퍼 클래스
	•	byte → Byte
	•	short → Short
	•	int → Integer
	•	long → Long
	•	float → Float
	•	double → Double
	•	char → Character
	•	boolean → Boolean

⸻

- 공통 유용 메서드 (Integer, Double, Boolean 등)
	•	valueOf(String s) / valueOf(primitive)
        문자열 또는 기본형 값을 해당 래퍼 객체로 반환
        예: Integer.valueOf("123") → Integer(123)

	•	parse타입(String s) **
        문자열을 기본형으로 변환
        예: Integer.parseInt("123") → int 123
        예: Double.parseDouble("3.14") → double 3.14

	•	xxx.toString() / 타입.toString(xxx)
        숫자나 불리언 값을 문자열로 변환
        예: Integer.toString(10) → "10"

	•	xxx.xxxValue()
        다른 기본형으로 변환
        예: Integer i = 10; i.doubleValue() → 10.0

	•	compare(x, y)
        두 값을 비교 (앞이 크면 1, 같으면 0, 작으면 -1)
        예: Integer.compare(10, 5) → 1

	•	equals(Object o)
        두 래퍼 객체의 값 비교
        예: Integer.valueOf(10).equals(10) → true

⸻

- Integer / Long 전용 메서드
	•	Integer.bitCount(int)
        이진수로 나타낸 1의 개수 반환
	•	Integer.toBinaryString(int)
        2진수 문자열로 변환
	•	Integer.toHexString(int)
        16진수 문자열로 변환
	•	Integer.toOctalString(int)
        8진수 문자열로 변환
	•	Integer.reverse(int)
        비트 순서를 반대로 뒤집은 값 반환
	•	Integer.highestOneBit(int) / lowestOneBit(int)
        가장 높은/낮은 비트 위치의 1 반환

⸻

- Double / Float 전용 메서드
	•	isInfinite()
        무한대인지 확인
	•	Double.compare(x, y)
        부동소수점 비교 (정밀도 문제 대응)

⸻

- Character 전용 메서드
	•	isDigit(char)
        숫자인지 확인
	•	isLetter(char)
        알파벳인지 확인
	•	isLetterOrDigit(char)
        문자 또는 숫자인지 확인
	•	isWhitespace(char)
        공백 문자인지 확인
	•	toUpperCase(char) / toLowerCase(char)
        대문자 / 소문자로 변환

⸻

- Boolean 전용 메서드
	•	Boolean.parseBoolean(String s)
        문자열 "true"면 true, 아니면 false
	•	Boolean.toString(boolean b)
        true 또는 false 문자열로 반환

⸻

- Auto-boxing / Unboxing 기능

Java 5부터는 기본형 ↔ 래퍼 클래스 간 자동 변환을 지원합니다.

Integer i = 10;        // auto-boxing
int n = i;             // auto-unboxing

⸻
- 활용 예시

int a = Integer.parseInt("100");
String binary = Integer.toBinaryString(100);
boolean b = Boolean.parseBoolean("true");
char c = 'A';
if(Character.isUpperCase(c)) {
    System.out.println("대문자입니다.");
}


    * */
}
