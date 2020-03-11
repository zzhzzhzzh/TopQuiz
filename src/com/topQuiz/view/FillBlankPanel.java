package com.topQuiz.view;

import com.topQuiz.dao.BlankQuestionDao;
import com.topQuiz.model.BlankQuestion;
import com.topQuiz.model.User;
import com.topQuiz.util.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FillBlankPanel extends JPanel implements ActionListener {

    User user;
    private JPanel questionPanel, answerPanel, controlPanel, scorePanel;
    private JButton submitBtn, nextBtn, prevBtn, mainBtn;
    private JLabel quesLbl, quesContentLbl, ansLbl, score, username;
    private JTextArea ansTa;
    private List<BlankQuestion> questionList;
    private Iterator<BlankQuestion> blankQuestionIterator;
    private BlankQuestion blankQuestion;

    public FillBlankPanel(User user) throws Exception {
        this.user = user;
        questionList = getQuestionList();
        blankQuestionIterator = questionList.iterator();
        if (blankQuestionIterator.hasNext()) {
            blankQuestion = blankQuestionIterator.next();
        }

        questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

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
        mainBtn = new JButton("Home");
        mainBtn.setActionCommand("Home");
        nextBtn.addActionListener(this);

        controlPanel.add(nextBtn);

        scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout());
        username = new JLabel(user.getUsername());
        username.setFont(new Font("Arial", Font.PLAIN, 19));
        username.setForeground(Color.BLUE);
        score = new JLabel(String.valueOf(user.getCurScore()));
        scorePanel.add(username);
        scorePanel.add(score);

        add(scorePanel);
        add(questionPanel);
        add(answerPanel);
        add(controlPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("next question")) {
            String answer = ansTa.getText();
            if (!answer.equals(blankQuestion.getAnswer())) { // wrong answer
                JOptionPane.showMessageDialog(null, "Your answer is incorrect");
            } else { //correct answer
                if (blankQuestionIterator.hasNext()) { // there still have some questions in this question list
                    user.setCurScore(user.getCurScore() + 1);

                    blankQuestion = blankQuestionIterator.next();
                    quesContentLbl.setText(blankQuestion.getQuestion());
                } else { // switch to choice questions
                    removeAll();
                    repaint();
                    try {
                        add(new ChoicePanel());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    validate();
                    //JOptionPane.showMessageDialog(null, "switch to choice questions");

                }
            }
            ansTa.setText("");
        } else if (event.getActionCommand().equals("Home")) {
            removeAll();
            repaint();
        }
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

    public static void main(String[] args) throws Exception {
//        JFrame f = new JFrame();
//        FillBlankPanel app = new FillBlankPanel();
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.getContentPane().add(app);
     }
}
