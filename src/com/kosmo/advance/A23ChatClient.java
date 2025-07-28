package com.kosmo.advance;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class A23ChatClient {
    public static void main(String[] args) {
        try(Socket socket=new Socket("127.0.0.1",8888)){
            //콘솔에서 입력한 문자열 => 서버로 전송하는 무한반복문
            new Thread(()->{
                Scanner scan=new Scanner(System.in); //채팅창에 입력한 메세지 받을 준비
                try(BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));){
                    while (scan.hasNextLine()){ //채팅창인 터미널이 죽으면 false 반환 후 종료
                        String msg=scan.nextLine(); //메세지의 한줄 받기
                        writer.write(msg+"\r\n"); // \n 생략하면 서버에서 메세지를 계속 대기
                        //"안녕하세요!                " //buffer
                        writer.flush();
                        //"안녕하세요!"
                    }
                }catch (IOException e){
                    System.out.println("소켓 출력 객체에 문제 발생");
                }
            }).start();
            //서버가 보내는 문자열 => 받아서(in) 콘솔에 출력하는 무한 반복문
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str="";
            System.out.println("메세지 받을 준비 완료!!");
            while ((str=reader.readLine())!=null){ // \r\n 맥
                System.out.println(str);
            }
        } catch (UnknownHostException e) {
            System.out.println("서버 주소가 잘못됨");
        } catch (IOException e) {
            System.out.println("서버와의 연결이 문제");
            e.printStackTrace();
        }
    }
}
