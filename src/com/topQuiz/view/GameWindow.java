package com.topQuiz.view;

import com.topQuiz.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener {

    private JButton game1, game2, game3, mainBtn;
    private JPanel scorePanel;
    private JLabel username, score;
    private User user;

    public GameWindow(User user) {
        super("Welcome to TopQuiz");

        this.user = user;
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout());

        game1 = new JButton("game1");
        game1.setPreferredSize(new Dimension(300, 300));
        game1.setActionCommand("click game1");
        game1.addActionListener(this);
        container.add(game1);

        game2 = new JButton("game2");
        game2.setPreferredSize(new Dimension(300, 300));
        game2.setActionCommand("click game2");
        game2.addActionListener(this);
        container.add(game2);

        game3 = new JButton("game3");
        game3.setPreferredSize(new Dimension(300, 300));
        game3.setActionCommand("click game3");
        game3.addActionListener(this);
        container.add(game3);

        username = new JLabel(user.getUsername());
        username.setFont(new Font("ARIAL", Font.PLAIN, 19));
        username.setForeground(Color.BLUE);

        score = new JLabel(String.valueOf(user.getMaxSocre()));
        scorePanel.add(username);
        scorePanel.add(score);
        container.add(scorePanel);

        mainBtn = new JButton("main");
        mainBtn.setPreferredSize(new Dimension(100, 100));
        mainBtn.setActionCommand("click main");
        mainBtn.addActionListener(this);
        container.add(mainBtn);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("click main")) {
            getContentPane().setVisible(false);
        }
        if (event.getActionCommand().equals("click game1")) {
            getContentPane().removeAll();
            repaint();
            try {
                getContentPane().add(new FillBlankPanel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            validate();
//            dispose();
//            new FillBlankQues().setVisible(true);
        } else if (event.getActionCommand().equals("click game2")) {
            dispose();
            new GameWindow(user).setVisible(true);
        } else if (event.getActionCommand().equals("click game3")){
            getContentPane().removeAll();
            repaint();
            getContentPane().add(new MyPanel());
            validate();
        }else {

        }
    }

    public static void createAndShowGUI(User user) {
        GameWindow gameWindow = new GameWindow(user);
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



}
