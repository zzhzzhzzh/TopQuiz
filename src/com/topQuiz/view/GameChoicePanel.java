package com.topQuiz.view;

import javax.swing.*;
import java.awt.*;

public class GameChoicePanel extends JPanel{
    private JButton game1, game2, game3;

    public GameChoicePanel(GameWindow gameWindow) {

        game1 = new JButton("game1");
        game1.setPreferredSize(new Dimension(100, 100));
        game1.setActionCommand("click game1");
        game1.addActionListener(gameWindow);

        game2 = new JButton("game2");
        game2.setPreferredSize(new Dimension(100, 100));
        game2.setActionCommand("click game2");
        game2.addActionListener(gameWindow);

        game3 = new JButton("game3");
        game3.setPreferredSize(new Dimension(100, 100));
        game3.setActionCommand("click game3");
        game3.addActionListener(gameWindow);

        add(game1);
        add(game2);
        add(game3);

        setVisible(true);
    }
}
