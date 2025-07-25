package com.kosmo.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A16Reader {
    public static void main(String[] args) throws IOException {
        InputStream inputStream=System.in;
        //인코딩 처리 및 2byte씩 받을 수 있는 문자열 입력 스트림
        InputStreamReader reader=new InputStreamReader(inputStream,"utf-8");
        int a;
        String str="";
        StringBuilder sb=new StringBuilder();
        while ( (a=reader.read()) != -1){
            //break : 반복문 종료
            //continue : 반복문의 한구간만 건너뜀
            if((char)a=='\n') break;
            System.out.println(a+":"+(char)a);
            str+=(char)a;
            sb.append((char) a); //문자열을 불변데이터기 때문에 호출하는 즉시 생성
            //안녕
            //50504 //문자을 2byte씩 처리
            //45397
        }
        System.out.println(str);
        //1byte 씩 2byte 씩 문자열 처리하면 귀찮아서 Buffer로 한줄씩 받을 수 있음
        BufferedReader bufferedReader=new BufferedReader(reader);

        str=bufferedReader.readLine();
        System.out.println("버퍼로 받은 한줄 :"+str);


        //**Scanner : BufferedReader 보다 기능이 많고 inputStream 을 바로 변환가능
        //BufferedReader 보다 데이터 변환 속도가 느리고 메모리 차지를 많이 함
        //InputStreamReader 처럼 인코딩 변환이 다양하지 않음
        Scanner scanner=new Scanner(System.in);
        str=scanner.nextLine();
        System.out.println("스캐너로 받은 한줄 :"+str);


        InputStream inputStream1=System.in;
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream1);
        BufferedReader bufferedReader1=new BufferedReader(inputStreamReader);
        //BufferedReader 를 사용하기 위한 과정
        //1byte->2byte-> 2byte 짜리 buffer로 변환


    }
}
