package com.kosmo.advance.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class S12GUIChattingServer {
    private static Map<String,PrintWriter> clientOuts=new HashMap();

    static class UserMsgReceiver implements Runnable{
        String userName;
        Socket clientSocket;

        public UserMsgReceiver(String userName, Socket clientSocket) {
            this.userName = userName;
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                Scanner in=new Scanner(clientSocket.getInputStream()); //스레드에서 입력 받는 객체 새로 생성 main과 충돌 위험
                String msg;
                while (in.hasNextLine()){ //hasNext,hasNextLine 클라이언트의 메세지 입력을 대기 (만약 연결이 끓어지면 false 반환 후 반복문 종료)
                    msg=in.nextLine();
                    System.out.println(msg); //클라이언트가 보낸 메세지
                    //접속한 모든 클라이언트에게 메세지 보내기
                    for ( PrintWriter printWriter : clientOuts.values()){
                        printWriter.println("msg:"+msg); //msg:최경민:안녕하세요
                        printWriter.flush();
                    }
                }
                //연결이 끊어짐 : 소켓 닫기 및 clientOuts 에서 제거
                System.out.println(userName+"나감");
                clientOuts.remove(userName);
                clientSocket.close();

                //접속한 모든 클라이언트에게 퇴장 메세지 보내기
                for ( PrintWriter printWriter : clientOuts.values()){
                    printWriter.println("exit:"+userName);
                    printWriter.flush();
                }

            } catch (IOException e) {
                System.out.println("클라이언트의 채팅을 받는 중 오류 발생");
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        try (ServerSocket server=new ServerSocket(9999)){
            //단체 채팅방 만들기
            System.out.println("서버가 실행되었습니다.");
            while (true){
                Socket client=server.accept(); //누군가 접속했습니다.
                String clientIp=client.getInetAddress().toString(); //어디서(ip) 접솝했는지 확인
                System.out.println(clientIp+"가 접속");

                PrintWriter clinetOut=new PrintWriter(client.getOutputStream(),true);
                Scanner clientIn=new Scanner(client.getInputStream());
                String userName=clientIn.nextLine();//접속하자 마자 사용자 이름 보냄
                if(clientOuts.containsKey(userName)){ //유저이름이 같은 것이 있다면 랜던 수를 이름 뒤에 표기(같은 이름이 없을 때까지 검사)
                    while (true){
                        String randomUserName=userName+new Random().nextInt(9999);
                        if(!clientOuts.containsKey(randomUserName)){
                            userName=randomUserName;
                            break;
                        }
                    }
                    //바뀐 이름을 전달
                    clinetOut.println("rename:"+userName);
                }
                clientOuts.put(userName,clinetOut);

                for(PrintWriter clientPrint:clientOuts.values()){ //모든 유저에게 모든 참가자 전송
                    for(String key:clientOuts.keySet()){ //{최경민,최경민2235,채정호,김지형,이지형}
                        clientPrint.println("enter:"+key); //enter:최경민
                    }
                }

                new Thread(new UserMsgReceiver(userName,client)).start();
            }
        } catch (IOException e) {
            System.out.println("서버 실행 중 오류");
            e.printStackTrace();
        }
    }
}
