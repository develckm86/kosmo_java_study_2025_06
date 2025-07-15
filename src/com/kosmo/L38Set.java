package com.kosmo;

import java.util.*;

public class L38Set {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>(); //Hash 알고리즘으로 구현된 Set
        //hashcode(데이터의 주소)로 같은 아이템을(중복) 제거 HashSet
        //자료형 데이터는 equals 로 같은 데이터를 제거
        set.add(5);
        set.add(5);
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(30);
        set.add(5);
        System.out.println(set); //[20, 5, 10, 30]
        //set 인덱스가 없다.
        //set.get(1); //오류
        System.out.println(set.contains(20));
        System.out.println(set.contains(21));
        System.out.println(set.remove(10)); //remove(index) : 없다.

        //반복자
        Iterator<Integer> it=set.iterator(); //반복자 초기화 (생성)
        // it.pointer=> [20, 5, 30 *=>30] ??
        // it.hasNext() : 포인터 다음에 아이템이 있냐?
        // it.next() : 이동하고 아이템 반환
        System.out.println("///////////이터레이터 while////////////");
        while (it.hasNext()){
            int i=it.next();
            System.out.println(i);
        }
        System.out.println("///////////향상된 for////////////");
        for(int i : set){
            System.out.println(i);
        }
        System.out.println(set.size());

        //add(o),remove(o),contains(o),size(), clear():모든요소지우기,isEmpty(),iterator() 반복자 생성
        //없는것 : get(i),remove(i)


        Set<String> setStr=new HashSet<>();

        setStr.add("안녕"); //String.equals 가 구현되어 있어서 Set 중복제거합니다.
        setStr.add("안녕"); //==
        setStr.add(new String("안녕"));
        //"안녕" new String("안녕") 은 저장된 주소가 다름 (Set 은 자료형 데이터를 equals 로 제거)

        setStr.add("잘가");
        setStr.add("식사 맛있게 하세요~^^");
        System.out.println(setStr);
        //Map
    }
}
