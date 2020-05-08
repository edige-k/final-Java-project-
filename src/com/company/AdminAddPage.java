package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminAddPage extends Container {
    private JLabel labelkindofsubject;
    private JTextField textkindofsubject;

    private JLabel labelname;
    private JTextField textname;

    private JLabel labeltime;
    private JTextField texttime;

    private JButton addSubjects;
    private JButton back;

    public AdminAddPage() {
        setLayout(null);
        setSize(700, 700);

        labelkindofsubject = new JLabel("KindofSubject:");
        labelkindofsubject.setBounds(250, 150, 80, 40);
        add(labelkindofsubject);
        textkindofsubject = new JTextField();
        textkindofsubject.setBounds(340, 150, 100, 40);
        add(textkindofsubject);

        labelname = new JLabel("Name:");

        labelname.setBounds(250, 300, 80, 40);
        add(labelname);

        textname = new JTextField();
        textname.setBounds(340, 300, 100, 40);
        add(textname);

        labeltime = new JLabel("Time:");
        labeltime.setBounds(250, 350, 80, 40);
        add(labeltime);

        texttime = new JTextField();
        texttime.setBounds(340, 350, 100, 40);
        add(texttime);

        addSubjects = new JButton("Add");
        addSubjects.setBounds(250, 400, 100, 50);
        addSubjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Sheadules sheadules = new Sheadules(null, textkindofsubject.getText(), textname.getText(),texttime.getText() );
                    Admin.addShedules(sheadules);

                    textkindofsubject.setText("");
                    textname.setText("");
                    texttime.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addSubjects);

        back = new JButton("Back");
        back.setBounds(360, 400, 100, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(back);
    }
}


