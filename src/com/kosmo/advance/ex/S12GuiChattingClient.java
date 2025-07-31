package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class S12GuiChattingClient extends JFrame {

    private JTextArea chatArea;          // 채팅 출력 창
    private JTextField inputField;       // 입력 필드
    private JButton sendButton;          // 전송 버튼
    private DefaultListModel<String> userListModel; // 참가자 리스트 모델(목록을 관리)
    private JList<String> userList;      // 참가자 리스트(목록을 출력하는 View)
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private String userName;
    private JLabel userNameLabel;
    //채팅 입력시 서버로 채팅을 보냄
    class ChattingHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String msg=inputField.getText();//입력창 메세지 받아오기
            out.println(userName+":"+msg); //"최경민:안녕"으로 메세지 서버에 보내기
            out.flush();
            inputField.setText("");//입력창 비우기

        }
    }
    //상대방이 입력한 채팅을 계속 받음
    class ReceiveChattingThread extends Thread {
        @Override
        public void run() {
            while (in.hasNextLine()) {
                String msg = in.nextLine(); //"최경민:안녕하세요!"(메세지) or "최경민"(최초입장시)
                String [] msgArr = msg.split(":");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a h:mm", Locale.KOREAN);//오전 10:46
                LocalTime now = LocalTime.now();
                String time = now.format(formatter);

                System.out.println("msg:"+ Arrays.toString(msgArr));
                switch (msgArr[0]) {
                    case "msg": //msg:최경민:안녕하세요!
                        chatArea.append("\n"+msgArr[1]+"\n"+msgArr[2]+"\t"+""+time+"\n");
                        break;
                    case "exit": //exit:최경민
                        userListModel.removeElement(msgArr[1]);
                        chatArea.append("\n"+msgArr[1]+"님이 나가셨습니다.\t"+time+"\n");
                        break;
                    case "enter":
                        if (!userListModel.contains(msgArr[1])) {//이미 추가된 user는 제외
                            userListModel.addElement(msgArr[1]);
                            chatArea.append("\n"+msgArr[1]+"님 입장하셨습니다.\t"+time+"\n");
                        }
                        break;
                    case "rename": //rename:최경민3334
                        userName=msgArr[1];
                        userNameLabel.setText(userName);
                        break;
                }

            }
        }
    }

    public S12GuiChattingClient(String userName) throws IOException {
        setTitle("단체 채팅방");
        this.userName=userName;
        //서버와 소켓 생성 후 채팅방 반들기
        socket=new Socket("127.0.0.1",9999);
//        socket=new Socket("192.168.0.65",9999);
        out = new PrintWriter(socket.getOutputStream(),true); //서버와 연결된 출력 객체
        out.flush();
        in = new Scanner(socket.getInputStream());//서버와 연결된 입력 객체
        out.println(userName); //접속하고 바로 보내는 메세지는 유저 이름

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 채팅 출력 영역
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatArea);

        // 입력 필드와 버튼
        inputField = new JTextField();
        sendButton = new JButton("전송");
        userNameLabel = new JLabel(userName);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.add(userNameLabel, BorderLayout.WEST);
        // 참가자 목록
        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        JScrollPane userScroll = new JScrollPane(userList);
        userScroll.setPreferredSize(new Dimension(120, 0));
        userScroll.setBorder(BorderFactory.createTitledBorder("참가자"));

        //채팅에서 엔터를 입력하거나 전송 버튼을 누루면 서버로 메세제 전송
        ChattingHandler chattingHandler = new ChattingHandler();
        inputField.addActionListener(chattingHandler);
        sendButton.addActionListener(chattingHandler);

        new ReceiveChattingThread().start(); //채팅 메세지가 있으면 계속 받는 스레드 생성

        // 전체 레이아웃
        setLayout(new BorderLayout());
        add(chatScroll, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(userScroll, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        //SwingUtilities.invokeLater  : main 스레드가 EDT 에게 frame 생성을 위임
        //Event Dispatch Thread 는 window(GUI)의 화면에서 발생하는 이벤트를 받고 window를 새로 그리는데 main이
        //window를 생성 및 출력하면 edt와 충돌발생(화면 깜빡임)이 있음
        SwingUtilities.invokeLater(() -> {
            S12GuiChattingClient gui = null;
            try {
                gui = new S12GuiChattingClient("최경민");
                gui.setVisible(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}