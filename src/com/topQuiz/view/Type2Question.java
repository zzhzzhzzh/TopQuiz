package com.topQuiz.view;

import com.topQuiz.model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Type2Question extends JPanel implements ActionListener, MouseListener {

    User user;
    private NavigationPanel navigationPanel;
    private JPanel questionPanel, picPanel;
    private JButton submitBtn, nextBtn, prevBtn;
    private JLabel quesLbl, quesContentLbl, cApicLabel, GpicLabel, LpicLabel, TpicLabel, wApicLebel;


    public Type2Question(User user, NavigationPanel navigationPanel) {

        this.user = user;
        this.navigationPanel = navigationPanel;
        questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));

        quesLbl = new JLabel("Question");
        quesLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
        quesLbl.setForeground(Color.BLUE);
        quesLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/question.png")));

        quesContentLbl = new JLabel("California");

        questionPanel.add(quesLbl);
        questionPanel.add(quesContentLbl);

        picPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        ImageIcon cAIcon = new ImageIcon(new ImageIcon("src/images/ca.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon georgiaIcon = new ImageIcon(new ImageIcon("src/images/Georgia.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon louisianaIcon = new ImageIcon(new ImageIcon("src/images/Louisiana.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon texasIcon = new ImageIcon(new ImageIcon("src/images/Texas.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon wAIcon = new ImageIcon(new ImageIcon("src/images/WA.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));


        cApicLabel = new JLabel(cAIcon);
        cApicLabel.addMouseListener(this);
        picPanel.add(cApicLabel);

        GpicLabel = new JLabel(georgiaIcon);
        GpicLabel.addMouseListener(this);
        picPanel.add(GpicLabel);

        LpicLabel = new JLabel(louisianaIcon);
        LpicLabel.addMouseListener(this);
        picPanel.add(LpicLabel);

        TpicLabel = new JLabel(texasIcon);
        TpicLabel.addMouseListener(this);
        picPanel.add(TpicLabel);

        wApicLebel = new JLabel(wAIcon);
        wApicLebel.addMouseListener(this);
        picPanel.add(wApicLebel);


        add(questionPanel, BorderLayout.NORTH);
        add(picPanel, BorderLayout.CENTER);

        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
//        JFrame f = new JFrame();
//        //f.setSize(800,800);
//        Type2Question app = new Type2Question();
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(app);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (quesContentLbl.getText() == "California" && e.getSource() == cApicLabel) {
            user.setCurScore(user.getCurScore() + 1);
            navigationPanel.updateScore(user.getCurScore());
            quesContentLbl.setText("Washington");
        } else if (quesContentLbl.getText() == "Washington" && e.getSource() == wApicLebel) {
            user.setCurScore(user.getCurScore() + 1);
            navigationPanel.updateScore(user.getCurScore());
            JOptionPane.showMessageDialog(null, "You have answered all question, please go back to home page");

        } else {
            JOptionPane.showMessageDialog(null, "incorrect anwer");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
