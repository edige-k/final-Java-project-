package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends Container {
    public JButton addd;
    public JButton listSchedules;
    public JButton delete;
    public JButton exit;

    public AdminMainMenu() {
        setSize(700, 700);
        setLayout(null);
        addd = new JButton("Add Schedule");
        addd.setLocation(200, 150);
        addd.setSize(300, 30);
        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddPage();
            }
        });
        add(addd);

        listSchedules = new JButton("List_Schedules");
        listSchedules.setLocation(200, 190);
        listSchedules.setSize(300, 30);
        listSchedules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showListPage();
            }
        });
        add(listSchedules);


        delete= new JButton("Delete_Schedules");
        delete.setLocation(200, 230);
        delete.setSize(300, 30);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeletePage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setBounds(200, 310, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}


