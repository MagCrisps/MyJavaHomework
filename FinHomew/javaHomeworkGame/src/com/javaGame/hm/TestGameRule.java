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
        textArea.setText("��Ϸ���������������ƶ�����������������\\\n��Ϸ����������ֵ�ƻ��������һ��ƻ����һ�֣�\\\n�ȴﵽʮ��ֻ��߶�����������Ϸʤ����");
        JScrollPane jScrollPane = new JScrollPane(textArea);
        this.add(jScrollPane);
        this.setBounds(200,200,400,400);
        this.setVisible(true);
        textArea.setEditable(false);
        setResizable(false);
        textArea.setBackground(Color.PINK);
    }
}

