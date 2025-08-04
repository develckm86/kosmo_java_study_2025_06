package com.kosmo.advance.ex;

public class S14Enum {
    /*

1. enum은 클래스처럼 동작하는 열거형 타입이다
    Java에서 enum은 단순한 상수 집합이 아니라 내부적으로 클래스로 처리되는 참조형 타입입니다.

    예시:

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY
    }


⸻

2. enum 상수는 내부적으로 public static final 객체로 생성된다
    MONDAY, TUESDAY와 같은 상수들은 각각 Day 클래스의 객체로 한 번만 생성되어 공유된다.

    예시:

    Day d = Day.MONDAY;
    // 사실상 Day d = Day.valueOf("MONDAY"); 와 동일


⸻

3. enum은 switch 문에서도 사용할 수 있다
    enum 타입은 switch 문의 조건식에 사용할 수 있는 유일한 사용자 정의 타입이다.

    예시:

    switch (d) {
        case MONDAY -> System.out.println("Start of week");
        case TUESDAY -> System.out.println("Second day");
    }


⸻

4. enum은 생성자를 가질 수 있지만, 외부에서 호출할 수 없다
    enum의 생성자는 자동으로 private로 제한되어 외부에서 직접 생성할 수 없다. 대신 내부에서 상수 정의 시 호출된다.

    예시:

    enum Level {
        LOW(1), MEDIUM(2), HIGH(3);

        private final int code;

        private Level(int code) {
            this.code = code;
        }

        public int getCode() { return code; }
    }


⸻

5. enum은 필드와 메서드를 정의할 수 있다
    클래스처럼 필드와 메서드를 가질 수 있으며, 각 상수마다 다른 값이나 동작을 부여할 수 있다.

    예시:

    System.out.println(Level.HIGH.getCode()); // 출력: 3



    ⸻

    6. values() 메서드로 모든 상수를 배열로 얻을 수 있다
    모든 enum은 컴파일 시 자동으로 values() 메서드가 생성된다.

    예시:

    for (Day d : Day.values()) {
        System.out.println(d);
    }


⸻

7. ordinal() 메서드로 선언 순서(인덱스)를 확인할 수 있다
    enum의 각 상수는 0부터 시작하는 고유한 순번(ordinal) 을 갖는다.

    예시:

    System.out.println(Day.MONDAY.ordinal()); // 0


    ⸻

    8. valueOf(String) 메서드로 이름으로 상수를 얻을 수 있다
    문자열을 이용해 enum 상수를 찾을 수 있으며, 존재하지 않으면 예외가 발생한다.

    예시:

    Day d = Day.valueOf("TUESDAY");


    ⸻

9. 열거형 상수마다 개별 동작을 정의할 수도 있다 (상수별 구현)
    각 상수에 대해 오버라이딩된 메서드를 제공하면 상수별 특성 동작을 만들 수 있다.

    예시:

    enum Shape {
        CIRCLE {
            double area(double r) { return Math.PI * r * r; }
        },
        SQUARE {
            double area(double s) { return s * s; }
        };

        abstract double area(double value);
    }

10. 상수보다 enum을 사용해야 하는 이유

    1. 가독성과 그룹화
    관련된 상수를 하나의 그룹으로 묶어 의미론적으로 표현 가능합니다. 예를 들어, 상태코드를 int 상수로 나열하는 것보다 enum Status { SUCCESS, ERROR }가 더 명확합니다.

    2. 타입 안정성
    int나 String 상수는 다른 값을 넣을 수 있지만, enum은 지정된 값만 허용되어 오류 가능성을 줄입니다.

    3. 추가 기능 확장 용이
    enum은 생성자, 필드, 메서드를 가질 수 있어 상수 이상으로 복잡한 동작이나 속성을 구현할 수 있습니다.

    4. 비교 연산이 간단하고 안전
    ==로 객체 비교가 가능하며, equals보다 더 안전하고 빠릅니다.

    5. switch문과 자연스럽게 연동
    enum은 switch문에서 정확하고 빠르게 동작하며, 예외나 버그 가능성을 줄여줍니다.
*/
}
