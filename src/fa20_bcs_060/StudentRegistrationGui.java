package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentRegistrationGui {
    private JFrame frame;
    private JPanel panel;

    private JLabel addStd;
    private JLabel stdCnic;
    private JLabel stdAge;
    private JLabel stdName;
    private JLabel stdDob;
    private JLabel stdUsername;
    private JLabel stdPassword;
    private JLabel stdContact;
    private JLabel stdUniversity;
    private JLabel stdRoom;

    private JTextField t_stdCnic;
    private JTextField t_stdAge;
    private JTextField t_stdName;
    private JTextField t_stdDob;
    private JTextField t_stdUsername;
    private JTextField t_stdPassword;
    private JTextField t_stdContact;
    private JTextField t_stdUniversity;
    private JTextField t_stdRoom;

    private JButton clear;
    private JButton add;
    private JButton back;

    public StudentRegistrationGui() {

        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addStd = new JLabel("Add Student");
        stdCnic = new JLabel("Cnic:");
        stdAge = new JLabel("Age:");
        stdName = new JLabel("Name:");
        stdDob = new JLabel("Date of Birth:");
        stdUsername = new JLabel("Username:");
        stdPassword = new JLabel("Password:");
        stdContact = new JLabel("Contact:");
        stdUniversity = new JLabel("University:");
        stdRoom = new JLabel("Room No:");

        t_stdCnic = new JTextField();
        t_stdAge = new JTextField();
        t_stdName = new JTextField();
        t_stdDob = new JTextField();
        t_stdUsername = new JTextField();
        t_stdPassword = new JTextField();
        t_stdContact = new JTextField();
        t_stdUniversity = new JTextField();
        t_stdRoom = new JTextField();

        addStd.setFont(new Font("Sanserif", Font.BOLD, 30));
        stdCnic.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdAge.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdName.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdDob.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdUsername.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdPassword.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdContact.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdUniversity.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdRoom.setFont(new Font("Sanserif", Font.BOLD, 20));

        addStd.setForeground(Color.BLACK);//Text color
        stdCnic.setForeground(Color.BLACK);
        stdAge.setForeground(Color.BLACK);
        stdName.setForeground(Color.BLACK);
        stdDob.setForeground(Color.BLACK);
        stdUsername.setForeground(Color.BLACK);
        stdPassword.setForeground(Color.BLACK);
        stdContact.setForeground(Color.BLACK);
        stdUniversity.setForeground(Color.BLACK);
        stdRoom.setForeground(Color.BLACK);

        addStd.setBounds(190, 40, 200, 60);
        stdCnic.setBounds(120, 110, 250, 30);
        stdAge.setBounds(120, 150, 250, 30);
        stdName.setBounds(120, 190, 250, 30);
        stdDob.setBounds(120, 230, 250, 30);
        stdUsername.setBounds(120, 270, 250, 30);
        stdPassword.setBounds(120, 310, 250, 30);
        stdContact.setBounds(120, 350, 250, 30);
        stdUniversity.setBounds(120, 390, 250, 30);
        stdRoom.setBounds(120, 430, 250, 30);

        t_stdCnic.setBounds(330, 110, 130, 30);
        t_stdAge.setBounds(330, 150, 130, 30);
        t_stdName.setBounds(330, 190, 130, 30);
        t_stdDob.setBounds(330, 230, 130, 30);
        t_stdUsername.setBounds(330, 270, 130, 30);
        t_stdPassword.setBounds(330, 310, 130, 30);
        t_stdContact.setBounds(330, 350, 130, 30);
        t_stdUniversity.setBounds(330, 390, 130, 30);
        t_stdRoom.setBounds(330, 430, 130, 30);

        t_stdCnic.setBackground(Color.white);
        t_stdAge.setBackground(Color.white);
        t_stdName.setBackground(Color.white);

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

        panel.add(addStd);
        panel.add(stdCnic);
        panel.add(stdAge);
        panel.add(stdName);
        panel.add(stdUsername);
        panel.add(stdPassword);
        panel.add(stdContact);
        panel.add(stdUniversity);
        panel.add(stdRoom);
        panel.add(clear);
        panel.add(back);
        panel.add(t_stdCnic);
        panel.add(t_stdName);
        panel.add(t_stdAge);
        panel.add(t_stdUsername);
        panel.add(t_stdPassword);
        panel.add(t_stdContact);
        panel.add(t_stdUniversity);
        panel.add(t_stdRoom);
        panel.add(add);

        frame.add(panel);
        frame.setTitle("Add Student");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        add.addActionListener ( new StudentRegistrationGuiHandler ());
       back.addActionListener ( new StudentRegistrationGuiHandler ());
        clear.addActionListener ( new StudentRegistrationGuiHandler ());
    }
    class StudentRegistrationGuiHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == add) {
                if(t_stdCnic.getText().trim().isEmpty()||t_stdName.getText ().trim ().isEmpty ()||t_stdAge.getText().trim().isEmpty()|| t_stdUsername.getText().trim().isEmpty()||t_stdUniversity.getText().trim().isEmpty()||t_stdPassword.getText().trim().isEmpty()||t_stdRoom.getText().trim().isEmpty()){

                    StudentRegistrationGui p=new StudentRegistrationGui();
                    frame.dispose ();
                }
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    String sqlPerson = "Insert into person(CNIC,AGE,Username,password,name,contactNo,Person_type) " +
                            "values("+t_stdCnic.getText ()+" , "+t_stdAge.getText ()+",'"+t_stdUsername.getText ()+"','"+t_stdPassword.getText ()+"', '"+t_stdName.getText ()+"'" +
                            ", '"+t_stdContact.getText ()+"','Student')";
                    System.out.println (sqlPerson );
                    String sqlStudent="Insert into Student(cnic, university) values("+t_stdCnic.getText ()+",'"+t_stdUniversity.getText ()+"')";
                    System.out.println(sqlStudent);
                    String sqlRoom="UPDATE Rooms SET AVALIABILITY = 'not' WHERE AVALIABILITY = 'yes' and Rooms.roomno="+Integer.parseInt(t_stdRoom.getText())+" ";
                    String sqlStay = "Insert into Stay(ROOMS_ROOMNO, STUDENT_CNIC) values("+t_stdRoom.getText ()+" ,'"+t_stdCnic.getText()+"')";

                    String sqlOccupied = "Insert into Occupied(ROOMS_ROOMNO, STUDENT_CNIC) values("+t_stdRoom.getText ()+" ,'"+t_stdCnic.getText()+"')";
                    System.out.println(sqlOccupied);
                    ResultSet resultPerson = st.executeQuery(sqlPerson);
                    ResultSet resultStudent = st.executeQuery(sqlStudent);
                    ResultSet resultRoom = st.executeQuery(sqlRoom);
                    ResultSet resultStay = st.executeQuery(sqlStay);
                    ResultSet resultOccupied = st.executeQuery(sqlOccupied);
                    JOptionPane.showMessageDialog(null,"Added ");
                    frame.dispose();
                    StudentRegistrationGui m=new StudentRegistrationGui();

                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"invalid Data");
                    frame.dispose();
                    StudentRegistrationGui j=new StudentRegistrationGui();
                    System.out.println(e1.toString());
                }

            }
            if (e.getSource() == back) {
                frame.dispose();
                StudentManagementGui studentManagementGui = new StudentManagementGui();
            }
            if (e.getSource() == clear) {
                frame.dispose();
                StudentRegistrationGui k=new StudentRegistrationGui();
            }
        }
    }
}

