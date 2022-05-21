package com.javaGame.hm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.PixelGrabber;
import java.util.Random;

public class GameClass extends JPanel implements KeyListener, ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��ʼ����������
    int p1X;
    int p1Y;
    int p2X;
    int p2Y;
    public static int pixel = 30;
    boolean isStart = false;    //��Ϸ�Ƿ�ʼ
    boolean p1isFail = false;     //��Ϸ�Ƿ�ʧ��
    boolean p2isFail = false;
    String fx1;         //��L�� �ң�R�� �ϣ�U�� �£�D
    String fx2;

    Timer timer = new Timer(50,this);//��ʱ��

    //����
    int p1score = 0;
    int p2score = 0;

    //ƻ��
    int AppleX;
    int AppleY;

    //����
    int monster1X;
    int monster1Y;
    int monster2X;
    int monster2Y;
    int monster3X;
    int monster3Y;
    int monster4X;
    int monster4Y;
    int monster5X;
    int monster5Y;

    //�������
    Random random = new Random();


    public GameClass() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }


    //��ʼ��
    public void init() {
        p1X = 25;
        p1Y = 150;
        p2X = 700;
        p2Y = 550;
        fx1 = "L";
        fx2 = "R";
        monster1X = 25*random.nextInt(28);
        monster1Y = 100 + 25*random.nextInt(18);
        monster2X = 25*random.nextInt(28);
        monster2Y = 100 + 25*random.nextInt(18);
        monster3X = 25*random.nextInt(28);
        monster3Y = 100 + 25*random.nextInt(18);
        monster4X = 25*random.nextInt(28);
        monster4Y = 100 + 25*random.nextInt(18);
        monster5X = 25*random.nextInt(28);
        monster5Y = 100 + 25*random.nextInt(18);
        AppleX = 25*random.nextInt(28);
        AppleY = 100 + 25*random.nextInt(18);

        add(startGame);
        add(restart);
        showRule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TestGameRule();
            }
        });
    }


    //��Ϸ���ܰ�ť
    JButton startGame = new JButton("��ʼ");
    JButton restart = new JButton("���¿�ʼ");
    JButton showRule = new JButton("��Ϸ����");

    //����
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        TestGameData.header.paintIcon(this,g,0,0);
        g.setColor(Color.CYAN);
        g.fillRect(0,100,780,520);

        //������
        TestGameData.p1player1.paintIcon(this,g,p1X,p1Y);
        TestGameData.p2player1.paintIcon(this,g,p2X,p2Y);

        //���÷�
        g.setFont(new Font("���Ĳ���",Font.BOLD,18));  //��������
        g.setColor(Color.RED);
        g.drawString("���1��" + p1score,20,20 );
        g.drawString("���2��" + p2score,680,20);

        //��ƻ��
        TestGameData.apple.paintIcon(this,g,AppleX,AppleY);

        //����̬����
        TestGameData.monster.paintIcon(this,g,monster1X,monster1Y);
        TestGameData.monster.paintIcon(this,g,monster2X,monster2Y);
        TestGameData.monster.paintIcon(this,g,monster3X,monster3Y);
        TestGameData.monster.paintIcon(this,g,monster4X,monster4Y);
        TestGameData.monster.paintIcon(this,g,monster5X,monster5Y);



        //��Ϸ��ʾ���Ƿ�ʼ
        if(!isStart) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("���Ĳ���",Font.BOLD,30));
            g.drawString("������ʼ��Ϸ",300,300);
        }

        //��Ϸ������ʾ���Ƿ����¿�ʼ
        if(p2isFail || p1score == 15) {
            g.setColor(Color.RED);
            g.setFont(new Font("���Ĳ���",Font.BOLD,30));
            g.drawString("���һ��ʤ���������¿�ʼ��Ϸ",200,300);
        }
        if(p1isFail || p2score == 15) {
            g.setColor(Color.RED);
            g.setFont(new Font("���Ĳ���",Font.BOLD,30));
            g.drawString("��Ҷ���ʤ���������¿�ʼ��Ϸ",200,300);
        }
    }

    //���̼����¼�
    @Override
    public void keyPressed(KeyEvent e) {
        //���������߶�
        //���1
        if(isStart == true && (p1isFail == false && p2isFail == false)) {
            if(e.getKeyCode() == KeyEvent.VK_D) {
                fx1 = "R";
                p1X += 25;
                if(p1X >= 750) {p1X = 750;}
            }
            else if(e.getKeyCode() == KeyEvent.VK_A) {
                fx1 = "L";
                p1X -= 25;
                if(p1X <= 0) {p1X = 0;}
            }
            else if(e.getKeyCode() == KeyEvent.VK_W) {
                fx1 = "U";
                p1Y -= 25;
                if(p1Y <= 100) {p1Y = 100;}
            }
            else if(e.getKeyCode() == KeyEvent.VK_S) {
                fx1 = "D";
                p1Y += 25;
                if(p1Y >= 600) {p1Y = 600;}
            }

            //���2
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                fx2 = "R";
                p2X += 25;
                if(p2X >= 750) {p2X = 750;}
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                fx2 = "L";
                p2X -= 25;
                if(p2X <= 0) {p2X = 0;}
            }
            else if(e.getKeyCode() == KeyEvent.VK_UP) {
                fx2 = "U";
                p2Y -= 25;
                if(p2Y <= 100) {p2Y = 100;}
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                fx2 = "D";
                p2Y += 25;
                if(p2Y >= 600) {p2Y = 600;}
            }
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStart = true;
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p1isFail) { p1isFail = !p1isFail; init(); }
                if(p2isFail) { p2isFail = !p2isFail; init(); }
            }
        });

        add(startGame);
        add(restart);
        add(showRule);

        if(isStart == true && (p1isFail == false && p2isFail == false)) {

            //���˶�����
            if(fx1.equals("R")) {
                p1X += 25;
                if(p1X >= 750) { p1X = 750; }
            }
            if(fx1.equals("L")) {
                p1X -= 25;
                if(p1X <= 0) { p1X = 0; }
            }
            if(fx1.equals("U")) {
                p1Y -= 25;
                if(p1Y <= 100) { p1Y = 100; }
            }
            if(fx1.equals("D")) {
                p1Y += 25;
                if(p1Y >= 600) { p1Y = 600; }
            }

            if(fx2.equals("R")) {
                p2X += 25;
                if(p2X >= 750) { p2X = 750; }
            }
            if(fx2.equals("L")) {
                p2X -= 25;
                if(p2X <= 0) { p2X = 0; }
            }
            if(fx2.equals("U")) {
                p2Y -= 25;
                if(p2Y <= 100) { p2Y = 100; }
            }
            if(fx2.equals("D")) {
                p2Y += 25;
                if(p2Y >= 600) { p2Y = 600; }
            }

            //�ù��ﶯ����
                //����1
                int i = random.nextInt(4) + 1;
                if(i == 1) {
                    monster1X += 5;
                    if(monster1X >= 750) {monster1X = 750;}
                }
                if(i == 2) {
                    monster1X -= 5;
                    if(monster1X <= 0) {monster1X = 0;}
                }
                if(i == 3) {
                    monster1Y += 5;
                    if(monster1Y >= 600) {monster1Y = 600;}
                }
                if(i == 4) {
                    monster1Y -= 5;
                    if(monster1Y <= 100) {monster1Y = 100;}
                }
            //����2
            int j = random.nextInt(4) + 1;
            if(j == 1) {
                monster2X += 5;
                if(monster2X >= 750) {monster2X = 750;}
            }
            if(j == 2) {
                monster2X -= 5;
                if(monster2X <= 0) {monster2X = 0;}
            }
            if(j == 3) {
                monster2Y += 5;
                if(monster2Y >= 600) {monster2Y = 600;}
            }
            if(j == 4) {
                monster2Y -= 5;
                if(monster2Y <= 100) {monster2Y = 100;}
            }
            //����3
            int k = random.nextInt(4) + 1;
            if(k == 1) {
                monster3X += 5;
                if(monster3X >= 750) {monster3X = 750;}
            }
            if(k == 2) {
                monster3X -= 5;
                if(monster3X <= 0) {monster3X = 0;}
            }
            if(k == 3) {
                monster3Y += 5;
                if(monster3Y >= 600) {monster3Y = 600;}
            }
            if(k == 4) {
                monster3Y -= 5;
                if(monster3Y <= 100) {monster3Y = 100;}
            }
            //����4
            int n= random.nextInt(4) + 1;
            if(n == 1) {
                monster4X += 5;
                if(monster4X >= 750) {monster4X = 750;}
            }
            if(n == 2) {
                monster4X -= 5;
                if(monster4X <= 0) {monster4X = 0;}
            }
            if(n == 3) {
                monster4Y += 5;
                if(monster4Y >= 600) {monster4Y = 600;}
            }
            if(n == 4) {
                monster4Y -= 5;
                if(monster4Y <= 100) {monster4Y = 100;}
            }
            //����5
            int m = random.nextInt(4) + 1;
            if(m == 1) {
                monster5X += 5;
                if(monster5X >= 750) {monster5X = 750;}
            }
            if(m == 2) {
                monster5X -= 5;
                if(monster5X <= 0) {monster5X = 0;}
            }
            if(m == 3) {
                monster5Y += 5;
                if(monster5Y >= 600) {monster5Y = 600;}
            }
            if(m == 4) {
                monster5Y -= 5;
                if(monster5Y <= 100) {monster5Y = 100;}
            }



            //�������ҳԵ�ʳ��
            if(p1X == AppleX && p1Y == AppleY) {
                p1score++;
                AppleX = 25*random.nextInt(28);
                AppleY = 100 + 25*random.nextInt(18);
            } else if(p2X == AppleX && p2Y == AppleY) {
                p2score++;
                AppleX = 25*random.nextInt(28);
                AppleY = 100 + 25*random.nextInt(18);
            }

            //����������������ж���������Ϸ����           �������޸ģ�����
            //����1����
            if(p1X >= monster1X -pixel && p1X <= monster1X +pixel) {
                if(p1Y == monster1Y) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p1Y >= monster1Y -pixel && p1Y <= monster1Y +pixel) {
                if(p1X == monster1X) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p2X >= monster1X -pixel && p2X <= monster1X +pixel) {
                if(p2Y == monster1Y) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            if(p2Y >= monster1Y -pixel && p2Y <= monster1Y +pixel) {
                if(p2X == monster1X) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            //����2����
            if(p1X >= monster2X -pixel && p1X <= monster2X +pixel) {
                if(p1Y == monster2Y) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p1Y >= monster2Y -pixel && p1Y <= monster2Y +pixel) {
                if(p1X == monster2X) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p2X >= monster2X -pixel && p2X <= monster2X +pixel) {
                if(p2Y == monster2Y) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            if(p2Y >= monster2Y -pixel && p2Y <= monster2Y +pixel) {
                if(p2X == monster2X) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            //����3����
            if(p1X >= monster3X -pixel && p1X <= monster3X +pixel) {
                if(p1Y == monster3Y) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p1Y >= monster3Y -pixel && p1Y <= monster3Y +pixel) {
                if(p1X == monster3X) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p2X >= monster3X -pixel && p2X <= monster3X +pixel) {
                if(p2Y == monster3Y) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            if(p2Y >= monster3Y -pixel && p2Y <= monster3Y +pixel) {
                if(p2X == monster3X) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            //����4����
            if(p1X >= monster4X -pixel && p1X <= monster4X +pixel) {
                if(p1Y == monster4Y) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p1Y >= monster4Y -pixel && p1Y <= monster4Y +pixel) {
                if(p1X == monster1X) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p2X >= monster4X -pixel && p2X <= monster4X +pixel) {
                if(p2Y == monster4Y) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            if(p2Y >= monster4Y -pixel && p2Y <= monster4Y +pixel) {
                if(p2X == monster4X) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            //����5����
            if(p1X >= monster5X -pixel && p1X <= monster5X +pixel) {
                if(p1Y == monster5Y) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p1Y >= monster5Y -pixel && p1Y <= monster5Y +pixel) {
                if(p1X == monster5X) { p1isFail = !p1isFail; p1score = p2score = 0;}
            }
            if(p2X >= monster5X -pixel && p2X <= monster5X +pixel) {
                if(p2Y == monster5Y) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            if(p2Y >= monster5Y -pixel && p2Y <= monster5Y+pixel) {
                if(p2X == monster5X) { p2isFail = !p2isFail; p1score = p2score = 0;}
            }
            //�������Ҵﵽָ�����֣��ж���ʤ����Ϸ����
            if(p1score == 15) { p2isFail = !p2isFail; }
            if(p2score == 15) { p1isFail = !p1isFail; }

            repaint();
        }
        timer.start();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

