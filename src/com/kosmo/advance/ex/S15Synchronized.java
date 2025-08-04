package com.kosmo.advance.ex;

public class S15Synchronized {
    /*
    *
⸻

1. 코드 간의 비동기 실행 현상과 해결 (Thread 간의 실행 순서 문제)
	•	설명: 멀티스레드에서는 각 스레드가 독립적으로 실행되므로, 어떤 코드가 먼저 실행될지 보장할 수 없습니다. 이것이 “코드 간의 비동기 실행”입니다.
	•	해결 방법: join() 메서드를 통해 특정 스레드의 작업이 끝날 때까지 기다릴 수 있습니다.
	•	예제:

        Thread t1 = new Thread(() -> {
            System.out.println("작업1 수행");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("작업2 수행");
        });

        t1.start();
        t1.join(); // t1이 끝날 때까지 대기
        t2.start(); // 그 후에 t2 실행



⸻

2. 공유 자원의 비동기 문제 (데이터 일관성 문제)
	•	설명: 여러 스레드가 동시에 하나의 공유 변수나 객체를 수정할 경우, 순서와 타이밍에 따라 잘못된 결과가 발생할 수 있습니다.
	•	해결 방법: synchronized 키워드 또는 AtomicInteger 같은 동기화된 클래스 사용.
	•	예제 (synchronized 사용):

        class Counter {
            private int count = 0;

            public synchronized void increment() {
                count++;
            }

            public int getCount() {
                return count;
            }
        }



⸻

3. synchronized 키워드는 어디에 사용할 수 있는가?
	•	설명: synchronized는 메서드나 특정 블록에 사용할 수 있으며, 객체 단위(lock)을 기준으로 동작합니다. 이를 통해 공유 자원의 접근을 한 번에 하나의 스레드만 허용할 수 있습니다.
	•	예제:

        public synchronized void method() {
            // 메서드 전체가 동기화됨
        }

        public void blockMethod() {
            synchronized (this) {
                // 특정 블록만 동기화
            }
        }



⸻

4. 멀티스레드의 실제 적용 예 (공유 자원 문제 발생 예시)
	•	설명: 여러 스레드가 동시에 증가시키는 int 변수는 동기화하지 않으면 정확한 값을 보장하지 못합니다.
	•	예제 (잘못된 예):

        class Counter {
            int count = 0;

            public void increment() {
                count++;
            }
        }

        // 여러 스레드에서 동시에 increment() 호출하면 예상보다 작은 결과 나올 수 있음



⸻

5. 동기화된 클래스 사용 (AtomicInteger)
	•	설명: AtomicInteger는 내부적으로 CAS(compare-and-swap) 연산을 사용하여 스레드 안전하게 값을 수정할 수 있게 해줍니다.
	•	예제:

    AtomicInteger atomicCount = new AtomicInteger();

    atomicCount.incrementAndGet(); // 스레드 안전하게 증가
    //수업에서 안전하게 동기화 되지 않은 이유는 AtomicInteger 에서 제공하는 동기화된 함수를 사용하지 않았기 때문



*/
}
