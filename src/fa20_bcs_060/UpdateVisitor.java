package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateVisitor {
    private JFrame frame;
    private JPanel panel;

    private JLabel addEmp;
    private JLabel empCnic;
    private JLabel empAge;
    private JLabel empName;
    //    private JLabel stdDob;
    private JLabel empUsername;
    private JLabel empPassword;
    private JLabel empContact;
    private JLabel empField;
//    private JLabel stdRoom;

    //    private JTextField t_empCnic;
    private JTextField t_empAge;
    private JTextField t_empName;
    //    private JTextField t_stdDob;
    private JTextField t_empUsername;
    private JTextField t_empPassword;
    private JTextField t_empContact;
    private JTextField t_empField;
//    private JTextField t_stdRoom;

    private JButton clear;
    private JButton add;
    private JButton back;
    private JComboBox jComboBox;
    ArrayList<String> cnic1 = new ArrayList<>();

    String dAge = null;
    String dName = null;
    String dUsername = null;
    String dPassword = null;
    String dContact = null;
    String dField = null;

    public UpdateVisitor(int selectedCnic) {

        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addEmp = new JLabel("Update Visitor");
        empCnic = new JLabel("Cnic:");
        empAge = new JLabel("Age:");
        empName = new JLabel("Name:");
//        stdDob = new JLabel("Date of Birth:");
        empUsername = new JLabel("Username:");
        empPassword = new JLabel("Password:");
        empContact = new JLabel("Contact:");
        empField = new JLabel("Role:");
//        stdRoom = new JLabel("Room No:");

//        t_empCnic = new JTextField();
        t_empAge = new JTextField();
        t_empName = new JTextField();
//        t_stdDob = new JTextField();
        t_empUsername = new JTextField();
        t_empPassword = new JTextField();
        t_empContact = new JTextField();
        t_empField = new JTextField();
//        t_stdRoom = new JTextField();

        addEmp.setFont(new Font("Sanserif", Font.BOLD, 30));
        empCnic.setFont(new Font("Sanserif", Font.BOLD, 20));
        empAge.setFont(new Font("Sanserif", Font.BOLD, 20));
        empName.setFont(new Font("Sanserif", Font.BOLD, 20));
//        stdDob.setFont(new Font("Sanserif", Font.BOLD, 20));
        empUsername.setFont(new Font("Sanserif", Font.BOLD, 20));
        empPassword.setFont(new Font("Sanserif", Font.BOLD, 20));
        empContact.setFont(new Font("Sanserif", Font.BOLD, 20));
        empField.setFont(new Font("Sanserif", Font.BOLD, 20));
//        stdRoom.setFont(new Font("Sanserif", Font.BOLD, 20));

        addEmp.setForeground(Color.BLACK);//Text color
        empCnic.setForeground(Color.BLACK);
        empAge.setForeground(Color.BLACK);
        empName.setForeground(Color.BLACK);
//        stdDob.setForeground(Color.BLACK);
        empUsername.setForeground(Color.BLACK);
        empPassword.setForeground(Color.BLACK);
        empContact.setForeground(Color.BLACK);
        empField.setForeground(Color.BLACK);
//        stdRoom.setForeground(Color.BLACK);

        addEmp.setBounds(190, 40, 200, 60);
        empCnic.setBounds(120, 110, 250, 30);
        empAge.setBounds(120, 150, 250, 30);
        empName.setBounds(120, 190, 250, 30);
//        stdDob.setBounds(120, 230, 250, 30);
        empUsername.setBounds(120, 270, 250, 30);
        empPassword.setBounds(120, 310, 250, 30);
        empContact.setBounds(120, 350, 250, 30);
        empField.setBounds(120, 390, 250, 30);
//        stdRoom.setBounds(120, 430, 250, 30);

//        t_empCnic.setBounds(330, 110, 130, 30);
        t_empAge.setBounds(330, 150, 130, 30);
        t_empName.setBounds(330, 190, 130, 30);
//        t_stdDob.setBounds(330, 230, 130, 30);
        t_empUsername.setBounds(330, 270, 130, 30);
        t_empPassword.setBounds(330, 310, 130, 30);
        t_empContact.setBounds(330, 350, 130, 30);
        t_empField.setBounds(330, 390, 130, 30);
//        t_stdRoom.setBounds(330, 430, 130, 30);

//        t_empCnic.setBackground(Color.white);
        t_empAge.setBackground(Color.white);
        t_empName.setBackground(Color.white);

        add = new JButton("Add");

        back = new JButton("Back");

        clear = new JButton("Clear");

        add.setFont(new Font("Sanserif", Font.BOLD, 20));
        back.setFont(new Font("Sanserif", Font.BOLD, 20));
        clear.setFont(new Font("Sanserif", Font.BOLD, 20));

        add.setForeground(Color.orange);
        back.setForeground(Color.orange);
        clear.setForeground(Color.orange);
        add.setBackground(Color.black);
        clear.setBackground(Color.black);
        back.setBackground(Color.black);

        add.setBounds(50, 500, 150, 50);
        back.setBounds(215, 500, 150, 50);
        clear.setBounds(380, 500, 150, 50);
        try {
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
            Statement st = con1.createStatement();
            ResultSet result = st.executeQuery("select visitorcnic from visitors");
            while (result.next()) {
                cnic1.add(result.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        String unArray[] = cnic1.toArray(new String[cnic1.size()]);
        jComboBox = new JComboBox(unArray);
        jComboBox.setBounds(330, 110, 130, 30);
        panel.add(jComboBox);

        panel.add(addEmp);
        panel.add(empCnic);
        panel.add(empAge);
        panel.add(empName);
//        panel.add(stdDob);
        panel.add(empUsername);
        panel.add(empPassword);
        panel.add(empContact);
        panel.add(empField);
//        panel.add(stdRoom);
        panel.add(clear);
        panel.add(back);
//        panel.add(t_empCnic);
        panel.add(t_empName);
        panel.add(t_empAge);
//        panel.add(t_stdDob);
        panel.add(t_empUsername);
        panel.add(t_empPassword);
        panel.add(t_empContact);
        panel.add(t_empField);
//        panel.add(t_stdRoom);
        panel.add(add);

        frame.add(panel);
        frame.setTitle("Add Student");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



        add.addActionListener(new updateEmployeeHandler());
        clear.addActionListener(new updateEmployeeHandler());
        back.addActionListener(new updateEmployeeHandler());
    }

    class updateEmployeeHandler implements ActionListener {
        public void actionPerformed(ActionEvent i) {

            if (i.getSource() == add) {
                try {
                    Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
                    Statement st = con1.createStatement();
                    ResultSet resultSet = st.executeQuery("update employee set field='" + t_empField.getText() + "'where cnic='" + Integer.parseInt(String.valueOf(jComboBox.getSelectedItem())) + "'");
                    ResultSet resultSetPerson = st.executeQuery("update person set age='" + t_empAge.getText() + "', Username='"+t_empUsername.getText()+"', password='"+t_empPassword.getText()+"', name='"+t_empName.getText()+"', contactNo='"+t_empContact.getText() + "'where cnic='" + Integer.parseInt(String.valueOf(jComboBox.getSelectedItem())) + "'");
                    JOptionPane.showMessageDialog(null, "Information Updated");

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
            if (i.getSource() == clear) {
            }
            if (i.getSource() == back) {
                frame.dispose();
            }
        }
    }
}
