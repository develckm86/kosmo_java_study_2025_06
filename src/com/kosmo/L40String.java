package com.kosmo;

public class L40String {
    public static void main(String[] args) {

        //문자열
        String s="안녕"; //문자열
        char [] s2={'안','녕'}; //"안녕" 을 선언하면 생성되는 데이터
        //문자열 == 배열 (공정길이,불변데이터)
        s+="잘가";
        System.out.println(s); //"안녕" 따로 "잘가" 따로 "안녕잘가" 따로 생성
        //"AB"+"CD" => "ABCD"

        // +, concat() : 배열을 더하는 함수의 이름
        s=s.concat("!");
        s=s+"~";
        System.out.println(s);

        //문자열 더하기(+) 연산은 수의 더하기 연산보다 우선순위가 높다(먼저 연산)
        System.out.println("문자열"+2*2); //문자열4
        System.out.println("문자열"+2+2); //"문자열"+(2=>"2") =>"문자열2"+2=>문자열22
        System.out.println("문자열"+(2+2)); //"문자열"+(2=>"2") =>"문자열2"+2=>문자열22

        //{}
        //"" : 문자열의 리터럴(있는 그대로) 표기법
        //기본형은 무조건 리터럴 표기 : 10,  10l, 10,0, 10.0f, true,false, 'd',

        //문자열 리터럴 표기법을 사용하면....
        //**같은 문자열을 새로만들면 새로만들지 않고 기존의 문자열을 참조
        // 문자열을 많이 사용하기 때문에 메모리를 절약하기 위해

        System.out.println("안녕"=="안녕"); //문자열,배열은 불변
        System.out.println("안녕"==new String("안녕")); //문자열,배열은 불변


        //문자열의 유용한 함수들
        String str="ABCDEFG"; //{'A','B','C'...}
        //Array[index], List.get(index), String.charAt(index)
        System.out.println(str.charAt(2));
        System.out.println(str.length()); //length,size()
        System.out.println(str.contains("E"));
        System.out.println(str.contains("Z"));
        System.out.println(str.contains("AB")); //==List
        System.out.println(str.substring(1,3)); //==List.subList()
        System.out.println("str.substring(5,7): "+str.substring(5,7));
        System.out.println("str.substring(2): "+str.substring(2));
        //"FG"
        //삭제 : x  List.remove()
        //수정 : x  List.set(index,Obj)
        //더하기 : x  List.add(Obj)
        //전체삭제 : x  List.clear()
        //정렬 : x List.sort()
        //반복자(Iterator) : x List.iterator()

        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+", ");
        }
        //for(char c : str){} //for each(==향상된 for)
        //str.iterator();

        System.out.println();
        //Array 반복자가 없음
        int [] arr={10,20,30};
        for (int n:arr){ //컴파일러가 상상해서 (인덱스 참조 반복문으로 )자동완성
        //for(int i=0; i<arr.length; i++){int n=arr[i]
            System.out.print(n+", ");
        }
        //subString

    }
}
