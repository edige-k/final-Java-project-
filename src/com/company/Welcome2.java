package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome2 extends Container {
    public JButton aaa;

    public Welcome2() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("java Student.jpeg");

        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(-400, 0, 1500, 700);
        add(background);
        setVisible(true);

        aaa = new JButton("Student!!!");
        aaa.setLocation(200, 600);
        aaa.setSize(300, 30);
        aaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.showMenuPage();
            }
        });
        add(aaa);

    }
    int x=0, y=100;
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Font font = new Font("Tahoma",Font.BOLD+Font.PLAIN,100);
        g2.setFont(font);
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawString("Welcome",x,y);
        try{
            Thread.sleep(100);
        }catch (Exception ex){}
        x+=10;
        if(x>this.getWidth()){
            x=0;
        }
        repaint();
    }

}

