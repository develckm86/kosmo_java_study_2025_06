package com.kosmo.advance.ex;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class S09ChattingServer {
    public static List<Socket> clients=new ArrayList<>();
    public static void main(String[] args) {
        ServerSocket server=null;
        try {
            //단체 채팅방 만들기
            server=new ServerSocket(7777);
            System.out.println("서버가 실행되었습니다.");
            while (true){
                Socket client=server.accept(); //누군가 접속했습니다.
                String clientIp=client.getInetAddress().toString(); //어디서(ip) 접솝했는지 확인
                System.out.println(clientIp+"가 접속");
                clients.add( client ); //접속한 클라이언트 모음 (ip: Socket)
                //클라이언트가 메세지 데이터를 보내는 것을 기다림
                //여러명이 접속해서 데이터를 보낼 예정이기 때문에 Thread 생성
                new Thread(()->{
                    try {
                        Scanner in=new Scanner(client.getInputStream());
                        String msg;
                        while (in.hasNextLine()){ //hasNext,hasNextLine 클라이언트의 메세지 입력을 대기 (만약 연결이 끓어지면 false 반환 후 반복문 종료)
                            msg=clientIp+"님 메세지 : "+in.nextLine();
                            System.out.println(msg); //클라이언트가 보낸 메세지
                            //접속한 모든 클라이언트에게 메세지 보내기
                            for ( Socket c : clients){
                                PrintWriter out=new PrintWriter(c.getOutputStream(),true);
                                out.println(msg);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("클라이언트의 채팅을 받는 중 오류 발생");
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("서버 실행 중 오류");
            e.printStackTrace();
        }finally {
            try {
                if(server!=null)server.close();
            } catch (IOException e) {
                System.out.println("서버 종료 중 오류");
            }
        }
    }
}
