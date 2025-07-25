package com.kosmo.advance;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class A19Memo extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem fileOpen; //파일 찾아서 textArea 출력
    JMenuItem fileSave; //textArea의 내용을 파일로 저장
    JMenuItem exit; //메모장 종료
    //탐색기 컴포넌트
    JFileChooser fileChooser;
    JTextArea textArea;
    public A19Memo(){
        super("메모장");

        fileChooser=new JFileChooser();
        textArea=new JTextArea();
        this.add(textArea, BorderLayout.CENTER);

        menuBar=new JMenuBar();
        menu=new JMenu("파일");

        fileOpen=new JMenuItem("열기...");
        fileSave=new JMenuItem("저장");
        //Dialog 로 창을 열때는 부모창을 기준으로 열기 때문에 JFrame 객체를 전달!!
        fileOpen.addActionListener((e)->{
           int state=fileChooser.showOpenDialog(A19Memo.this);
           if(state==JFileChooser.APPROVE_OPTION){ //파일을 선택한 상태! fileChooser 내에 선택한 파일을 참조하고 있음
               File selectedFile = fileChooser.getSelectedFile();
               System.out.println(selectedFile.getName());
               //file 데이터를 문자열로 출력하는 객체는??  read write : 문자열과 관련된 입출력
               try (FileReader fileReader=new FileReader(selectedFile);
                    BufferedReader bufferedReader=new BufferedReader(fileReader);
               ){
                   String str="";
                   StringBuilder sb=new StringBuilder();
                   while ((str=bufferedReader.readLine())!=null){
                       sb.append(str+"\n");
                   }
                   textArea.setText(sb.toString());
               } catch (FileNotFoundException ex) {
                   throw new RuntimeException(ex);
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               }
           }
        });
        fileSave.addActionListener((e)->{
            //FileChooser save 모드 (폴더 선택,파일이름 작성)
            int state=fileChooser.showSaveDialog(A19Memo.this);
            if(state==JFileChooser.APPROVE_OPTION){
                //폴더와 파일이름을 작성하면 File 객체를 생성 후 반환
                File file=fileChooser.getSelectedFile();
                try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));){
                    String txt=textArea.getText();
                    bufferedWriter.write(txt);
                    System.out.println("저장 완료!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });
        menu.add(fileOpen);
        menu.add(fileSave);
        menuBar.add(menu);
        //this.add(menuBar);
        this.setJMenuBar(menuBar);


        setBounds(0,0,400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new A19Memo();
    }
}
