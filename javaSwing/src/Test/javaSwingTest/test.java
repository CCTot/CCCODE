package Test.javaSwingTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;



public class test extends JFrame{
    
    public test(){
        super("标题");

        //按钮
        JButton jButton = new JButton("按钮");
        Container contentPane = getContentPane();
        contentPane.add(jButton);

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
        new test();
        
    }
}
