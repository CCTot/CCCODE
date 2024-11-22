package Test.javaSwingTest;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest extends JFrame {

    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,80,30));
    JButton jb1 = new JButton(("按钮1"));
    JButton jb2 = new JButton(("按钮1"));
    JButton jb3 = new JButton(("按钮1"));
    JButton jb4 = new JButton(("按钮1"));
    JButton jb5 = new JButton(("按钮1"));
    JButton jb6 = new JButton(("按钮1"));
    JButton jb7 = new JButton(("按钮1"));

    public FlowLayoutTest(){
        super("标题");

        Container contentPane = getContentPane();
        jPanel.add(jb1);
        jPanel.add(jb2);
        jPanel.add(jb3);
        jPanel.add(jb4);
        jPanel.add(jb5);
        jPanel.add(jb6);
        jPanel.add(jb7);

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
        new FlowLayoutTest();
    }

}
