package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchVisitor {
    private JFrame frame;
    private JPanel panel;

    private JLabel addEmp;
    private JLabel empCnic;

    private JButton clear;
    private JButton search;
    private JButton back;

    private JComboBox jComboBox;
    ArrayList<String> cnic1 = new ArrayList<>();

    public SearchVisitor(){
        panel = new JPanel(null);

        frame = new JFrame("Add Student");
        panel.setBackground(Color.orange);

        addEmp = new JLabel("Search Visitor");
        empCnic = new JLabel("Cnic:");


        addEmp.setFont(new Font("Sanserif", Font.BOLD, 30));
        empCnic.setFont(new Font("Sanserif", Font.BOLD, 20));


        addEmp.setForeground(Color.BLACK);//Text color
        empCnic.setForeground(Color.BLACK);

        addEmp.setBounds(190, 40, 200, 60);
        empCnic.setBounds(120, 110, 250, 30);


        search = new JButton("Search");

        back = new JButton("Back");

        clear = new JButton("Clear");

        search.setFont(new Font("Sanserif", Font.BOLD, 20));
        back.setFont(new Font("Sanserif", Font.BOLD, 20));
        clear.setFont(new Font("Sanserif", Font.BOLD, 20));

        search.setForeground(Color.orange);
        back.setForeground(Color.orange);
        clear.setForeground(Color.orange);
        search.setBackground(Color.black);
        clear.setBackground(Color.black);
        back.setBackground(Color.black);

        search.setBounds(50, 500, 150, 50);
        back.setBounds(215, 500, 150, 50);
        clear.setBounds(380, 500, 150, 50);
        try {
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "project");
            Statement st = con1.createStatement();
            ResultSet result = st.executeQuery("select visitorcnic from visitors");
            while (result.next()) {
                cnic1.add(result.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        String unArray[] = cnic1.toArray(new String[cnic1.size()]);
        jComboBox = new JComboBox(unArray);
        jComboBox.setBounds(330, 110, 130, 30);
        panel.add(jComboBox);


        panel.add(addEmp);
        panel.add(empCnic);
        panel.add(clear);
        panel.add(back);
        panel.add(search);

        frame.add(panel);
        frame.setTitle("Add Student");
        frame.setVisible(true);
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



        search.addActionListener(new SearchStudentHandler());
        clear.addActionListener(new SearchStudentHandler());
        back.addActionListener(new SearchStudentHandler());
    }
    class SearchStudentHandler implements ActionListener {
        public void actionPerformed(ActionEvent i) {

            if (i.getSource() == search) {
                UpdateVisitor updateEmployee11 = new UpdateVisitor(Integer.parseInt(String.valueOf(jComboBox.getSelectedItem())));
                frame.dispose();
            }
            if (i.getSource() == clear) {
                SearchVisitor s = new SearchVisitor();
                frame.dispose();

            }
            if (i.getSource() == back) {
                AdminMenuGui adminMenuGui = new AdminMenuGui();
                frame.dispose();
            }
        }
    }
}
