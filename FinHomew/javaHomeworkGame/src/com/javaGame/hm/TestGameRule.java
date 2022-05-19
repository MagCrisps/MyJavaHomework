package com.javaGame.hm;

import javax.swing.*;
import java.awt.*;

public class TestGameRule extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7539399214829629925L;
	private int num = 1;
    public TestGameRule() {
        TextArea textArea = new TextArea(20,10);
        textArea.setText("游戏中有五个怪物随机移动，碰到怪物算死亡\\\n游戏中有随机出现的苹果，碰到一个苹果加一分，\\\n先达到十五分或者对手死亡算游戏胜利！");
        JScrollPane jScrollPane = new JScrollPane(textArea);
        this.add(jScrollPane);
        this.setBounds(200,200,400,400);
        this.setVisible(true);
        textArea.setEditable(false);
        setResizable(false);
        textArea.setBackground(Color.PINK);
    }
}

