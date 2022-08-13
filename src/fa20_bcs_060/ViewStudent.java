package fa20_bcs_060;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewStudent {
    JFrame frame2;//creating object of second JFrame
    JButton logout;
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class

    public void viewStudentGui(){
        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(600, 400);

        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Cnic");
        defaultTableModel.addColumn("University");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Room");
        defaultTableModel.addColumn("Contact No");
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");//Crating connection with database
            statement = connection.createStatement();
            String query = "select * from person, student, occupied where person.cnic = student.cnic and student.cnic = occupied.STUDENT_CNIC\n";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
            System.out.println(query);

            while (resultSet.next()) {

                //Retrieving details from the database and storing it in the String variables
                String cnic = resultSet.getString("Cnic");
                String uni = resultSet.getString("University");
                String age = resultSet.getString("Age");
                String name = resultSet.getString("Name");
                String username = resultSet.getString("username");
                int password = resultSet.getInt("rooms_roomno");
                String contact = resultSet.getString("contactNo");
                defaultTableModel.addRow(new Object[]{cnic, uni, age, name, username, password, contact});//Adding row in Table
                frame2.setVisible(true);//Setting the visibility of second Frame
                frame2.validate();

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
                StudentManagementGui f = new StudentManagementGui();
                frame2.dispose();
            }
        }
    }
}
