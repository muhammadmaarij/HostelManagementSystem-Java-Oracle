package fa20_bcs_060;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class ViewSalary {
    JButton back;
    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class
    public ViewSalary(){

    }

    public void viewsalarygui(String a,String b) {
        //setting the properties of second JFrame
        back = new JButton ( "OK" );
        back.setBounds ( 600 , 1000 , 200 , 30 );
        back.setForeground ( new Color ( 255 , 255 , 255 ) );
        back.setFont ( new Font ( "My boli" , Font.BOLD , 20 ) );
        back.setHorizontalTextPosition ( JLabel.CENTER );
        back.setVerticalTextPosition ( JLabel.BOTTOM );
        back.setHorizontalAlignment ( JLabel.CENTER );
        back.setBackground ( new Color ( 0 , 0 , 0 ) );
        back.setOpaque ( true );
        back.setFocusable ( false );
        back.addActionListener(new ActionListener () {
            public void actionPerformed( ActionEvent ae) {
                frame2.dispose ();

            }
        });
        frame2 = new JFrame ( "Database Results" );
        frame2.setLayout ( new FlowLayout ( ) );
        frame2.setSize ( 400 , 400 );



        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel ( );
        table = new JTable ( defaultTableModel );
        table.setPreferredScrollableViewportSize ( new Dimension ( 300 , 200 ) );
        table.setFillsViewportHeight ( true );
        frame2.add ( new JScrollPane ( table ) );
        frame2.add ( back );

        defaultTableModel.addColumn ( "Cheque No" );
        defaultTableModel.addColumn ( "Employee_CNIC" );
        defaultTableModel.addColumn ( "Salary amount" );
        defaultTableModel.addColumn ( "Date" );

        try {
            connection = DriverManager.getConnection ( "jdbc:oracle:thin:@localhost:1521:xe" , "project" , "project" );//Crating connection with database
            statement = connection.createStatement ( );
            String query = "SELECT chequeno,employee_cnic,salaryamount, TO_CHAR(salarydate, 'DD-Mon-YYYY')  FROM salary WHERE salarydate between TO_DATE('"+a+"','DD-Mon-RR') and TO_DATE('"+b+"','DD-Mon-RR')";

            ResultSet resultSet = statement.executeQuery ( query );//executing query and storing result in ResultSet

            SalaryGui n=new SalaryGui ();
            while ( resultSet.next ( ) ) {

                //Retrieving details from the database and storing it in the String variables
                int id = resultSet.getInt ( 1 );
                int amount = resultSet.getInt ( 2 );
                String purpose = resultSet.getString ( 3 );
                String date = resultSet.getString ( 4 );
                defaultTableModel.addRow ( new Object[]{ id , amount , purpose , date } );//Adding row in Table
                frame2.setVisible ( true );//Setting the visibility of second Frame
                frame2.validate ( );

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
            ViewSalary viewSalary = new ViewSalary();
        }

    }
}
