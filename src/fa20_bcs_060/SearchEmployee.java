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

public class SearchEmployee {
    private JFrame frame;
    private JPanel panel;

    private JLabel addEmp;
    private JLabel empCnic;

    private JButton clear;
    private JButton delete;
    private JButton back;

    private JComboBox jComboBox;
    ArrayList<String> cnic1 = new ArrayList<>();

    public SearchEmployee(){
        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addEmp = new JLabel("Search Employee");
        empCnic = new JLabel("Cnic:");


        addEmp.setFont(new Font("Sanserif", Font.BOLD, 30));
        empCnic.setFont(new Font("Sanserif", Font.BOLD, 20));


        addEmp.setForeground(Color.BLACK);//Text color
        empCnic.setForeground(Color.BLACK);

        addEmp.setBounds(150, 40, 280, 60);
        empCnic.setBounds(120, 110, 250, 30);


        delete = new JButton("Add");

        back = new JButton("Back");

        clear = new JButton("Clear");

        delete.setFont(new Font("Sanserif", Font.BOLD, 20));
        back.setFont(new Font("Sanserif", Font.BOLD, 20));
        clear.setFont(new Font("Sanserif", Font.BOLD, 20));

        delete.setForeground(Color.orange);
        back.setForeground(Color.orange);
        clear.setForeground(Color.orange);
        delete.setBackground(Color.black);
        clear.setBackground(Color.black);
        back.setBackground(Color.black);

        delete.setBounds(50, 500, 150, 50);
        back.setBounds(215, 500, 150, 50);
        clear.setBounds(380, 500, 150, 50);
        try {
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
            Statement st = con1.createStatement();
            ResultSet result = st.executeQuery("select cnic from employee");
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
        panel.add(clear);
        panel.add(back);
        panel.add(delete);

        frame.add(panel);
        frame.setTitle("Add Student");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



        delete.addActionListener(new searchEmployeeHandler());
        clear.addActionListener(new searchEmployeeHandler());
        back.addActionListener(new searchEmployeeHandler());
    }
    class searchEmployeeHandler implements ActionListener {
        public void actionPerformed(ActionEvent i) {

            if (i.getSource() == delete) {
                UpdateEmployee11 updateEmployee11 = new UpdateEmployee11(Integer.parseInt(String.valueOf(jComboBox.getSelectedItem())));
                frame.dispose();
            }
            if (i.getSource() == clear) {
                SearchEmployee e = new SearchEmployee();
                frame.dispose();
            }
            if (i.getSource() == back) {
                EmployeeManagementGui employeeManagementGui = new EmployeeManagementGui();
                frame.dispose();
            }
        }
    }
}
