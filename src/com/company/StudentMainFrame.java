package com.company;

import javax.swing.*;
public class StudentMainFrame extends JFrame {
    public StudentAddPage Attendences;
    public StudentListPage list;
    public StudentMainMenu menu;
    public StudentRegistr regitr;
    public StudentAdd addStudent;
    public Welcome2 welcome2;

    public StudentMainFrame(){
        setTitle("Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        menu = new StudentMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addStudent = new StudentAdd();
        addStudent.setLocation(0, 0);
        addStudent.setVisible(false);
        add(addStudent);

        welcome2 = new Welcome2();
        welcome2.setLocation(0, 0);
        welcome2.setVisible(true);
        add(welcome2);

        regitr=new StudentRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        Attendences = new StudentAddPage();
        Attendences.setLocation(0,0);
        Attendences.setVisible(false);
        add(Attendences);

        list= new StudentListPage();
        list.setLocation(0,0);
        list.setVisible(false);
        add(list);

        repaint();
    }
}

