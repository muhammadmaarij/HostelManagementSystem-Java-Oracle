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

public class AddExisStudent {

    int sCnic = 0;
    private JFrame frame;
    private JPanel panel;

    private JLabel addStd;
    private JLabel stdAge;
    private JLabel stdName;
    private JLabel stdDob;
    private JLabel stdUsername;
    private JLabel stdPassword;
    private JLabel stdContact;
    private JLabel stdUniversity;
    private JLabel stdRoom;

    private JTextField t_stdAge;
    private JTextField t_stdName;
    private JTextField t_stdDob;
    private JTextField t_stdUsername;
    private JTextField t_stdPassword;
    private JTextField t_stdContact;
    private JTextField t_stdUniversity;
    private JTextField t_stdRoom;
    private JComboBox jComboBox;
    ArrayList<String> cnic1 = new ArrayList<>();

    int dAge = 0;
    String dName = null;
    String dUsername = null;
    String dPassword = null;
    int dContact = 0;
    String dUni = null;
   int dRoom = 0;


    private JButton clear;
    private JButton add;
    private JButton back;

    public AddExisStudent(int selectedCnic) {
sCnic=selectedCnic;
        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addStd = new JLabel("Add Student");
        stdAge = new JLabel("Age:");
        stdName = new JLabel("Name:");
        stdDob = new JLabel("Date of Birth:");
        stdUsername = new JLabel("Username:");
        stdPassword = new JLabel("Password:");
        stdContact = new JLabel("Contact:");
        stdUniversity = new JLabel("University:");
        stdRoom = new JLabel("Room No:");

        t_stdAge = new JTextField();
        t_stdName = new JTextField();
        t_stdDob = new JTextField();
        t_stdUsername = new JTextField();
        t_stdPassword = new JTextField();
        t_stdContact = new JTextField();
        t_stdUniversity = new JTextField();
        t_stdRoom = new JTextField();

        addStd.setFont(new Font("Sanserif", Font.BOLD, 30));
        stdAge.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdName.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdDob.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdUsername.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdPassword.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdContact.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdUniversity.setFont(new Font("Sanserif", Font.BOLD, 20));
        stdRoom.setFont(new Font("Sanserif", Font.BOLD, 20));

        addStd.setForeground(Color.BLACK);//Text color
        stdAge.setForeground(Color.BLACK);
        stdName.setForeground(Color.BLACK);
        stdDob.setForeground(Color.BLACK);
        stdUsername.setForeground(Color.BLACK);
        stdPassword.setForeground(Color.BLACK);
        stdContact.setForeground(Color.BLACK);
        stdUniversity.setForeground(Color.BLACK);
        stdRoom.setForeground(Color.BLACK);

        addStd.setBounds(190, 40, 200, 60);
        stdAge.setBounds(120, 150, 250, 30);
        stdName.setBounds(120, 190, 250, 30);
        stdDob.setBounds(120, 230, 250, 30);
        stdUsername.setBounds(120, 270, 250, 30);
        stdPassword.setBounds(120, 310, 250, 30);
        stdContact.setBounds(120, 350, 250, 30);
        stdUniversity.setBounds(120, 390, 250, 30);
        stdRoom.setBounds(120, 430, 250, 30);

        t_stdAge.setBounds(330, 150, 130, 30);
        t_stdName.setBounds(330, 190, 130, 30);
        t_stdDob.setBounds(330, 230, 130, 30);
        t_stdUsername.setBounds(330, 270, 130, 30);
        t_stdPassword.setBounds(330, 310, 130, 30);
        t_stdContact.setBounds(330, 350, 130, 30);
        t_stdUniversity.setBounds(330, 390, 130, 30);
        t_stdRoom.setBounds(330, 430, 130, 30);

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
        panel.add(stdAge);
        panel.add(stdName);
//        panel.add(stdDob);
        panel.add(stdUsername);
        panel.add(stdPassword);
        panel.add(stdContact);
        panel.add(stdUniversity);
        panel.add(stdRoom);
        panel.add(clear);
        panel.add(back);
        panel.add(t_stdName);
        panel.add(t_stdAge);
//        panel.add(t_stdDob);
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

        try {
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
            Statement st = con1.createStatement();
            ResultSet result = st.executeQuery("select cnic from student");
            while (result.next()) {
                cnic1.add(result.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }



        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "project", "project");
            java.sql.Statement st = con.createStatement();
            String SQL = "SELECT * from student where cnic = '" + selectedCnic + "'";
            ResultSet result = st.executeQuery(SQL);
            while (result.next()) {
                dUni = result.getString("university");

            }

            String sqlPerson = "SELECT * from person where cnic = " + selectedCnic + "";
            System.out.println (sqlPerson );
            ResultSet resultP = st.executeQuery(sqlPerson);
            while (resultP.next()) {
                dAge = resultP.getInt("age");
                dName = resultP.getString("name");
                dUsername = resultP.getString("username");
                dPassword = resultP.getString("password");
                dContact = resultP.getInt("contactNo");

            }

            String sqlOccupied = "SELECT * from occupied where student_cnic = " + selectedCnic + " ";
            ResultSet resultOccupied = st.executeQuery(sqlOccupied);
            while (resultOccupied.next()) {
                dRoom = resultOccupied.getInt("rooms_roomNo");

            }
            String ag=Integer.toString(dAge);
            t_stdAge.setText(ag);
            t_stdName.setText(dName);
            t_stdUsername.setText(dUsername);
            String agg=Integer.toString(dContact);
            t_stdContact.setText(agg);
            t_stdPassword.setText(dPassword);
            t_stdUniversity.setText(dUni);

            if(dRoom==0){
                t_stdRoom.setText("");
            }
            else {
                String aggg=Integer.toString(dRoom);
                t_stdRoom.setText(aggg);

            }

        } catch (Exception e) {
            System.out.println("oo");
            System.err.println(e.toString());
        }


        sCnic = selectedCnic;

        add.addActionListener(new updateEmployeeHandler());
        clear.addActionListener(new updateEmployeeHandler());
        back.addActionListener(new updateEmployeeHandler());
    }

