package fa20_bcs_060;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminLogiGui extends JFrame{
    JLabel Adminl2, l3;
    JButton Adminl1;
    JTextField t_name;
    JPasswordField t_pass;
    Border border1;
    JFrame frame;
    public AdminLogiGui () {
        border1=BorderFactory.createLineBorder(Color.red,3);
        Border border=BorderFactory.createLineBorder ( new Color ( 0,0,0 ),10);
        ImageIcon image=new ImageIcon ( "download.jpg" );
        JLabel label=new JLabel ( );
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
        Adminl1=new JButton ( "Log In" );
        Adminl1.setBounds ( 600,600,200,30);
        Adminl1.setForeground ( new Color ( 255,255,255) );
        Adminl1.setFont ( new Font("My boli",Font.BOLD,20) );
        Adminl1.setHorizontalTextPosition ( JLabel.CENTER);
        Adminl1.setVerticalTextPosition ( JLabel.BOTTOM );
        Adminl1.setHorizontalAlignment ( JLabel.CENTER );
        Adminl1.setBackground ( new Color(0,0,0) );
        Adminl1.setOpaque ( true );
        Adminl1.setFocusable(false);


        Adminl2 =new JLabel ( "Admin Login" );
        Adminl2.setBounds(625, 400, 250, 40);
        Adminl2.setFont(new Font("My Bali", Font.BOLD, 25));
        Adminl2.setForeground(new Color(2));

        t_name=new JTextField (  );
        t_name.setBounds (  500,450,400,35);
        t_name.setText ( "Username" );
        t_name.addFocusListener ( new FocusListener( ) {
            public void focusGained( FocusEvent  event){
                if(t_name.getText ().equals ( "Username" )){
                    t_name.setText ( "" );
                    if(t_name.getBorder()==border1){
                        t_name.setBorder(null);
                    }
                }
            }
            public void focusLost(FocusEvent event){
                if(t_name.getText ().equals ( "" )){
                    t_name.setText ( "Username" );
                }
                if(t_name.getBorder()==border1){
                    t_name.setBorder(null);
                }
            }
        } );
        t_name.setFont ( new Font ( "My Bali",Font.BOLD,20 ) );

        t_pass=new JPasswordField (  );
        t_pass.setBounds (  500,500,400,35);
        t_pass.setText ( "password" );
        t_pass.addFocusListener ( new FocusListener( ) {
            public void focusGained( FocusEvent  event){
                if(t_pass.getText ().equals ( "password" )){
                    t_pass.setText ( "" );
                    if(t_pass.getBorder()==border1){
                        t_pass.setBorder(null);
                    }
                }
            }
            public void focusLost(FocusEvent event){
                if(t_pass.getText ().equals ( "" )){
                    t_pass.setText ( "password" );
                }
            }
        } );
        t_pass.setFont ( new Font ( "My Bali",Font.BOLD,20 ) );
        frame.setTitle ( "hostel" );
        frame.setSize ( 700,500 );
        //frame.setResizable ( false );
        frame.setVisible ( true );
        frame.setLayout ( null );
        frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        frame.getContentPane ().setBackground ( new Color (0,0,0) );
        frame.setSize ( 1400,700 );
        frame.getContentPane ().setBackground ( new Color (255,255,255) );
        frame.add (Adminl1  );
        frame.add (t_name  );
        frame.add (Adminl2  );
        frame.add(t_pass);
        frame.add(label);

        Adminl1.addActionListener ( new LoginHandler());
    }
   public class LoginHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==Adminl1){
                String dName = "";
                String dPassword = "";
                String type="";
                String name = t_name.getText();;
                String password = t_pass.getText();;
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    String SQL = "SELECT * FROM person WHERE username='" + name + "' and password='" + password+ "'";
                    ResultSet result = st.executeQuery(SQL);
                    while (result.next()) {
                        dName = result.getString("username");
                        dPassword = result.getString("password");
                        type=result.getString("Person_type");

                    }

                    if (name.equals(dName) && password.equals(dPassword)&&type.equals("Admin")) {
                        AdminMenuGui b=new AdminMenuGui ();
                        frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null,"Incorrect Username or Password\nEnter credentials again");
                        t_name.setText("");
                        t_pass.setText("");
                    }

                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                    AdminMenuGui adminMenuGui = new AdminMenuGui();
                    frame.dispose();
                }
            }
        }
    }
}
