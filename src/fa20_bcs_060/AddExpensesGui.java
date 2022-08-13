package fa20_bcs_060;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddExpensesGui {
    private JFrame frame;
    private JPanel panel;

    private JLabel addMess;
    private JLabel day;
    private JLabel amount;
    private JLabel purpose;
    private JLabel Dinner;

    private JTextField t_day;
    private JTextField t_amount;
    private JTextField t_purpose;
    private JTextField t_dinner;
    JComboBox days;
    int id;
    private JButton clear;
    private JButton add;
    private JButton back;
public AddExpensesGui (){
    panel = new JPanel (null);

    frame = new JFrame("Expenses");
    panel.setBackground( new Color ( 0,153,153 ));

    addMess = new JLabel("Expenses");
    day = new JLabel("Day:");
    amount = new JLabel("Amount");
    purpose = new JLabel("Purpose");
    Dinner = new JLabel("Dinner:");
    String []dayss={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    days=new JComboBox ( dayss );

    t_day = new JTextField();
    t_amount = new JTextField();
    t_purpose = new JTextField();
    t_dinner = new JTextField();

    addMess.setFont(new Font("Sanserif", Font.BOLD, 30));
    day.setFont(new Font("Sanserif", Font.BOLD, 20));
    amount.setFont(new Font("Sanserif", Font.BOLD, 20));
    purpose.setFont(new Font("Sanserif", Font.BOLD, 20));
    Dinner.setFont(new Font("Sanserif", Font.BOLD, 20));

    addMess.setForeground(Color.BLACK);//Text color
    day.setForeground(Color.BLACK);
    amount.setForeground(Color.BLACK);
    purpose.setForeground(Color.BLACK);
    Dinner.setForeground(Color.BLACK);

    addMess.setBounds(190, 40, 200, 60);
    day.setBounds(120, 110, 250, 30);
    amount.setBounds(120, 150, 250, 30);
    purpose.setBounds(120, 190, 250, 30);
    Dinner.setBounds(120, 230, 250, 30);

    days.setBounds(330, 110, 130, 30);
    t_amount.setBounds(330, 150, 130, 30);
    t_purpose.setBounds(330, 190, 130, 30);
    t_dinner.setBounds(330, 230, 130, 30);

    days.setBackground(Color.white);
    t_amount.setBackground(Color.white);
    t_purpose.setBackground(Color.white);

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

    panel.add(addMess);
    //panel.add(day);
    panel.add(amount);
    panel.add(purpose);
    //panel.add(Dinner);
    panel.add(clear);
    panel.add(back);
    //panel.add(days);
    panel.add(t_purpose);
    panel.add(t_amount);

    panel.add(add);

    frame.add(panel);
    frame.setTitle("Add Student");
    frame.setVisible(true);
    frame.setSize(600, 650);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    add.addActionListener ( new ExpensesGuihandler ());
    back.addActionListener ( new ExpensesGuihandler () );

}
 class ExpensesGuihandler implements ActionListener{
    public void actionPerformed( ActionEvent e) {

        if ( e.getSource ( ) == add ){
            if(t_amount.getText ().trim ().equals ( "" )|| t_purpose.getText ().trim ().equals ( "" )){
                frame.dispose ();
                AddExpensesGui vv=new AddExpensesGui ();
            }
            else{

                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","project");
                    Statement st = con.createStatement();
                     String sql1="Select Expenseid from Expenses";

                    ResultSet result = st.executeQuery(sql1);
                    while(result.next ()){
                        id=result.getInt ( 1 );

                    }
                    id++;
                    String sql2="Insert into Expenses(Expenseid,expenseamount,expensepurpose) values("+id+","+t_amount.getText ()+",'"+t_purpose.getText ()+"')";
                    result=st.executeQuery ( sql2 );
                    JOptionPane.showMessageDialog ( null,"Expense inserted against id no---> "+id );
               frame.dispose();
               AddExpensesGui j=new AddExpensesGui();
                }
                catch (Exception e1){
                    System.out.println(e1.toString());
                    AddExpensesGui addExpensesGui = new AddExpensesGui();
                    frame.dispose();
                }
            }

        }
        else if(e.getSource ()==back){
            frame.dispose();
            ExpenseGui c =new ExpenseGui ();
        }

    }

}

}
