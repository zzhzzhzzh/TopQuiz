package com.topQuiz.view;

import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;

public class ChooseQuesType extends JFrame {
    private JButton blankQuesBtn, choiceQuesBtn;

    public ChooseQuesType(){
        super( "Choose Question Type" );
        
        // get content pane
        Container container = getContentPane();

        // set the layout
        container.setLayout( new FlowLayout() );

        // create buttons
        blankQuesBtn = new JButton("Blank Question");
        blankQuesBtn.setPreferredSize(new Dimension(150, 150));
        blankQuesBtn.setFont(new Font("Arial", Font.BOLD, 16));
        blankQuesBtn.setBackground(Color.WHITE);
        blankQuesBtn.setForeground(Color.RED);
        blankQuesBtn.setActionCommand("blankQues");

        choiceQuesBtn = new JButton("Choice Question");
        choiceQuesBtn.setPreferredSize(new Dimension(150, 150));
        choiceQuesBtn.setFont(new Font("Arial", Font.BOLD, 16));
        choiceQuesBtn.setBackground(Color.WHITE);
        choiceQuesBtn.setForeground(Color.BLUE);
        choiceQuesBtn.setActionCommand("choiceQues");

        container.add(blankQuesBtn);
        container.add(choiceQuesBtn);

        setLocationRelativeTo(null);
        // Use an anonymous class as an event handler
        blankQuesBtn.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent event){
				dispose();
				new FillBlankQues().setVisible(true);
            }

        });

        choiceQuesBtn.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent event){
                dispose();
                new FillChoiceQues().setVisible(true);
            }

        });

        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }


    public static void createAndShowGUI(){
        ChooseQuesType app = new ChooseQuesType();
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}  


