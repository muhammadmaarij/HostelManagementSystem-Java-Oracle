package fa20_bcs_060;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class StudentInterface {
    private JFrame frame;
    private JPanel panel;
    private JLabel studentMenu;
    private JLabel Complaints;
    JLabel count;
    private JButton send;
    private JTextArea notifications;
    private JLabel Name;
    private JLabel cnicc;
    private JLabel university;
    private JLabel room;
    private JButton mess;
    private JButton fees;
    private JButton Notifications;
    private JButton back;
    Border border1;
    Border border;

    String display="";
    String dis="Challan No | CNIC  | FEEAMOUNT  | FEEDATE   |  FEESTATUS  \n";
    String f="";


    private JTextField complaints;


    public StudentInterface(String uni ,int roo,String stdname ,int cnic,boolean bbb ,String c ){
        panel = new JPanel(null);
        String ba=Integer.toString ( cnic);
        String abc=Integer.toString ( roo);
        border=BorderFactory.createLineBorder ( new Color ( 2,0,0 ),6);
        border1=BorderFactory.createLineBorder ( new Color ( 255,0,0),6);

        studentMenu = new JLabel("WELLCOME TO STUDENT DASH BOARD");
        Complaints = new JLabel("Register your complaints!");
        complaints=new JTextField ( "" );
        send =new JButton ( "Send" );
        notifications=new JTextArea (  );
        Name=new JLabel ( "NAME : "+stdname );
        cnicc=new JLabel ("CNIC : " +ba );
        university=new JLabel ("UNIVERSITY : " +uni );
        room=new JLabel ( "ROOM : "+abc );
        notifications.setText ( ba );
        mess=new JButton ( "MESS" );
        fees=new JButton ( "FEES" );
        Notifications=new JButton ( "NOTIFICATIONS" );
        if(c.trim().equals("0")){
            count=new JLabel("");
        }
        else {
            count=new JLabel(c);
        }

        back=new JButton ( "logout" );
        back.setFont(new Font("Sanserif", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.GRAY);
        back.setBounds(200, 650, 200, 50);

        Name.setFont(new Font("Sanserif", Font.BOLD, 20));
        room.setFont(new Font("Sanserif", Font.BOLD, 20));
        count.setFont(new Font("Sanserif", Font.BOLD, 20));
        university.setFont(new Font("Sanserif", Font.BOLD, 20));
        cnicc.setFont(new Font("Sanserif", Font.BOLD, 20));
        studentMenu.setFont(new Font("Sanserif", Font.BOLD, 35));
       Complaints.setFont(new Font("Sanserif", Font.BOLD, 15));
       send.setFont(new Font("Sanserif", Font.BOLD, 15));
        mess.setFont(new Font("Sanserif", Font.BOLD, 15));
       fees.setFont(new Font("Sanserif", Font.BOLD, 15));
       Notifications.setFont(new Font("Sanserif", Font.BOLD, 15));


        studentMenu.setForeground(Color.BLACK);
        Complaints.setForeground(Color.BLACK);
        send.setForeground(Color.BLACK);
        mess.setForeground(Color.BLACK);
        fees.setForeground(Color.BLACK);
        Notifications.setForeground(Color.BLACK);

        Name.setForeground(Color.BLACK);
        count.setForeground(Color.RED);
        university.setForeground(Color.BLACK);
        cnicc.setForeground(Color.BLACK);
       room.setForeground(Color.BLACK);
       studentMenu.setBackground(Color.green);
        Complaints.setBackground(Color.green);
        send.setBackground(Color.GRAY);
        mess.setBackground(Color.GRAY);
        fees.setBackground(Color.GRAY);
       Notifications.setBackground(Color.GRAY);

        Name.setBounds(150, 150, 350, 50);
        university.setBounds(550, 150, 250, 50);
        cnicc.setBounds(150, 200, 250, 50);
        room.setBounds(550, 200, 250, 50);
        studentMenu.setBounds(180, 45, 800, 50);
        complaints.setBounds ( 700,400,230,150 );
        Complaints.setBounds(700, 350, 200, 50);
        send.setBounds(830, 550, 100, 30);
        mess.setBounds(200, 350, 200, 50);
        fees.setBounds(200, 450, 200, 50);
        Notifications.setBounds(200, 550, 200, 50);
        count.setBounds(400, 530, 200, 50);

            mess.setBorder ( border );
            send.setBorder ( border );
        fees.setBorder ( border );
        Notifications.setBorder ( border );
        if(bbb){
            Notifications.setBorder ( border1 );
        }



    frame = new JFrame("Student Menu");
    panel.setBackground(Color.orange);
        panel.add(studentMenu);
        panel.add ( complaints );
        panel.add ( Complaints );
        panel.add ( send );
        panel.add ( notifications );
        panel.add ( Name );
        panel.add ( university );
        panel.add ( cnicc );
        panel.add ( room );
        panel.add ( mess );
        panel.add ( fees );
        panel.add ( Notifications );
        panel.add ( count );
        panel.add ( back );

        notifications.setEditable ( false );

        frame.add(panel);


        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        send.addActionListener ( new StudentInterfaceGuiHandler ());
       mess.addActionListener ( new StudentInterfaceGuiHandler ());
        fees.addActionListener ( new StudentInterfaceGuiHandler ());
       Notifications.addActionListener ( new StudentInterfaceGuiHandler ());
       back.addActionListener ( new StudentInterfaceGuiHandler ());
    }
    class StudentInterfaceGuiHandler implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == send) {
                int c=0;
                if(complaints.getText().trim().isEmpty()){
                    frame.dispose ();
                }
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    int numbeer = Integer.parseInt(notifications.getText ());
                    String hh="select complaintid from complaint";
                    ResultSet hhh=st.executeQuery(hh);
                    while (hhh.next ()){
                        c =hhh.getInt ( 1 );
                    }
                    c++;
                    String gg="Insert  into complaint(complaintid,Student_CNIC,COMPLAINT) values ( "+c+","+numbeer+",'"+complaints.getText ()+"')";

                    ResultSet result = st.executeQuery(gg);
                    complaints.setText ( "" );
                    JOptionPane.showMessageDialog ( null,"COMPLAINT SENT WE WILL CONTACT YOU SOON" ) ;
                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                }
            }
            if(e.getSource ()==mess){
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                   String mm="Select * from mess";
                    ResultSet result = st.executeQuery(mm);
                    while (result.next()) {
                        display+= "Day : " +result.getString ( 1 ) + "   Breakfast :"+result.getString ( 2 ) +"    Lunch :"+result.getString ( 3 )+"      Dinner :"+result.getString ( 4 ) +"\n" ;
                    }
                    JOptionPane.showMessageDialog ( null,display );
                    display="";
                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                }
            }
            if(e.getSource ()==fees){
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    String mm="Select * from STUDENTFEES where STUDENT_CNIC="+Integer.parseInt(notifications.getText ())+"";
                    ResultSet result = st.executeQuery(mm);

                    while (result.next()) {

                        dis+=result.getInt ( 1 )+"                 |"+result.getInt ( 2 )+ "       |"+result.getInt ( 3 )+"              |"+ result.getDate ( 4 )+"   | "+result.getString ( 5 )+"\n";
                    }
                    JOptionPane.showMessageDialog ( null,dis );
                    dis="";






                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                }
            }
            if(e.getSource ()==Notifications){
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    String mm="Select * from receives,Notifications where receives.notifications_notificationid=notifications.notificationid and receives.student_cnic="+Integer.parseInt(notifications.getText ())+"";
                    ResultSet result = st.executeQuery(mm);

                    while (result.next()) {
                        if(result.getString ( 3 ).trim ().toLowerCase( Locale.ROOT ).equals ( "not" )){
                            f+="new--->>>>   "+result.getString ( 5 )+"                 Dated"+result.getDate ( 6 )+"\n";
                        }
                        else
                        f+=result.getString ( 5 )+"                 Dated"+result.getDate ( 6 )+"\n";
                    }
                    JOptionPane.showMessageDialog ( null,f);
                    f="";
                    String f="UPDATE receives SET readstd = 'yes' WHERE receives.student_cnic="+Integer.parseInt(notifications.getText ())+" ";
                    String j="commit";
                    ResultSet g=st.executeQuery ( f );
                    g=st.executeQuery ( j );
                    Notifications.setBorder ( border );
                    count.setText("");
                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                }
            }
            if (e.getSource() == back){
                WelcomeGui employeeLogiGui = new WelcomeGui();
                frame.dispose();
            }
        }
    }
}
