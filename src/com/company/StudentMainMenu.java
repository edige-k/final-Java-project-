package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMainMenu extends Container {
    public JButton addAttendences;
    public JButton list;
    public JButton exit;
    public JButton basket;


    public StudentMainMenu() {
        setSize(700, 700);
        setLayout(null);

        addAttendences = new JButton("Add Attendances");
        addAttendences.setLocation(200, 150);
        addAttendences.setSize(300, 30);
        addAttendences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.frame.menu.setVisible(false);
                Student.frame.list.setVisible(false);
                Student.frame.Attendences.setVisible(true);
                Student.frame.repaint();
            }
        });
        add(addAttendences);

        list = new JButton("List_Attendences");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.showListPage();
            }
        });
        add(list);

        exit = new JButton("EXIT");
        exit.setBounds(200, 350, 300, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);


    }
}


