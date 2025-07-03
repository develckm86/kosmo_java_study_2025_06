package com.kosmo;

import java.util.Arrays;

public class L17ClassObject2 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        System.out.println(nums.toString()); // [].toString()
        //toString() 기본값 : 데이터의 타입 + 객체가 저장된 주소 위치
        //toString : 객체의 정보를 출력하는 함수
        //Arrays : 배열을 돕는 클래스(필드,메서드)
        System.out.println(Arrays.toString(nums));//[1, 2, 3, 4]
        System.out.println(Integer.toHexString(2222));//8ae

        Calculator c=new Calculator();
        Calculator c2=new Calculator("키티 계산기");
        System.out.println(c);//com.kosmo.Calculator@3feba861
        System.out.println(c.toString());//com.kosmo.Calculator@3feba861
        System.out.println(c.name);
        System.out.println(c2.name);
        int [] arr={111,-222,2000,333,123};
        int sum=c.arrSum(arr);
        System.out.println(sum);

    }
}
// class  : 필드로 자료만 저장하면 할 수 있는 것이 별로없어.
// 자료가 동작이 있으면 할 수 있는 것 이 더 많겠어!! => 메서드
// 메서드
// 1. 매개변수를 받는다.() => 동작을 제어, 동작에 필요한 데이터를 제공
// 2. 자신만의 영역이 필요 =>scope {} 제공
// 3. 메서드의 이름이 있어야 호출이 가능
// 4. 결과를 반환해야한다. => return과 반환타입을 작성할 수 있어야한다.

class Calculator{
    String name=""; //필드 : 클래스 전역에 선언된 변수
    public Calculator(){}
    //생성자 : 객체를 만들때 호출되는 것,  클래스이름 (파라미터){영역}
    public Calculator(String name){
        //this.name : 필드 접근자 (객체 자신을 접근),
        // 변수나 파라미터의 이름이 필드와 같을 때 사용
        //객체의 필드인 name을 바꾸고 싶다
        //== 생성자의 매개변수(받아온 데이터)로 필드를 재정의(바꾼다)하고 싶다,
        this.name=name;
    }
    //생성자는 파라미터(매개변수)가 다른 것을 만들 수 있다.

    void a(){
        int a=20;
    }
    int b(){
        int b=30;
        //b+=a; //형제 영역의 변수는 접근 불가능
        return b;
    }
    int arrSum(int [] arr){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
}

//class A{}