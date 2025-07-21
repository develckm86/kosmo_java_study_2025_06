package com.kosmo.advance.ex;

public class S05LocalDate {
    /*
    자바 8부터 도입된 java.time 패키지는 날짜와 시간을 훨씬 더 명확하고 안전하게 다룰 수 있도록 해줍니다.
그중 **LocalDate, LocalTime, LocalDateTime**은 자주 쓰이며, 각각 다음과 같은 용도입니다:
	•	LocalDate: 날짜만 (년/월/일)
	•	LocalTime: 시간만 (시/분/초)
	•	LocalDateTime: 날짜 + 시간

⸻

📘 1. LocalDate – 날짜만 다룰 때 사용

import java.time.LocalDate;

LocalDate today = LocalDate.now(); // 현재 날짜
LocalDate birth = LocalDate.of(2000, 5, 5); // 특정 날짜
LocalDate parsed = LocalDate.parse("2025-07-21"); // 문자열 파싱

✅ 자주 쓰는 메서드

메서드	설명
getYear()	연도 반환
getMonth(), getMonthValue()	월(문자열/숫자) 반환
getDayOfMonth()	일 반환
getDayOfWeek()	요일 반환 (MONDAY 등)
plusDays(n), minusMonths(n)	날짜 계산
isBefore(date), isAfter(date)	날짜 비교
lengthOfMonth()	해당 월의 일 수


⸻

📘 2. LocalTime – 시간만 다룰 때 사용

import java.time.LocalTime;

LocalTime now = LocalTime.now(); // 현재 시각
LocalTime time = LocalTime.of(14, 30, 0); // 14시 30분
LocalTime parsed = LocalTime.parse("09:15:45"); // 문자열 파싱

✅ 자주 쓰는 메서드

메서드	설명
getHour(), getMinute(), getSecond()	시, 분, 초 반환
plusHours(n), minusMinutes(n)	시간 연산
isBefore(time), isAfter(time)	시간 비교
withHour(h)	시를 특정 값으로 변경


⸻

📘 3. LocalDateTime – 날짜와 시간을 함께 다룰 때 사용

import java.time.LocalDateTime;

LocalDateTime now = LocalDateTime.now();
LocalDateTime dateTime = LocalDateTime.of(2025, 7, 21, 10, 30); // 날짜+시간
LocalDateTime parsed = LocalDateTime.parse("2025-07-21T10:30:00");

✅ 자주 쓰는 메서드

메서드	설명
toLocalDate()	날짜만 추출
toLocalTime()	시간만 추출
getYear(), getHour() 등	구성 요소 추출
plusDays(), plusHours()	날짜/시간 계산
isBefore(), isAfter()	비교


⸻

📌 날짜 간 차이 계산

import java.time.LocalDate;
import java.time.Period;

LocalDate d1 = LocalDate.of(2025, 1, 1);
LocalDate d2 = LocalDate.of(2025, 7, 21);
Period p = Period.between(d1, d2);
System.out.println(p.getMonths()); // 6
System.out.println(p.getDays());   // 20


⸻

📌 시간 간 차이 계산

import java.time.LocalTime;
import java.time.Duration;

LocalTime t1 = LocalTime.of(10, 0);
LocalTime t2 = LocalTime.of(12, 30);
Duration d = Duration.between(t1, t2);
System.out.println(d.toMinutes()); // 150


⸻

📌 포맷 출력 (DateTimeFormatter 사용)

import java.time.format.DateTimeFormatter;

LocalDateTime dt = LocalDateTime.of(2025, 7, 21, 14, 5);
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
System.out.println(dt.format(fmt)); // 2025년 07월 21일 14시 05분


⸻

✅ 핵심 비교 요약

클래스	포함 정보	예시 생성	특징
LocalDate	년/월/일	LocalDate.of(2025,7,21)	날짜 연산
LocalTime	시/분/초	LocalTime.of(10,30)	시간 연산
LocalDateTime	날짜 + 시간	LocalDateTime.of(2025,7,21,10,30)	통합 연산

⸻

📘 ISO 8601 표준이란?

ISO 8601은 날짜와 시간의 국제 표준 표기 형식입니다.
→ 사람보다 컴퓨터가 읽기 쉬운 형식, 정렬이 가능한 형식, 일관된 표기법

⸻

✅ 기본 형식 정리

유형	ISO 8601 형식 예시	설명
날짜 (LocalDate)	2025-07-21	yyyy-MM-dd
시간 (LocalTime)	14:30:00	HH:mm:ss
날짜+시간 (LocalDateTime)	2025-07-21T14:30:00	T는 날짜와 시간 구분자
날짜+시간+UTC (Instant)	2025-07-21T14:30:00Z	Z는 UTC (Zulu time)
시간대 포함 (ZonedDateTime)	2025-07-21T14:30:00+09:00[Asia/Seoul]	시간대 정보 포함


⸻

✅ 자바의 기본 ISO 포맷 예시

LocalDate date = LocalDate.of(2025, 7, 21);
System.out.println(date); // 출력: 2025-07-21

LocalTime time = LocalTime.of(14, 30, 0);
System.out.println(time); // 출력: 14:30:00

LocalDateTime dt = LocalDateTime.of(2025, 7, 21, 14, 30);
System.out.println(dt); // 출력: 2025-07-21T14:30:00


⸻

✅ ISO 포맷을 명시적으로 사용할 수도 있음

자바는 미리 정의된 DateTimeFormatter를 제공함:

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

LocalDateTime dt = LocalDateTime.now();
String iso = dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
System.out.println(iso); // 예: 2025-07-21T14:30:00

주요 Formatter

Formatter 상수	설명
ISO_LOCAL_DATE	yyyy-MM-dd
ISO_LOCAL_TIME	HH:mm:ss
ISO_LOCAL_DATE_TIME	yyyy-MM-dd'T'HH:mm:ss
ISO_OFFSET_DATE_TIME	시간대 오프셋 포함
ISO_ZONED_DATE_TIME	ZonedDateTime용 (시간대 이름 포함)
ISO_INSTANT	Instant용 (Z 포함)


⸻

📌 참고: 왜 ISO 형식이 중요한가?
	•	날짜/시간을 문자열로 정렬하면 시간 순서로 정렬됨
	•	**전 세계 시스템 간 통신(API, DB, 로그)**에 적합
	•	사람이 보기엔 약간 불편하지만, 기계가 쓰기엔 가장 안정적

⸻

✅ 요약

형식 예시	의미
2025-07-21	날짜
14:30:00	시간
2025-07-21T14:30:00	날짜 + 시간
2025-07-21T14:30:00Z	UTC 시간
2025-07-21T14:30:00+09:00	시간대 포함
2025-07-21T14:30:00+09:00[Asia/Seoul]	지역 기반 시간대 포함


⸻

📘 LocalDate 유용한 메서드

메서드	설명	예시
now()	현재 날짜	LocalDate.now()
of(y, m, d)	특정 날짜 생성	LocalDate.of(2025, 7, 21)
parse(str)	문자열 → 날짜	LocalDate.parse("2025-07-21")
getYear()	연도 반환	2025
getMonth()	Month 열거형 반환	JULY
getMonthValue()	월(숫자) 반환	7
getDayOfMonth()	일 반환	21
getDayOfWeek()	요일 반환	MONDAY
isLeapYear()	윤년 여부	true / false
plusDays(n) / minusWeeks(n)	날짜 연산	.plusDays(5)
withDayOfMonth(n)	일 변경	.withDayOfMonth(1)
isBefore(), isAfter()	날짜 비교	d1.isBefore(d2)


⸻

📘 LocalTime 유용한 메서드

메서드	설명	예시
now()	현재 시각	LocalTime.now()
of(h, m, s)	특정 시각 생성	LocalTime.of(14, 30, 0)
parse(str)	문자열 → 시간	LocalTime.parse("14:30:00")
getHour()	시 반환	14
getMinute()	분 반환	30
getSecond()	초 반환	0
plusMinutes(n) / minusHours(n)	시간 연산	.plusMinutes(10)
withHour(n)	시 변경	.withHour(9)
isBefore(), isAfter()	시간 비교	t1.isAfter(t2)


⸻

📘 LocalDateTime 유용한 메서드

메서드	설명	예시
now()	현재 날짜+시간	LocalDateTime.now()
of(...)	날짜+시간 생성	LocalDateTime.of(2025, 7, 21, 14, 30)
parse(str)	문자열 → 날짜+시간	LocalDateTime.parse("2025-07-21T14:30:00")
getYear(), getHour() 등	날짜/시간 요소 추출	.getMonthValue()
toLocalDate()	날짜만 추출	.toLocalDate()
toLocalTime()	시간만 추출	.toLocalTime()
plusDays(), plusHours() 등	날짜+시간 연산	.plusDays(3)
withMinute(n)	분 변경	.withMinute(0)
isBefore(), isAfter()	비교	dt1.isBefore(dt2)


⸻

📌 추가 유틸 클래스 메서드 (비교/차이 계산용)

Period (날짜 차이)

Period diff = Period.between(date1, date2);
diff.getDays(); diff.getMonths(); diff.getYears();

Duration (시간 차이)

Duration diff = Duration.between(time1, time2);
diff.toMinutes(); diff.toMillis();


⸻

*/
}
