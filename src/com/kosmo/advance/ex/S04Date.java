package com.kosmo.advance.ex;

public class S04Date {
    /*물론입니다! 아래는 Date 객체를 중심으로 Unix 시간 개념, SimpleDateFormat 사용법을 통합하여 수업 용도로 정리한 설명입니다. Java 초급~중급 수업에 적합하게 구성했습니다.

⸻

📘 Java의 Date, Unix 시간, SimpleDateFormat 개념 정리

⸻

✅ 1. Date 객체란?
	•	java.util.Date 클래스는 날짜와 시간을 표현하는 자바의 초기 클래스
	•	객체를 생성하면 해당 시점의 시간을 자동으로 저장함
	•	내부적으로는 시간 정보를 1970년 1월 1일 00:00:00 UTC부터 경과된 밀리초(ms) 로 저장

Date now = new Date();
System.out.println(now); // 현재 시각 출력


⸻

✅ 2. Unix 시간 (Unix Timestamp)

📌 정의
	•	1970년 1월 1일 00:00:00 UTC를 기준으로 얼마나 시간이 지났는지를 밀리초(ms) 또는 초(s) 단위로 표현
	•	이 값을 Unix 시간 또는 Epoch Time이라 부름

📌 Java에서 Unix 시간 구하기

Date now = new Date();
System.out.println(now.getTime()); // long 타입, 현재까지 경과된 밀리초

📌 예시
	•	0 → 1970-01-01 00:00:00 UTC
	•	1000 → 1초 후
	•	3600000 → 1시간 후

📌 현재 시각을 Unix 시간으로

long now = System.currentTimeMillis(); // 현재 밀리초

📌 Unix 시간으로 Date 생성

Date d = new Date(2000000000000L); // 약 2033년


⸻

✅ 3. SimpleDateFormat — 날짜를 문자열로 포맷하거나, 문자열을 파싱

📌 기본 개념
	•	Date는 내부적으로 시간을 저장하지만, 사람이 읽기 쉽게 만들기 위해 문자열로 바꿔야 함
	•	SimpleDateFormat은 Date ↔ String 변환을 도와주는 도구

📌 포맷 문자열 예시

패턴	의미	예시
yyyy	연도 (4자리)	2025
MM	월 (2자리)	07
dd	일 (2자리)	21
HH	시 (24시간)	14
mm	분	05
ss	초	30
SSS	밀리초	123
a	오전/오후	PM

📌 날짜 → 문자열

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String str = sdf.format(new Date());
System.out.println(str); // 예: 2025-07-21 15:30:00

📌 문자열 → 날짜

String text = "2002-05-05 13:13:13";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date d = sdf.parse(text); // 문자열을 Date로 변환

📌 시간대(TimeZone) 설정
	•	Date는 내부적으로 UTC 기준, 출력은 JVM의 기본 시간대 (한국은 KST)
	•	UTC 기준으로 파싱하거나 출력하려면 TimeZone 설정 필요

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // 출력/파싱을 UTC 기준으로


⸻

✅ 전체 예제 정리

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC 기준
String str = "1970-01-01 01:00:00";
Date date = sdf.parse(str);

System.out.println(date);            // 출력은 JVM 기준(KST)
System.out.println(date.getTime());  // 3600000 (1시간 = 3600초 = 1000*60*60)



⸻

📘 java.util.Date 주요 메서드 정리

※ Date 클래스는 오래된 클래스이며, 대부분의 세부 메서드는 Deprecated 되었습니다.
하지만 이해를 위해 주요 메서드를 정리합니다.

⸻

✅ 1. 시간 정보 가져오기 (Deprecated)

메서드	설명	주의사항
getYear()	1900년을 기준으로 연도 반환	Deprecated
getMonth()	0~11로 월 반환	Deprecated
getDate()	일 반환 (1~31)	Deprecated
getDay()	요일 반환 (0:일요일 ~ 6:토요일)	Deprecated
getHours()	시 반환 (0~23)	Deprecated
getMinutes()	분 반환 (0~59)	Deprecated
getSeconds()	초 반환 (0~59)	Deprecated

👉 이 메서드들은 가급적 Calendar나 LocalDateTime 등으로 대체해야 합니다.

⸻

✅ 2. 현재 시간 또는 Unix 시간 관련 메서드

메서드	설명
getTime()	1970-01-01 00:00:00 UTC부터 밀리초 반환
setTime(long time)	밀리초 기반 시간 설정


⸻

✅ 3. 비교 및 검사 메서드

메서드	설명
before(Date d)	이 날짜가 d보다 이전인가
after(Date d)	이 날짜가 d보다 이후인가
compareTo(Date d)	날짜 비교 (정렬 시 사용)
equals(Object obj)	날짜가 동일한가 비교


⸻


✅ 6. 문자열 ↔ Date (SimpleDateFormat)

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = sdf.parse("2025-07-21 10:00:00");
String str = sdf.format(date);


⸻
*/
}
