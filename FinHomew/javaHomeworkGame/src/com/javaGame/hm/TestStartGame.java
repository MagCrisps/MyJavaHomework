package com.javaGame.hm;


import javax.swing.*;

public class TestStartGame {
    public static void main(String[] args) {
        //��������
        JFrame jFrame = new JFrame("2D��սС��Ϸ");
        jFrame.setBounds(10,10,790,660);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //�����Ϸ���
        jFrame.add(new GameClass());
        //���ÿɼ�
        jFrame.setVisible(true);
    }
}

