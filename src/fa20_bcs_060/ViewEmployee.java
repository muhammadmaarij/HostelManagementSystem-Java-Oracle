package fa20_bcs_060;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewEmployee {
    JFrame frame2;
    JButton logout;

    public void viewEmployeeGui(){

        DefaultTableModel defaultTableModel;
        JTable table;
        Connection connection;
        Statement statement;

        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(600, 400);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Cnic");
        defaultTableModel.addColumn("Field");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Password");
        defaultTableModel.addColumn("Contact No");
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
            statement = connection.createStatement();
            String query = "select * from person, employee where person.cnic = employee.cnic\n";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("Cnic");
                String roll = resultSet.getString("Field");
                String age = resultSet.getString("Age");
                String name1 = resultSet.getString("Name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String contact = resultSet.getString("contactNo");
                defaultTableModel.addRow(new Object[]{name, roll, age, name1, username, password, contact});
                frame2.setVisible(true);
                frame2.validate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logout = new JButton("Back");
        logout.setFont(new Font("Sanserif", Font.BOLD, 20));

        logout.setForeground(Color.orange);
        logout.setFocusable(false);

        logout.setBounds(175, 370, 50, 15);
        logout.setBackground(Color.black);
        frame2.add(logout);
        logout.addActionListener (new StudentRegistrationGuiHandler());
    }
    class StudentRegistrationGuiHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == logout) {
                EmployeeManagementGui employeeManagementGui =  new EmployeeManagementGui();
                frame2.dispose();
            }
        }
    }
}
