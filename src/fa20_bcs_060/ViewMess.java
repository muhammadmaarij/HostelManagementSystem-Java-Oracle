package fa20_bcs_060;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewMess {
    JFrame frame2;
    JButton logout;
    public void viewMessGui() {

        DefaultTableModel defaultTableModel;
        JTable table;
        Connection connection;
        Statement statement;
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Day");
        defaultTableModel.addColumn("Breakfast");
        defaultTableModel.addColumn("Lunch");
        defaultTableModel.addColumn("Dinner");
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
            statement = connection.createStatement();
            String query = "select * from Mess ";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {

                String dayMess = resultSet.getString("MessDay");
                String Breakfast = resultSet.getString("Breakfast");
                String lunch = resultSet.getString("Lunch");
                String dinner = resultSet.getString("Dinner");
                defaultTableModel.addRow(new Object[]{dayMess, Breakfast, lunch, dinner});
                frame2.setVisible(true);
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
                MessInterface f = new MessInterface();
                frame2.dispose();
            }
        }

    }
}
