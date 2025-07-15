package com.kosmo;
//java.util : 개발자에게 유용한 도구(라이브러리, class)를 제공
import java.util.*;

public class L37Collections {
    public static void main(String[] args) {
        int [] arr=new int[4];//{0,0,0,0}
        System.out.println(Arrays.toString(arr));

        //arr[4]=1; //{0,0,0,0,1} 기대 중 => 오류
        //배열 : 순서와 길이가 있는 데이터
        //Array [] : 처음 만들어진 길이 고정


        List list=new ArrayList();
        //List : 길이가 변경되는 배열?
        list.add(10);
        list.add(10.0);
        list.add(10.0f);
        list.add(10l);
        System.out.println(list);
        System.out.println(list.size()); //arr.length
        System.out.println(list.get(3)); //list의 인덱스 참조, arr[3]
        //System.out.println(list.get(4)); //Array 처럼 없는 것은 참조 불능
        list.add("10");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.remove("10")); //데이터를 찾아서 지움(실패가능)
        System.out.println(list.remove("10.0")); //데이터를 찾아서 지움(실패가능)
        System.out.println(list.remove(0));//인덱스로 지울때는 삭제한 대상이 출력
        System.out.println(list);
        System.out.println(list.contains(10.0));
        System.out.println(list.contains(11));
        //(double) 10; : 수(기본형)를 더블에 맞게 변경
        //(Double) 10; : 객체(자료형)의 타입이 Double이 있냐

        Object [] objArr={10,10.0,10.0f,10l};
        //10.0
        //objArr.contains(10.0);//불가능 => 직접 탐색
        boolean result=false;
        for (int i=0; i<objArr.length; i++){
            if((objArr[i] instanceof Double) && 10.0 == (Double) objArr[i]){
                result=(true);
                break;
            }
        }
        //Array 사용 이유 : 메모리가 절약되서 !!(고급언어일수록 Array가 없는 경우가 존재합니다.)


        List<Integer> listInt=new ArrayList<>();
        listInt.add(10);
        //listInt.add(10.0);
        //listInt.add("10");
        listInt.add(99);
        listInt.add(20);
        listInt.add(-100);
        System.out.println(listInt);
        listInt.sort(null); //오름차순  작은수=>큰수로
        System.out.println(listInt);
        listInt.sort(Comparator.reverseOrder());
        System.out.println(listInt);
        //문자열도 정렬이되나?? (문자=>번호)
        List<String> listStr=new ArrayList<>();
        listStr.add("Banana");
        listStr.add("사과");
        listStr.add("Kiwi");
        listStr.add("Lemon");
        listStr.add("apple");
        listStr.add("Apple"); //대문자가 앞번호 소문자가 뒷번호
        System.out.println(listStr);
        listStr.sort(null);
        System.out.println(listStr);
        //contains,sort,remove,add : List 유용한 함수


        for(String s : listStr){ //index를 알수 없다.
            System.out.println(s);
        }
        System.out.println("향상된 for 반복문 (iterator) 종료");
        for (String s : listStr){
            System.out.println(s);
        }
        System.out.println("향상된 for 반복문은 iterator를 초기화하고 다시 사용");

        Iterator<String> it=listStr.iterator();
        while (it.hasNext()){
            String s=it.next();
            System.out.println(s);
        }
        //it=listStr.iterator();
        System.out.println("while 로 이터레이터(반복자) 호출");
        while (it.hasNext()){ //반복자는 끝으로 이동하면 다시 사용할 수없음
            String s=it.next();
            System.out.println(s);
        }
    }
}
