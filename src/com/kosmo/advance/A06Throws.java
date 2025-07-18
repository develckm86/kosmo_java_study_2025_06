package com.kosmo.advance;

public class A06Throws {
    //이 함수는 위험하니까 예외처리해!!(강제)
    //throws Exception : 이 함수를 사용하려면 try catch로 예외처리해!!
    public static int sum(String a, String b) throws Exception{
        int sum=0;
        //"13"+"14"="1314"
        //"13"=>13
        //"14"=>14
        //13+14=17
        int i=Integer.parseInt(a);
        int i2=Integer.parseInt(b);
        sum=i+i2;
        return sum;
    }
    //main 은 최종사용자기 때문에 예외 위임은 소용 없다.
    //main 은 코드를 실행하는 어플이기 때문에 try catch로 예외를 처리해야한다.
    public static void main(String[] args){

        try {
            int sum= sum("10","20");
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("수를 입력하세요!! ");
        }
    }
}
