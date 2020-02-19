package com.topQuiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {
	private JPanel contentPane;
    private JDesktopPane table = null; //move from below
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("TopQuiz Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Type/Quiz Management");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_2 = new JMenu("Type");
		mnNewMenu.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizTypeAddInterFrm quizTypeAddInterFrm = new QuizTypeAddInterFrm();
				quizTypeAddInterFrm.setVisible(true);
				table.add(quizTypeAddInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Maintain");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizTypeManageInterFrm quizTypeManageInterFrm = new QuizTypeManageInterFrm();
				quizTypeManageInterFrm.setVisible(true);
				table.add(quizTypeManageInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_3 = new JMenu("Quiz");
		mnNewMenu.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizAddInterFrm quizAddInterFrm = new QuizAddInterFrm();
				quizAddInterFrm.setVisible(true);
				table.add(quizAddInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Maintain");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizManageInterFrm quizManageInterFrm = new QuizManageInterFrm();
				quizManageInterFrm.setVisible(true);
				table.add(quizManageInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
				if (result == 0) {
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_1 = new JMenu("User Management");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_4 = new JMenu("About");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("About TopQuiz");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizInterFrm quizInterFrm = new QuizInterFrm();
				quizInterFrm.setVisible(true);
				table.add(quizInterFrm);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));


	    table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);

		// set JFrame to maximum size
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
