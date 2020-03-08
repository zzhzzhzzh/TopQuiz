package com.topQuiz.view;

import com.sun.tools.javac.comp.Flow;
import com.topQuiz.dao.BlankQuestionDao;
import com.topQuiz.model.BlankQuestion;
import com.topQuiz.model.User;
import com.topQuiz.util.DbUtil;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FillBlankGames extends JFrame implements ActionListener {

    User user;
    private JPanel questionPanel, answerPanel, controlPanel;
    private JButton submitBtn, nextBtn, prevBtn;
    private JLabel quesLbl, quesContentLbl, ansLbl;
    private JTextArea ansTa;
    private List<BlankQuestion> questionList;
    private Iterator<BlankQuestion> iterator;
    private BlankQuestion blankQuestion;

    public FillBlankGames() throws Exception {
        super("Fill in Blank Games");
        //this.user = user;
        this.setSize(640, 300);
        this.setResizable(false);
        questionList = getQuestionList();
        iterator = questionList.iterator();
        blankQuestion = iterator.next();


        Container container = getContentPane();
        questionPanel = new JPanel();
        questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        quesLbl = new JLabel("Question");
        quesLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
        quesLbl.setForeground(Color.BLUE);
        quesLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/question.png")));

        quesContentLbl = new JLabel(blankQuestion.getQuestion());

        questionPanel.add(quesLbl);
        questionPanel.add(quesContentLbl);

        answerPanel = new JPanel();
        answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        ansLbl = new JLabel("Answer");
        ansLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
        ansLbl.setForeground(Color.BLUE);
        ansLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/answer.png")));

        ansTa = new JTextArea(2, 50);


        answerPanel.add(ansLbl);
        answerPanel.add(ansTa);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        nextBtn = new JButton("next");
        nextBtn.setActionCommand("next question");
        nextBtn.addActionListener(this);

        controlPanel.add(nextBtn);

        container.add(questionPanel, BorderLayout.NORTH);
        container.add(answerPanel, BorderLayout.CENTER);
        container.add(controlPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("next question")) {
            String answer = ansTa.getText();
            if (!answer.equals(blankQuestion.getAnswer())) { // wrong answer
                JOptionPane.showMessageDialog(null, "Your answer is incorrect");
            } else { //correct answer
                if (iterator.hasNext()) { // there still have some questions in this question list
                    blankQuestion = iterator.next();
                    quesContentLbl.setText(blankQuestion.getQuestion());
                } else { // switch to choice questions
                    JOptionPane.showMessageDialog(null, "switch to choice questions");

                }
            }
            ansTa.setText("");
        }
    }

    public static void createAndShowGUI() throws Exception {
        FillBlankGames app = new FillBlankGames();
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private List<BlankQuestion> getQuestionList() throws Exception {
        List<BlankQuestion> questionsList = new ArrayList<>();
        DbUtil dbUtil = new DbUtil();
        BlankQuestionDao blankQuestionDao = new BlankQuestionDao();
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet res = blankQuestionDao.search(con);
            while (res.next()) {
                String question = res.getString("question");
                String answer = res.getString("answer");
                questionsList.add(new BlankQuestion(question, answer));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeCon(con);
            return questionsList;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




}
