package com.javaGame.hm;


import javax.swing.*;

public class TestStartGame {
    public static void main(String[] args) {
        //制作窗口
        JFrame jFrame = new JFrame("2D对战小游戏");
        jFrame.setBounds(10,10,790,660);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //添加游戏面板
        jFrame.add(new GameClass());
        //设置可见
        jFrame.setVisible(true);
    }
}

