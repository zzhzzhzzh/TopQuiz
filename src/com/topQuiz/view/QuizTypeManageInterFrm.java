package com.topQuiz.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.topQuiz.dao.QuizDao;
import com.topQuiz.dao.QuizTypeDao;
import com.topQuiz.model.QuizType;
import com.topQuiz.util.DbUtil;
import com.topQuiz.util.StringUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuizTypeManageInterFrm extends JInternalFrame {
	private JTable quizTypeTable;

    private DbUtil dbUtil = new DbUtil();
    private QuizTypeDao quizTypeDao = new QuizTypeDao();
    private JTextField s_quizTypeNameTxt;
    private JTextField idTxt;
    private JTextField quizTypeNameTxt;

    private JTextArea quizTypeDescTxt;

    private QuizDao quizDao = new QuizDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizTypeManageInterFrm frame = new QuizTypeManageInterFrm();
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
	public QuizTypeManageInterFrm() {
		setTitle("Quiz Type Management");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 331);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblTypeName = new JLabel("Type Name:");

		s_quizTypeNameTxt = new JTextField();
		s_quizTypeNameTxt.setColumns(10);

		JButton btnQuery = new JButton("Search");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizTypeSearchActionPerformed(e);
			}
		});

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTypeName)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(s_quizTypeNameTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
									.addComponent(btnQuery)))
							.addContainerGap(50, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeName)
						.addComponent(s_quizTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnQuery))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
		);

		JLabel lblNewLabel = new JLabel("ID:");

		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Type Name:");

		quizTypeNameTxt = new JTextField();
		quizTypeNameTxt.setColumns(10);

		JLabel lblTypeDescription = new JLabel("Type Description:");

		quizTypeDescTxt = new JTextArea(); // add to top

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizTypeUpdateActionEvent(e);
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizTypeDeleteActionEvent(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(quizTypeDescTxt, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnUpdate)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDelete))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
										.addGap(30)
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(quizTypeNameTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblTypeDescription))
							.addContainerGap(43, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(quizTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTypeDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(quizTypeDescTxt, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnDelete)))
		);
		panel.setLayout(gl_panel);

		quizTypeTable = new JTable();
		quizTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				quizTypeTableMousePressed(e);
			}
		});
		quizTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Type Name", "Type Description"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		quizTypeTable.getColumnModel().getColumn(0).setPreferredWidth(47);
		quizTypeTable.getColumnModel().getColumn(2).setPreferredWidth(139);
		scrollPane.setViewportView(quizTypeTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new QuizType()); // put an empty type

		// add border to text area
		 quizTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}

	/**
	 * quiz type delete event
	 * @param e
	 */
	private void quizTypeDeleteActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please choose one type!");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "Are you sure?");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				// check whether the required type to delete has quiz or not
				boolean flag = quizDao.existQuizByQuizTypeId(con, id);
				if (flag){
					JOptionPane.showMessageDialog(null, "The type contains quizs and cannot be deleted!");
					return;
				}
				int deleteNum = quizTypeDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Successfully deleted!");
					this.resetValue(); // make this small table blank after delete
					this.fillTable(new QuizType()); // show the data rows
				}
				else {
					JOptionPane.showMessageDialog(null, "fail to delete!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "fail to delete!");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * quiz type update event
	 * @param evt
	 */
	private void quizTypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		String quizTypeName = quizTypeNameTxt.getText();
		String quizTypeDesc = quizTypeDescTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please choose one type!");
			return;
		}
		if (StringUtil.isEmpty(quizTypeName)) { // user must input new type name
			JOptionPane.showMessageDialog(null, "Type name cannot be empty!");
			return;
		}
		QuizType quizType = new QuizType(Integer.parseInt(id), quizTypeName, quizTypeDesc);

		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = quizTypeDao.update(con, quizType);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "Successfully updated!");
				this.resetValue(); // make this small table blank after update
				this.fillTable(new QuizType()); // show the updated data rows
			}
			else {
				JOptionPane.showMessageDialog(null, "fail to update!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "fail to update!");
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
	 * click table row event
	 * @param e
	 */
	private void quizTypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row = quizTypeTable.getSelectedRow();
		idTxt.setText((String)quizTypeTable.getValueAt(row, 0)); // obj to string
		quizTypeNameTxt.setText((String)quizTypeTable.getValueAt(row, 1));
		quizTypeDescTxt.setText((String)quizTypeTable.getValueAt(row, 2));

	}

	/**
	 * quiz type search event
	 * @param evt
	 */
	private void quizTypeSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_quizTypeName = this.s_quizTypeNameTxt.getText();
		QuizType quizType = new QuizType();
		quizType.setQuizTypeName(s_quizTypeName);
		this.fillTable(quizType);
	}

	/**
	 * initialize the table
	 * @param quizType
	 */
	private void fillTable(QuizType quizType) {
		DefaultTableModel dtm = (DefaultTableModel) quizTypeTable.getModel();
		dtm.setRowCount(0); // before query clear the table
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = quizTypeDao.list(con, quizType);
			while (rs.next()) {
				Vector v = new Vector(); // thread safe
				v.add(rs.getString("id"));
				v.add(rs.getString("quizTypeName"));
				v.add(rs.getString("quizTypeDesc"));
				dtm.addRow(v); // add data to the table
			}
		} catch (Exception e) {
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
	 * reset the table content
	 * @param evt
	 */
    // change from protected to private
	private void resetValue() {
		// TODO Auto-generated method stub
		this.idTxt.setText("");
		this.quizTypeNameTxt.setText("");
		this.quizTypeDescTxt.setText("");
	}
}
