package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminDeletePage  extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton delete;
    private JButton back;

    public AdminDeletePage() {
        setLayout(null);
        setSize(700, 700);

        label = new JLabel("INSERT ID:");
        label.setBounds(250, 450, 100, 50);
        add(label);

        textField = new JTextField("");
        textField.setBounds(340, 450, 100, 30);
        add(textField);

        delete = new JButton("DELETE");
        delete.setBounds(150, 500, 100, 50);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                try {
                    id = Long.parseLong(textField.getText());

                    Admin.deleteWithId(id);

                    Admin.showMenuPage();
                    textField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(delete);

        back = new JButton("BACK");
        back.setBounds(450, 500, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(back);

    }


    public void updateArea(ArrayList<Sheadules> sheadules) {

        String columnNames[] = new String[]{"ID", "KINDOFSUBJECTS", "NAME", "TIME"};

        String data[][] = new String[sheadules.size()][4];

        int i = 0;
        for (Sheadules st : sheadules) {
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getKindofsubjects();
            data[i][2] = st.getName();
            data[i][3] = st.getTime();
            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70, 80, 500, 500);

        add(table);
        repaint();
    }
}
