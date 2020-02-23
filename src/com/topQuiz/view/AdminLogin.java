package com.topQuiz.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminLogin extends JFrame{
    private JPanel panel1,panel2;
    private JButton submitBtn;
    private JLabel unameLbl,pswLbl;
    private JTextField unametTf, pswTf;

    public AdminLogin(){
        super( "Admin Login" );
        this.setSize(250, 250);
        this.setResizable(false);
        
        // get content pane
        Container container = getContentPane();
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        
        // create  labels
        unameLbl = new JLabel("Username");
        pswLbl = new JLabel("Password");
        unameLbl.setFont(new Font("ARIAL", Font.PLAIN, 19));
        unameLbl.setForeground(Color.BLUE);
        pswLbl.setFont(new Font("ARIAL", Font.PLAIN, 19));
        pswLbl.setForeground(Color.BLUE);

        unametTf = new JTextField(10);
        pswTf = new JTextField(10);

        // Add the labels and textfields to panel1
        panel1.add(unameLbl);
        panel1.add(unametTf);
        panel1.add(pswLbl);
        panel1.add(pswTf);

        // Create and add button to panel2
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        submitBtn = new JButton("Submit");
        submitBtn.setActionCommand("submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 16));

        // add the event handlers to the buttons
        ButtonEventHandler handler = new ButtonEventHandler();
        submitBtn.addActionListener(handler);

        panel2.add(submitBtn);

        container.add(panel1,BorderLayout.PAGE_START);
        container.add(panel2,BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    class ButtonEventHandler implements ActionListener {
        public void actionPerformed( ActionEvent event ){

            if ( (unametTf.getText().equals("")) || (pswTf.getText().equals(""))){
                  JOptionPane.showMessageDialog(null, "Please enter full info!");
            }

            else {
                if (event.getActionCommand().equals("submit")){
                    if ( (unametTf.getText().equals("admin")) && (pswTf.getText().equals("123456"))){
                        dispose();
        				new ChooseQuesType().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Wrong user info!");
                        unametTf.setText("");
                        pswTf.setText("");
                    }
                }
     

            }
        }

    }
    public static void createAndShowGUI(){
        AdminLogin app = new AdminLogin();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
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
