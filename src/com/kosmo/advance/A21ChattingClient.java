package com.kosmo.advance;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class A21ChattingClient {
    //서버에 접속 후 메세지 전송 및 서버가 보낸 메세지를 받는다.
    public static void main(String[] args) {
        //Socket 객체 생성이 성공하면 접속
        try (Socket socket=new Socket("127.0.0.1",3333);
             OutputStream outputStream=socket.getOutputStream(); //input 먼저 생성하면 차단 가능성이 있음
             BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
             InputStream inputStream=socket.getInputStream();
             BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
             )  {
            new Thread(()->{
                Scanner terminalScan=new Scanner(System.in); //터미널에서 입력받을 준비
                while (true){//터미널에서 입력한 문자열을 서버에 전송
                    String msg=terminalScan.nextLine();
                    try {
                        writer.write(msg+"\n"); //서버에 메세지 전송
                        //라인개행이 없으면 서버가 nextLine()으로 받을 수 없음!!
                        writer.flush(); //불필요한 버퍼 비우기
                    } catch (IOException e) {
                        System.out.println("서버로 메세지 전송 중 오류발생");
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true){ //무한히 메세지 받기
                String inputMsg=reader.readLine(); //서버가 보낸 메세지
                System.out.println(inputMsg);
            }
        } catch (UnknownHostException e) {
            System.out.println("찾는 서버가 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("서버와의 접속에 문제가 생겼습니다.");
            e.printStackTrace();
        }
    }
}
