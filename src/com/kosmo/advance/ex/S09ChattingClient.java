package com.kosmo.advance.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class S09ChattingClient {
    public static void main(String[] args) {
        //내컴퓨터 내부 : localhost == 192.0.0.1
        try (Socket socket =new Socket("localhost",7777);
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true); //연결된 소켓으로 서버에 문자열 데이터를 보내는 객체
            Scanner in=new Scanner(socket.getInputStream());){

            System.out.println("채팅 서버 접속완료!");
            //터미널에서 입력한 문자열을 서버로 보냄( 채팅을 보내면서 채팅을 불러와야하기 때문에 thread 생성)
            new Thread(()->{
                Scanner scanner=new Scanner(System.in);
                while (true){
                    String msg=scanner.nextLine();
                    out.println(msg);
                }
            }).start();

            new Thread(()->{
                try {
                    while (in.hasNextLine()){
                        String msg=in.nextLine();
                        System.out.println(msg);
                    }
                }catch (Exception e){
                    System.out.println("메세지 수신 중 오류");
                    e.printStackTrace();
                }

            }).start();

            Thread.currentThread().join(); //main 쓰레드가 다른 스레드가 종료될 때까지 기다림
            //모든 일을 스레드가 하고 있어서 main은 다른 스레드를 기다리지 않고 종료됨.
            //보통은 상관 없지만 try가 종료되면 auto close를 지정한 Socket 연결이 끓어져버림
        }catch (IOException e){
            System.out.println("서버와 접속이 끊어짐");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("메인 스레드가 다른 스레드 기다리다가 오류 발생");
            e.printStackTrace();
        }
    }
}
