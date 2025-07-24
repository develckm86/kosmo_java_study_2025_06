package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.*;
import java.util.List;

public class S11GuiGameClient extends JFrame {
    Map<String,Block> blocks=new HashMap<>();
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    String myIp="my";
    //"my"를 제외한 모든 블럭의 key 는 ip
    class Block implements Serializable {
        String id=myIp;
        int red;
        int green;
        int blue;
        int x;
        int y;
        Color color;
        int xSize=50;
        int ySize=50;

        public Block(int red, int green, int blue, int x, int y) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.x = x;
            this.y = y;
            color=new Color(red,green,blue);
        }
    }
    class GameCanvas extends Canvas{
        int x; //block 의 x 좌표
        int y; //block 의 y 좌표
        // Swing + Canvas란?
        //	•	Canvas: 그림을 그리기 위한 영역 (Graphics 객체로 그림을 그림)
        //	•	Canvas는 paint(Graphics g) 또는 paintComponent(Graphics g)에서 동작
        public GameCanvas(){
            setBackground(Color.BLACK);
            setFocusable(true); //키 이벤트 받기
            requestFocus(); //다른 컨포넌트의 포커스 뺏어오기

            //내 블럭 만들기
            Random rand = new Random();
            int red = rand.nextInt(50,256); // 50~255
            int green = rand.nextInt(50,256);
            int blue = rand.nextInt(50,256);
            int x=rand.nextInt(750);
            int y=rand.nextInt(550);

            Block block=new Block(red,green,blue,x,y);
            blocks.put(block.id,block);

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT -> blocks.get("my").x-=5;
                        case KeyEvent.VK_RIGHT -> blocks.get("my").x+=5;
                        case KeyEvent.VK_UP -> blocks.get("my").y-=5;
                        case KeyEvent.VK_DOWN -> blocks.get("my").y+=5;
                    }
                    GameCanvas.this.repaint(); //paint 함수 재호출

                }
            });
        }
        //정의한 그림이 그려지는 함수
        @Override
        public void paint(Graphics g) {
            for(Map.Entry<String,Block> blockEntry : blocks.entrySet()){
                Block block=blockEntry.getValue();
                g.setColor(block.color);
                g.fillRect(block.x,block.y,block.xSize,block.ySize);//g.fill* :모양 선택
            }
        }
    }

    public S11GuiGameClient(String host, int port) throws IOException {
        super("멀티 게임");

//        socket=new Socket(host,port);
//        myIp=socket.getInetAddress().getHostAddress(); //내 아이피
//        System.out.println(host+":"+port+"서버 접속 완료");
//        in=new ObjectInputStream(socket.getInputStream());
//        out=new ObjectOutputStream(socket.getOutputStream());
//
//        new Thread(()->{
//            while (true){ //서버가 다른 클라이언트가 보내는 블럭 받아오기
//                try {
//                    Block block=(Block) in.readObject();
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();


        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙
        setResizable(false);

        GameCanvas gameCanvas=new GameCanvas();
        add(gameCanvas);

        setVisible(true);




    }

    public static void main(String[] args) {
        try {
            new S11GuiGameClient("192.168.0.65",7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
