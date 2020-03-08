package com.topQuiz.view;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    JButton myByn;

    public MyPanel() {
        setLayout(new FlowLayout());

        myByn = new JButton("123");
        myByn.setFont(new Font("Arial", Font.BOLD, 16));

        add(myByn);
    }


}
