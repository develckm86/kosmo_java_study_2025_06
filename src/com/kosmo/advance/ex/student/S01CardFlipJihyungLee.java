package com.kosmo.advance.ex.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S01CardFlipJihyungLee {

    static final int SIZE=4;
    static String[][] board=new String[SIZE][SIZE];
    static boolean[][] flipped=new boolean[SIZE][SIZE];
    static JButton[][] buttons=new JButton[SIZE][SIZE];
    static String[] colors={
            "Red", "Blue", "Green", "Yellow", "Red", "Blue", "Green", "Yellow",
            "Orange", "Purple", "Orange", "Purple", "Pink", "Black", "Pink", "Black"
    };
    static int matches=0;
    static int clickCount=0;
    static int card1Row=0, card1Col=0, card2Row=0, card2Col=0;
    static boolean isWaiting=false;
    static JFrame frame=new JFrame("카드 맞추기 게임");

    public static void main(String[] args){
        List<String> colorList = new ArrayList<>();
        Collections.addAll(colorList, colors);
        Collections.shuffle(colorList);

        int idx=0;
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                board[i][j] =colorList.get(idx++);
                flipped[i][j] =false;
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(SIZE, SIZE));
        frame.setSize(500, 500);

        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                buttons[i][j]=new JButton();
                buttons[i][j].setBackground(Color.GRAY);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 24));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                frame.add(buttons[i][j]);
            }
        }
        frame.setVisible(true);

        isWaiting = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                showColor(i, j);
            }
        }
        javax.swing.Timer timer = new javax.swing.Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        buttons[i][j].setBackground(Color.GRAY);
                        buttons[i][j].setText("");
                        flipped[i][j] = false;
                    }
                }
                isWaiting = false;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    static class ButtonClickListener implements ActionListener{
        int row,col;
        ButtonClickListener(int row,int col){
            this.row=row;
            this.col=col;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if (isWaiting) return;
            if (flipped[row][col]) return;
            showColor(row,col);
            flipped[row][col]=true;
            if (clickCount==0){
                card1Row=row;
                card1Col=col;
                clickCount=1;
            } else if (clickCount==1){
                card2Row=row;
                card2Col=col;
                isWaiting=true;
                if (card1Row==card2Row && card1Col==card2Col){
                    isWaiting=false;
                    return;
                }

                if (board[card1Row][card1Col].equals(board[card2Row][card2Col])){
                    matches++;
                    clickCount=0;
                    isWaiting=false;
                    if (matches==SIZE*SIZE/2){
                        JOptionPane.showMessageDialog(frame, "게임이 끝났습니다!");
                    }
                } else {
                    javax.swing.Timer timer=new javax.swing.Timer(500, new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            buttons[card1Row][card1Col].setBackground(Color.GRAY);
                            buttons[card2Row][card2Col].setBackground(Color.GRAY);
                            buttons[card1Row][card1Col].setText("");
                            buttons[card2Row][card2Col].setText("");
                            flipped[card1Row][card1Col]=false;
                            flipped[card2Row][card2Col]=false;
                            clickCount=0;
                            isWaiting=false;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
    static void showColor(int row, int col){
        switch (board[row][col]){
            case "Red":
                buttons[row][col].setBackground(Color.RED);
                buttons[row][col].setForeground(Color.RED);
                buttons[row][col].setText("RED");
                break;
            case "Blue":
                buttons[row][col].setBackground(Color.BLUE);
                buttons[row][col].setForeground(Color.BLUE);
                buttons[row][col].setText("Blue");

                break;
            case "Green":
                buttons[row][col].setBackground(Color.GREEN);
                buttons[row][col].setForeground(Color.GREEN);
                buttons[row][col].setText("Green");
                break;
            case "Yellow":
                buttons[row][col].setBackground(Color.YELLOW);
                buttons[row][col].setForeground(Color.YELLOW);
                buttons[row][col].setText("Yellow");
                break;
            case "Orange":
                buttons[row][col].setBackground(Color.ORANGE);
                buttons[row][col].setForeground(Color.ORANGE);
                buttons[row][col].setText("Orange");
                break;
            case "Purple":
                buttons[row][col].setBackground(new Color(128, 0, 128));
                buttons[row][col].setForeground(new Color(128, 0, 128));
                buttons[row][col].setText("Purple");
                break;
            case "Pink":
                buttons[row][col].setBackground(Color.PINK);
                buttons[row][col].setForeground(Color.PINK);
                buttons[row][col].setText("Pink");
                break;
            case "Black":
                buttons[row][col].setBackground(Color.BLACK);
                buttons[row][col].setForeground(Color.BLACK);
                buttons[row][col].setText("Black");
                break;
        }
    }
}
