package com.topQuiz.view;

import com.topQuiz.dao.ChoiceQuestionDao;
import com.topQuiz.model.ChoiceQuestion;
import com.topQuiz.model.User;
import com.topQuiz.util.DbUtil;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ChoicePanel extends JPanel implements ActionListener {

    User user;
    private JPanel questionPanel, selectionPanel, controlPanel;
    private NavigationPanel navigationPanel;
    private JButton submitBtn, nextBtn, prevBtn;
    private JLabel quesLbl, quesContentLbl;
    private List<ChoiceQuestion> questionList;
    private Iterator<ChoiceQuestion> choiceQuestionIterator;
    private ChoiceQuestion choiceQuestion;
    private JCheckBox[] checkBoxList;
    private String[] answers;

    public ChoicePanel(User user, NavigationPanel navigationPanel) throws Exception {
        this.user = user;
        this.navigationPanel = navigationPanel;
        setLayout(new BorderLayout());
        questionList = getQuestionList();
        choiceQuestionIterator = questionList.iterator();
        if (choiceQuestionIterator.hasNext()) {
            choiceQuestion = choiceQuestionIterator.next();
        }

        answers = new String[4];
        answers[0] = choiceQuestion.getChoice1();
        answers[1] = choiceQuestion.getChoice2();
        answers[2] = choiceQuestion.getChoice3();
        answers[3] = choiceQuestion.getChoice4();

        questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        quesLbl = new JLabel("Question");
        quesLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
        quesLbl.setForeground(Color.BLUE);
        quesLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/question.png")));

        quesContentLbl = new JLabel(choiceQuestion.getQuestion());

        questionPanel.add(quesLbl);
        questionPanel.add(quesContentLbl);

        selectionPanel = new JPanel(new GridLayout(0,1));
        checkBoxList = new JCheckBox[4];
        System.out.println("answer:" + Arrays.toString(answers));
        for (int i = 0; i < 4; i++) {
            checkBoxList[i] = new JCheckBox(answers[i]);
            selectionPanel.add(checkBoxList[i]);
        }

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        nextBtn = new JButton("next");
        nextBtn.setActionCommand("next question");
        nextBtn.addActionListener(this);

        controlPanel.add(nextBtn);

        add(questionPanel, BorderLayout.PAGE_START);
        add(selectionPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.PAGE_END);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String ans = null;
        boolean rightanswer = true;
        for (int i =0; i < checkBoxList.length; i++) {
            if (checkBoxList[i].isSelected()) {
                if (ans != null) {
                    JOptionPane.showMessageDialog(null, "Only select one choice");
                    rightanswer = false;
                }
                ans = checkBoxList[i].getText();
                if (!ans.equals(choiceQuestion.getAnswer())) {
                    JOptionPane.showMessageDialog(null, "your answer is incorrect");
                    rightanswer = false;
                }
            }
        }

        for (JCheckBox jCheckBox: checkBoxList) {
            jCheckBox.setSelected(false);
        }

        if (rightanswer &&rightanswer && event.getActionCommand().equals("next question") && choiceQuestionIterator.hasNext()) {
            user.setCurScore(user.getCurScore() + 1);
            navigationPanel.updateScore(user.getCurScore());
            choiceQuestion = choiceQuestionIterator.next();
            quesContentLbl.setText(choiceQuestion.getQuestion());
            checkBoxList[0].setText(choiceQuestion.getChoice1());
            checkBoxList[1].setText(choiceQuestion.getChoice2());
            checkBoxList[2].setText(choiceQuestion.getChoice3());
            checkBoxList[3].setText(choiceQuestion.getChoice4());
        } else if (!choiceQuestionIterator.hasNext()) {
            navigationPanel.updateScore(user.getCurScore());
            choiceQuestion = choiceQuestionIterator.next();
            JOptionPane.showMessageDialog(null, "You have answered all questions, please go back to home page");
        }
    }

    private List<ChoiceQuestion> getQuestionList() throws Exception {
        List<ChoiceQuestion> questionList = new ArrayList<>();
        DbUtil dbUtil = new DbUtil();
        ChoiceQuestionDao choiceQuetionDao = new ChoiceQuestionDao();
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet res = choiceQuetionDao.search(con);
            while(res.next()) {
                String question = res.getString("question");
                String choice1 = res.getString("choice1");
                String choice2 = res.getString("choice2");
                String choice3 = res.getString("choice3");
                String choice4 = res.getString("choice4");
                String answer = res.getString("answer");
                questionList.add(new ChoiceQuestion(question, choice1, choice2, choice3, choice4, answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeCon(con);
            return questionList;
        }
    }

    public static void main(String[] args) throws Exception {
//        JFrame f = new JFrame();
//        //f.setSize(600, 600);
//        f.setResizable(false);
//        ChoicePanel app = new ChoicePanel();
//        f.getContentPane().add(app);
//        //f.pack();
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
