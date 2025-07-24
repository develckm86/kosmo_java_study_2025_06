package com.kosmo.advance.ex;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S10GuiGameServer {
    public static Map<Socket,ObjectOutputStream> clients=new HashMap<>();
    //public static List<ObjectOutputStream> clientsOut=new ArrayList<>();
    public static Map<String,Block> blocks=new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket server=new ServerSocket(5555)){
            System.out.println("서버시작");
            while (true){
                Socket client=server.accept();
                ObjectOutputStream clientOut=new ObjectOutputStream(client.getOutputStream());
                clients.put(client,clientOut);
                for (Map.Entry entry: blocks.entrySet()){//최초 접속자에게 모든 블럭 보내기
                    Block b=(Block)entry.getValue();
                    clientOut.writeObject(b);
                    clientOut.flush();
                }
                //client가 보내는 입력을 받아서 다른 클라이언트 모드에게 보내기
                new Thread(()->{
                    try {
                        ObjectInputStream input=new ObjectInputStream(client.getInputStream());
                        while (true){
                            Block blockObj=(Block) input.readObject();
                            System.out.println(blockObj);
                            blocks.put(blockObj.id, blockObj); //받은 블럭들 저장하기
                            //접속한 모든 사람에게 블럭 보내기(자신 제외)
                            for (Map.Entry<Socket,ObjectOutputStream> entry:clients.entrySet()){
                                Socket socket=entry.getKey();
                                ObjectOutputStream out=entry.getValue();
                                if(socket.equals(client)){continue;}
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
                    }
                }).start();
            }

        } catch (IOException e) {
            System.out.println("서버 문제 발생");
            e.printStackTrace();
        }
    }
}
