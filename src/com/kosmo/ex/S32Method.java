package com.kosmo.ex;

public class S32Method {
    /*
📘 자바 메서드(Method) 정리

⸻

1. 메서드란?

특정 작업을 수행하는 코드 블록

	•	재사용 가능한 코드 조각
	•	코드의 중복 제거, 기능 분리, 가독성 향상에 사용됨
	•	입력(매개변수)을 받아서 결과(리턴값)를 돌려주거나 단순 실행도 가능

⸻

2. 메서드의 기본 형식

[접근제한자] [static] [리턴타입] 메서드이름(매개변수) {
    // 실행 코드
    return 결과값;
}

구성 요소	설명
접근제한자	public, private 등
static	클래스 메서드 여부 (static 없으면 인스턴스 메서드)
리턴타입	결과의 데이터 타입 (void는 결과 없음)
메서드이름	소문자로 시작하는 동사형 보통 사용 (sum, print, isNum 등)
매개변수	메서드 실행에 필요한 입력값


⸻

3. 메서드의 구성 예시

public static int add(int a, int b) {
    int result = a + b;
    return result;
}

	•	public static → 어디서든 호출 가능, 클래스 메서드
	•	int → 결과값 타입
	•	add(int a, int b) → 정수 2개를 받아 더함
	•	return → 결과 반환 및 메서드 종료

⸻

4. 메서드 호출

int result = add(5, 3);
System.out.println(result); // 8 출력

	•	add(5, 3) → 메서드 실행
	•	결과값을 받아 출력

⸻

5. 반환값이 없는 메서드

public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}

	•	void → 반환값 없음
	•	실행만 하고 끝나는 메서드

⸻

6. 매개변수가 없는 메서드

public static void sayHello() {
    System.out.println("Hello!");
}

	•	괄호 안에 매개변수가 없음
	•	단순히 실행

⸻

7. 메서드 오버로딩 (Overloading)

이름은 같지만 매개변수의 타입이나 개수가 다른 메서드

public static int sum(int a, int b) {
    return a + b;
}

public static int sum(int[] arr) {
    int total = 0;
    for (int num : arr) {
        total += num;
    }
    return total;
}


⸻

8. static 메서드 vs 인스턴스 메서드

구분	설명
static 메서드	클래스 이름으로 직접 호출 가능
인스턴스 메서드	객체를 생성해야 호출 가능

Math.abs(-3); // static 메서드 예


⸻

9. return 키워드
	•	메서드를 즉시 종료하고 값을 반환
	•	void에서는 return;만 가능

if (x < 0) return -1;


⸻

10. 주의사항

주의할 점	설명
return 뒤에 코드 불가	return 이후는 실행되지 않음
main() 메서드 필수	자바 실행의 시작점
static 없는 메서드는 객체 필요	new 로 생성 후 사용


⸻

11. 실습 예시

public static boolean isNum(Object o) {
    return o instanceof Number;
}

System.out.println(isNum(10)); // true
System.out.println(isNum("hello")); // false


⸻

✨ 마무리 요약

키워드	의미
메서드	기능을 수행하는 코드 블럭
매개변수	입력 값
리턴값	결과 값
static	클래스 레벨에서 사용 가능
return	메서드를 종료하고 결과 반환

⸻

📘 자바 메서드 문제 5선

⸻

1. 다음 중 sum 메서드의 리턴 타입으로 올바른 것은?
C
public static ??? sum(int a, int b) {
    return a + b;
}

A. void
B. String
C. int
D. boolean

⸻

2. 다음 중 void 메서드의 특징으로 올바른 것은?
B
A. 값을 반드시 리턴해야 한다
B. 값을 리턴할 수 없다
C. 오직 한 번만 호출할 수 있다
D. static 메서드만 가능하다


⸻

3. 아래 메서드를 호출했을 때 출력 결과는?
"Hello, Java"
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

public static void main(String[] args) {
    greet("Java");
}

정답:

⸻

4. 매개변수로 정수 배열을 받아 배열의 합계를 반환하는 메서드를 작성하시오.

( 직접 작성)
class A{
    int arraySum(int [] arr){
           int arraySum=0;
           for(int i=0; i<arr.length; i++){
                arraySum+=arr[i];
           }
           return arraySum;
    }

    public static void main(String[]args){
        int [] arr={10,9,11,0,-20}
        A a=new A();
        int sum=a.arraySum(arr);

    }
}

⸻

5. 다음 코드의 출력 결과는?
B
public static int multiply(int x, int y) {
    return x * y;
}

public static void main(String[] args) {
    System.out.println(multiply(3, 4));
}

A. 7
B. 12
C. 34
D. 컴파일 오류

⸻

정답: 1.C, 2.B, 3.Hello, Java,
4.public static int sum(int[] arr) {
    int total = 0;
    for (int i; i<arr.length; i++) {
        total += i;
    }
    return total;
}
5.B
⸻
*/
}
