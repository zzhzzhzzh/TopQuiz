package com.topQuiz.view;

import com.topQuiz.dao.UserDao;
import com.topQuiz.model.User;
import com.topQuiz.util.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserLogin extends JFrame implements ActionListener {
    private JPanel panel1, panel2;
    private JButton loginBtn;
    private JLabel unameLbl;
    private JTextField unameTf;

    public UserLogin() {
        super("User Login");
        this.setSize(250, 250);
        this.setResizable(false);

        Container container = getContentPane();
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        unameLbl = new JLabel("Username");
        unameLbl.setFont(new Font("ARIAL", Font.PLAIN, 19));
        unameLbl.setForeground(Color.BLUE);
        unameTf = new JTextField(10);

        panel1.add(unameLbl);
        panel1.add(unameTf);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        loginBtn = new JButton("Login");
        loginBtn.setActionCommand("login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 16));

        loginBtn.addActionListener(this);

        panel2.add(loginBtn);

        container.add(panel1, BorderLayout.PAGE_START);
        container.add(panel2, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (unameTf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter fill info!");
        } else {
            userLoginAction(event);
        }
    }
    private void userLoginAction(ActionEvent event) {
        String username = unameTf.getText();

        DbUtil dbUtil = new DbUtil();
        UserDao userDao = new UserDao();
        Connection con = null;

        try {
            con = dbUtil.getCon();
            ResultSet res = userDao.search(con, username);
            if (res.next()) {
                int userId = res.getInt("id");
                int maxScore = res.getInt("maxscore");

                User user = new User(userId, username, maxScore);
                System.out.println(user.toString());
                dispose();
                new GameWindow(user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong username!");
                unameTf.setText("");
                System.out.println("用户不存在");
            }
        } catch (Exception e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        userLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
