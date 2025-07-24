package com.kosmo.advance.ex.student;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/// 3 곱 3 숫자 (1,2,3....,9)
/// 셔플
///  누르면 상하좌우 +1됨
//
class BtnPlus extends JFrame {
    private class Btn extends JButton {
        int num;
        boolean left = true;
        boolean up = true;
        boolean right = true;
        boolean down = true;
        boolean isZero;
        Btn(int n,int x,int y) {
            this.num = n;
            this.addActionListener((e) -> {
                click++;
                label.setText("클릭 횟수: "+click);
                //this.num++;
                System.out.println(this.num);
                this.setText((++this.num) + "");
                if (this.num==10){
                    this.setText("0");
                    this.num =0;
                    isZero = true;
                }else isZero = false;
                if ((x-1)<0){left = false;}
                if ((y-1)<0){up = false;}
                if ((x+1)>2){right = false;}
                if ((y+1)>2){down = false;}

                if (left&&(btn[y][x-1].num != 10)){
                    btn[y][x-1].num++;btn[y][x-1].setText(btn[y][x-1].num+"");
                    if (btn[y][x-1].num == 10){
                        btn[y][x-1].num = 0;

                        isZero = true;
                    } else isZero = false;
                }
                if (right&& (btn[y][x+1].num != 10)){
                    btn[y][x+1].num++;btn[y][x+1].setText(btn[y][x+1].num+"");
                    if (btn[y][x+1].num == 10){
                        btn[y][x+1].num = 0;

                        isZero = true;
                    } else isZero = false;
                }
                if (up && (btn[y-1][x].num != 10)){
                    btn[y-1][x].num++;btn[y-1][x].setText(btn[y-1][x].num+"");
                    if (btn[y-1][x].num == 10){
                        btn[y-1][x].num = 0;

                        isZero = true;
                    } else isZero = false;
                }
                if (down && (btn[y+1][x].num != 10)){
                    btn[y+1][x].num++;btn[y+1][x].setText(btn[y+1][x].num+"");

                    if (btn[y+1][x].num == 10){
                        btn[y+1][x].num = 0 ;
                        isZero = true;
                    } else isZero = false;
                }
                checkAnswer();


            });

        }

    }

    Btn[][] btn;
    JButton allZeroBtn;
    JPanel panel;
    JPanel btnPanel;
    JLabel label;
    List<Btn> li = new Vector<>();
    int click;
    int cnt;


    BtnPlus() {
        super("btnPlus");
        this.panel = new JPanel(new FlowLayout());
        this.allZeroBtn = new JButton("all zero");
        this.btnPanel = new JPanel(new GridLayout(3, 3));
        this.label = new JLabel("클릭 횟수: " + click + "");
        this.btn = new Btn[3][3];
//        this.startBtn = new JButton("시작");
        this.add(panel, BorderLayout.NORTH);
        panel.add(label);
        panel.add(allZeroBtn);
        allZeroBtn.addActionListener((e)->{ //확
            for (int i = 0; i < btn.length ; i++) {
                for (int j = 0; j <btn[i].length ; j++) {
                    btn[i][j].num =0;
                    btn[i][j].setText("0");
                }
            }
            checkAnswer();
        });
//        panel.add(startBtn);
        this.add(btnPanel);
        int x;
        int y;
        cnt =1;
        for (int i = 0; i < btn.length ; i++) {

            y =i;
            for (int j = 0; j <btn[i].length ; j++) {
                x =j;
                System.out.println("y:"+y+", x:"+x);
                btn[i][j] = new Btn(cnt,x,y);
                btn[i][j].setText(cnt+"");
                btnPanel.add(btn[i][j]);
                cnt++;
            }
        }







        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(0, 0, 500, 500);
        super.setVisible(true);
    }
    public void checkAnswer(){
        int zeroCheck=0;
        for (int i = 0; i < btn.length; i++) {
            for (int j = 0; j < btn[i].length; j++) {
                System.out.println(btn[i][j].num);
                if (btn[i][j].num==0){
                    zeroCheck++;
                    if (zeroCheck ==9){
                        JOptionPane.showMessageDialog(this,"승리");
                    }
                }else {
                    break;
                }
            }
        }
    }

}

public class S02MakeZeroJunghoChae {
    public static void main(String[] args) {
        BtnPlus btnPlus = new BtnPlus();
    }
}
