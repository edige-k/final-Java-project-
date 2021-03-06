package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class StudentAddPage extends Container {
    private JLabel labelSheadulesId;
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelSurname;
    private JTextField textSurname;
    private JLabel labelPasswordNumber;
    private JTextField textPasswordNumber;
    private JButton addAttendences;
    private JButton back;

    public StudentAddPage(){
        setLayout(null);
        setSize(700,700);

        labelSheadulesId=new JLabel("Schedule_Id:");
        labelSheadulesId.setBounds(100,150,120,40);
        add(labelSheadulesId);

        Sheadules[]sheadules=null;
        ArrayList<Sheadules> list = Student.listSheadules();
        sheadules = list.toArray(new Sheadules[list.size()]);

        JComboBox comboBox=new JComboBox(sheadules);
        comboBox.setBounds(230,150,250,40);
        add(comboBox);
        labelName=new JLabel("Name:");
        labelName.setBounds(100,200,120,40);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(230,200,250,40);
        add(textName);

        labelSurname=new JLabel("Surname:");
        labelSurname.setBounds(100,250,120,40);
        add(labelSurname);

        textSurname=new JTextField();
        textSurname.setBounds(230,250,250,40);
        add(textSurname);

        labelPasswordNumber=new JLabel("PasswordNumber");
        labelPasswordNumber.setBounds(100,300,120,40);
        add(labelPasswordNumber);

        textPasswordNumber=new JTextField();
        textPasswordNumber.setBounds(230,300,250,40);
        add(textPasswordNumber);

        addAttendences =new JButton("ADD");
        addAttendences.setBounds(100,400,120,50);
        addAttendences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Sheadules mySheadules = (Sheadules) comboBox.getSelectedItem();
                    Attendences attendences=new Attendences(null,mySheadules.getId().intValue(),textName.getText(),textSurname.getText(),textPasswordNumber.getText());
                    Student.addAttendences(attendences);

                    textName.setText("");
                    textSurname.setText("");
                    textPasswordNumber.setText("");

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(addAttendences);

        back=new JButton("BACK");
        back.setBounds(360,400,120,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student.frame.Attendences.setVisible(false);
                Student.frame.list.setVisible(false);
                Student.frame.menu.setVisible(true);
                Student.frame.repaint();
            }
        });
        add(back);
    }
}
