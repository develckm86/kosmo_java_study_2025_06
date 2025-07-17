package com.kosmo;

public class L41StringBuffer {
    public static void main(String[] args) {
        //Array vs List
        //Array가 불변데이터기 때문에 List가 나옴

        //String vs StringBuilder (StringBuffer)
        //String이 불변데이터기 때문에 StringBuffer
        //가변길이의 문자열은 StringBuffer를 사용해야합니다.
        //buffer : 임시저장공간
        StringBuffer sb=new StringBuffer("안녕"); //기본 16개의 buffer를 가짐
        sb.append(" 난 경민이야~"); //append 문지열 += 연산
        sb.append(" 오늘은 비가 많이 오는구나!");
        System.out.println(sb);

        String s="A";
        s+="B"; //"A", "B" ,"AB" :생성된 데이터
        s+="C"; //"A","B,","C", "AB", "ABC"

        sb=new StringBuffer(100); //{'A','\0'.... } 16=>100
        sb.append("A"); // "A"
        sb.append("B"); // "AB"
        sb.append("C"); // "ABC"
        //기존 StringBuffer의 문자열을 추가하거나 삭제하거나 수정
        //insert(3,"") : 특정위치에 문자열 추가
        //delete(1,4) : 삭제
        //replace(0,3,"Hello") : 대체
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        StringBuilder strBuilder=new StringBuilder();
        strBuilder.append("A");
        strBuilder.append("B");
        strBuilder.append("C");
        System.out.println(strBuilder);
        strBuilder.reverse();
        System.out.println(strBuilder);
        //StringBuilder vs StringBuffer  거의 비슷
        //StringBuffer 멀티스레드환경에서 안전 (Vector) : 멀티스레드 배우고 다시 등장할 예정

        //System : 자바를 실행하는 터미널 호출
        long start=System.nanoTime();
        int sum=1+1;
        long end=System.nanoTime();
        System.out.println(end-start); //1+1 이 걸린 시간

        start=System.nanoTime();
        String str="";
        for (int i=0; i<100000; i++){
            str+=i;
        }
        //System.out.println(str);
        end=System.nanoTime();
        System.out.println("문자열 더하기 연산시간:"+(end-start));

        start=System.nanoTime();
        strBuilder=new StringBuilder();
        for (int i=0; i<100000; i++){
            strBuilder.append(i);
        }
        //System.out.println(strBuilder);
        end=System.nanoTime();
        System.out.println("스트링빌터의 더하기 연산시간:"+(end-start));
    }
}
//22939417
//1766958

//1070636750
//2338334