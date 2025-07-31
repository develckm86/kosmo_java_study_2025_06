package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;

public class A24Canvas extends JFrame {
    //canvas==component
    MyCanvas canvas;

    class MyCanvas extends Canvas {
        Image image;//=Toolkit.getDefaultToolkit().getImage("./강아지.jpeg");

        public MyCanvas(){
            this.setBackground(Color.PINK); //배경은 바로 지정 가능
            image=Toolkit.getDefaultToolkit().getImage("./강아지.jpeg");
            //캔버스가 생성될때만 이미지를 불러오기 위해!
        }
        //paint() : 캔버스가 생성되면 자동으로 호출

        //g 와 g2는 같은 객체를 참조
        @Override
        public void paint(Graphics g) { //Graphics g == 붓
            Graphics2D g2=(Graphics2D)g; //선 굵기는 Graphics2D로 캐스팅 후 사용
            g2.setStroke(new BasicStroke(5f));

            g2.setColor(Color.RED);
            g2.drawLine(50,50,100,100);

            g.setColor(Color.YELLOW);
            g2.fillArc(150,150,200,200,0,300);

        //    ./강아지.jpeg or 강아지.jpeg
             g2.drawImage(image,300,300,50,50,this); //사이지 변경
//            Image image=new ImageIcon("./강아지.jpeg").getImage();
//            g2.drawImage(image,200,200,null);
            //ImageIcon을 쓰면 다음 코드에는 무조건 이미지가 존재 하기 때문에 observer 필요없음
        }
    }

    public A24Canvas(){
        super("캔버스 수업");

        canvas=new MyCanvas();
        this.add(canvas);

        this.setBounds(-1980,0,500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {
        new A24Canvas();
    }
}
