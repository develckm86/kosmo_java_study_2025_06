package com.kosmo.advance;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class A12LocalDate {
    public static void main(String[] args) {
        //최초의 시간 객체 java.util.Date 가 사용하기 불편해서
        //1. 문자열 파싱이 편리함

        //java 8 에서 java.time.* 패키지 도입
        //LocalDate(날짜), LocalDateTime(날짜+시간), LocalTime(시간,날짜 무시)
//        Date now=new Date();
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);//2025-07-21 iso 규칙으로 출력
        //ISO-Date 표기법 : 문자열로 날짜를 표기하는 공통된 규칙
        //2025-07-21T14:30:00  년-월-일T시:분:초
        //2025-07-21
        //14:30:00
        localDate=LocalDate.parse("2002-05-05"); //yyyy-MM-dd
        System.out.println(localDate);

        localDate=LocalDate.of(2012,12,25);
        System.out.println(localDate);
        //LocalDate 년 월 일만 저장


        //LocalTime
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime); //14:45:40.553148
        localTime=LocalTime.parse("12:01:23");//HH:mm:ss.S
        //밀리초 : 1/1000초
        //나노초 : 1/1000밀리초
        localTime=LocalTime.parse("12:01:23.0000001");
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        localTime=LocalTime.of(12,33,44,111);
        System.out.println(localTime);
        //데이터베이스(데이터저장) => 가져온 데이터를 Local* 로 파싱하면 편리함
        // 날짜,시간,Timestamp(유닉스시간)
        //날짜=> LocalDate
        //시간 => LocalTime
        //Timestamp => LocalDateTime
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);//2025-07-21T14:55:09.112636 =>ISO
        //parse
        //of
        System.out.println(localDateTime.getDayOfWeek()); //MONDAY
        //DateTimeFormatter : 심플데이트포맷 처럼 localDateTime 의 문자열 표기 변경
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String dateStr=localDateTime.format(dtf);
        System.out.println(dateStr);


         //2025년 7월의 마지막 일
        System.out.println(localDate.lengthOfMonth());
        //해당 달의 길이 == 해당 달의 마지막 일 (LocalDate)
        //LocalDate는 LocalDateTime 에서 시간만 제거
        //LocalDateTime.toLocalDate() => LocalDate

        System.out.println(localDateTime.toLocalDate().lengthOfMonth());
        System.out.println(localDateTime.toLocalTime());

        //계산 날짜간의 비교나 계산
        //LocalDate 는 배열처럼 불변데이터

        LocalDate localDate3=localDate.plusDays(3); //3일 더하기
        //3일을 더한 새로운 데이트 반환
        System.out.println(localDate);
        System.out.println(localDate3);


    }
}
