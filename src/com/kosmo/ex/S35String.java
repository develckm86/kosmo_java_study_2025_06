package com.kosmo.ex;

public class S35String {
    /*⸻

✅ Java 문자열(String) 수업 정리

⸻

📌 1. 문자열이란?
	•	String은 문자들의 집합, 내부적으로는 char[] 배열
	•	불변(immutable) 객체: 한 번 생성되면 변경 불가능
	•	"안녕"은 내부적으로 {'안', '녕'} 과 유사

⸻

📌 2. 문자열과 메모리 구조

String s = "안녕";
s += "잘가";

	•	"안녕", "잘가", "안녕잘가" 각각 별도의 문자열 객체 생성
	•	String은 변경 불가능하므로 + 연산 시마다 새로운 객체가 만들어짐
	•	"문자열 리터럴"은 메모리 절약을 위해 재사용됨 (== 비교 시 true 가능)

System.out.println("안녕" == "안녕");             // true (같은 리터럴 참조)
System.out.println("안녕" == new String("안녕")); // false (새 객체 생성)


⸻

📌 3. 문자열 연산과 우선순위

System.out.println("문자열" + 2 * 2);     // 문자열4
System.out.println("문자열" + 2 + 2);     // 문자열22
System.out.println("문자열" + (2 + 2));   // 문자열4

	•	+ 연산은 문자열 연결 연산이 숫자보다 우선순위가 높음
	•	숫자보다 먼저 문자열이 오면 이후 숫자들도 자동 문자열로 변환

⸻

📌 4. 문자열 리터럴 특징
	•	"문자열" 형태의 리터럴은 JVM이 상수 풀에 저장하고 재사용
	•	메모리 절약과 성능 향상을 위해 중복된 문자열 객체 생성 방지

    ✅ JVM 상수 풀(Constant Pool) 이란?

    JVM 내부에 문자열 리터럴과 같은 상수들을 저장해두는 특별한 메모리 공간입니다.
        •	중복된 상수 객체 생성을 방지
        •	메모리 사용을 줄이고 실행 속도 향상
        •	예: "hello"라는 리터럴이 여러 곳에 있어도, 상수 풀에 한 번만 저장됨

⸻

📌 5. 문자열 반복

for (int i = 0; i < str.length(); i++) {
    System.out.print(str.charAt(i) + ", ");
}

	•	String은 Iterable이 아니므로 for-each 문 사용 불가
	•	반복 시 charAt(i)을 사용한 인덱스 기반 반복 사용

⸻

✅ Java String의 주요 메서드 정리

메서드	                                설명	                                예시
length()	                            문자열 길이 반환	                    "hello".length() → 5
charAt(int index)	                    특정 위치의 문자 반환	                "java".charAt(1) → 'a'
equals(String s)	                    문자열 비교 (내용 기준)	                "hi".equals("hi") → true
equalsIgnoreCase(String s)	            대소문자 무시 비교	                    "hi".equalsIgnoreCase("HI") → true
indexOf(String s)	                    처음 나오는 위치 반환	                "hello".indexOf("l") → 2
lastIndexOf(String s)	                마지막 위치 반환	                    "hello".lastIndexOf("l") → 3
startsWith(String s)	                특정 문자로 시작하는지 검사	            "java".startsWith("j") → true
endsWith(String s)	                    특정 문자로 끝나는지 검사	                "test.txt".endsWith(".txt") → true
split(String regex)	                    구분자로 나누어 배열 반환	                "a,b,c".split(",") → [a, b, c]
contains(String s)	                    문자열 포함 여부	                    "hello".contains("el") → true

✅ 새로운 문자열을 생성하는 메서드

메서드	                                설명	                                예시
toUpperCase()	                        대문자로 변환	                        "java".toUpperCase() → "JAVA"
toLowerCase()	                        소문자로 변환	                        "JAVA".toLowerCase() → "java"
replace(old, new)	                    문자열 치환	                        "apple".replace("p", "b") → "abble"
trim()	                                앞뒤 공백 제거	                        " hello ".trim() → "hello"
substring(int begin)	                시작 인덱스부터 끝까지 잘라냄	            "abcdef".substring(2) → "cdef"
substring(int begin, int end)	        범위 지정해 부분 문자열 추출	            "abcdef".substring(1, 4) → "bcd"


⸻

✅ String vs List의 유용한 메서드 비교 정리

기능	                String 메서드	                List 메서드	                설명
길이 구하기	        length()	                size()	                    길이 또는 요소 수 반환
특정 요소 접근	        charAt(index)	            get(index)	                인덱스 위치의 값 반환
포함 여부 확인	        contains("a")	            contains(obj)	            특정 요소가 포함되어 있는지
일부 추출	            substring(start, end)	    subList(start, end)	        일부 범위 잘라내기
요소 추가	            ✖	                        add(obj)	                String은 불변이라 직접 추가 불가
요소 수정	            ✖	                        set(index, obj)	            String은 한 글자 변경 불가 (불변)
요소 삭제	            ✖	                        remove(index)	            String은 삭제 불가, 새로운 문자열 생성 필요
전체 삭제	            ✖	                        clear()	                    String은 불변, 삭제는 없음
반복 가능	            ✖	                        for-each (element)	        List만 가능
반복자 사용	        ❌ Iterator 불가	            ✅ Iterator 사용 가능	        String은 Iterable 아님
정렬	                ✖	                        sort()	                    문자열 자체는 문자순 고정, 리스트는 정렬 가능


⸻

✅ 겹쳐 보이지만 차이 나는 부분 정리
	1.	문자열은 불변(immutable) → 내부 수정이 불가능함
→ String에서 추가, 수정, 삭제가 불가
	2.	List는 가변적
→ 요소 추가, 수정, 삭제가 자유로움 (add, remove, set 등)

⸻

예시 비교

charAt() vs get()

String str = "hello";
System.out.println(str.charAt(1)); // 'e'

List<String> list = List.of("a", "b", "c");
System.out.println(list.get(1)); // "b"

contains()

str.contains("el"); // true
list.contains("el"); // false (완전 일치해야 함)

substring() vs subList()

str.substring(1, 4); // "ell"

List<String> list = List.of("a", "b", "c", "d");
list.subList(1, 3); // ["b", "c"]

좋습니다! 아래는 사용하신 수업 범위에 맞춰 재구성한 문자열(String) 관련 문제 20제입니다.
	•	✅ 불변성, 리터럴, 연산 우선순위, 참조 비교, charAt 등
	•	✅ String의 유용한 메서드 중심 문제 10제 포함
	•	❌ StringBuffer, 상수 풀 설명 제외

⸻

✅ 문자열 개념 및 연산 관련 문제 (총 10문제)

📘 기본 개념 (1~5)

	1.	자바에서 문자열은 어떤 자료형인가?
A. char[]
B. String
C. StringBuilder
D. List

	2.	다음 중 String의 특징으로 올바른 것은?
A. 문자열은 가변이다
B. 문자열은 참조형이지만 값처럼 다룬다 // 값==기본형
C. 문자열은 기본형이다
D. 문자열은 항상 new로 생성해야 한다

	3.	문자열 + 연산의 결과는 어떤 객체인가?
A. 같은 객체
B. 기존 문자열을 수정한 객체
C. 새로운 문자열 객체
D. StringBuilder 객체

    4.  다음 중 문자열에서 문자를 하나씩 꺼내는 데 사용할 수 있는 메서드는?
A. substring()
B. charAt()
C. contains()
D. split()

	5.	다음 중 문자열의 불변성 설명으로 옳은 것은?
A. 문자열은 내용을 수정할 수 있다
B. 문자열을 더하면 원본 문자열이 바뀐다
C. 문자열 연산 시 기존 문자열은 유지되고 새 문자열이 생성된다
D. 문자열은 내부적으로 리스트로 관리된다

⸻

📙 참조 비교와 문자열 리터럴 (6~10)

	6.	다음 코드의 출력 결과는?

String a = "hello";
String b = "hello";
System.out.println(a == b);

A. true
B. false
C. 컴파일 에러
D. 예외 발생

	7.	다음 코드의 출력 결과는?

String a = "hi";
String b = new String("hi");
System.out.println(a == b);

A. true
B. false
C. 예외
D. null

	8.	문자열을 비교할 때 == 대신 equals()를 써야 하는 이유는?
A. equals가 더 빠르기 때문에
B. 문자열 내용 비교는 equals로 해야 하기 때문에
C. ==은 null을 허용하지 않기 때문에
D. equals는 기본형만 가능하기 때문에

	9.	다음 중 문자열 연결 결과가 "hello42"가 되는 것은?
A. "hello" + 4 + 2
B. "hello" + 4 + "2"
C. "hello" + "4" + "2"
D. 모두 맞다

	10.	문자열 + 숫자 연산에서 우선순위가 높은 것은?
A. 산술 연산
B. 문자열 연결
C. 괄호
D. 비교 연산

⸻

✅ 문자열 유용한 메서드 관련 문제 (총 10문제)

	11.	"banana".length()의 결과는?
A. 5
B. 6
C. 7
D. 오류

	12.	"hello".charAt(1)의 결과는?
A. 'e'
B. "e"
C. 'h'
D. 'l'

	13.	"apple".substring(1, 4)의 결과는?
A. "ppl"
B. "pple"
C. "ple"
D. "app"

	14.	"hello".contains("ll")의 결과는?
A. true
B. false
C. 오류
D. “ll”

	15.	"java".toUpperCase()의 결과는?
A. "Java"
B. "JAVA"
C. "java"
D. 오류

	16.	"hi there".indexOf("t")의 결과는?
A. 2
B. 3
C. 4
D. 1

	17.	"hello".replace("l", "x")의 결과는?
A. "hexxo"
B. "hello"
C. "hexx"
D. "hxxlo"

	18.	"  hello  ".trim()의 결과는?
A. "hello"
B. "  hello"
C. "hello  "
D. "  hello  "

	19.	"abcde".substring(2)의 결과는?
A. "cd"
B. "cde"
C. "de"
D. "bcde"

	20.	"apple".contains("A")의 결과는?
A. true
B. false
C. 오류
D. null

⸻

정답:
	1.	B   2. B   3. C   4. B   5. C   6. A   7. B   8. B   9. D   10. C
	11.	B   12. A   13. A   14. A   15. B   16. B   17. A   18. A   19. B   20. B
*/
}
