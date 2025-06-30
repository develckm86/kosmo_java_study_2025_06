package com.kosmo;

public class L10Char {
    public static void main(String[] args) {
        char c='A'; //문자표의 번호 크기가 (2, 4 byte)
        //아스키코드 0~127 : 영문자+키보드 문자표 (컴퓨터에서 사용하기 위해 최초로 만들어짐)
        //모든 문자표는 아스키코드를 포함
        //MS949 : 윈도우 운영체제에서 사용
        //유니코드 : 국제표준 문자표 (utf-8 (1~4), utf-16 (2 or 4))
        //utf-8 : 1~4 문자를 표현, 이때 한글은 3byte 😍 이모지 4byte (일반적인 문서)
        //utf-16 : 2 or 4 바이트로 문자 데이터를 저장  한글 2byte 😍 이모지 4byte (java)
        System.out.println((int)'A'); //65
        System.out.println((int)'가'); //44032 => 16진수
        // FF 1111 1111 1byte
        // A1F2  2byte
        //Integer : int 기본형을 돕는 랩퍼클래스
        System.out.println(Integer.toHexString(44032)); //ac00
        //c='😍';

        //char c2='😍'; //자바는 문자를 2바트까지 저장 가능합니다.
        String s="\uD83D\uDE0D";
        // \uD83D :유니코드
        //자바의 문자는 2바이트 고정크기다.

        char u='\uAAAA';
        System.out.println(u); //ꪪ

        char n=80;
        System.out.println(n);
        n=60000;
        System.out.println(n);

    }
}
