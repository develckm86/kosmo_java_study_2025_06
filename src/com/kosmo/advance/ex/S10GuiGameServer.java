package com.kosmo.advance.ex;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class S10GuiGameServer {
    public static List<Socket> clients=new ArrayList<>();
    public static List<ObjectOutputStream> clientsOut=new ArrayList<>();


    public static void main(String[] args) {
        try (ServerSocket server=new ServerSocket(5555)){
            while (true){
                Socket client=server.accept();
                clients.add(client);
                ObjectOutputStream clientOut=new ObjectOutputStream(client.getOutputStream());
                clientsOut.add(clientOut);
                //client가 보내는 입력을 받아서 다른 클라이언트 모드에게 보내기
                new Thread(()->{
                    try {
                        ObjectInputStream input=new ObjectInputStream(client.getInputStream());
                        while (true){
                            Object blockObj=input.readObject();
                            System.out.println(client.getInetAddress().getAddress()+"님 오브젝트 전송");
                            //접속한 모든 사람에게 블럭 보내기
                            for(ObjectOutputStream out: clientsOut){
                                out.writeObject(blockObj);
                                out.flush(); //버퍼 비우기
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("클라이언트와 통신중 오류");
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("클라이언트가 보낸 데이터가 오브젝트가 아님");
                        e.printStackTrace();
                    }finally {
                        clients.remove(client);
                        clientsOut.remove(clientOut);
                    }
                }).start();
            }

        } catch (IOException e) {
            System.out.println("서버 문제 발생");
            e.printStackTrace();
        }
    }
}
