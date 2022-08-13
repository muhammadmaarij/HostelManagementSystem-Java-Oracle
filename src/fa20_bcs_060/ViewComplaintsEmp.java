package fa20_bcs_060;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewComplaintsEmp {
    JFrame frame2;
JButton logout;
    public void viewComplaintsEmpGui(){

        DefaultTableModel defaultTableModel;
        JTable table;
        Connection connection;
        Statement statement;

        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(500, 400);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 200));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("COMPLAINTID: ");
        defaultTableModel.addColumn("EMPLOYEE_CNIC");
        defaultTableModel.addColumn("COMPLAINT");
        defaultTableModel.addColumn("COMPLAINDATE");
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
            statement = connection.createStatement();
            String query = "select * from ComplainEmp ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("COMPLAINIDEMP");
                String roll = resultSet.getString("EMPLOYEE_CNIC");
                String abc = resultSet.getString("COMPLAINTEXTEMP");
                String bcd = resultSet.getString("COMPLAINDATEEMP");
                defaultTableModel.addRow(new Object[]{name, roll, abc, bcd});
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
        logout.addActionListener ( new StudentRegistrationGuiHandler());
    }
    class StudentRegistrationGuiHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == logout) {
                AdminMenuGui f = new AdminMenuGui();
                frame2.dispose();
            }
        }
    }
}
