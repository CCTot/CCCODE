package Test.javaSwingTest;

import javax.swing.*;
import java.awt.*;

public class SpringLayoutTest extends JFrame {

    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);

    JLabel titleLabel = new JLabel("文章标题：");
    JTextField titleTxt = new JTextField();
    JLabel authorLabel = new JLabel("作者：");
    JTextField authorTxt = new JTextField();
    JLabel contentLabel = new JLabel("请输入内容：");
    JTextArea contArea = new JTextArea(4,10);

    public SpringLayoutTest(){
        super("弹簧布局");

        Container contentPane = getContentPane();
        jPanel.add(titleLabel);
        titleTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(titleTxt);
        jPanel.add(authorLabel);
        authorTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(authorTxt);
        jPanel.add(contentLabel);
        jPanel.add(contArea);



        /*
        SpringLayout:布局管理器
        SpringLayout.Constraints: 使用弹簧布局里的组件的布局约束，每个组件对应一个
        * */
        Spring titleLabelWidth = Spring.width(titleLabel);
        Spring titleTxtWidth = Spring.width(titleTxt);
        Spring spaceWidth = Spring.constant(20);
        Spring totalWidth = Spring.sum(Spring.sum(titleLabelWidth,titleTxtWidth),spaceWidth);
        int offsetX = totalWidth.getValue()/2;

        SpringLayout.Constraints titleLabelC = springLayout.getConstraints(titleLabel);
        springLayout.putConstraint(SpringLayout.WEST,titleLabel,-offsetX,SpringLayout.HORIZONTAL_CENTER,jPanel);
        titleLabelC.setY(Spring.constant(50));

        // 设置约束的第一种写法
        //  设置标题文本框
        SpringLayout.Constraints titleTxtC = springLayout.getConstraints(titleTxt);
        Spring titleLabelEastSpring = titleLabelC.getConstraint(SpringLayout.EAST);
        titleTxtC.setConstraint(SpringLayout.WEST,Spring.sum(titleLabelEastSpring,Spring.constant(20)));
        titleTxtC.setConstraint(SpringLayout.NORTH,titleLabelC.getConstraint(SpringLayout.NORTH));

        //设置约束的第二种方法
        //  设置作者文本框
        springLayout.putConstraint(SpringLayout.EAST,authorLabel,0,SpringLayout.EAST,titleLabel);
        springLayout.putConstraint(SpringLayout.NORTH,authorLabel,20,SpringLayout.SOUTH,titleLabel);
        springLayout.putConstraint(SpringLayout.WEST,authorTxt,20,SpringLayout.EAST,authorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,authorTxt,0,SpringLayout.NORTH,authorLabel);

        // 设置内容文本框
        springLayout.putConstraint(SpringLayout.EAST,contentLabel,0,SpringLayout.EAST,authorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,contentLabel,20,SpringLayout.SOUTH,authorLabel);
        springLayout.putConstraint(SpringLayout.WEST,contArea,20,SpringLayout.EAST,contentLabel);
        springLayout.putConstraint(SpringLayout.NORTH,contArea,0,SpringLayout.NORTH,contentLabel);

        springLayout.putConstraint(SpringLayout.SOUTH,contArea,-20,SpringLayout.SOUTH,jPanel);
        springLayout.putConstraint(SpringLayout.EAST,contArea,-20,SpringLayout.EAST,jPanel);

        contentPane.add(jPanel);

        //设置窗体图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage("E:\\IDEA\\Code\\javaSwing\\src\\resource\\1563503219679854.jpg");
        setIconImage(image);

        //设置大小
        setSize(1000,600);

        //居中显示
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new SpringLayoutTest();

    }
}
