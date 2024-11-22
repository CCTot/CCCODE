package handler;

import Test.javaSwingTest.LoginView;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginHandler extends KeyAdapter implements ActionListener {

    private LoginView loginView;
    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if("登录".equals(text))
        {
            login();
        }else if("注册".equals(text)){
            System.out.println("注册");
        }
    }

    private void login() {
        String user = loginView.getUserTxt().getText();
        char[] password = loginView.getPwdField().getPassword();
        String pwd = new String(password);
        System.out.println(user+":"+pwd);
        //查询数据库
        boolean flag = false;
        if(flag){

        }else{
            JOptionPane.showMessageDialog(loginView,"用户名密码错误");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(KeyEvent.VK_ENTER==e.getKeyCode()){
            login();
        };
    }
}
