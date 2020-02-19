package com.topQuiz.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.topQuiz.dao.QuizTypeDao;
import com.topQuiz.model.QuizType;
import com.topQuiz.util.DbUtil;
import com.topQuiz.util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class QuizTypeAddInterFrm extends JInternalFrame {
	private JTextField quizTypeNameTxt;
    private JTextArea quizTypeDescTxt;

    private DbUtil dbUtil = new DbUtil();
    private QuizTypeDao quizTypeDao = new QuizTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizTypeAddInterFrm frame = new QuizTypeAddInterFrm();
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
	public QuizTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Quiz Type");
		setBounds(100, 100, 450, 300);

		JLabel lblNewLabel = new JLabel("Type Name:");

		JLabel lblNewLabel_1 = new JLabel("Desciption:");

		quizTypeNameTxt = new JTextField();
		quizTypeNameTxt.setColumns(10);

		quizTypeDescTxt = new JTextArea();

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        quizTypeAddActionPerformed(e);
			}
		});

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(quizTypeNameTxt)
								.addComponent(quizTypeDescTxt, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(quizTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(quizTypeDescTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		// add border to text area
	    quizTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}

	/**
	 * quiz type add event
	 * @param e
	 */

	protected void quizTypeAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String quizTypeName = this.quizTypeNameTxt.getText();
		String quizTypeDesc = this.quizTypeDescTxt.getText();
		if (StringUtil.isEmpty(quizTypeName)) {
			JOptionPane.showMessageDialog(null, "Input is unvalid!");
			return;
		}
		QuizType quizType = new QuizType(quizTypeName, quizTypeDesc);
		Connection con = null;

		try {
			con = dbUtil.getCon();
			int n = quizTypeDao.add(con, quizType);
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
		this.quizTypeNameTxt.setText("");
		this.quizTypeDescTxt.setText("");
	}
}
