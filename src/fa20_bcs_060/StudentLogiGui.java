package fa20_bcs_060;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class StudentLogiGui extends JFrame{
    JLabel l2, l3;
    JButton l1;
    JLabel label;
    public JTextField Studentuser;
    JPasswordField t2;
    Border border1;
    JFrame frame;
    String iname;
    int iroom;
    String iuniversity;
    int icnic;
    String b="not";
    boolean bor=false;

    public StudentLogiGui () {
        border1=BorderFactory.createLineBorder(Color.red,3);
        Border border=BorderFactory.createLineBorder ( new Color ( 0,0,0 ),10);
        ImageIcon image=new ImageIcon ( "download.jpg" );
        label=new JLabel ( );
        label.setText ( "HOSTEL COSTEL" );
        label.setIcon(image);
        label.setHorizontalTextPosition ( JLabel.CENTER);
        label.setVerticalTextPosition ( JLabel.BOTTOM );
        label.setForeground ( new Color ( 0,0,0) );
        label.setFont ( new Font ( "MV Boli",Font.BOLD,20 ) );
        label.setBackground ( new Color(255,255,255 ));
        label.setOpaque ( true );
        label.setBorder ( border );
        label.setHorizontalAlignment ( JLabel.CENTER );
        label.setBounds ( 550,100,300,300);
        frame=new JFrame (  );
        l1=new JButton ( "Log In" );
        l1.setBounds ( 600,600,200,30);
        l1.setForeground ( new Color ( 255,255,255) );
        l1.setFont ( new Font("My boli",Font.BOLD,20) );
        l1.setHorizontalTextPosition ( JLabel.CENTER);
        l1.setVerticalTextPosition ( JLabel.BOTTOM );
        l1.setHorizontalAlignment ( JLabel.CENTER );
        l1.setBackground ( new Color(0,0,0) );
        l1.setOpaque ( true );
        l1.setFocusable(false);


        l2 =new JLabel ( "Student Login" );
        l2.setBounds(625, 400, 250, 40);
        l2.setFont(new Font("My Bali", Font.BOLD, 25));
        l2.setForeground(new Color(2));

        Studentuser=new JTextField (  );
        Studentuser.setBounds (  500,450,400,35);
        Studentuser.setText ( "Username" );
        Studentuser.addFocusListener ( new FocusListener( ) {
            public void focusGained( FocusEvent  event){
                if(Studentuser.getText ().equals ( "Username" )){
                    Studentuser.setText ( "" );
                    if(Studentuser.getBorder()==border1){
                        Studentuser.setBorder(null);
                    }
                }
            }
            public void focusLost(FocusEvent event){
                if(Studentuser.getText ().equals ( "" )){
                    Studentuser.setText ( "Username" );
                }
                if(Studentuser.getBorder()==border1){
                    Studentuser.setBorder(null);
                }
            }
        } );
        Studentuser.setFont ( new Font ( "My Bali",Font.BOLD,20 ) );

        t2=new JPasswordField (  );
        t2.setBounds (  500,500,400,35);
        t2.setText ( "password" );
        t2.addFocusListener ( new FocusListener( ) {
            public void focusGained( FocusEvent  event){
                if(t2.getText ().equals ( "password" )){
                    t2.setText ( "" );
                    if(t2.getBorder()==border1){
                        t2.setBorder(null);
                    }
                }
            }
            public void focusLost(FocusEvent event){
                if(t2.getText ().equals ( "" )){
                    t2.setText ( "password" );
                }
            }
        } );
        t2.setFont ( new Font ( "My Bali",Font.BOLD,20 ) );
        frame.setTitle ( "hostel" );
        frame.setSize ( 700,500 );
        //frame.setResizable ( false );
        frame.setVisible ( true );
        frame.setLayout ( null );
        frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        frame.getContentPane ().setBackground ( new Color (0,0,0) );
        frame.setSize ( 1400,700 );
        frame.getContentPane ().setBackground ( new Color (255,255,255) );
        frame.add (l1  );
        frame.add (Studentuser  );
        frame.add (l2  );
        frame.add(t2);
        frame.add(label);


        l1.addActionListener ( new LoginHandler ());
    }
    public class LoginHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==l1){
                String q="";
                String dName = "";
                String dPassword = "";
                String name = Studentuser.getText().trim ();;
                String password = t2.getText();
                int coun=0;
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    String SQL = "SELECT * FROM person,student,occupied where person.cnic=occupied.student_cnic and person.cnic=student.cnic and username='" + name + "' and password='" + password+ "'";
                    ResultSet result = st.executeQuery(SQL);
                    while (result.next()) {

                        dName = result.getString("username").trim ();
                        dPassword = result.getString("password").trim ();
                        iuniversity= result.getString ( "university" ).toUpperCase( Locale.ROOT );
                        iroom=result.getInt ( "Rooms_RoomNo" );
                        iname=result.getString ( "name" );
                        icnic=result.getInt ( "cnic" );


                    }
                    System.out.println (name+password );
                    if (name.equals(dName) && password.equals(dPassword)) {
                        String qw="Select * from receives,Notifications where receives.notifications_notificationid=notifications.notificationid and receives.student_cnic="+icnic+"";
                        ResultSet resultt = st.executeQuery(qw);
                        while(resultt.next ()){
                           q=resultt.getString ( 3 ).trim ().toLowerCase( Locale.ROOT );
//                            System.out.println (resultt.getString ( 3 ).trim ().toLowerCase( Locale.ROOT ) );
                            //System.out.println (resultt.getInt ( 1 )+"   "+resultt.getInt ( 2 )+resultt.getString ( 3 ) );
                            if(q.equals ( b )){
                                bor=true;
                            }
                        }
                        String kkk="select count(*) from receives  where student_cnic ="+icnic+" and readstd='not'";
                        ResultSet jjj=st.executeQuery(kkk);
                        while (jjj.next()){
                             coun=jjj.getInt(1);
                        }
                        System.out.println(coun);
                        String f=Integer.toString(coun);
                       StudentInterface k=new StudentInterface (iuniversity,iroom,iname,icnic,bor,f);
                       frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null,"Incorrect Username or Password\nEnter credentials again");
                        StudentLogiGui logiGui = new StudentLogiGui();
                        frame.dispose();
                    }
                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                    StudentLogiGui s = new StudentLogiGui();
                    frame.dispose();
                }
            }
        }
    }
}
