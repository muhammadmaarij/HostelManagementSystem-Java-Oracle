package fa20_bcs_060;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomGui {
    private JFrame frame;
    private JPanel panel;
    private JLabel addexpensesMenu;

    private JButton addexpenses;
    private JButton logout;
    private JButton student;
    private JButton hostel;

    public RoomGui() {

        panel = new JPanel(null);

        frame = new JFrame("addexpenses Menu");
        panel.setBackground(new Color ( 0,153,153 ));

        addexpensesMenu = new JLabel("Room Management ");
        addexpenses = new JButton("Add Room");
        student = new JButton("View Room");
        hostel = new JButton("<---");
        logout = new JButton("Logout");


        addexpensesMenu.setFont(new Font("Sanserif", Font.BOLD, 30));
        addexpenses.setFont(new Font("Sanserif", Font.BOLD, 20));
        student.setFont(new Font("Sanserif", Font.BOLD, 20));
        hostel.setFont(new Font("Sanserif", Font.BOLD, 20));
        logout.setFont(new Font("Sanserif", Font.BOLD, 20));


        addexpensesMenu.setForeground(Color.BLACK);
        addexpenses.setForeground(Color.orange);
        student.setForeground(Color.orange);
        hostel.setForeground(Color.orange);
        logout.setForeground(Color.orange);


        addexpensesMenu.setBackground(Color.green);
        addexpenses.setBackground(Color.black);
        student.setBackground(Color.black);
        hostel.setBackground(Color.black);
        logout.setBackground(Color.black);

        addexpensesMenu.setBounds(200, 50, 350, 50);
        addexpenses.setBounds(125, 150, 350, 50);
        student.setBounds(125, 230, 350, 50);
        hostel.setBounds(125, 390, 350, 50);
        logout.setBounds(175, 460, 250, 50);

        addexpenses.setFocusable(false);
        student.setFocusable(false);

        hostel.setFocusable(false);
        logout.setFocusable(false);


        panel.add(addexpensesMenu);
        panel.add(student);

        panel.add(logout);
        panel.add(hostel);
        panel.add(addexpenses);

        frame.add(panel);
        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        addexpenses.addActionListener(new addexpensesguiHandler());

        student.addActionListener(new addexpensesguiHandler());
        logout.addActionListener(new addexpensesguiHandler());
        hostel.addActionListener(new addexpensesguiHandler());
    }

    class addexpensesguiHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addexpenses) {
                frame.dispose ();
                AddRoom l=new AddRoom ();
            }

            else if (e.getSource() == student) {
                frame.dispose ();
                ViewRoom n=new ViewRoom ();
                n.viewRoomGui();
            }

            else if (e.getSource() == hostel) {
                frame.dispose ();
                HostelInterface f=new HostelInterface ();

            }

            else if  (e.getSource() == logout) {
                frame.dispose ();
                WelcomeGui w = new WelcomeGui();

            }
        }
    }
}
