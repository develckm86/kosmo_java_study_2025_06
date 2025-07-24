package com.kosmo.advance.ex;

public class S07InputOutStream {
    /*
⸻

물론입니다. 기존 내용을 바탕으로 조금 더 깊이 있으면서도 쉽게 이해할 수 있도록 보강한 설명을 아래에 정리해드릴게요.

⸻

- 1. 입출력 스트림 개요

	•Stream(스트림)이란?

    데이터를 순차적으로, 한 방향으로 흘려보내는 데이터 통로를 말합니다.
    즉, 어디선가 데이터를 받아오거나, 어디론가 데이터를 보내는 과정 전체를 추상화한 개념입니다.

    자바에서 스트림은 기본적으로 단방향이며,
    데이터는 **한 번에 한 바이트(또는 문자)**씩 흐름을 따라 이동합니다.

    만약 스트림이 없다면, 데이터를 매번 한 바이트씩 직접 읽고
    “지금 어디까지 읽었는지”를 매번 추적해야 하며,
    이런 작업은 매우 번거롭고 비효율적입니다.

    스트림을 사용하면 이런 처리를 자바가 자동으로 관리해주기 때문에
    개발자는 흐름만 신경 쓰면 되도록 단순화됩니다.

- 비유로 이해하기
	•	스트림은 데이터가 흐르는 “수도관”
	•	입력 스트림은 수돗물을 틀어 들여오는 것
	•	출력 스트림은 물을 밖으로 흘려보내는 것

⸻

- 스트림의 방향성
	•	입력(Input) 스트림
        외부(파일, 키보드, 네트워크 등)에서 데이터를 읽어와 프로그램 내부로 가져오는 흐름
            예:
            •	키보드에서 사용자 입력 받기
            •	파일에서 데이터 읽기
            •	서버로부터 응답 받기
            •	출력(Output) 스트림
        프로그램 내부에서 생성된 데이터를 외부(파일, 화면, 네트워크 등)로 보내는 흐름
            예:
            •	파일에 데이터 저장
            •	콘솔에 출력
            •	네트워크를 통해 데이터 전송


- 스트림은 단방향이다
	•	스트림은 입력용과 출력용이 따로 존재
	•	InputStream / OutputStream
	•	Reader / Writer
	•	양방향 통신을 하려면 두 개의 스트림을 사용해야 함
	•	예: 소켓 통신에서는 getInputStream()과 getOutputStream()을 따로 사용

⸻

- 스트림의 핵심 특징 요약
	•	순차적 처리: 데이터를 한 번에 하나씩 읽고 씀 (대용량 처리에 적합)
	•	단방향 흐름: 입력과 출력은 별도의 스트림
	•	다양한 출처와 목적지 지원: 파일, 네트워크, 메모리, 콘솔 등
	•	보조 스트림 가능: Buffered, Data, Object 등 성능 향상 및 기능 확장 가능

⸻

- 예시 흐름

텍스트 파일에서 읽어 화면에 출력

[파일] → FileReader → BufferedReader → 프로그램 → System.out → [화면 출력]

소켓 통신 예시

[클라이언트 프로그램]
  ↓ OutputStream           ↑ InputStream
[서버 프로그램]


⸻

⸻
⸻

2. 스트림의 종류
	•	방향 기준
        •	입력 스트림 (InputStream, Reader)
        •	출력 스트림 (OutputStream, Writer)

	•	데이터 단위 기준
        •	바이트 스트림 (1바이트 단위)
            •	InputStream, OutputStream 계열
            •	주로 이미지, 영상, 오디오, 바이너리 파일 등 처리

        •	문자 스트림 (2바이트 단위)
            •	Reader, Writer 계열
            •	주로 텍스트 데이터 처리

⸻

3. 주요 클래스 구조
	•	InputStream / OutputStream (추상 클래스) : 1byte씩 문자열을 처리
        •	FileInputStream, FileOutputStream : 파일에 문자열을 바이트 단위로 저장및 읽기
        •	BufferedInputStream, BufferedOutputStream : 버퍼를 사용해 입출력 성능 향상
        •	ObjectInputStream, ObjectOutputStream : 객체 단위로 읽고 쓰기 (직렬화 필요)

	•	Reader / Writer (추상 클래스) : 2byte씩 문자열 처리
        •	FileReader, FileWriter : 파일에 문자열을 바이트 단위로 저장및 읽기
        •	BufferedReader, BufferedWriter : 버퍼로 한줄씩(readLine) 읽고 쓰기 가능
        •	InputStreamReader, OutputStreamWriter : 바이트 스트림을 문자 스트림으로 변환 (인코딩 설정 가능)

⸻

4. 기본 예제: 파일에 문자열 저장 및 읽기

4-1. FileWriter  (문자 스트림)
    try (FileWriter writer = new FileWriter("hello.txt")) {
        writer.write("안녕하세요\nJava 입출력 수업입니다.");
    } catch (IOException e) {
        e.printStackTrace();
    }

4-1. FileReader (문자 스트림)
    try (FileReader reader = new FileReader("hello.txt")) {
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }



⸻

4-2. FileInputStream (바이트 스트림)

    try (FileOutputStream fos = new FileOutputStream("byte.txt")) {
        fos.write("Byte Stream 예제입니다.".getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }

4-2.  FileOutputStream (바이트 스트림)

    try (FileInputStream fis = new FileInputStream("byte.txt")) {
        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


⸻

5. 보조 스트림 (Buffered)
	•	입출력 성능 향상
	•	BufferedReader → readLine() 지원
    •	BufferedInputStream은 내부에 **버퍼(기본 8192바이트)**를 두어 여러 바이트를 한 번에 읽고 처리함으로써 입출력 성능을 높임
    •	BufferedInputStream은 바이트 스트림이므로 텍스트 파일도 읽을 수 있지만,한글이 깨질 수 있으므로 문자 스트림을 쓰거나,InputStreamReader를 이용한 인코딩 처리가 필요합니다.


FileReader fr=new FileReader("data.txt");
BufferedReader br = new BufferedReader(fr);
String line;
while ((line = br.readLine()) != null) {
    System.out.println(line);
}



FileInputStream fis = new FileInputStream("sample.txt");
BufferedInputStream bis = new BufferedInputStream(fis);
//InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//BufferedInputStream bis = new BufferedInputStream(isr);
int data;
while ((data = bis.read()) != -1) {
    System.out.print((char) data); // 바이트 → 문자로 출력
}

⸻

6. 객체 직렬화
	•	객체를 저장하고 다시 복원할 때 사용
	•	ObjectOutputStream, ObjectInputStream
	•	클래스는 implements Serializable 필요

⸻

- 직렬화(Serialization)란?
	•	직렬화(Serialization): 객체(Object)를 바이트 형태로 변환하여 저장하거나 전송할 수 있게 만드는 과정
	•	역직렬화(Deserialization): 바이트 데이터를 다시 객체로 복원하는 과정

⸻

- 직렬화가 필요한 이유
    **사용자가 만든 객체(Class 인스턴스)**는 내부 구조가 복잡하므로
    그 자체를 파일이나 네트워크로 직접 저장하거나 전송하려면
    객체 전체를 바이트 형태로 바꾸는 “직렬화” 과정이 꼭 필요합니다.

- 대표적인 직렬화 사용 사례
	•	1. 파일 저장용 직렬화 (ObjectOutputStream)
        → 객체를 .ser 같은 바이너리 파일로 저장
        → 학습용이나 내부 캐시 등에서 사용
	•	2. 네트워크 전송용 직렬화 (Socket, RMI)
        → 서버 간 데이터 객체 전송 시
        → 자바 RMI(Remote Method Invocation)는 객체 직렬화 필수
	•	3. DB 저장 / ORM (예: JPA)
        → 객체를 DB로 옮기기 위해 상태를 분해하고 직렬화(영속화)
        → JPA는 내부적으로 객체를 식별 가능한 형태로 바꾸고 복원
        → 복잡한 객체 필드를 @Embeddable, @ElementCollection 등으로 분해 직렬화
	•	4. JSON 직렬화 (예: Jackson, Gson 등)
        → 객체 → JSON 문자열로 변환
        → HTTP 응답/요청, API 통신, 프론트-백 간 통신에 필수
⸻
- 자바에서 직렬화 구현 방법
	•	클래스에 implements Serializable 명시
	•	ObjectOutputStream → 객체를 바이트로 저장
	•	ObjectInputStream → 바이트를 다시 객체로 복원

⸻

- 직렬화 예제

1. 직렬화 대상 클래스

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "이름: " + name + ", 나이: " + age;
    }
}


⸻

2. 객체 저장 (직렬화)

    Student stu = new Student("홍길동", 20);
    FileOutputStream fos = new FileOutputStream("student.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos)
    oos.writeObject(stu); // 객체 저장
    System.out.println("객체를 파일에 저장했습니다.");



⸻

3. 객체 복원 (역직렬화)

    FileInputStream fis = new FileInputStream("student.ser");
    ObjectInputStream ois = new ObjectInputStream(fis)
    Student stu = (Student) ois.readObject(); // 객체 복원
    System.out.println("파일에서 읽은 객체: " + stu);


⸻

- 주의할 점
	•	Serializable 인터페이스는 marker interface (메서드 없음)
	•	serialVersionUID는 클래스 버전 관리용 (자동 생성 가능)
	•	transient 키워드: 직렬화에서 제외할 필드에 사용 예) transient String password;


⸻

Input/Output & 통신에서 close()가 꼭 필요한 이유

⸻

 1. 스트림은 운영체제의 자원(Resource) 을 사용한다
	•	InputStream, OutputStream, Reader, Writer 등은 내부적으로 파일 핸들, 네트워크 포트, 버퍼 메모리 등 한정된 시스템 자원을 사용함
	•	사용이 끝났을 때 close()를 호출하지 않으면 발생하는 문제
        •	파일이 잠긴 채로 남아 쓰기/삭제가 안 되거나
        •	소켓(연결성 통신)이 닫히지 않아 연결이 끊기지 않거나
        •	메모리/자원이 해제되지 않아 누수 발생

⸻

 2. 연결성 통신(Socket)에서는 close()가 더 중요하다
	•	소켓 기반 통신에서는 InputStream과 OutputStream이 서로 연결되어 있음
	•	close()를 호출하지 않으면:
	•	상대방은 **“아직 데이터가 올 거다”**라고 생각함 → 통신이 끊기지 않음
	•	심지어 readLine()에서 무한 대기 상태가 될 수 있음
	    즉, close()는 상대방에게 “나는 다 보냈다”는 신호를 주는 역할도 함

⸻

 3. 파일도 닫지 않으면 손상이나 접근 오류 발생
	•	파일은 열려 있는 동안 쓰기 버퍼가 아직 저장되지 않았을 수 있음
	•	close()를 호출해야 버퍼에 남은 데이터가 최종적으로 기록(flush)되고, 파일이 안전하게 닫힘

⸻

 try-with-resources (자동 닫기) 사용법

⸻

 자바 7부터 도입된 try-with-resources

	•	AutoCloseable 인터페이스를 구현한 클래스는
	    try(...) {} 안에서 선언만 해주면 자동으로 close() 호출됨
	•	스트림, 리더, 라이터, 소켓, DB 연결 등 대부분의 입출력/통신 객체가 해당

⸻

 예제 1: 파일 읽기 close 예시

FileReader fr=null;
BufferedReader reader=null;
try {
    fr = new FileReader("test.txt");
    reader = new BufferedReader();
    String line = reader.readLine();
    System.out.println(line);
}catch(Exception e){
    //..
}finally{
    if(fr!=null) fr.close();
    if(reader!=null) reader.close();

}

 예제 1: 파일 읽기 Auto close 예시

try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
    String line = reader.readLine();
    System.out.println(line);
}catch(Exception e){
    //..
}
// 자동으로 reader.close() 호출됨

⸻

 복수의 자원도 한 번에 관리 가능

여러 개의 자원(Stream, Reader, Socket 등)을 한 줄에 나열해도 자동으로 모두 닫힘
→ 닫히는 순서는 반대 방향 (마지막 선언부터)


⸻

⸻*/
}
