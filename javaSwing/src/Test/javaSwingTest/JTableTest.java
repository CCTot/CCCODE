package Test.javaSwingTest;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Objects;
import java.util.Vector;

public class JTableTest extends JFrame {

    public JTableTest(){
        super("测试jTable");

        Vector<Vector<Object>> data = new Vector<>();

        Vector<Object> rowVector1 = new Vector<>();
        rowVector1.addElement(1);
        rowVector1.addElement("Tom");
        rowVector1.addElement("M");
        rowVector1.addElement(1);
        rowVector1.addElement(1);
        rowVector1.addElement("10.01");
        rowVector1.addElement("罗德岛");

        Vector<Object> rowVector2 = new Vector<>();
        rowVector2.addElement(2);
        rowVector2.addElement("卢删培");
        rowVector2.addElement("M");
        rowVector2.addElement(4);
        rowVector2.addElement(3);
        rowVector2.addElement("10.01");
        rowVector2.addElement("罗德岛");

        data.addElement(rowVector1);
        data.addElement(rowVector2);


        //tablemodel:和jTable关联后，之后只需要更新model就可以把数据反映到jTable中
        StudentTableModel studentTableModel = StudentTableModel.assembleModel(data);
        //jTable和model关联
        JTable jTable = new JTable(studentTableModel);

        //jTable放在jPanel上的话，默认是不展示列头的，JScrollPane则是默认展示列头的
        Container contentPane = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        //设置表头
        JTableHeader tableHeader = new JTableHeader();
        tableHeader.setFont(new Font(null,Font.PLAIN,16));
        tableHeader.setForeground(Color.blue);
        //设置表格体
        jTable.setFont(new Font(null,Font.PLAIN,14));
        jTable.setForeground(Color.black);
        jTable.setGridColor(Color.BLACK);
        jTable.setRowHeight(30);
        //设置多行选择
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //设置表格列的渲染方式
        Vector<String> columns = StudentTableModel.getColumns();
        StudentCellRender studentCellRender = new StudentCellRender();
        for (int i = 0; i < columns.size(); i++) {
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer (studentCellRender);
            if(i==0){
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }
        }


        contentPane.add(jScrollPane);

        setSize(600,400);
        //居中显示
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTableTest();
    }

}

class StudentCellRender extends DefaultTableCellRenderer{

    //在每一行的每一列显示前都会调用
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(row % 2 == 0){
            setBackground(Color.LIGHT_GRAY);
        }else{
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

//自定义TableModel
class StudentTableModel extends DefaultTableModel{
    static Vector<String> columns = new Vector<>();
    static{
        columns.add("编号");
        columns.add("姓名");
        columns.add("性别");
        columns.add("班级");
        columns.add("学院");
        columns.add("生日");
        columns.add("籍贯");
    }

    private StudentTableModel(){
        super(null,columns);
    }

    private static StudentTableModel studentTableModel = new StudentTableModel();

    public static StudentTableModel assembleModel(Vector<Vector<Object>> data){
        studentTableModel.setDataVector(data,columns);
        return studentTableModel;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
