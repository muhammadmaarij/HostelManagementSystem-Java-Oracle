package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementGui {
    private JFrame frame;
    private JPanel panel;
    private JLabel studentMenu;

    private JButton addStudent;
//    private JButton removeStudent;
    private JButton viewStudent;
    private JButton searchStudent;
    private JButton notifications;
    private JButton backBtn;



    public EmployeeManagementGui() {

        panel = new JPanel(null);

        frame = new JFrame("Employee Menu");
        panel.setBackground(Color.orange);

        studentMenu = new JLabel("Employee Management");
        addStudent = new JButton("Add Employee");
        searchStudent = new JButton("Search Employee");
//        removeStudent = new JButton("Remove Employee");
        viewStudent = new JButton("View Employee");
        notifications = new JButton("Notice Board");
        backBtn = new JButton("<----");


        studentMenu.setFont(new Font("Sanserif", Font.BOLD, 30));
        addStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
        searchStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
//        removeStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
        viewStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
        notifications.setFont(new Font("Sanserif", Font.BOLD, 20));
        backBtn.setFont(new Font("Sanserif", Font.BOLD, 20));


        studentMenu.setForeground(Color.BLACK);
        addStudent.setForeground(Color.orange);
        searchStudent.setForeground(Color.orange);
//        removeStudent.setForeground(Color.orange);
        viewStudent.setForeground(Color.orange);
        notifications.setForeground(Color.orange);
        backBtn.setForeground(Color.orange);


        studentMenu.setBackground(Color.green);
        addStudent.setBackground(Color.black);
        searchStudent.setBackground(Color.black);
//        removeStudent.setBackground(Color.black);
        viewStudent.setBackground(Color.black);
        notifications.setBackground(Color.black);
        backBtn.setBackground(Color.black);

        studentMenu.setBounds(150, 50, 350, 50);
        addStudent.setBounds(125, 130, 350, 50);
        searchStudent.setBounds(125, 200, 350, 50);
//        removeStudent.setBounds(125, 270, 350, 50);
        viewStudent.setBounds(125, 340, 350, 50);
        notifications.setBounds(125, 410, 350, 50);
        backBtn.setBounds(125, 480, 250, 30);

        addStudent.setFocusable(false);
        searchStudent.setFocusable(false);
//        removeStudent.setFocusable(false);
        viewStudent.setFocusable(false);
        notifications.setFocusable(false);
        backBtn.setFocusable(false);


        panel.add(studentMenu);
        panel.add(searchStudent);
//        panel.add(removeStudent);
        panel.add(viewStudent);
        panel.add(addStudent);

        panel.add(backBtn);

        frame.add(panel);
        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        addStudent.addActionListener( new StudentManagementGuiHandler () );
        viewStudent.addActionListener( new StudentManagementGuiHandler () );
        searchStudent.addActionListener( new StudentManagementGuiHandler () );
        backBtn.addActionListener( new StudentManagementGuiHandler () );
        viewStudent.addActionListener( new StudentManagementGuiHandler () );
//        removeStudent.addActionListener( new StudentManagementGuiHandler () );
    }
    class StudentManagementGuiHandler implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == addStudent) {
                EmployeeRegistration u =new EmployeeRegistration();
                frame.dispose();
            }

            else if (e.getSource() == viewStudent) {
                ViewEmployee viewStudent = new ViewEmployee();
                viewStudent.viewEmployeeGui();
                frame.dispose();
            }

            else if (e.getSource() == searchStudent) {
                SearchEmployee h=new SearchEmployee ();
                frame.dispose();

            }

            else if (e.getSource() == notifications) {

            }

            else if  (e.getSource() == backBtn) {
                frame.dispose();
                AdminMenuGui y =new AdminMenuGui ();

            }
//            else if  (e.getSource() == removeStudent) {
//                AdminMenuGui y =new AdminMenuGui ();
//                frame.dispose();
//
//
//            }
        }
    }
}

