package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 4. 1~50 랜덤 숫자 맞추기 게임 (Higher)

목표:
	•	텍스트 입력창에 수를 입력하여 “정답 숫자”를 맞추는 간단한 미니게임
	•	정답에 도달하면 “축하합니다!” 표시
	*   기회 3번 (도전)
	*   게임 다시 시작(도전)
*/
public class S01Q04RandomNum extends JFrame {
    private JButton startBtn; //시작버튼
    private JButton endBtn; //종료버튼
    private JPanel topPanel; //시작, 종료 버튼 패널

    private JTextField numInput; //숫자 입력
    private JLabel numLabel; //숫자 입력 안내
    private JButton numBtn; //숫자 입력 버튼
    private JPanel bottomPanel;

    private JLabel centerLabel;  //게임 진행상황 출력

    private int cnt=0; //도전한 수
    private final int MAX_CNT=3; //최대 도전 수
    private int random; //랜덤 수

    private final int GAME_END=0;
    private final int GAME_START=1;
    private final int GAME_WIN=2;
    private final int GAME_LOSE=3;
    private final int GAME_UP=4;
    private final int GAME_DOWN=5;
    public String gameMsg(int gameState){
        String hint="<br>남은 기회 :"+(MAX_CNT-cnt)+", <br> 맞춰야하는 수 :"+random+"</html>";

        return switch (gameState){
            case GAME_END -> "<html>1~50까지 수를 맞추는 게임<br>시작 버튼을 누르세요</html>";
            case GAME_START ->  "남은 기회 :"+(MAX_CNT-cnt)+", 맞춰야하는 수 :"+random;
            case GAME_WIN ->  "승리~!";
            case GAME_LOSE ->  "패배~!";
            case GAME_UP ->  "<html>UP~!"+hint;
            case GAME_DOWN ->  "<html>DOWN~!"+hint;
            default -> "게임을 다시 시작하세요.";
        };
    }

    //수를 입력해서 맞추는 이벤트
    //JTextField numInput 에서 클릭하거나 , JButton numBtn 을 누르면 발생하는 이벤트
    class NumInputHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String numStr=numInput.getText(); //입력한 수의 문자열
            //"30"->30 (O)
            //"삼십"-> 오류
            int num=0;
            try{
                num=Integer.parseInt(numStr); //수로 형변환
            }catch (NumberFormatException ex){
                centerLabel.setText("숫만 입력하세요!!");
                return; //다음코드가 실행되지 않도록 함수 종료
            }

            ++cnt;
            if(num==random){ //정답
                centerLabel.setText(gameMsg(GAME_WIN));
            }else if(cnt==MAX_CNT){ //오답인데 마지막 기회일때
                centerLabel.setText(gameMsg(GAME_LOSE));
            }else{ //오답인데 마지막 기회가 아닐때
                if(num>random){
                    centerLabel.setText(gameMsg(GAME_DOWN));
                }else {
                    centerLabel.setText(gameMsg(GAME_UP));
                }
            }
        }
    }


    public S01Q04RandomNum(){
        startBtn=new JButton("시작");
        endBtn=new JButton("종료");
        centerLabel=new JLabel(gameMsg(GAME_END),SwingConstants.CENTER);
        centerLabel.setFont(new Font("",Font.BOLD,30));
        topPanel=new JPanel();
        topPanel.setLayout(new GridLayout(1,2));
        topPanel.add(startBtn);
        topPanel.add(endBtn);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(centerLabel);

        numLabel=new JLabel("수 입력:");
        numInput=new JTextField(5);
        numBtn=new JButton("제출");
        numInput.addActionListener(new NumInputHandler());
        numBtn.addActionListener(new NumInputHandler());

        bottomPanel=new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(numLabel);
        bottomPanel.add(numInput);
        bottomPanel.add(numBtn);

        this.add(bottomPanel,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0,0,500,400);
        this.setVisible(true);

        startBtn.addActionListener((e)->{
            random= (int)(50*Math.random()) +1;
            centerLabel.setText(gameMsg(GAME_START));
            cnt=0; //게임할 기회
            numInput.requestFocusInWindow(); //숫자 입력창에 포커스 주기
        });

    }



    public static void main(String[] args) {
        new S01Q04RandomNum();
    }
}
