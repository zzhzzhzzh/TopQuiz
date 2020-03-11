package com.topQuiz.view;

import com.topQuiz.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationPanel extends JPanel  {
    private JButton homeBtn;
    private JLabel username, score;
    private User user;

    public NavigationPanel(User user, GameWindow gameWindow) {
        this.user = user;
        setLayout(new FlowLayout());

        homeBtn = new JButton("Home");
        homeBtn.setActionCommand("click Home");
        homeBtn.addActionListener(gameWindow);

        username = new JLabel(user.getUsername());
        username.setFont(new Font("ARIAL", Font.PLAIN, 19));
        username.setForeground(Color.BLUE);

        score = new JLabel(String.valueOf(user.getCurScore()));
        add(username);
        add(score);
        add(homeBtn);

        setVisible(true);
    }

    public void updateScore(int score) {
        this.score.setText(String.valueOf(score));
    }



}
