package com.topQuiz.view;

import com.topQuiz.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener {

    private JButton game1, game2, game3, homeBtn;
    private JPanel gameChoicePanel;
    private  NavigationPanel navigationPanel;
    private JLabel username, score;
    private User user;

    public GameWindow(User user) {
        super("Welcome to TopQuiz");
        setSize(600, 400);
        this.user = user;
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        navigationPanel = new NavigationPanel(user, this);
        gameChoicePanel = new GameChoicePanel(this);

        container.add(navigationPanel, BorderLayout.PAGE_START);
        container.add(gameChoicePanel, BorderLayout.CENTER);

        //pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("click game1")) {
            getContentPane().remove(gameChoicePanel);
            repaint();
            try {
                getContentPane().add(new FillBlankPanel(user, navigationPanel), BorderLayout.CENTER);
            } catch (Exception e) {
                e.printStackTrace();
            }
            validate();
        } else if (event.getActionCommand().equals("click game2")) {
            getContentPane().remove(gameChoicePanel);
            repaint();
            try {
                getContentPane().add(new Type2Question(user, navigationPanel), BorderLayout.CENTER);
            } catch (Exception e) {
                e.printStackTrace();
            }
            validate();
        } else if (event.getActionCommand().equals("click game3")){
//            getContentPane().removeAll();
//            repaint();
//            getContentPane().add(new MyPanel());
//            validate();
        }else if (event.getActionCommand().equals("click Home")){
            BorderLayout layout = (BorderLayout) getContentPane().getLayout();
            getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
            repaint();
            getContentPane().add(gameChoicePanel, BorderLayout.CENTER);
        }
    }

    public static void createAndShowGUI(User user) {
        GameWindow gameWindow = new GameWindow(user);
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



}
