package com.topQuiz.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.topQuiz.dao.QuizDao;
import com.topQuiz.dao.QuizTypeDao;
import com.topQuiz.model.Quiz;
import com.topQuiz.model.QuizType;
import com.topQuiz.util.DbUtil;
import com.topQuiz.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuizManageInterFrm extends JInternalFrame {
	private JTable quizTable;
	private JTextField s_quesTxt;
	private JTextField s_ansTxt;

	// introduce into
    private DbUtil dbUtil = new DbUtil();
    private QuizTypeDao quizTypeDao = new QuizTypeDao();
    private QuizDao quizDao = new QuizDao();

    private JComboBox s_quizTypeJcb;
    private JTextField idTxt;

    private JTextArea quesTxt;
    private JTextArea ansTxt;
    private JTextArea quizDescTxt;
    private JComboBox quizTypeJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizManageInterFrm frame = new QuizManageInterFrm();
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
	public QuizManageInterFrm() {
		setTitle("Quiz Management");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 533, 526);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
		);

		JLabel lblId = new JLabel("ID:");

		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);

		JLabel lblQuestion_1 = new JLabel("Question:");

		quesTxt = new JTextArea(); // move up

		JLabel lblAnswer_1 = new JLabel("Answer:");

		ansTxt = new JTextArea(); // move up

		JLabel lblType_1 = new JLabel("Type:");

		JLabel lblDescription = new JLabel("Description:");

		quizDescTxt = new JTextArea(); // move up

		quizTypeJcb = new JComboBox(); // move up

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quizDeleteActionPerformed(evt);
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quizUpdateActionPerformed(evt);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(lblType_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(quizTypeJcb, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnUpdate)
							.addPreferredGap(ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
							.addComponent(btnDelete))
						.addComponent(quizDescTxt, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription)
						.addComponent(ansTxt, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnswer_1)
						.addComponent(quesTxt, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuestion_1))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType_1)
						.addComponent(quizTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestion_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(quesTxt, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAnswer_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ansTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(quizDescTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addGap(6))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblQuestion = new JLabel("Question:");

		s_quesTxt = new JTextField();
		s_quesTxt.setColumns(10);

		JLabel lblAnswer = new JLabel("Answer:");

		s_ansTxt = new JTextField();
		s_ansTxt.setColumns(10);

		JLabel lblType = new JLabel("Type:");

		s_quizTypeJcb = new JComboBox(); // move up

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(1)
					.addComponent(lblQuestion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_quesTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAnswer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_ansTxt, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblType)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_quizTypeJcb, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnSearch)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_quesTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuestion)
						.addComponent(btnSearch)
						.addComponent(lblAnswer)
						.addComponent(s_ansTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType)
						.addComponent(s_quizTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		quizTable = new JTable();
		quizTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				quizTableMousePressed(met);
			}
		});
		quizTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Question", "Answer", "Description", "Quiz Type"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		quizTable.getColumnModel().getColumn(0).setPreferredWidth(41);
		quizTable.getColumnModel().getColumn(1).setPreferredWidth(136);
		quizTable.getColumnModel().getColumn(2).setPreferredWidth(67);
		quizTable.getColumnModel().getColumn(3).setPreferredWidth(101);
		scrollPane.setViewportView(quizTable);
		getContentPane().setLayout(groupLayout);

		// add border to three text area
	    quesTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	    ansTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	    quizDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

		this.fillQuizType("search"); // to fill quiz type with added search item and full data when "search"
		this.fillQuizType("modify"); // to fill quiz type with full data when "modify"

		this.fillTable(new Quiz());
	}

	/**
	 * delete quiz event
	 * @param evt
	 */
	private void quizDeleteActionPerformed(ActionEvent evt) {
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
				int deleteNum = quizDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Successfully deleted!");
					this.resetValue(); // make this small table blank after delete
					this.fillTable(new Quiz()); // show the data rows
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
	 * quiz update event processing
	 * @param evt
	 */
	private void quizUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText(); // an item must first selected
		String ques = quesTxt.getText();
		String ans = ansTxt.getText();
		String quizDesc = quizDescTxt.getText();

		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select one record!");
			return;
		}
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

		Quiz quiz = new Quiz(Integer.parseInt(id), ques, ans, quizTypeId, quizDesc);

		Connection con = null;

		try {
			con = dbUtil.getCon();
			int n = quizDao.update(con, quiz);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "Successfully updated!");
				resetValue();
				this.fillTable(new Quiz()); // show the updated data rows
			} else {
				JOptionPane.showMessageDialog(null, "Cannot be updated!");
				resetValue();
			}
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot be updated!"); // here added
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
		this.idTxt.setText("");
		this.quesTxt.setText("");
		this.ansTxt.setText("");
		this.quizDescTxt.setText("");
		if (this.quizTypeJcb.getItemCount() > 0) { // if type number is not 0, then select first one
			this.quizTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * click row event
	 * @param met
	 */
	private void quizTableMousePressed(MouseEvent met) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// column in the table should in align with the below items?
		int row = quizTable.getSelectedRow();
		this.idTxt.setText((String)quizTable.getValueAt(row, 0)); // obj to string
		this.quesTxt.setText((String)quizTable.getValueAt(row, 1));
		this.ansTxt.setText((String)quizTable.getValueAt(row, 2));
		this.quizDescTxt.setText((String)quizTable.getValueAt(row, 3));

		String quizTypeName = (String)this.quizTable.getValueAt(row, 4);
		int n = this.quizTypeJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			QuizType item = (QuizType)this.quizTypeJcb.getItemAt(i);
			if (quizTypeName.equals(item.getQuizTypeName())) {
				this.quizTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * book search event
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String ques = this.s_quesTxt.getText();
		String ans = this.s_ansTxt.getText();
		QuizType quizType = (QuizType) this.s_quizTypeJcb.getSelectedItem();
		int quizTypeId = quizType.getId();
		Quiz quiz = new Quiz(ques, ans, quizTypeId);
		this.fillTable(quiz);
	}

	/**
	 * initialize the type Jcb
	 * @param type
	 */
    private void fillQuizType(String type) {
		Connection con = null;
		QuizType quizType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = quizTypeDao.list(con, new QuizType());
			if ("search".equals(type)) {
				quizType = new QuizType();
				quizType.setQuizTypeName("Select");
				quizType.setId(-1);
				this.s_quizTypeJcb.addItem(quizType);
			}
			while (rs.next()) {
				quizType = new QuizType();
				quizType.setQuizTypeName(rs.getString("quizTypeName"));
				quizType.setId(rs.getInt("id"));
			//	this.s_quizTypeJcb.addItem(quizType);

				if ("search".equals(type)) {
					this.s_quizTypeJcb.addItem(quizType);
				}
				else if ("modify".equals(type)) {
					this.quizTypeJcb.addItem(quizType);
				}
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

	/**
	 * initialize the table
	 * @param quiz
	 */
	private void fillTable(Quiz quiz) {
		DefaultTableModel dtm = (DefaultTableModel) quizTable.getModel();
		dtm.setRowCount(0); // before query clear the table
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = quizDao.list(con, quiz);
			while (rs.next()) {
				Vector v = new Vector(); // thread safe
				v.add(rs.getString("id"));
				v.add(rs.getString("ques"));
				v.add(rs.getString("ans"));
				v.add(rs.getString("quizDesc"));
				v.add(rs.getString("quizTypeName")); // primary-foreign key can check
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
}
