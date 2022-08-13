package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddSalary {
    private JFrame frame;
    private JPanel panel;

    private JLabel addMess;
    private JLabel day;
    private JLabel breakfast;
    private JLabel lunch;
    private JLabel Dinner;

    private JTextField t_day;
    private JTextField t_breakfast;
    private JTextField t_lunch;
    private JTextField t_dinner;
    JComboBox days;

    private JButton clear;
    private JButton add;
    private JButton back;

    public AddSalary() {

        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addMess = new JLabel("Salary Data Entry Form");
        day = new JLabel("Day:");
        breakfast = new JLabel("Cheque No.");
        lunch = new JLabel("Employee Cnic");
        Dinner = new JLabel("Salary");
        String []dayss={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        days=new JComboBox ( dayss );

        t_day = new JTextField();
        t_breakfast = new JTextField();
        t_lunch = new JTextField();
        t_dinner = new JTextField();

        addMess.setFont(new Font("Sanserif", Font.BOLD, 30));
        day.setFont(new Font("Sanserif", Font.BOLD, 20));
        breakfast.setFont(new Font("Sanserif", Font.BOLD, 20));
        lunch.setFont(new Font("Sanserif", Font.BOLD, 20));
        Dinner.setFont(new Font("Sanserif", Font.BOLD, 20));

        addMess.setForeground(Color.BLACK);//Text color
        day.setForeground(Color.BLACK);
        breakfast.setForeground(Color.BLACK);
        lunch.setForeground(Color.BLACK);
        Dinner.setForeground(Color.BLACK);

        addMess.setBounds(190, 40, 200, 60);
        day.setBounds(120, 110, 250, 30);
        breakfast.setBounds(120, 150, 250, 30);
        lunch.setBounds(120, 190, 250, 30);
        Dinner.setBounds(120, 230, 250, 30);

        days.setBounds(330, 110, 130, 30);
        t_breakfast.setBounds(330, 150, 130, 30);
        t_lunch.setBounds(330, 190, 130, 30);
        t_dinner.setBounds(330, 230, 130, 30);

        days.setBackground(Color.white);
        t_breakfast.setBackground(Color.white);
        t_lunch.setBackground(Color.white);

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

        panel.add(addMess);

        panel.add(breakfast);
        panel.add(lunch);
        panel.add(Dinner);
        panel.add(clear);
        panel.add(back);

        panel.add(t_lunch);
        panel.add(t_breakfast);
        panel.add(t_dinner);
        panel.add(add);

        frame.add(panel);
        frame.setTitle("Add Student");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        add.addActionListener ( new StudentRegistrationGuiHandler ());
        clear.addActionListener ( new StudentRegistrationGuiHandler ());
        back.addActionListener ( new StudentRegistrationGuiHandler ());

    }
    class StudentRegistrationGuiHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == add) {
                if( t_lunch.getText ().trim ().isEmpty ()|| t_breakfast.getText().trim().isEmpty()|| t_dinner.getText().trim().isEmpty()){
                    frame.dispose ();
                    AddSalary k=new AddSalary ();

                }
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");

                    Statement st = con.createStatement();

                    String sqlStudent="Insert into salary(chequeno, employee_cnic,salaryamount) values('"+t_breakfast.getText ()+"','"+t_lunch.getText ()+"','"+t_dinner.getText ()+"')";


                    ResultSet resultStudent = st.executeQuery(sqlStudent);
                    JOptionPane.showMessageDialog ( null,"Added Successfully!" );
                    frame.dispose();

                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog ( null,"Enter valid data" );
                    frame.dispose();
                    AddSalary k=new AddSalary();
                    System.out.println(e1.toString());
                }

            }
            else if(e.getSource ()==clear){
                frame.dispose ();
                AddSalary k=new AddSalary();
            }
            else if(e.getSource ()==back){
                frame.dispose ();
                FeesGui k=new FeesGui ();
            }}}}
