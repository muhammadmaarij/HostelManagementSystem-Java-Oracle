package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorRegistration {
    String cnicVV = "";

    private JFrame frame;
    private JPanel panel;

    private JLabel addVisitor;
    private JLabel vCnic;
    private JLabel vName;
    private JLabel sCnic;

    private JTextField t_vCnic;
    private JTextField t_vName;
    private JTextField t_sCnic;

    private JButton clear;
    private JButton add;
    private JButton back;

    public VisitorRegistration() {

        panel = new JPanel(null);

        frame = new JFrame("Add Visitor");
        panel.setBackground(Color.orange);

        addVisitor = new JLabel("Add Visitor");
        vCnic = new JLabel("Cnic:");
        vName = new JLabel("Name:");
        sCnic = new JLabel("Student Cnic:");

        t_vCnic = new JTextField();
        t_vName = new JTextField();
        t_sCnic = new JTextField();

        addVisitor.setFont(new Font("Sanserif", Font.BOLD, 30));
        vCnic.setFont(new Font("Sanserif", Font.BOLD, 20));
        vName.setFont(new Font("Sanserif", Font.BOLD, 20));
        sCnic.setFont(new Font("Sanserif", Font.BOLD, 20));

        addVisitor.setForeground(Color.BLACK);//Text color
        vCnic.setForeground(Color.BLACK);
        vName.setForeground(Color.BLACK);
        sCnic.setForeground(Color.BLACK);

        addVisitor.setBounds(190, 40, 200, 60);
        vCnic.setBounds(120, 110, 250, 30);
        vName.setBounds(120, 190, 250, 30);
        sCnic.setBounds(120, 270, 250, 30);

        t_vCnic.setBounds(330, 110, 130, 30);
        t_vName.setBounds(330, 190, 130, 30);
        t_sCnic.setBounds(330, 270, 130, 30);

        t_vCnic.setBackground(Color.white);
        t_vName.setBackground(Color.white);
        t_sCnic.setBackground(Color.white);

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

        panel.add(addVisitor);
        panel.add(vCnic);
        panel.add(vName);
        panel.add(sCnic);
        panel.add(clear);
        panel.add(back);
        panel.add(t_vCnic);
        panel.add(t_vName);
        panel.add(t_sCnic);
        panel.add(add);

        frame.add(panel);
        frame.setTitle("Add Visitor");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        add.addActionListener ( new EmployeeRegitrationHandler ());
    }
    class EmployeeRegitrationHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            boolean bool = false;
            if (e.getSource() == add) {
                if(t_vCnic.getText().trim().isEmpty()&& t_vName.getText ().trim ().isEmpty()){

                    VisitorRegistration p=new VisitorRegistration();
                    frame.dispose ();
                }
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    ResultSet result = st.executeQuery("select * from visitors where visitorcnic = '" + t_vCnic.getText() + "'");
                    while (result.next()) {
                            bool = true;
                    }
                    if (bool){
                        JOptionPane.showMessageDialog(null,"Cnic Already exists");
                    }
                    else {
                        String sqlVisitor = "Insert into visitors(visitorCnic,visitorName) values("+ t_vCnic.getText ()+ ",'"+ t_vName.getText ()+"')";
                        System.out.println (sqlVisitor );
                        String sqlEmp="Insert into VISITS(visitors_visitorCnic, student_cnic) values("+ t_vCnic.getText ()+",'"+ t_sCnic.getText ()+"')";
                        System.out.println(sqlEmp);
                        ResultSet resultPerson = st.executeQuery(sqlVisitor);
                        ResultSet resultEmp = st.executeQuery(sqlEmp);
                    }
                }
                catch (Exception e1){
                    VisitorRegistration v = new VisitorRegistration();
                    frame.dispose();
                    System.out.println(e1.toString());
                }

            }
            if (e.getSource() == back){
                frame.dispose();
                AdminMenuGui adminMenuGui = new AdminMenuGui();
            }
            if (e.getSource() == clear){
                frame.dispose();
                VisitorRegistration adminMenuGui = new VisitorRegistration();
            }
        }
    }
}

