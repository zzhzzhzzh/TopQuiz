package com.topQuiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.topQuiz.dao.UserDao;
import com.topQuiz.model.User;
import com.topQuiz.util.DbUtil;
import com.topQuiz.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LogOnFrm extends JFrame {
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Quiz Management System");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/com/topQuiz/images/management_69.888px_1215614_easyicon.net.png")));

		JLabel lblNewLabel_1 = new JLabel("Username:");

		JLabel lblNewLabel_2 = new JLabel("Password:");

		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);

		passwordTxt = new JPasswordField();

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnReset))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		// set login form in the center
		this.setLocationRelativeTo(null);
	}

	/**
	 * login event
	 * @param evt
	 */
	// change from protected to private
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "Username is unvalid!"); // put at the top
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "Password is unvalid!");
			return;
		}
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {
				// JOptionPane.showMessageDialog(null, "Successfully logged in!");
				// login and destroy the current window, make new window visible
				dispose();
				new MainFrm().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong user!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
    // change from protected to private
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
