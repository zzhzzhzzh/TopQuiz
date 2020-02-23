package com.topQuiz.view;

import javax.swing.*;

import com.topQuiz.dao.BlankQuestionDao;
import com.topQuiz.dao.ChoiceQuestionDao;
import com.topQuiz.model.BlankQuestion;
import com.topQuiz.model.ChoiceQuestion;
import com.topQuiz.util.DbUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class FillChoiceQues extends JFrame {
  private JPanel panel1,panel2;
  private JButton submitBtn;
  private JLabel quesLbl,choiceLbl,ansLbl;
  private JTextArea quesTa, choice1Ta, choice2Ta, choice3Ta, choice4Ta, ansTa;

  public FillChoiceQues(){
      super( "Fill Choice Question" );
      this.setSize(640, 600);
      this.setResizable(false);
      
      // get content pane
      Container container = getContentPane();
      panel1 = new JPanel();

      panel1.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
      
      // create question
      quesLbl = new JLabel("Question");
      quesLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
      quesLbl.setForeground(Color.BLUE);
      quesLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/question.png")));
      
      quesTa = new JTextArea(3,50);

      panel1.add(quesLbl);
      panel1.add(quesTa);

      // create choices
      choiceLbl = new JLabel("Choices");
      choiceLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
      choiceLbl.setForeground(Color.BLUE);
      choiceLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/option.png")));
      
      choice1Ta = new JTextArea(2,50);
      choice2Ta = new JTextArea(2,50);
      choice3Ta = new JTextArea(2,50);
      choice4Ta = new JTextArea(2,50);

      panel1.add(choiceLbl);
      panel1.add(choice1Ta);
      panel1.add(choice2Ta);
      panel1.add(choice3Ta);
      panel1.add(choice4Ta);
      
      // create answer
      ansLbl = new JLabel("Answer");
      ansLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
      ansLbl.setForeground(Color.BLUE);
      ansLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/answer.png"))); 
      
      ansTa = new JTextArea(2,50);

      panel1.add(ansLbl);
      panel1.add(ansTa);

      // create submit button
      panel2 = new JPanel();
      panel2.setLayout(new FlowLayout());

      submitBtn = new JButton("Submit");
      submitBtn.setActionCommand("submit");
      submitBtn.setFont(new Font("Arial", Font.BOLD, 16));

      // add the event handlers to the buttons
      FillChoiceQues.ButtonEventHandler handler = new FillChoiceQues.ButtonEventHandler();
      submitBtn.addActionListener(handler);

      panel2.add(submitBtn);


      container.add(panel1,BorderLayout.CENTER);
      container.add(panel2,BorderLayout.SOUTH);

      setLocationRelativeTo(null);
      setVisible(true);

  }

  class ButtonEventHandler implements ActionListener {
      public void actionPerformed(ActionEvent event) {

          if (quesTa.getText().equals("")) {
              JOptionPane.showMessageDialog(null, "Please enter question!");
          } else if (choice1Ta.getText().equals("") && choice2Ta.getText().equals("")
                  && choice3Ta.getText().equals("") && choice4Ta.getText().equals("")) {
              JOptionPane.showMessageDialog(null, "Please input choices!");
          } else if (ansTa.getText().equals("")) {
              JOptionPane.showMessageDialog(null, "Please enter answer!");
          } else {
              if (event.getActionCommand().equals("submit")) {
            	  choiceQuesAddActionPerformed(event);
              }
          }
      }
  }
  
  private void choiceQuesAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String question = quesTa.getText();
		String choice1 = choice1Ta.getText();
		String choice2 = choice2Ta.getText();
		String choice3 = choice3Ta.getText();
		String choice4 = choice4Ta.getText();
		String answer = ansTa.getText();

		ChoiceQuestion choiceQuestion = new ChoiceQuestion(question, choice1, choice2, choice3, choice4, answer);
		
	    DbUtil dbUtil = new DbUtil();
	    ChoiceQuestionDao choiceQuestionDao = new ChoiceQuestionDao();
		Connection con = null;
		
		try {
			con = dbUtil.getCon();
			int n = choiceQuestionDao.add(con, choiceQuestion);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "Successfully added!");
			} else {
				JOptionPane.showMessageDialog(null, "Cannot be added!");			
			}
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot be added!"); 
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

  public static void createAndShowGUI(){
	  FillChoiceQues app = new FillChoiceQues();
      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
  }
  public static void main(String[] args) {
      //Schedule a job for the event dispatch thread:
      //creating and showing this application's GUI.
      SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createAndShowGUI();
          }
      });

  }

}