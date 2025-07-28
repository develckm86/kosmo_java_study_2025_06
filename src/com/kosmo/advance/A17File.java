package com.kosmo.advance;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A17File {
    public static void main(String[] args) {
        //문자열로된 파일을 작성하고 읽어오는 예제
        //왠만한 입출력은 오류를 동반하기 때문에 예외처리 하세요!
        //입출력은 stream을 동반하는데 다 사용하고 나면 close()를 해야합니다.

//        FileWriter fileWriter=null;
//        try {
//            fileWriter=new FileWriter("A17hello.txt");
//            fileWriter.write("안녕");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            try {
//                if(fileWriter!=null)fileWriter.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


        //close()가 작성된 클래스의 close를 자동으로 finally 지점에 호출
        // ./경로  : 현재 위치를 기준으로 해당 파일을 작성
        try (FileWriter fileWriter=new FileWriter("./L17Hello.txt")){

            fileWriter.write("안녕하세요!\n");
            fileWriter.write("자바 고급 수업 입니다!");


        } catch (IOException e) {
            System.out.println("파일 출력 중 오류 발생");
            e.printStackTrace();
        }
        System.out.println("파일을 읽는 중...");
        try(
                FileReader fileReader=new FileReader("./L17Hello.txt");
                BufferedReader bufferedReader=new BufferedReader(fileReader); //파일을 문자열로 읽기
        ){
            String line="";
            while ( (line=bufferedReader.readLine()) !=null ){ //한줄씩 받는데 없을때까지 반복문 실행!
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("찾는 파일이 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일을 찾는 도중 오류가 발생");
            e.printStackTrace();
        }


        //java 11 이상만 가능
        //Files
        Path path =Paths.get("L17FilsHello.txt"); //경로를 찾는 객체
        String txt="안녕!!\nFiles로 파일 쓰기!"; //getBytes() : byte로 바꾸는데 인코딩 지정후 변경
        try {
            Files.write(path,txt.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Files로 파일 불러오는중 ..");
        try {
            String contents=Files.readString(path);
            System.out.println(contents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
