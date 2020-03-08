package com.topQuiz.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopQuizMain extends JFrame implements ActionListener {
    private JButton user, admin;

    public TopQuizMain() {
        super("Welcome to TopQuiz");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        admin = new JButton("admin");
        admin.setPreferredSize(new Dimension(200,200));
        admin.setActionCommand("click admin");
        admin.addActionListener(this);
        container.add(admin);

        user = new JButton("user");
        user.setPreferredSize(new Dimension(200, 200));
        user.setActionCommand("click user");
        user.addActionListener(this);
        container.add(user);

        pack();
        setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("click admin")) {
            new AdminLogin().setVisible(true);
        } else {
            new UserLogin().setVisible(true);
        }

    }


    public static void main(String[] args) {

        TopQuizMain topQuizMain = new TopQuizMain();
        topQuizMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
