package Test.javaSwingTest;

import handler.LoginHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class LoginView extends JFrame{
    JLabel nameLabel = new JLabel("明日方舟",JLabel.CENTER);
    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel userNameLabel = new JLabel("用户名：");
    JTextField userTxt = new JTextField();
    JLabel pwdLabel = new JLabel("密码：");
    JPasswordField pwdField = new JPasswordField();
    JButton LoginBtn = new JButton("登录");
    JButton registerBtn = new JButton("注册");

    SystemTray systemTray;
    TrayIcon trayIcon;
    LoginHandler loginHandler;

    public LoginView(){
        super("明日方舟");

        loginHandler = new LoginHandler(this);
        Container contentPane = getContentPane();

        nameLabel.setFont(new Font("微软雅黑",Font.PLAIN,40));
        nameLabel.setPreferredSize(new Dimension(0,80));

        Font centerFont = new Font("微软雅黑",Font.PLAIN,20);
        userNameLabel.setFont(centerFont);
        userTxt.setPreferredSize(new Dimension(200,30));
        pwdLabel.setFont(centerFont);
        pwdField.setPreferredSize(new Dimension(200,30));
        LoginBtn.setFont(centerFont);
        registerBtn.setFont(centerFont);

        //把组件加入面板
        centerPanel.add(userNameLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdField);
        //添加鼠标点击
        LoginBtn.addActionListener(loginHandler);
        //增加按键事件
        LoginBtn.addKeyListener(loginHandler);
        centerPanel.add(LoginBtn);
        registerBtn.addActionListener(loginHandler);
        centerPanel.add(registerBtn);

        //弹簧布局
        LayoutCenter();

        contentPane.add(nameLabel,BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);

        //缩小到系统托盘
        if(SystemTray.isSupported()){
            systemTray = SystemTray.getSystemTray();
            Toolkit tk = Toolkit.getDefaultToolkit();
            Image Image = tk.getImage("E:\\IDEA\\Code\\javaSwing\\src\\resource\\1563503219679854.jpg");
            trayIcon = new TrayIcon(new ImageIcon(Image).getImage());
            //设置托盘图片大小可以自动缩放
            trayIcon.setImageAutoSize(true);

            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            //增加最小化时销毁资源
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowIconified(WindowEvent e) {
                    LoginView.this.dispose();
                }
            });
            //托盘事件监听
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    if(clickCount==1){
                        LoginView.this.setExtendedState(JFrame.NORMAL);
                    }
                    LoginView.this.setVisible(true);
                }
            });
        }

        //设施loginBtn为默认按钮
        getRootPane().setDefaultButton(LoginBtn);

        //设置窗体图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage("E:\\IDEA\\Code\\javaSwing\\src\\resource\\1563503219679854.jpg");
        setIconImage(image);

        //设置大小
        setSize(600,400);
        //居中显示
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(true);
        setVisible(true);
    }

    //弹簧布局
    private void LayoutCenter(){
        Spring userNameLabelWidth = Spring.width(userNameLabel);
        Spring userTxtWidth = Spring.width(userTxt);
        Spring spaceWidth = Spring.constant(20);
        Spring totalWidth = Spring.sum(Spring.sum(userNameLabelWidth,userTxtWidth),spaceWidth);
        int offsetX = totalWidth.getValue()/2;

        SpringLayout.Constraints userNameLabelC = springLayout.getConstraints(userNameLabel);
        springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-offsetX,SpringLayout.HORIZONTAL_CENTER,centerPanel);
        userNameLabelC.setY(Spring.constant(50));
        //userTxt
        springLayout.putConstraint(SpringLayout.WEST,userTxt,20,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,userTxt,0,SpringLayout.NORTH,userNameLabel);
        //pwdLabel
        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdLabel,20,SpringLayout.SOUTH,userNameLabel);
        //pwdField
        springLayout.putConstraint(SpringLayout.WEST,pwdField,20,SpringLayout.EAST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdField,0,SpringLayout.NORTH,pwdLabel);
        //LoginBtn
        springLayout.putConstraint(SpringLayout.WEST,LoginBtn,50,SpringLayout.WEST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,LoginBtn,50,SpringLayout.NORTH,pwdLabel);
        //registerBtn
        springLayout.putConstraint(SpringLayout.WEST,registerBtn,50,SpringLayout.EAST,LoginBtn);
        springLayout.putConstraint(SpringLayout.NORTH,registerBtn,0,SpringLayout.NORTH,LoginBtn);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    public JTextField getUserTxt() {
        return userTxt;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }

}
