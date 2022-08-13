package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddRoom {
    private JFrame frame;
    private JPanel panel;

    private JLabel addRoom;
    private JLabel roomNo;

    private JTextField t_roomNo;


    private JButton clear;
    private JButton add;
    private JButton back;

    public AddRoom() {

        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addRoom = new JLabel("Add Room");
        roomNo = new JLabel("Room No:");

        t_roomNo = new JTextField();

        addRoom.setFont(new Font("Sanserif", Font.BOLD, 30));
        roomNo.setFont(new Font("Sanserif", Font.BOLD, 20));

        addRoom.setForeground(Color.BLACK);//Text color
        roomNo.setForeground(Color.BLACK);

        addRoom.setBounds(190, 40, 200, 60);
        roomNo.setBounds(120, 110, 250, 30);

        t_roomNo.setBounds(330, 110, 130, 30);

        t_roomNo.setBackground(Color.white);

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

        panel.add(addRoom);
        panel.add(roomNo);
        panel.add(clear);
        panel.add(back);
        panel.add(t_roomNo);
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
                if(t_roomNo.getText().trim().isEmpty()){

                    AddMess p=new AddMess();
                    frame.dispose ();
                }
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                    String sqlStudent="Insert into Rooms(roomNo, AVALIABILITY) values('"+ t_roomNo.getText()+"','yes')";


                    ResultSet resultStudent = st.executeQuery(sqlStudent);
                    JOptionPane.showMessageDialog ( null,"Added Successfully!" );
                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog ( null,"THIS room is already used" );
                    System.out.println(e1.toString());
                    frame.dispose ();
                    AddRoom d=new AddRoom ();
                }

            }
            else if(e.getSource ()==clear){
                frame.dispose ();
                AddRoom d=new AddRoom();
            }
            else if(e.getSource ()==back){
                frame.dispose ();
                RoomGui b=new RoomGui ();
            }
        }
    }
}

