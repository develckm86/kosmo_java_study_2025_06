package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;

public class A02Layout {
    /*	•	레이아웃(Layout Manager)이란?
컨테이너에 컴포넌트들을 어떻게 배치할지 결정하는 객체입니다.
각 컨테이너는 하나의 레이아웃 매니저를 가질 수 있으며, 컴포넌트의 위치와 크기를 자동으로 조정합니다.
대표적인 레이아웃 매니저들:

	•	FlowLayout:
컴포넌트를 왼쪽에서 오른쪽으로 순서대로 나열
기본적으로 JPanel의 기본 레이아웃
줄 바꿈도 자동 처리

	•	BorderLayout:
동서남북(center 포함) 5개의 영역에 컴포넌트를 배치
JFrame의 기본 레이아웃
add(comp, BorderLayout.NORTH) 형태로 지정

	•	GridLayout:
행 × 열 형태의 격자 구조로 모든 셀에 같은 크기로 컴포넌트 배치
new GridLayout(2, 3) → 2행 3열

	•	GridBagLayout:
가장 유연하고 복잡한 레이아웃
셀 병합, 비대칭 배치 가능 (실무에서 많이 사용됨)

	•	CardLayout:
여러 개의 화면을 카드처럼 겹쳐 놓고 하나씩 보여줌
탭 전환, 마법사(wizard) UI에 유용

*/
    public static void main(String[] args) {

        //Frame => window, 모든 컨테이너의 부모
        JFrame frame=new JFrame("레이아웃 수업");

        JButton btn=new JButton("1번");
        JButton btn2=new JButton("2번");
        JButton btn3=new JButton("3번");

        JPanel p=new JPanel(); //모든 컨테이너는 BorderLayout을 기본으로 사용
        p.setLayout(new FlowLayout());
        p.add(btn);
        p.add(btn2);
        p.add(btn3);
        frame.add(p, BorderLayout.NORTH);

        JLabel label=new JLabel("안녕!");
        frame.add(label); //"Center"는 생략가능

        frame.setBounds(-1980,0,500,500);
        frame.setVisible(true);

        //라벨 3개를 카드레이아웃으로 구성하고 버튼을 누르면 카드가 변경되도록 구현


    }
}
