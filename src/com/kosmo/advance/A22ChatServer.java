package com.kosmo.advance;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class A22ChatServer {

    private static List<Socket> clients=new ArrayList<>();

    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(8888);){
            while (true){
                Socket client =serverSocket.accept();
                clients.add(client);
                String ip=client.getInetAddress().toString();
                System.out.println(ip+"님 접속");
                //클라이너트 접속이 올때까지 기다림, 막약 오면 Socket을 반환
                new Thread(()->{ //접속한 클라이언트의 메세지를 받는 일꾼
                    try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(client.getInputStream()));) {
                        String msg="";
                        while ((msg=bufferedReader.readLine())!=null) {//연결이 끊어졌을 때 반복문을 중단
                            System.out.println(ip+"님 보낸 메세지:"+msg);

                            for (Socket c: clients){
                                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
                                writer.write(ip+":"+msg+"\n");
                                //클라이언트가 라인개행을 기준으로 문자열을 받을 예정(만약 라인개행을 보내지 않으면 보낼때까지 대기)
                                writer.flush();
                            }
                        }//while 무한 반복에서 나가는 것은 클라이언트와 소켓이 끊어졌을때
                        clients.remove(client);
                        client.close();
                    } catch (IOException e) {
                        System.out.println("클라이언트와의 접속 소켓에 문제가 생김");
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("서버 오류");
            e.printStackTrace();
        }
    }
}