    boolean temp = false;


    //    String usernameText=text1.getText();
    class updateEmployeeHandler implements ActionListener {
        public void actionPerformed(ActionEvent i) {

            boolean flag = true;
            if (i.getSource() == add) {
                try {
                    System.out.println("ll");
                    Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
                    Statement st = con1.createStatement();
                    System.out.println("KK");
                    String jj="update student set university='"+ t_stdUniversity.getText()+"'where cnic="+sCnic+"";
                    ResultSet resultSetStudent = st.executeQuery(jj);
                    ResultSet resultSetPerson = st.executeQuery("update person set age=" + t_stdAge.getText() + ", Username='"+t_stdUsername.getText()+"', password='"+t_stdPassword.getText()+"', name='"+t_stdName.getText()+"', contactNo="+t_stdContact.getText() + "where cnic=" + sCnic + "");
                    System.out.println("update person set age=" + t_stdAge.getText() + ", Username='"+t_stdUsername.getText()+"', password='"+t_stdPassword.getText()+"', name='"+t_stdName.getText()+"', contactNo="+t_stdContact.getText() + "where cnic=" + sCnic + "");
                    String dAvaliablility = "";
                    String sqlRoom = "SELECT * from rooms where roomNo = " + t_stdRoom.getText() + "";
                    ResultSet result = st.executeQuery(sqlRoom);
                    while (result.next()) {
                        dAvaliablility = result.getString("avaliability");
                    }
                    if(dAvaliablility.equals("yes")){
                        if (t_stdRoom.getText().equals(dRoom)){
                        }

                        else {
                            ResultSet hhhh=st.executeQuery("update rooms set avaliability= 'yes' where roomno="+dRoom+"");
                            ResultSet resultSetRoomsSame = st.executeQuery("update rooms set avaliability= 'not' where roomno="+t_stdRoom.getText()+"");
                            System.out.println("update rooms set avaliability= 'not' where roomno='"+t_stdRoom.getText()+"'");
                            String hh="insert into occupied values ("+sCnic+","+ t_stdRoom.getText()+")";
                            System.out.println(hh);
                            ResultSet resultSetOccupied = st.executeQuery(hh);

                            ResultSet resultSetStay = st.executeQuery("insert into stay(ROOMS_ROOMNO,STUDENT_CNIC) values ("+ t_stdRoom.getText()+","+sCnic+")");

                            JOptionPane.showMessageDialog(null,"Room Updated");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Room Already Booked");

                    }

                    JOptionPane.showMessageDialog(null,"Other Information Updated");

                } catch (Exception e) {
                    System.out.println(e.toString());
                    AddExisStudent student = new AddExisStudent(sCnic);
                    frame.dispose();
                }
            }
            if (i.getSource() == clear) {
                AddExisStudent student = new AddExisStudent(sCnic);
                frame.dispose();
            }
            if (i.getSource() == back) {
                StudentManagementGui studentManagementGui = new StudentManagementGui();
                frame.dispose();
            }
        }

    }
}
