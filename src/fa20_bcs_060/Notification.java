package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class Notification {
    private JFrame frame;
    private JPanel panel;
    private JLabel studentMenu;
    private JLabel Complaints;
    private JButton send;
    private JButton back;

    private JTextField complaints;
    JComboBox type;
    String typedText;

    public Notification(){
        studentMenu = new JLabel("Notification");
        Complaints = new JLabel("Enter your notification here!");
        complaints=new JTextField ( "" );
        send =new JButton ( "Send" );
        back =new JButton ( "Back" );
        String []tye={"Student","Employee"};
        type=new JComboBox ( tye );



   ;
        studentMenu.setFont(new Font("Sanserif", Font.BOLD, 35));
        Complaints.setFont(new Font("Sanserif", Font.BOLD, 15));
        send.setFont(new Font("Sanserif", Font.BOLD, 15));
        send.setFont(new Font("Sanserif", Font.BOLD, 15));



        studentMenu.setForeground(Color.BLACK);
        Complaints.setForeground(Color.BLACK);
        send.setForeground(Color.BLACK);
        send.setForeground(Color.BLACK);



        studentMenu.setBackground(Color.green);
        Complaints.setBackground(Color.green);
        send.setBackground(Color.GRAY);
        back.setBackground(Color.gray);



        studentMenu.setBounds(280, 45, 800, 50);
       type.setBounds(300, 155, 150, 25);
        complaints.setBounds ( 300,200,230,150 );
        Complaints.setBounds(300, 100, 200, 50);
        send.setBounds(330, 350, 100, 30);
        back.setBounds(330, 400, 100, 50);


        panel = new JPanel(null);
        frame = new JFrame("Student Menu");
        panel.setBackground(Color.orange);
        panel.add(studentMenu);
        panel.add ( complaints );
        panel.add ( Complaints );
        panel.add ( send );
        panel.add ( back );
        panel.add ( type );




        frame.add(panel);


        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
       send.addActionListener ( new StudentRegistrationGuiHandler());
        back.addActionListener ( new StudentRegistrationGuiHandler());
    }
    class StudentRegistrationGuiHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == send) {
                if(complaints.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter some text");
                }

                int c = 0;
                typedText = ((JTextField)type.getEditor().getEditorComponent()).getText();

                if (typedText.trim ().equals ( "" )){
                    JOptionPane.showMessageDialog ( null,"Select the sender option" );
                }
                else{
                    try{
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                        Statement st = con.createStatement();
                        String sqlStudent="Select * from notifications";
                        ResultSet resultStudent = st.executeQuery(sqlStudent);
                        while (resultStudent.next ()){
                            c =resultStudent.getInt ( 1 );
                        }
                        c++;
                        String sq ="insert into notifications(notificationid,notification) values ("+c+",'"+complaints.getText ()+"')";
                        System.out.println (sq );
                        ResultSet resultStudentt = st.executeQuery(sq);

                    }
                    catch (Exception e1){
                        JOptionPane.showMessageDialog ( null,"THIS day is already present" );
                        Notification n = new Notification();
                        frame.dispose();
                        System.out.println(e1.toString());
                    }

                 if (typedText.trim ().toLowerCase( Locale.ROOT ).equals ( "student" )){

                    try{
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                        Statement st = con.createStatement();
                        String sqlStudent="Select Cnic from person where person_type='Student'";



                        ResultSet resultStudent = st.executeQuery(sqlStudent);
                        while (resultStudent.next ()){
                       int  cnic =resultStudent.getInt ( 1 );
                            System.out.println (cnic );
                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                            Statement stt = con.createStatement();
                            String ss="insert into receives values("+c+","+cnic+",'not')";
                            ResultSet resultStudenttt = stt.executeQuery(ss);
                            resultStudenttt=null;
                            System.gc ();

                            stt.close ();
                            stt=null;
                            System.gc ();

                        }
                        JOptionPane.showMessageDialog(null,"SENDED");
                        frame.dispose();
                        Notification kp=new Notification();

                    }
                    catch (Exception e1){
                        JOptionPane.showMessageDialog ( null,"THIS day is already present" );
                        Notification n = new Notification();
                        frame.dispose();
                        System.out.println(e1.toString());
                    }


                }
                    else if(typedText.trim ().toLowerCase( Locale.ROOT ).equals ( "employee" )){
                     System.out.println (typedText );
                     try{
                         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                         Statement st = con.createStatement();
                         String sqlStudent="Select Cnic from person where person_type='Employee'";



                         ResultSet resultStudent = st.executeQuery(sqlStudent);
                         while (resultStudent.next ()){
                             int  cnic =resultStudent.getInt ( 1 );
                             System.out.println (cnic );
                             Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                             Statement stt = con.createStatement();
                             String ss="insert into receivesv1 values("+cnic+","+c+",'not')";
                             System.out.println (ss );
                             ResultSet resultStudenttt = stt.executeQuery(ss);
                             resultStudenttt=null;
                             System.gc ();

                             stt.close ();
                             stt=null;
                             System.gc ();

                         }

                     }
                     catch (Exception e1){
                         JOptionPane.showMessageDialog ( null,"THIS day is already present" );
                         Notification n = new Notification();
                         frame.dispose();
                         System.out.println(e1.toString());
                     }

                 }
                }

//


            }

            else if(e.getSource ()==back){
                frame.dispose ();
              AdminMenuGui h=new AdminMenuGui();
            }
        }
    }

}
