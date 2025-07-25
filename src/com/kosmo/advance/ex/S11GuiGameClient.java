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
class Block implements Serializable {//내부클래스로 작성시 외부 클래스 필드에 영향으로 직렬화 실패
    private static final long serialVersionUID = 1L; // ✔ 양쪽에 동일하게 설정
    //serialVersionUID를 지정하지 않으면 컴파일 시 자동 생성되며, 클래스 구조가 바뀌면 다른 값이 생성됩니다.
    String id;
    int red;
    int green;
    int blue;
    int x;
    int y;
    //        Color color; //직렬화 불가 객체
    int xSize=50;
    int ySize=50;

    public Block(String id, int red, int green, int blue, int x, int y) {
        this.id = id;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id='" + id + '\'' +
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", x=" + x +
                ", y=" + y +
                ", xSize=" + xSize +
                ", ySize=" + ySize +
                '}';
    }
}

public class S11GuiGameClient extends JFrame {
    Map<String,Block> blocks=new HashMap<>();
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    Block block;
    public S11GuiGameClient(String host, int port) throws IOException {
        super("멀티 게임");

        socket=new Socket(host,port);
        String myIp=socket.getInetAddress().getHostAddress()+"."+(new Random().nextInt(9999)); //내 아이피
        System.out.println(myIp);
        System.out.println(host+":"+port+"서버 접속 완료");
        //ObjectInputStream이 먼저 생성되면 스트림 deadlock 발생
        out=new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in=new ObjectInputStream(socket.getInputStream());

        //내 블럭 만들기
        Random rand = new Random();
        int red = rand.nextInt(50,256); // 50~255
        int green = rand.nextInt(50,256);
        int blue = rand.nextInt(50,256);
        int x=rand.nextInt(750);
        int y=rand.nextInt(550);

        block=new Block(myIp,red,green,blue,x,y);
        blocks.put(block.id,block);
        System.out.println(block);
        out.writeObject(block); //처음 생성한 블럭 보내기
        GameCanvas gameCanvas=new GameCanvas();
        add(gameCanvas);
        new Thread(()->{
            while (true){ //서버가 다른 클라이언트가 보내는 블럭 받아오기
                try {
                    Block otherBlock=(Block) in.readObject();
                    if(!otherBlock.id.equals(block.id)){//내 블럭은 무시(이전 상태를 덮어쓸수 있음)
                        blocks.put(otherBlock.id,otherBlock);
                        gameCanvas.requestFocus();
                        gameCanvas.repaint();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        setLocation(0,0);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    class GameCanvas extends Canvas{
        // Swing + Canvas란?
        //	•	Canvas: 그림을 그리기 위한 영역 (Graphics 객체로 그림을 그림)
        //	•	Canvas는 paint(Graphics g) 또는 paintComponent(Graphics g)에서 동작
        public GameCanvas(){
            setBackground(Color.BLACK);
            setFocusable(true); //키 이벤트 받기
            requestFocus(); //다른 컨포넌트의 포커스 뺏어오기


            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT -> block.x-=20;
                        case KeyEvent.VK_RIGHT -> block.x+=20;
                        case KeyEvent.VK_UP -> block.y-=20;
                        case KeyEvent.VK_DOWN -> block.y+=20;
                    }
                    try {
                        out.reset(); //같은 객체를 보내기 때문에 서버에서 상태가 변한 객체를 받지 않을 수 있음
                        out.writeObject(block);
                    } catch (IOException ex) {
                        System.out.println("데이터 전송중 오류");
                        ex.printStackTrace();
                    }
                    blocks.put(block.id,block);
                    GameCanvas.this.repaint(); //paint 함수 재호출

                }
            });
        }
        //정의한 그림이 그려지는 함수
        @Override
        public void paint(Graphics g) {
            for(Map.Entry<String,Block> blockEntry : blocks.entrySet()){
                Block block=blockEntry.getValue();
                g.setColor(new Color(block.red,block.green,block.blue));
                g.fillRect(block.x,block.y,block.xSize,block.ySize);//g.fill* :모양 선택
            }
        }
    }


    public static void main(String[] args) {
        try {
            new S11GuiGameClient("192.168.0.65",5555);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
