package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber, textFieldName, textFieldDisease, textFieldDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(250, 11, 300, 70);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(120, 100, 100, 20);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"NIC", "Passport", "Driving License"});
        comboBox.setBounds(190, 100, 150, 25);
        comboBox.setBackground(Color.WHITE);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(120, 140, 100, 20);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(190, 140, 150, 25);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name:");
        labelName1.setBounds(120, 180, 100, 20);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textFieldName = new JTextField();
        textFieldName.setBounds(190, 180, 150, 25);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(120, 220, 100, 20);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(190, 225, 80, 20);
        r1.setForeground(Color.WHITE);
        panel.add(r1);

        r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(280, 225, 100, 20);
        r2.setForeground(Color.WHITE);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(120, 260, 100, 20);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(190, 260, 150, 25);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(120, 299, 100, 20);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            DBConnection c = new DBConnection();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(190, 299, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(255, 255, 255));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time:");
        labelDate.setBounds(120, 333, 100, 20);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(190, 337, 200, 14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(120, 374, 100, 20);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(190, 374, 150, 25);
        panel.add(textFieldDeposit);

        b1 = new JButton("ADD");
        b1.setBounds(260, 430, 120, 30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("CANCEL");
        b2.setBounds(400, 430, 120, 30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);

        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            DBConnection c = new DBConnection();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "MALE";
            } else if (r2.isSelected()) {
                radioBTN = "FEMALE";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textFieldName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s8 = c1.getSelectedItem();
            String s7 = date.getText();
            String s6 = textFieldDeposit.getText();

            try {
                String q = "insert into patient_info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                String q1 = "update room set Availability = 'Occupied' where room_no = '" + s8 + "'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
