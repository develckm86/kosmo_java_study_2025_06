package com.kosmo;

import java.util.Arrays;

class Student{
    //클래스 변수
    static int count=0; // Student.count 이제만 Student 클래스와 관련이 없다.
    //static 으로 선언된 변수는 독립적으로 데이터로 존재한다. 클래스 이름을 빌려써서 클래스 변수라 부른다.

    // 필드
    int cnt=0;

    int score;
    String name;
    public Student(){}
    public Student(String name){ //객체를 만들때 이름 필드가 존재하도록 강제
        this.name=name;
    }
}
public class L19StaticClassVariable {
    public static void main(String[]args){
        System.out.println("안녕!");
        Student student=new Student();
        student.name="최경민";
        student.score=90;
        Student student1=new Student("홍길동");
        Student student2=new Student("고길동");//데이터가 객체
        //heap 메모리 : GC 쓰지 않는 객체를 삭제 (메모리 걱정 없이 편하게 만들 수 있다.)


        System.out.println(Student.count); //독립적인 데이터기 때문에 바로 호출가능
        //System.out.println(Student.cnt); //Student가 객체가 될때만 데이터로 존재
        //이때 cnt 는 Student 객체에 소속되어서 필드라 부른다.
        Student student3=new Student();
        System.out.println(student3.cnt);
        System.out.println(new Student().cnt);

        //클래스변수(static) 항상 같은 데이터를 공유
        ++Student.count; //1
        ++Student.count; //2
        ++new Student().count; //할수 있지만 권장하지 않는다
        System.out.println(Student.count); //3

        //객체는(new Student()) 서로 독립적이다
        ++student2.cnt; //1
        ++student3.cnt; //1
        System.out.println(student2.cnt);
        System.out.println(student3.cnt);

        //PI 공유데이터(클래스변수의 특징)
        System.out.println(Math.PI); //PI 클래스 변수라 그냥 호출
        //System.out.println(new Math().PI);

        //객체 vs 클래스변수
        //학생 클래스 변수가 저장
        //학생 -> 정호
        //학생 -> 범준
        //독립된 정보를 한개의 데이터가 공유하면 신뢰도가 떨어진다.
        //때문에 클래스 변수는 대체로 상수를 정의한다.
        final  int a=10;
        //a=20;

        int [] arr={1,2,3};
        //System.out.println(new Arrays().toString(arr));
        System.out.println(Arrays.toString(arr));

    }
}
