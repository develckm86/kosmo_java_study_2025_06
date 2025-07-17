package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;

/*1. 숫자 증가 게임 (Easy)
목표: 버튼을 누를 때마다 숫자가 1씩 올라가고, 100이 되면 “완료!” 표시
	•	기능:
	•	숫자 증가 버튼
	•	리셋 버튼
	•	100 이상일 때 메시지 출력 (JOptionPane)
	•	학습 포인트: 상태 관리, 조건 분기, 레이블 갱신
*/
public class S01NumberUp extends JFrame {
    private JButton btn;
    private JButton resetBtn;
    private JLabel label;
    private JPanel p;
    private int num;
    private final int lastNum=10;
    public S01NumberUp(){
        this.p=new JPanel();
        this.p.setLayout(new FlowLayout());
        this.resetBtn=new JButton("리셋");
        this.btn=new JButton("n++");
        p.add(btn);
        p.add(resetBtn);
        this.add(p,BorderLayout.NORTH);
        resetBtn.addActionListener((e)->{
            num=0;
            label.setText(num+"");
        });
        btn.addActionListener((e)->{
            num++;
            label.setText(num+"");
            if(num==lastNum){
                JOptionPane.showMessageDialog(this,"완료");
                num=0;
                label.setText(num+" 수를 10까지 올리는 게임");
            }
        });

        this.label=new JLabel(num+" 수를 10까지 올리는 게임",SwingConstants.CENTER);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(label);
        this.setBounds(0,0,400,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new S01NumberUp();
    }
}
