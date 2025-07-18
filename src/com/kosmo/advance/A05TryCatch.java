package com.kosmo.advance;

public class A05TryCatch {
    public static void main(String[] args) {
        //Exception  예외
        //오류가 발생하는 상황 => 예외
        //컴파일 언어인 자바는 런타임시 발생하는 오류를 예외라 한다.
        int i=10;
        //i="10"; //컴파일 언어는 오류를 미리 발견하고 배포(java->class)하지 않음
        int [] arr={1,2,3};

        try{
            //try 블럭에서 오류가 발생하면  catch 에서 오류를 잡는다.
            i=arr[4];//예외
            System.out.println("안녕!!"); //예외가 발생한 시점 이후 코드는 무시
        }catch (ArrayIndexOutOfBoundsException e){
            //ArrayIndexOutOfBoundsException :배열의 길이가 문제일때
            System.out.println(e.toString());
        }catch (Exception e){
            //Exception : 모든 예외 클래스의 부모, 모든 문제를 해결(==else)
            System.out.println(e.toString());
        }finally {
            System.out.println("무조건 실행되는 블럭!"); //
        }
        //런터임시 오류가 발생하면 프로그램 (jvm main 함수)이 종료 = > 심각한 상황!!!
        // => 개발자가 예외를 예상하고 막을 수 있다.
        System.out.println("내가 실행된다면 종료되지 않음!!!");

    }
}
