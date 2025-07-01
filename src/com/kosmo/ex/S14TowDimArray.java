package com.kosmo.ex;

import java.util.Arrays;

public class S14TowDimArray {
    /*
# 📘 Java 2차원 배열 수업 정리

## ✅ 1. 2차원 배열이란?

> "행(Row)과 열(Column)로 구성된 **배열 안의 배열**"

Java에서는 배열 안에 또 다른 배열을 요소로 갖는 구조로 구현됩니다.

```java
int[][] array = new int[3][2];
// 배열 구조: 3행 2열 → {{0,0}, {0,0}, {0,0}}
```
기본형 => 연산
자료형(배열) => 데이터 관리

---

## ✅ 2. 2차원 배열의 자료 예시

### 📌 실생활 예시

| 예시     | 내용                        |
| ------ | ------------------------- |
| 성적표    | 학생별 과목 점수 (`학생 수 x 과목 수`) |
| 좌석 배치도 | 영화관 좌석 (`행 x 열`)          |
| 지도 (맵) | 게임에서의 좌표 (`Y x X`)        |
| 이미지    | 픽셀 색상 정보 (`세로 x 가로`)      |
| 게임 보드  | 바둑판, 체스판 등 (`행 x 열`)      |

### 📌 코드 예시

```java
// 학생 3명의 3과목 점수
int[][] scoreTwos = {
    {88, 77, 99},     // 학생 1
    {100, 66, 89},    // 학생 2
    {81, 100, 100}    // 학생 3
};
```

---

## ✅ 3. 2차원 배열 탐색 이유

### 🔍 왜 탐색이 필요한가?

* 배열에 저장된 모든 데이터를 **읽거나 수정**하기 위해
* 예: 전체 점수 출력, 과목별 평균 구하기, 특정 값 찾기 등

---

## ✅ 4. 2차원 배열 탐색 방법

> **중첩 반복문(중첩 for문)** 사용

```java
for (int i = 0; i < 배열.length; i++) { //행 탐색
    for (int j = 0; j < 배열[i].length; j++) { //각 열 탐색
        System.out.print(배열[i][j] + " ");
    }
    System.out.println(); // 한 행 출력 후 줄 바꿈
}
```

### 예시

```java
for (int i = 0; i < scoreTwos.length; i++) {
    for (int j = 0; j < scoreTwos[i].length; j++) {
        System.out.print(scoreTwos[i][j] + " ");
    }
    System.out.println();
}
```

---

## ✅ 5. 2차원 배열 선언 방식 정리

| 선언 방법                                      | 설명               |
| ------------------------------------------ | ---------------- |
| `int[][] arr = new int[3][2];`             | 3행 2열의 정수 배열 생성  |
| `String[][] names = new String[2][4];`     | 2행 4열의 문자열 배열 생성 |
| `double[][] data = new double[4][3];`      | 4행 3열의 실수 배열 생성  |
| `char[][] chs = { {'가','나'}, {'다','라'} };` | 선언과 동시에 초기화      |
| `chs = { {'가','나'}, {'다','라'} };`     |  변수에 배열생성(x 오류발생)  |
| `chs = new char[][]{ {'가','나'}, {'다','라'} };`  |  변수에 배열생성  |
선언과 동시에 초기화 : 선언과 동시에 초기값을 대입한다.(리터럴하게 선언)
---

## ✅ 보충 개념: 가변 배열(Jagged Array)

* 행마다 열의 길이가 다른 배열

```java
int[][] jagged = {
    {1, 2},
    {3, 4, 5},
    {6}
};
```

---

## ✅ 요약 정리

| 항목     | 핵심 내용                                       |
| ------ | ------------------------------------------- |
| 사용 목적  | 행과 열 구조의 데이터 저장                             |
| 대표 자료  | 점수표, 지도, 좌석표 등                              |
| 탐색 방법  | 중첩 for문 (`배열[i][j]`)                        |
| 초기화 방식 | 고정형(`new int[행][열]`), 리터럴(`{{...}, {...}}`) |
| 장점     | 구조적, 행/열 접근이 쉬움                             |



# ✅ 2차원 배열 입문 문제 (정답 없음)

## 🔹 배열 예시 (공통 사용)

```java
int[][] scores = {
    {90, 85, 78},   // 학생 1
    {88, 92, 100},  // 학생 2
    {60, 70, 80},   // 학생 3
    {100, 95, 90}   // 학생 4
};
```

---

### 📘 문제 1. 전체 점수 출력하기

위 `scores` 배열을 이용해 **각 학생의 점수**를 모두 출력하시오.
출력 예:

```
학생1: 90, 85, 78
학생2: 88, 92, 100
...
```
for(int i=0; i<scores.length; i++){
    System.out.print("학생"+(i+1)+":");
    for(int j=0; j<scores[i].length; j++){
        System.out.print(scores[i][j]);
        if(j!=scores[i].length-1){
            System.out.print(", ");
        }
    }
    System.out.println();
}
---

### 📘 문제 2. 전체 평균 점수 구하기

배열의 모든 점수의 평균을 구하시오.
(학생, 과목 상관없이 전체 평균)
int sum=0;
int cnt=0;
for(int i=0; i<scores.length; i++){
    for(int j=0; j<scores[i].length; j++){
        sum+=scores[i][j]
        cnt++;
    }
}
System.out.println("전체 평균"+(sum/cnt))

---

### 📘 문제 3. 과목별 총합 구하기

각 \*\*과목별 총합(세로 방향)\*\*을 출력하시오.
출력 예:

```
1과목 총합: ...
2과목 총합: ...
3과목 총합: ...
```

int [] scoreSum=new int[3]; {0,0,0}
for(int i=0; i<scores.length; i++){
    for(int j=0; j<scores[i].length; j++){
        scoreSum[j]+=scores[i][j];
    }
}

---

### 📘 문제 4. 90점 이상인 점수만 출력하기

배열에서 **90점 이상인 점수들만** 찾아서 출력하시오.
출력 예:

```
90 100 100 95 90 ...
```
for(int i=0; i<scores.length; i++){
    for(int j=0; j<scores[i].length; j++){
        if(scores[i][j]>=90){
            System.out.print(scores[i][j]+" ")
        }
    }
}

---

### 📘 문제 5. 최고 점수 구하기

배열에서 가장 높은 점수를 찾아 출력하시오.
출력 예:

```
최고 점수는: 100
```

---
int max=0;
for(int i=0; i<scores.length; i++){
    for(int j=0; j<scores[i].length; j++){
        if(max<scores[i][j]){
            max=scores[i][j];
        }
    }
}
System.out.println(max)


*/
    public static void main(String[] args) {
        int [][]scores={
                {55,66,77,88,99},
                {100,80,70,100,90},
                {89,99,79,555,59},
                {10,20,30,40,50}
        };
        for(int i=0; i<scores.length; i++){
            System.out.print("학생"+(i+1)+":");
            for(int j=0; j<scores[i].length; j++){
                System.out.print(scores[i][j]);
                if(j!=scores[i].length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        int [] scoreSum=new int[5]; //{0,0,0}
        for(int i=0; i<scores.length; i++){
            for(int j=0; j<scores[i].length; j++){
                scoreSum[j]+=scores[i][j];
            }
        }
        System.out.println(Arrays.toString(scoreSum));
        for (int i=0; i<scoreSum.length; i++){
            System.out.println("과목"+(i+1)+"의 합:"+scoreSum[i]);
        }
        int max=0;
        for(int i=0; i<scores.length; i++){
            for(int j=0; j<scores[i].length; j++){
                if(max<scores[i][j]){
                    max=scores[i][j];
                }
            }
        }
        System.out.println(max);

    }
}
