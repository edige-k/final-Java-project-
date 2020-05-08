package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentListPage extends Container {

    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton stud;
    private JButton back;
    private JTextArea area;

    public StudentListPage() {
        setLayout(null);
        setSize(700, 700);

        label = new JLabel("INSERT ID:");
        label.setBounds(250, 450, 80, 30);
        add(label);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        add(area);


        textField = new JTextField("");
        textField.setBounds(340, 450, 100, 30);
        add(textField);
        stud = new JButton("Attendence!");
        stud.setBounds(150, 500, 100, 50);
        stud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                try {
                    id = Long.parseLong(textField.getText());

                    Student.deleteWithId(id);
                    Student.showMainMenu();

                    textField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,
                        "Желаем хорошо сдать сессию!");
            }

        });
        add(stud);

        back = new JButton("BACK");
        back.setBounds(550, 600, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student.showMenuPage();
            }
        });
        add(back);

    }

    public void updateArea(ArrayList<Attendences> attendences) {
        area.setText("");
        for (Attendences ts : attendences) {
            area.append(ts + "\n");
        }
        repaint();
    }
}
