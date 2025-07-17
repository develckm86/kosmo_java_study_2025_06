package com.kosmo.advance.ex;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*2. 카운터 앱 (Medium)

목표:  숫자를 증가시키는 카운터입니다.
* 버튼 3개는 1,10,100 씩 수를 증가시키는 버튼이고 리셋버튼으로 0으로 바꿀수 있습니다.
*
	•	기능:
	•	1 씩 증가하는 버튼
	•	10씩 증가하는 버튼
	•	100 씩 증가하는 버튼
	•	0으로 수를 리셋하는 버튼
	•	수를 출력하는 라벨

*/
public class S01Q02ClickCounter extends JFrame {
    private JButton upBtn1;
    private JButton upBtn10;
    private JButton upBtn100;
    private JButton resetBtn;
    private JPanel btnPanel;
    private JLabel label;
    private int num;

    class BtnHandler implements ActionListener{
        private int increase;
        public BtnHandler(int increase){
            this.increase=increase;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
                num+=increase;
                label.setText(num+"");
        }
    }

    public S01Q02ClickCounter(){
        super("클릭 카운터");
        this.upBtn1=new JButton("num+=1");
        this.upBtn10=new JButton("num+=10");
        this.upBtn100=new JButton("num+=100");
        this.resetBtn=new JButton("num=0");
        this.label=new JLabel(num+"",SwingConstants.CENTER);
        this.label.setFont(new Font("",Font.BOLD,30));
        this.upBtn1.addActionListener(new BtnHandler(1));
        this.upBtn10.addActionListener(new BtnHandler(10));
        this.upBtn100.addActionListener(new BtnHandler(100));
        this.resetBtn.addActionListener((e)->{
            num=0;
            label.setText(num+"");
        });
        this.btnPanel=new JPanel();
        this.btnPanel.setLayout(new FlowLayout());
        this.btnPanel.add(upBtn1);
        this.btnPanel.add(upBtn10);
        this.btnPanel.add(upBtn100);
        this.btnPanel.add(resetBtn);

        this.add(btnPanel,BorderLayout.NORTH);
        this.add(label);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0,0,500,400);
        this.setVisible(true);

    }

    public static void main(String[] args) throws InterruptedException {
        new S01Q02ClickCounter();
    }
}
