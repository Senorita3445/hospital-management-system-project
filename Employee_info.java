package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5 , 5 , 990 , 590);
        panel.setBackground(new Color(109 , 164 , 170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10 , 34 , 980 , 450);
        panel.setBackground(new Color(109 , 164 , 170));
        panel.add(table);

        try{
            DBConnection c = new DBConnection();
            String q = "select * from Emp_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }





        setSize(1000, 600);
        setLocation(350 , 230);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}
