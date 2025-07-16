package com.kosmo.ex;

public class S35String {
    /*
좋습니다! 아래는 L40String.java에서 다룬 내용을 중심으로 학생용 수업 정리입니다.
문자열의 개념, 메모리 구조, 연산 특성, 배열과의 관계, 그리고 유용한 메서드까지 흐름에 맞춰 깔끔하게 정리했습니다.

⸻

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
substring(int begin)	                시작 인덱스부터 끝까지 잘라냄	            "abcdef".substring(2) → "cdef"
substring(int begin, int end)	        범위 지정해 부분 문자열 추출	            "abcdef".substring(1, 4) → "bcd"
equals(String s)	                    문자열 비교 (내용 기준)	                "hi".equals("hi") → true
equalsIgnoreCase(String s)	            대소문자 무시 비교	                    "hi".equalsIgnoreCase("HI") → true
indexOf(String s)	                    처음 나오는 위치 반환	                "hello".indexOf("l") → 2
lastIndexOf(String s)	                마지막 위치 반환	                    "hello".lastIndexOf("l") → 3
toUpperCase()	                        대문자로 변환	                        "java".toUpperCase() → "JAVA"
toLowerCase()	                        소문자로 변환	                        "JAVA".toLowerCase() → "java"
replace(old, new)	                    문자열 치환	                        "apple".replace("p", "b") → "abble"
trim()	                                앞뒤 공백 제거	                        " hello ".trim() → "hello"
split(String regex)	                    구분자로 나누어 배열 반환	                "a,b,c".split(",") → [a, b, c]
startsWith(String s)	                특정 문자로 시작하는지 검사	            "java".startsWith("j") → true
endsWith(String s)	                    특정 문자로 끝나는지 검사	                "test.txt".endsWith(".txt") → true
contains(String s)	                    문자열 포함 여부	                    "hello".contains("el") → true


⸻

이후에 StringBuffer와 StringBuilder를 비교하면서 가변 문자열, 성능 차이, append/insert/delete 등을 다루면 더 풍성한 수업이 될 거예요.

원하시면 StringBuffer/StringBuilder 요약도 바로 드릴게요!


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



*/
}
