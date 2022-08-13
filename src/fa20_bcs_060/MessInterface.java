package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessInterface {
    private JFrame frame;
    private JPanel panel;
    private JLabel adminMenu;

    private JButton addMess;
    private JButton delMess;
    private JButton logout;
    private JButton updateMess;
    private JButton viewMess;

    public MessInterface() {

        panel = new JPanel(null);

        frame = new JFrame("Admin Menu");
        panel.setBackground(Color.orange);

        adminMenu = new JLabel("Mess Management");
        addMess = new JButton("Add Mess");
        updateMess = new JButton("Update Mess");
        delMess = new JButton("");
        viewMess = new JButton("View Mess");
        logout = new JButton("Back");


        adminMenu.setFont(new Font("Sanserif", Font.BOLD, 30));
        addMess.setFont(new Font("Sanserif", Font.BOLD, 20));
        updateMess.setFont(new Font("Sanserif", Font.BOLD, 20));
        delMess.setFont(new Font("Sanserif", Font.BOLD, 20));
        viewMess.setFont(new Font("Sanserif", Font.BOLD, 20));
        logout.setFont(new Font("Sanserif", Font.BOLD, 20));


        adminMenu.setForeground(Color.BLACK);
        addMess.setForeground(Color.orange);
        updateMess.setForeground(Color.orange);
        delMess.setForeground(Color.orange);
        viewMess.setForeground(Color.orange);
        logout.setForeground(Color.orange);


        adminMenu.setBackground(Color.green);
        addMess.setBackground(Color.black);
        updateMess.setBackground(Color.black);
        delMess.setBackground(Color.black);
        viewMess.setBackground(Color.black);
        logout.setBackground(Color.black);

        adminMenu.setBounds(200, 50, 350, 50);
        addMess.setBounds(125, 150, 350, 50);
        updateMess.setBounds(125, 230, 350, 50);
        delMess.setBounds(125, 310, 350, 50);
        viewMess.setBounds(125, 390, 350, 50);
        logout.setBounds(175, 460, 250, 50);

        addMess.setFocusable(false);
        updateMess.setFocusable(false);
        delMess.setFocusable(false);
        viewMess.setFocusable(false);
        logout.setFocusable(false);


        panel.add(adminMenu);
        panel.add(updateMess);
        panel.add(delMess);
        panel.add(logout);
        panel.add(viewMess);
        panel.add(addMess);

        frame.add(panel);
        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        addMess.addActionListener(new AdminguiHandler());
        delMess.addActionListener(new AdminguiHandler());
        updateMess.addActionListener(new AdminguiHandler());
        logout.addActionListener(new AdminguiHandler());
        viewMess.addActionListener(new AdminguiHandler());
    }

    class AdminguiHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addMess) {
                frame.dispose ();
                AddMess meee=new AddMess ();

            }

            else if (e.getSource() == updateMess) {
                frame.dispose ();
                updateMess hhh=new updateMess ();

            }
            else if (e.getSource() == viewMess) {
                frame.dispose();
                ViewMess view=new ViewMess ();
                view.viewMessGui ();
            }

            else if  (e.getSource() == logout) {
                frame.dispose ();
                HostelInterface n=new HostelInterface ();

            }
        }
    }
}
