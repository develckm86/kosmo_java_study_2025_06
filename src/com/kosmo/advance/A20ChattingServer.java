package com.kosmo.advance;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class A20ChattingServer {
    public static List<Socket> clients=new ArrayList<>();

    public static void main(String[] args) {
        /// 2000 번 포트까지 OS 프로그램으로 존재할 가능성이 있음
        try(ServerSocket server=new ServerSocket(3333)){
            while(true){
                Socket client=server.accept();
                //accept() : Socket 으로 서버에 접속하면 반환, 접속할때까지 대기
                clients.add(client); //받은 메세지를 모든 클라이언트가 받게 하려고
                String clientAddress=client.getInetAddress().toString(); //클라이언 주소
                System.out.println(clientAddress+"님 서버 접속");
                new Thread(()->{
                    try {//스레드 안에서 소켓의 입력 객체를 호출하지 않으면 다른 소켓의 입력과 구분하지 못하는 문제 발생
                        InputStream in=client.getInputStream();
                        //클라이언트가 서버로 보내는 메세지(문자열)를 받는 통로
                        InputStreamReader inputStreamReader=new InputStreamReader(in);
                        BufferedReader reader=new BufferedReader(inputStreamReader);
                        while (true){
                            try {
                                String msg=clientAddress+" : "+reader.readLine();
                                //클라이언트가 입력하기 전까지 무한히 대기 => 다른 클라이언트가 접속 불가
                                System.out.println(msg);
                                for(Socket c: clients){
                                    BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
                                    writer.write(msg);
                                    writer.flush();//버퍼는 사용하고 비워야함 (오류 위험)
                                }
                            } catch (IOException e) {
                                System.out.println("클라이너트가 보낸 메세지를 받는 중 오류");
                                e.printStackTrace();
                            }
                        }
                    }catch (IOException ex){
                        System.out.println("클라이언트에게서 입력 받는 객체 받아오기 오류");
                        ex.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("서버에 문제가 생김, 종료됩니다.");
            e.printStackTrace();
        }

    }
}
