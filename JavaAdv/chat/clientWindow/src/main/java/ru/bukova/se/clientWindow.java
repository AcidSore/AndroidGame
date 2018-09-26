package ru.bukova.se;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class clientWindow extends JFrame {

    public clientWindow() {
        setTitle("IrishaChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 400, 500, 500);
        setLayout(new BorderLayout());
        JPanel panelUp = new JPanel();
        JPanel panelDown = new JPanel();
        add(panelUp, BorderLayout.CENTER);
        add(panelDown, BorderLayout.SOUTH);
        JButton button = new JButton("enter");
        final JTextArea history = new JTextArea();
        final JTextField text = new JTextField();
        JScrollPane scroll = new JScrollPane(history);
        panelUp.setLayout(new BorderLayout());
        panelUp.add(scroll, BorderLayout.CENTER);
        panelDown.setLayout(new BorderLayout());
        panelDown.add(text, BorderLayout.CENTER);
        panelDown.add(button, BorderLayout.EAST);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                history.setText(history.getText()+"\n"+text.getText());
                text.setText(null);

            }
        });

        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                history.setText(history.getText() +"\n"+ text.getText());
                text.setText(null);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.out.println("See you later");
            }
        });
    }

}
