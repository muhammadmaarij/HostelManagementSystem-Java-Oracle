package fa20_bcs_060;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewRoom {
    JFrame frame2;//creating object of second JFrame
    JButton logout;
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class

    public void viewRoomGui(){
        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);

        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Room");
        defaultTableModel.addColumn("AVALIABILITY");
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");//Crating connection with database
            statement = connection.createStatement();
            String query = "select * from Rooms";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet


            while (resultSet.next()) {

                //Retrieving details from the database and storing it in the String variables
                String name = resultSet.getString("RoomNo");
                String roll = resultSet.getString("AVALIABILITY");
                defaultTableModel.addRow(new Object[]{name, roll});//Adding row in Table
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
                RoomGui f = new RoomGui();
                frame2.dispose();
            }
        }
    }
}
