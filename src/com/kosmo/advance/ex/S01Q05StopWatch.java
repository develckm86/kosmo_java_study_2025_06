package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
/*5. 스탑워치 타이머 (Advanced)
목표:
	•	시작, 정지 버튼으로 시간 측정
	•	javax.swing.Timer 사용
	•	시간 포맷 출력 (mm:ss)

⸻*/

public class S01Q05StopWatch extends JFrame {
    private JButton startBtn; //시작버튼
    private JButton stopBtn; //정지버튼
    private JButton resetBtn; //정지버튼
    private JPanel topPanel; //시작, 종료 버튼 패널
    private JLabel centerLabel;
    private int time=1000; //10초*100


    private Timer timer;
    public S01Q05StopWatch(){
        timer=new Timer(10,(e)->{
            if(time==0){
                timer.stop();
                return;
            }
            --time;
            centerLabel.setText(String.format("%.2f", time/100.0));
        });//1/1000 초마다 time 을 --하는 타이머
        startBtn=new JButton("시작");
        startBtn.addActionListener((e)->{
            timer.start();
        });
        stopBtn=new JButton("종료");
        stopBtn.addActionListener((e)->{
            timer.stop();
        });
        resetBtn=new JButton("리셋");
        resetBtn.addActionListener((e)->{
            timer.stop();
            time=1000;
            centerLabel.setText(String.format("%.2f", time/100.0));
        });
        topPanel=new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
        topPanel.add(startBtn);
        topPanel.add(stopBtn);
        topPanel.add(resetBtn);
        this.add(topPanel,BorderLayout.NORTH);
        centerLabel=new JLabel(String.format("%.2f", time/100.0));
        this.add(centerLabel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        this.setBounds(0,0,500,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new S01Q05StopWatch();
    }
}
