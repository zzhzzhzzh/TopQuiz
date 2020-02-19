package com.topQuiz.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.topQuiz.dao.QuizDao;
import com.topQuiz.dao.QuizTypeDao;
import com.topQuiz.model.Quiz;
import com.topQuiz.model.QuizType;
import com.topQuiz.util.DbUtil;
import com.topQuiz.util.StringUtil;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizAddInterFrm extends JInternalFrame {
	// introduce into
    private DbUtil dbUtil = new DbUtil();
    private QuizTypeDao quizTypeDao = new QuizTypeDao();
    private QuizDao quizDao = new QuizDao();

    // move from down
    private JComboBox quizTypeJcb;
    private JTextArea quesTxt = new JTextArea();
    private JTextArea ansTxt = new JTextArea();
    private JTextArea quizDescTxt = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizAddInterFrm frame = new QuizAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuizAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Quiz");
		setBounds(100, 100, 450, 379);

		JLabel lblQuizName = new JLabel("Question:");

		quesTxt = new JTextArea();
		quesTxt.setText("");

		JLabel lblNewLabel = new JLabel("Answer:");

		ansTxt = new JTextArea();

		JLabel lblDescription = new JLabel("Description:");

		quizDescTxt = new JTextArea();

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizAddActionPerformed(e);
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});

		JLabel lblQuizType = new JLabel("Quiz Type:");

		quizTypeJcb = new JComboBox(); // move up
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(quesTxt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDescription)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblQuizName)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblQuizType)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(quizTypeJcb, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addGap(185))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(quizDescTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(btnSubmit)
													.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
													.addComponent(btnReset))
												.addComponent(ansTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
											.addGap(60))))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuizType)
						.addComponent(quizTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblQuizName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(quesTxt, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ansTxt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(quizDescTxt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnReset)))
		);
		getContentPane().setLayout(groupLayout);

		// add border to three text area
	    quesTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	    ansTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	    quizDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

		fillQuizType();
	}

	/**
	 * add quiz event
	 * @param evt
	 */
	private void quizAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String ques = this.quesTxt.getText();
		String ans = this.ansTxt.getText();
		String quizDesc = this.quizDescTxt.getText();

		if (StringUtil.isEmpty(ques)) {
			JOptionPane.showMessageDialog(null, "Please input question!");
			return;
		}
		if (StringUtil.isEmpty(ans)) {
			JOptionPane.showMessageDialog(null, "Please input answer!");
			return;
		}

		QuizType quizType = (QuizType) quizTypeJcb.getSelectedItem();
		int quizTypeId = quizType.getId();
		Quiz quiz = new Quiz(ques, ans, quizTypeId, quizDesc);

		Connection con = null;

		try {
			con = dbUtil.getCon();
			int n = quizDao.add(con, quiz);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "Successfully added!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "Cannot be added!");
				resetValue();
			}
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot be added!"); // here added
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * reset event
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		resetValue();
	}

	/**
	 * reset the table content
	 * @param evt
	 */
    // change from protected to private
	private void resetValue() {
		// TODO Auto-generated method stub
		this.quesTxt.setText("");
		this.ansTxt.setText("");
		this.quizDescTxt.setText("");
		if (this.quizTypeJcb.getItemCount() > 0) { // if type number is not 0, then select first one
			this.quizTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * initialize quiz type jcb
	 */
	private void fillQuizType() {
		Connection con = null;
		QuizType quizType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = quizTypeDao.list(con, new QuizType());
			while (rs.next()) {
				quizType = new QuizType();
				quizType.setId(rs.getInt("id"));
				quizType.setQuizTypeName(rs.getString("quizTypeName"));
				this.quizTypeJcb.addItem(quizType);
			}
		} catch (Exception e){
			e.printStackTrace();
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
