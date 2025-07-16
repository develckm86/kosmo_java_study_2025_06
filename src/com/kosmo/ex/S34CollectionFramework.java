package com.kosmo.ex;

public class S34CollectionFramework {
    /*

자바의 Collections Framework

1. Collections Framework란?

	•	자바에서 데이터를 저장하고 관리하는 표준화된 자료구조의 집합
	•	List(순서가 있는 자료인데 길이변경 가능), Set(순서가 없고 중복을 제거하는 자료), Map(Key(Set)와 Value로 된 자료) 인터페이스들과 이를 구현한 다양한 클래스들로 구성
	•	데이터의 추가, 삭제, 검색, 정렬 등을 효율적으로 처리할 수 있도록 지원

⸻

2. 주요 인터페이스

2.1 List
	•	순서와 길이가 있음
	•	대표 클래스: ArrayList*, LinkedList, Vector
	•	주요 메서드: add(), get(), remove(), size()

2.2 Set
	•	순서 없음, 중복 불허
	•	대표 클래스: HashSet, LinkedHashSet(순서는 없지만 이전자료가 다음자료를 참조), TreeSet
	•	주요 특징:
	•	HashSet: 순서 없음
	•	LinkedHashSet: 입력 순서 유지
	•	TreeSet: 정렬된 상태 유지 (Comparable 또는 Comparator 필요)

2.3 Map
	•	Key-Value 쌍으로 저장, Key는 중복 불가
	•	대표 클래스: HashMap, LinkedHashMap, TreeMap, Hashtable
	•	주요 메서드: put(), get(), remove(), containsKey()

⸻

3. 주요 구현 클래스

인터페이스	                    구현 클래스	                            특징
List	                    ArrayList	                            배열 기반, 인덱스로 접근 빠름
	                        LinkedList	                            연결 리스트 기반, 삽입/삭제가 빠름

Set	                        HashSet	                                순서 없음, 빠른 검색
                            TreeSet	                                자동 정렬

Map	                        HashMap	                                빠른 검색, 순서 없음
	                        TreeMap	                                자동 정렬된 키 저장
	                        LinkedHashMap	                        입력 순서 유지


⸻

4.                  Array 배열            List 리스트

도움되는 유틸 클래스     Arrays 	             Collections
길이                 고정된 크기	         동적으로 크기 조절 가능
아이템                같은 타입만 저장	     제네릭(Generic)으로 타입 제한
반복탐색              배열 길이로 반복 필요	 iterator 등 사용 가능


⸻


6. Iterable, Iterator
    •   Iterable 을 부모로 갖는 List, Set, Queue의 자식 클래스만 가능
	•	Iterable 인터페이스: for-each 루프에 사용 가능
	•	Iterator: 순차 접근, hasNext(), next()

⸻

✅ 이터레이터(Iterator)와 향상된 for문(for-each)

    1. Iterator
        •	컬렉션을 순회하기 위한 객체 기반 반복자
        •	hasNext(), next() 메서드 사용
        •	반복 중 요소 삭제 가능

    Iterator<String> it = list.iterator();
    while (it.hasNext()) {
        String item = it.next();
        if (item.equals("apple")) it.remove();
    }

    ⸻

    2. 향상된 for문 (for-each)
        •	더 간단한 반복문 형태
        •	모든 요소를 순서대로 접근할 때 유용
        •	삭제는 불가능
    for (String item : list) {
        System.out.println(item);
    }

    //컴파일러가 자동완성해주는 코드
    for(Iterator<String> it=list.iterator(); it.hasNext(); String item=it.next())


⸻

7. 제네릭(Generic)과 함께 사용
	•	타입 안정성과 코드 재사용성을 높이기 위해 제네릭과 함께 사용

List<String> list = new ArrayList<>();
Map<Integer, String> map = new HashMap<>();



⸻

8. 정렬 예제

List<String> list = new ArrayList<>();
list.add("banana");
list.add("apple");
Collections.sort(list); // 오름차순 정렬


⸻

✅ Java Collections 기초 복습 문제 (총 20문항)

📘 ArrayList (1~6)
C
	1.	ArrayList의 특징으로 올바른 것은?

A. 크기 변경이 불가능하다
B. 중복된 값을 허용하지 않는다
C. 순서를 유지하며 중복을 허용한다
D. Map 구조로 데이터를 저장한다

	2.	다음 중 ArrayList에 값을 추가하는 메서드는?
B
A. put()
B. add()
C. insert()
D. append()

	3.	ArrayList의 크기를 얻는 메서드는?
C
A. length()
B. count()
C. size()
D. getSize()

	4.	다음 코드 실행 결과는?
B
ArrayList<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");
System.out.println(list.get(1));

A. apple
B. banana
C. 1
D. 오류 발생

	5.	다음 중 ArrayList에서 특정 인덱스 값을 제거하는 방법은?
B
A. list.delete(1)
B. list.remove(1)
C. list.remove(“1”)
D. list.clear(1)

	6.	ArrayList에 존재하지 않는 값(Object)을 삭제하려고 하면?
C
A. 오류 발생
B. 프로그램 종료
C. 아무 일도 일어나지 않음 //false를 반환
D. 자동으로 삽입됨

⸻


📙 HashSet (7~11)

	7.	HashSet의 가장 큰 특징은?
C
A. 키-값 구조
B. 정렬된 출력
C. 중복 불가
D. 인덱스로 접근 가능

	8.	다음 중 HashSet에 값을 추가하는 코드는?
B
A. set.put(“apple”)
B. set.add(“apple”)
C. set.push(“apple”)
D. set.insert(“apple”)

	9.	HashSet<String>에 "apple"을 두 번 넣으면 어떻게 되나?
C
A. 둘 다 저장된다
B. 오류 발생
C. 한 번만 저장된다
D. 마지막 것만 저장된다

	10.	다음 중 HashSet에서 값을 제거하는 메서드는?
C
A. delete()
B. clear(“apple”)
C. remove(“apple”)
D. erase(“apple”)

	11.	HashSet은 요소를 어떤 기준으로 저장하는가?
C
A. 삽입 순서
B. 알파벳 순
C. 해시값
D. 인덱스

⸻

📗 HashMap (12~16)

	12.	HashMap은 어떤 방식으로 데이터를 저장하는가?
B
A. 값만 저장
B. 키-값 쌍으로 저장
C. 정렬된 순서로 저장
D. 인덱스를 기준으로 저장

	13.	다음 중 HashMap에서 값을 추가하는 코드로 알맞은 것은?
B
A. map.add(“id”, “user1”)
B. map.put(“id”, “user1”)
C. map.insert(“id”, “user1”)
D. map.set(“id”, “user1”)

	14.	HashMap<String, String>에서 "id"에 해당하는 값을 가져오는 방법은?
A
A. map.get(“id”)
B. map[“id”]
C. map.id
D. map.fetch(“id”)

	15.	다음 중 존재하지 않는 키를 제거하려고 할 경우 어떤 일이 일어나는가?
B
A. 오류 발생
B. null 반환
C. 무시됨
D. 빈 문자열 반환

	16.	HashMap에서 모든 key를 순회하려면 어떤 메서드를 사용해야 하나?
C
A. map.values()
B. map.entrySet()
C. map.keySet()
D. map.list()

⸻

📒 Iterator (17~20)

	17.	Iterator에서 다음 요소가 남아있는지 확인하는 메서드는?
B
A. hasElement()
B. hasNext()
C. next()
D. isEmpty()

	18.	Iterator에서 다음 요소를 꺼내는 메서드는?
C
A. getNext()
B. move()
C. next()
D. fetch()

	19.	Iterator는 한 번 다 순회한 후 다시 쓸 수 있는가?
B
A. 가능
B. 불가능
C. 조건부 가능
D. 자동 재생

	20.Iterable을 구현한 클래스의 향상된 for문(for-each)은 내부적으로 어떤 원리를 사용하는가?
C
A. 배열 인덱스
B. HashMap
C. Iterator
D. Thread

⸻


✅ Java Collections 구현 문제 5제 (ArrayList, HashSet, HashMap, Iterator)

⸻

1. ArrayList 요소 추가 및 출력

문제:
ArrayList<Integer>에 5개의 숫자 10, 20, 30, 40, 50을 추가하고, 전체 요소를 출력하시오.

// 출력 예시: 10 20 30 40 50

ArrayList<Integer> list=new ArrayList<>();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.add(50);
System.out.println(list); //[10,20,30,40,50]

for(int i: list){
    System.out.print(i+" ");
}//10 20 30 40 50

⸻

2. HashSet 중복 제거 확인

문제:
HashSet<String>을 만들어 "apple", "banana", "apple", "kiwi"를 추가하고, 전체 요소를 출력하시오.
(출력된 요소는 순서와 상관없지만 중복이 없어야 함)
HashSet<String> set=new HashSet<>();
set.add("apple");
set.add("banana");
set.add("apple");
set.add("kiwi");
System.out.println(set);//[ banana, kiwi, apple]
⸻

3. HashMap을 사용한 ID-비밀번호 저장 및 조회
HashMap<String, String> map1=new HashMap<>();
map.put("user1","1234");
map.put("user2","abcd");

System.out.println(map.get("user1"));

문제:
사용자의 ID와 비밀번호를 HashMap<String, String>에 저장하시오.
	•	ID: "user1", 비밀번호: "1234"
	•	ID: "user2", 비밀번호: "abcd"

그 후 "user1"의 비밀번호를 출력하시오.

⸻

4. Iterator를 사용한 ArrayList 반복 출력

문제:
ArrayList<String>에 "Java", "Python", "C++"를 추가하고,
Iterator를 사용하여 모든 요소를 출력하시오.
ArrayList<String> list=new ArrayList<>();
list.add("java");
list.add("Python");
list.add("C++");

Iterator<String> it=list.iterator();
while(it.hasNext()){
    String s=it.next();
    System.out.println(s);
}


⸻

5. HashMap 전체 순회 (entrySet 사용)
HashMap<String, String> map=new HashMap<>();
map.put("name","Alice")
map.put("email","alice@example.com")

Set<Map.Entry<String,String>> entrySet= map.entrySet();
Iterator<Map.Entry<String,String>> entrySetIt=entrySet.iterator();

while(entrySetIt.hasNext()){
    Map.Entry<String,String> entry =entrySetIt.next();
    System.out.println(entry.getKey()+":"+entry.getValue());

}

for(Map.Entry<String, String> entry : map.entrySet() ){
    System.out.println(entry.getKey()+":"+entry.getValue());
}

문제:
HashMap<String, String>에 다음 데이터를 저장하고
entrySet()을 이용하여 모든 key와 value를 출력하시오.
	•	"name" → "Alice"
	•	"email" → "alice@example.com"

// 출력 예시:
name = Alice
email = alice@example.com


⸻

⸻

✅ 정답 목록
	1.	C	2.	B	3.	C	4.	B	5.	B	6.	C	7.	C	8.	B
	9.	C	10.	C	11.	C	12.	B	13.	B	14.	A	15.	B	16.	C
	17.	B	18.	C	19.	B	20.	C

⸻

✅ 구현 문제 정답

⸻

1. ArrayList 요소 추가 및 출력

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}


⸻

2. HashSet 중복 제거 확인

import java.util.HashSet;

public class Q2 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");  // 중복
        set.add("kiwi");

        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}

※ 출력 순서는 보장되지 않습니다 (HashSet 특성상).

⸻

3. HashMap ID-비밀번호 저장 및 조회

import java.util.HashMap;

public class Q3 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user1", "1234");
        map.put("user2", "abcd");

        System.out.println(map.get("user1")); // 1234
    }
}


⸻

4. Iterator로 ArrayList 출력

import java.util.ArrayList;
import java.util.Iterator;

public class Q4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}


⸻

5. HashMap 전체 출력 (entrySet 사용)

import java.util.HashMap;
import java.util.Map;

public class Q5 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Alice");
        map.put("email", "alice@example.com");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}


⸻
*/
}
