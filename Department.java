package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5 , 5 , 690 , 490);
        panel.setLayout(null);
        panel.setBackground(new Color(90 , 156 , 163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0 , 40 , 600 , 300);
        table.setBackground(new Color(90 , 156 , 163));
        table.setFont(new Font("Tahoma" , Font.BOLD , 15));
        panel.add(table);

        try{
            DBConnection c = new DBConnection();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(60 , 11 , 105 , 20);
        label1.setFont(new Font("Tahoma" , Font.BOLD , 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(390 , 11 , 150 , 20);
        label2.setFont(new Font("Tahoma" , Font.BOLD , 14));
        panel.add(label2);

        JButton back1 = new JButton("Back");
        back1.setBackground(Color.black);
        back1.setBounds(230 , 410 , 130 , 30);
        back1.setForeground(Color.white);
        panel.add(back1);
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(700 , 500);
        setLayout(null);
        setLocation(350 , 250);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Department();
    }
}
