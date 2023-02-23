package hostelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Admin_Signup extends JFrame implements ActionListener
{

    private final JTextField First_Name, Last_Name, Email, Username, Password, Conform;
    private final JButton Sign_UP, back;
    Admin_Signup()
    {
        super("Admin Sign Up");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel header = new JLabel("Sign up");
        header.setBounds(300, 10, 350, 50);
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 40));
        header.setForeground(new Color(245, 246, 201, 255));
        add(header);
        
        First_Name = new JTextField("First Name");
        First_Name.setBounds(75, 70, 250, 30);
        First_Name.setHorizontalAlignment(JTextField.CENTER);
        First_Name.setOpaque(false);
        First_Name.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        First_Name.setForeground(new Color(204, 204, 255));
        First_Name.setBorder(null);
        First_Name.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                First_Name.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                First_Name.setText("");
            }
        });
        add(First_Name);
        
        JSeparator line = new JSeparator();
        line.setBounds(75, 100, 250, 10);
        line.setBackground(new Color(204, 204, 255, 255));
        add(line);
        
        Last_Name = new JTextField("Last Name");
        Last_Name.setBounds(425, 120, 250, 30);
        Last_Name.setOpaque(false);
        Last_Name.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Last_Name.setForeground(new Color(204, 204, 255));
        Last_Name.setBorder(null);
        Last_Name.setHorizontalAlignment(JTextField.CENTER);
        Last_Name.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Last_Name.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Last_Name.setText("");
            }
        });
        add(Last_Name);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(425, 150, 250, 10);
        line3.setBackground(new Color(204, 204, 255, 255));
        add(line3);
        
                
        Email = new JTextField("Email:");
        Email.setBounds(75, 170, 250, 30);
        Email.setOpaque(false);
        Email.setHorizontalAlignment(JTextField.CENTER);
        Email.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Email.setForeground(new Color(204, 204, 255));
        Email.setBorder(null);
        Email.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Email.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Email.setText("");
            }
        });
        add(Email);
        
        JSeparator line5 = new JSeparator();
        line5.setBounds(75, 200, 250, 30);
        line5.setBackground(new Color(204, 204, 255, 255));
        add(line5);
        
        Username = new JTextField("Username");
        Username.setBounds(425, 220, 250, 30);
        Username.setOpaque(false);
        Username.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Username.setForeground(new Color(204, 204, 255));
        Username.setBorder(null);
        Username.setHorizontalAlignment(JTextField.CENTER);
        Username.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Username.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Username.setText("");
            }
        });
        add(Username);
        
        JSeparator line4 = new JSeparator();
        line4.setBounds(425, 250, 250, 10);
        line4.setBackground(new Color(204, 204, 255, 255));
        add(line4);
        
        Password = new JTextField("Password");
        Password.setBounds(75, 270, 250, 30);
        Password.setOpaque(false);
        Password.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Password.setForeground(new Color(204, 204, 255));
        Password.setBorder(null);
        Password.setHorizontalAlignment(JTextField.CENTER);
        Password.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Password.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Password.setText("");
            }
        });
        add(Password);
        
        JSeparator line4a = new JSeparator();
        line4a.setBounds(75, 300, 250, 10);
        line4a.setBackground(new Color(204, 204, 255, 255));
        add(line4a);
        
        Conform = new JTextField ("Conform Password");
        Conform.setBounds(425, 320, 250, 30);
        Conform.setOpaque(false);
        Conform.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Conform.setForeground(new Color(204, 204, 255));
        Conform.setBorder(null);
        Conform.setHorizontalAlignment(JTextField.CENTER);
        Conform.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Conform.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Conform.setText("");
            }
        });
        add(Conform);
        
        JSeparator line7 = new JSeparator();
        line7.setBounds(425, 350, 250, 10);
        line7.setBackground(new Color(204, 204, 255, 255));
        add(line7);
        
        Sign_UP = new JButton("Sign_UP");
        Sign_UP.setBounds(75, 400, 250, 35);
        Sign_UP.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        Sign_UP.setBackground(new Color(0, 15, 26, 255));
        Sign_UP.setOpaque(false);
        Sign_UP.setContentAreaFilled(false);
        Sign_UP.setForeground(Color.white);
        Sign_UP.setHorizontalAlignment(JButton.CENTER);
        Sign_UP.setBorder(new RoundedBorder(25));
        Sign_UP.addActionListener(this);
        add(Sign_UP);
             
        back = new JButton("Cancel");
        back.setBounds(425, 425, 250, 35);
        back.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        back.setBackground(new Color(0, 0, 51, 255));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setForeground(Color.white);
        back.setHorizontalAlignment(JButton.CENTER);
        back.setBorder(new RoundedBorder(25));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/2188.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds (0, 0, 800, 550);
        add(image);

        setBounds(300, 100, 800, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Sign_UP)
        {
            if(First_Name.getText().matches("^[a-z A-Z]*$") && !First_Name.getText().isEmpty() &&
               Last_Name.getText().matches("^[a-z A-Z]*$") && !Last_Name.getText().isEmpty() &&
               Email.getText().contains("@gmail.com") && !Email.getText().isEmpty() &&
               Password.getText().equals(Conform.getText()))
            {
                String Firstname = First_Name.getText();
                String Lastname = Last_Name.getText();
                String EMail = Email.getText();
                String Name = Firstname + Lastname;
                String Username = this.Username.getText();
                String Password = this.Password.getText();
                try
                {
                    DataBase Conn = new DataBase();
                    Conn.statement.executeUpdate("insert into Admin_Login values('"+ Firstname +"', '"+ Lastname +"', '"+ EMail +"')");
                    Conn.statement.executeUpdate("insert into Sign_UP_Accounts values('Admin', '"+ Name +"', '"+ Username +"', '"+ Password +"')");
                    JOptionPane.showMessageDialog(null, "Data Add Sucessfully");
                    dispose();
                    new Login_Panel();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                if(!First_Name.getText().matches("^[a-z A-Z]*$") || First_Name.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid First Name");
                }
                else if(!Last_Name.getText().matches("^[a-z A-Z]*$") || Last_Name.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid Last Name");
                }
                else if(!Email.getText().contains("@gmail.com") || Email.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                }
                else if(!Password.getText().equals(Conform.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Password not match");
                }
            }
        }
        else
        {
            dispose();
        }
    }
    public static void main(String[] args) 
    {
        new Admin_Signup();
    }
}
