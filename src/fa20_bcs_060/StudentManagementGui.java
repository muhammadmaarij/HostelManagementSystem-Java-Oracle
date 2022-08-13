package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementGui {
    private JFrame frame;
    private JPanel panel;
    private JLabel studentMenu;

    private JButton addStudent;
    private JButton removeStudent;
    private JButton viewStudent;
    private JButton searchStudent;
    private JButton addExisting;
    private JButton backbtn;



    public StudentManagementGui() {

        panel = new JPanel(null);

        frame = new JFrame("Student Menu");
        panel.setBackground(Color.orange);

        studentMenu = new JLabel("Student Management");
        addStudent = new JButton("Add Student");
        searchStudent = new JButton("Search Student");
        removeStudent = new JButton("Remove Student");
        viewStudent = new JButton("View Student");

        addExisting = new JButton("Add Existing");
        backbtn = new JButton("<----");


        studentMenu.setFont(new Font("Sanserif", Font.BOLD, 30));
        addStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
        searchStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
        removeStudent.setFont(new Font("Sanserif", Font.BOLD, 20));
        viewStudent.setFont(new Font("Sanserif", Font.BOLD, 20));

        addExisting.setFont(new Font("Sanserif", Font.BOLD, 20));
        backbtn.setFont(new Font("Sanserif", Font.BOLD, 20));


        studentMenu.setForeground(Color.BLACK);
        addStudent.setForeground(Color.orange);
        searchStudent.setForeground(Color.orange);
        removeStudent.setForeground(Color.orange);
        viewStudent.setForeground(Color.orange);

        addExisting.setForeground(Color.orange);
        backbtn.setForeground(Color.orange);



        studentMenu.setBackground(Color.green);
        addStudent.setBackground(Color.black);
        searchStudent.setBackground(Color.black);
        removeStudent.setBackground(Color.black);
        viewStudent.setBackground(Color.black);

        addExisting.setBackground(Color.black);
        backbtn.setBackground(Color.black);

        studentMenu.setBounds(150, 50, 350, 50);
        addStudent.setBounds(125, 130, 350, 50);
        searchStudent.setBounds(125, 200, 350, 50);
        removeStudent.setBounds(125, 270, 350, 50);
        viewStudent.setBounds(125, 340, 350, 50);

        addExisting.setBounds(125, 480, 250, 50);
        backbtn.setBounds(125, 550, 250, 30);

        addStudent.setFocusable(false);
        searchStudent.setFocusable(false);
        removeStudent.setFocusable(false);
        viewStudent.setFocusable(false);

        addExisting.setFocusable(false);
        backbtn.setFocusable(false);


        panel.add(studentMenu);
        panel.add(searchStudent);
        panel.add(removeStudent);
        panel.add(viewStudent);
        panel.add(addStudent);
        panel.add(backbtn);

        panel.add(addExisting);

        frame.add(panel);
        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        addStudent.addActionListener( new StudentManagementGuiHandler () );
        viewStudent.addActionListener( new StudentManagementGuiHandler () );
        searchStudent.addActionListener( new StudentManagementGuiHandler () );
        addExisting.addActionListener( new StudentManagementGuiHandler () );
        viewStudent.addActionListener( new StudentManagementGuiHandler () );
        removeStudent.addActionListener( new StudentManagementGuiHandler () );
        backbtn.addActionListener( new StudentManagementGuiHandler () );
    }
    class StudentManagementGuiHandler implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent e) {
            if (e.getSource() == addStudent) {
            StudentRegistrationGui u =new StudentRegistrationGui();
            frame.dispose();
            }

            else if (e.getSource() == viewStudent) {
                ViewStudent viewStudent = new ViewStudent();
                viewStudent.viewStudentGui();
                frame.dispose();
            }

            else if (e.getSource() == searchStudent) {
                SearchStudent h=new SearchStudent ();
                frame.dispose();
            }



            else if  (e.getSource() == backbtn) {
                AdminMenuGui y =new AdminMenuGui ();
                frame.dispose();

            }
            else if  (e.getSource() == removeStudent) {
                DeleteStudent y =new DeleteStudent ();
                frame.dispose();

            }
            else if  (e.getSource() == addExisting) {
                SearchExistingStudent student = new SearchExistingStudent();
                frame.dispose();
            }
        }
    }
}

