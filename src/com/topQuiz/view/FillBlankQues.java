package com.topQuiz.view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.topQuiz.dao.BlankQuestionDao;
import com.topQuiz.model.BlankQuestion;
import com.topQuiz.util.DbUtil;

public class FillBlankQues extends JFrame{
    private JPanel panel1,panel2;
    private JButton submitBtn;
    private JLabel quesLbl,ansLbl;
    private JTextArea quesTa, ansTa;

    public FillBlankQues(){
        super( "Fill Blank Question" );
        this.setSize(640, 300);
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
        
        
        // create answer
        ansLbl = new JLabel("Answer");
        ansLbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
        ansLbl.setForeground(Color.BLUE);
        ansLbl.setIcon(new ImageIcon(FillBlankQues.class.getResource("/images/answer.png"))); 

        ansTa = new JTextArea(2,50);

        panel1.add(ansLbl);
        panel1.add(ansTa);

        // Create submit
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        submitBtn = new JButton("Submit");
        submitBtn.setActionCommand("submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 18));

        // add the event handlers to the buttons
        ButtonEventHandler handler = new ButtonEventHandler();
        submitBtn.addActionListener(handler);

        panel2.add(submitBtn);
        
        container.add(panel1,BorderLayout.CENTER);
        container.add(panel2,BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

    }
    class ButtonEventHandler implements ActionListener {
        public void actionPerformed( ActionEvent event ) {
            if ((quesTa.getText().equals("")) || (ansTa.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Please enter both question and answer!");
                return;
            } else {
                if (event.getActionCommand().equals("submit")) {       
                    blankQuesAddActionPerformed(event);
            }
        }
        }
            private void blankQuesAddActionPerformed(ActionEvent evt) {
        		// TODO Auto-generated method stub
        		String question = quesTa.getText();
        		String answer = ansTa.getText();
 
        		BlankQuestion blankQuestion = new BlankQuestion(question, answer);
        		
        	    DbUtil dbUtil = new DbUtil();
        	    BlankQuestionDao blankQuestionDao = new BlankQuestionDao();
        		Connection con = null;
        		
        		try {
        			con = dbUtil.getCon();
        			int n = blankQuestionDao.add(con, blankQuestion);
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
    

	}

    public static void createAndShowGUI(){
        FillBlankQues app = new FillBlankQues();
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
