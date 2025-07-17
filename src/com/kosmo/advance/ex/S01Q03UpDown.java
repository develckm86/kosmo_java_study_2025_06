package com.kosmo.advance.ex;

import javax.swing.*;
import java.awt.*;

/*3. Up/Down 버튼으로 숫자 조작 (Medium)

목표:
	•	“▲ 증가”, “▼ 감소” 버튼으로 숫자 조절
	•	마우스 휠로도 조작 가능 (보너스) ** Label 에 마우스 휠 이벤트 사용
	•	최대/최소 범위 제한

⸻
*/
public class S01Q03UpDown extends JFrame {
    private JButton upBtn;
    private JButton downBtn;
    private JButton resetBtn;
    private JLabel label;
    private JPanel p;
    private int num;
    private final int MAX;
    private final int MIN;
    public S01Q03UpDown(int MAX, int MIN){
        this.MAX=MAX;
        this.MIN=MIN;
        this.p=new JPanel();
        this.p.setLayout(new FlowLayout());
        this.resetBtn=new JButton("리셋");
        this.upBtn =new JButton("++n");
        this.downBtn =new JButton("--n");
        p.add(upBtn);
        p.add(downBtn);
        this.add(p,BorderLayout.NORTH);
        this.add(resetBtn,BorderLayout.SOUTH);
        resetBtn.addActionListener((e)->{
            num=0;
            label.setText(num+"");
        });
        upBtn.addActionListener((e)->{
            if(num==MAX) return;
            ++num;
            label.setText(num+"");
        });
        downBtn.addActionListener((e)->{
             if (num==MIN) return;
            --num;
            label.setText(num+"");

        });
        this.label=new JLabel(num+" -10 부터 10까지 카운터",SwingConstants.CENTER);
        this.add(label);
        label.addMouseWheelListener((e)->{
            int rotation=e.getWheelRotation();
            if(rotation>0){ // 휠업
                if(num>=MAX) return;
                ++num;
            }else{//휠 다운
                if(num<=MIN) return;
                --num;
            }
            label.setText(num+"");
        });

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0,0,400,400);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new S01Q03UpDown(10,-10);
    }
}
