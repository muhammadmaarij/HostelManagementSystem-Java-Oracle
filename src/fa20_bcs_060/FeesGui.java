package fa20_bcs_060;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeesGui {
    private JFrame frame;
    private JPanel panel;
    private JLabel addexpensesMenu;

    private JButton addexpenses;
    private JButton employee;
    private JButton logout;
    private JButton student;
    private JButton hostel;

    public FeesGui() {

        panel = new JPanel(null);

        frame = new JFrame("addexpenses Menu");
        panel.setBackground(new Color ( 0,153,153 ));

        addexpensesMenu = new JLabel("Fee Management ");
        addexpenses = new JButton("Add Fees");
        student = new JButton("View Fees");
        employee = new JButton("Update Fees");
        hostel = new JButton("<---");
        logout = new JButton("Logout");


        addexpensesMenu.setFont(new Font("Sanserif", Font.BOLD, 30));
        addexpenses.setFont(new Font("Sanserif", Font.BOLD, 20));
        student.setFont(new Font("Sanserif", Font.BOLD, 20));
        employee.setFont(new Font("Sanserif", Font.BOLD, 20));
        hostel.setFont(new Font("Sanserif", Font.BOLD, 20));
        logout.setFont(new Font("Sanserif", Font.BOLD, 20));


        addexpensesMenu.setForeground(Color.BLACK);
        addexpenses.setForeground(Color.orange);
        student.setForeground(Color.orange);
        employee.setForeground(Color.orange);
        hostel.setForeground(Color.orange);
        logout.setForeground(Color.orange);


        addexpensesMenu.setBackground(Color.green);
        addexpenses.setBackground(Color.black);
        student.setBackground(Color.black);
        employee.setBackground(Color.black);
        hostel.setBackground(Color.black);
        logout.setBackground(Color.black);

        addexpensesMenu.setBounds(200, 50, 350, 50);
        addexpenses.setBounds(125, 150, 350, 50);
        student.setBounds(125, 230, 350, 50);
        employee.setBounds(125, 310, 350, 50);
        hostel.setBounds(125, 390, 350, 50);
        logout.setBounds(175, 460, 250, 50);

        addexpenses.setFocusable(false);
        student.setFocusable(false);
        employee.setFocusable(false);
        hostel.setFocusable(false);
        logout.setFocusable(false);


        panel.add(addexpensesMenu);
        panel.add(student);
        panel.add(employee);
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
        employee.addActionListener(new addexpensesguiHandler());
        student.addActionListener(new addexpensesguiHandler());
        logout.addActionListener(new addexpensesguiHandler());
        hostel.addActionListener(new addexpensesguiHandler());
    }

    class addexpensesguiHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addexpenses) {
               frame.dispose ();
               AddFeesGui l=new AddFeesGui ();
            }

            else if (e.getSource() == student) {
                frame.dispose ();
               feesdate n=new feesdate ();
            }

            else if (e.getSource() == employee) {
                frame.dispose ();
                UpdateFees dg=new UpdateFees ();
            }

            else if (e.getSource() == hostel) {
                frame.dispose ();
               HostelInterface f=new HostelInterface ();

            }

            else if  (e.getSource() == logout) {
                WelcomeGui w = new WelcomeGui();
                frame.dispose ();

            }
        }
    }
}
