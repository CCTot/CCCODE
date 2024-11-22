package Test.javaSwingTest;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BorderLayoutTest extends JFrame{

    JButton northBtn = new JButton("北按钮");
    JLabel southLabel = new JLabel("南按钮");
    JRadioButton westRadioBtn = new JRadioButton("west");
    JTextArea eastArea = new JTextArea("东输入内容");
    JButton btn = new JButton("按钮");

    public BorderLayoutTest(){
        super("测试边界布局");

        //设置布局管理器
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(northBtn,BorderLayout.NORTH);
        contentPane.add(southLabel,BorderLayout.SOUTH);
        contentPane.add(westRadioBtn,BorderLayout.WEST);
        contentPane.add(eastArea,BorderLayout.EAST);
        contentPane.add(btn,BorderLayout.CENTER);

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
        new BorderLayoutTest();

    }
}
