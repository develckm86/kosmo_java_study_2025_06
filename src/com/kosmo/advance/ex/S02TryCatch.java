package com.kosmo.advance.ex;

public class S02TryCatch {
    /*
⸻
1. 예외(Exception)란?
	•	정의: 프로그램 실행 중 발생할 수 있는 비정상적인 상황이나 오류
	•	예: 0으로 나누기, 배열 인덱스 초과, 파일 없음, 널 포인터 등
	//null.toString()

⸻

2. 예외의 종류
	•	Checked Exception (확인된 예외)
	•	컴파일러가 확인하고 처리하도록 강제
	•	예: IOException, SQLException
	•	try-catch나 throws로 반드시 처리해야 함
	•	Unchecked Exception (확인되지 않은 예외)
	•	런타임 시점에 발생, 컴파일러가 강제하지 않음
	•	예: NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException

⸻

3. 예외 처리 (try-catch-finally)

try {
    // 예외가 발생할 수 있는 코드
} catch (ExceptionType e) {
    // 예외 처리 코드
} finally {
    // 항상 실행되는 블록 (생략 가능)
}

예제:

try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("0으로 나눌 수 없습니다.");
} finally {
    System.out.println("예외 여부와 관계없이 항상 실행됨.");
}


⸻

4. 여러 개의 catch 블록
	•	상위 타입보다 하위 타입 예외를 먼저 작성해야 함

try {
    String s = null;
    s.length();
} catch (NullPointerException e) {
    System.out.println("널 예외");
} catch (Exception e) {
    System.out.println("기타 예외");
}


⸻

5. 예외 객체의 주요 메서드
	•	e.getMessage() : 예외 메시지
	•	e.printStackTrace() : 예외 발생 위치 추적 출력

⸻

6. 예외 위임 (throws)
	•	메서드 내부에서 예외를 처리하지 않고 호출한 쪽으로 전달
	•	주로 Checked Exception에서 사용

형식:

public void readFile() throws IOException {
    // 예외 발생 가능 코드
}

예제:

public static void main(String[] args) {
    try {
        readFile();
    } catch (IOException e) {
        System.out.println("파일 읽기 실패: " + e.getMessage());
    }
}

public static void readFile() throws IOException {
    FileReader reader = new FileReader("data.txt");
}


⸻

7. throw와 throws 차이

항목	설명
throw	예외를 발생시킴 (실행 시)
throws	예외를 위임함 (선언 시)

throw new IllegalArgumentException("잘못된 값");

public void test() throws IOException { ... }




⸻

8. 요약
	•	예외 처리는 프로그램의 안정성을 유지하기 위한 필수 요소
	•	Checked Exception은 반드시 처리하거나 위임
	•	Unchecked Exception은 선택적으로 처리
	•	try-catch-finally로 직접 처리하거나, throws로 위임 가능
	•	throw는 예외 발생, throws는 예외 위임

⸻*/
}
