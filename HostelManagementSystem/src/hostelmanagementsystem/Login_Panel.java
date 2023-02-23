package hostelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login_Panel extends JFrame implements ActionListener
{
    JTextField Username;
    JPasswordField Password;
    JComboBox Account_Type;
    JButton Login, back;
    Login_Panel()
    {
        super("Seller Login");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        
        JLabel header = new JLabel("HOSTEL");
        header.setBounds(775, 100, 250, 50);
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 50));
        header.setForeground(new Color(0, 15, 26, 255));
        add(header);
        
        JLabel header1 = new JLabel("MANAGEMENT");
        header1.setBounds(620, 160, 450, 50);
        header1.setFont(new Font("SansSerif Regular", Font.BOLD, 50));
        header1.setForeground(new Color(0, 15, 26, 255));
        add(header1);
        
        JLabel header2 = new JLabel("SYSTEM");
        header2.setBounds(775, 220, 250, 50);
        header2.setFont(new Font("SansSerif Regular", Font.BOLD, 50));
        header2.setForeground(new Color(0, 15, 26, 255));
        add(header2);
        
        JLabel l = new JLabel("Log In to Your Account");
        l.setBounds(90, 125, 300, 30);
        l.setForeground(Color.white);
        l.setBorder(null);
        l.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        add(l);
        
        Username = new JTextField("Username");
        Username.setBounds(90, 270, 300, 30);
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
        
        JSeparator line = new JSeparator();
        line.setBounds(90, 300, 300, 10);
        line.setBackground(new Color(9, 36, 124, 255));
        add(line);
        
        Password = new JPasswordField("Password");
        Password.setBounds(90, 320, 300, 30);
        Password.setOpaque(false);
        Password.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Password.setForeground(new Color(204, 204, 255));
        Password.setBorder(null);
        Password.setHorizontalAlignment(JTextField.CENTER);
        Password.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Password.setText("");
            }
        });
        add(Password);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(90, 350, 300, 10);
        line2.setBackground(new Color(9, 36, 124, 255));
        add(line2);
                
        Login = new JButton("Login");
        Login.setBounds(250, 400, 150, 35);
        Login.setFont(new Font("Tahoma", Font.BOLD, 20));
        Login.setBackground(new Color(0, 15, 26, 255));
        Login.setOpaque(false);
        Login.setContentAreaFilled(false);
        Login.setForeground(Color.white);
        Login.setBorder(new RoundedBorder(25));
        Login.addActionListener(this);
        add(Login);
        
        back = new JButton("Back");
        back.setBounds(90, 400, 150, 35);
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setBackground(new Color(0, 15, 26, 255));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setForeground(Color.white);
        back.setBorder(new RoundedBorder(25));
        back.addActionListener(this);
        add(back);
        
        JLabel seller = new JLabel("Seller::                       Click here if You don't have any Account");
        seller.setBounds(100, 450, 450, 30);
        seller.setFont(new Font("SansSerif Regular", Font.ITALIC, 15));
        seller.setForeground(new Color(221, 217, 232, 255));
        seller.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                dispose();
                new Seller_Signup();
            }
            public void mouseExited(MouseEvent me)
            {
                seller.setText("Seller::                       Click here if You don't have any Account");
                seller.setFont(new Font("SansSerif Regular", Font.ITALIC, 15));
            }
            public void mouseEntered(MouseEvent me)
            {
                seller.setText("<html><a herf = ''>" + "Sign up here" +"</a></html>");
            }
        });
        add(seller);
        
        JLabel Customer = new JLabel("Customer::                Click here if You don't have any Account");
        Customer.setBounds(100, 475, 450, 30);
        Customer.setFont(new Font("SansSerif Regular", Font.ITALIC, 15));
        Customer.setForeground(new Color(221, 217, 232, 255));
        Customer.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                dispose();
                new Customer_Signup();
            }
            public void mouseExited(MouseEvent me)
            {
                Customer.setText("Customer::                Click here if You don't have any Account");
                Customer.setFont(new Font("SansSerif Regular", Font.ITALIC, 15));
            }
            public void mouseEntered(MouseEvent me)
            {
                Customer.setText("<html><a herf = ''>" + "Sign up here" +"</a></html>");
            }
        });
        add(Customer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/mainbg.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(50, 02, 960, 540);
        add(image);
        
        setBounds(100, 75, 1075, 585);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Login)
        {
            String Username = this.Username.getText();
            String Password = this.Password.getText(); 
            try
            {
                DataBase Connection = new DataBase();
                String query = "select * from Sign_UP_Accounts where Username = '" + Username + "'and Password = '" + Password +"'";
                ResultSet rs = Connection.statement.executeQuery(query);
                if(rs.next())
                {
                    if(rs.getString("Account_Typre").equals("Seller"))
                    {
                        String Name = rs.getString("Name");
                        dispose();
                        new Seller_Panel(Name);
                    }
                    else if(rs.getString("Account_Typre").equals("Customer"))
                    {
                        String Name = rs.getString("Name");
                        dispose();
                        new Customer_Panel(Name);
                    }
                    else if(rs.getString("Account_Typre").equals("Admin"))
                    {
                        String Name = rs.getString("Name");
                        dispose();
                        new Admin_Panel(Name);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid User Name Or Password");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }         
        }
        else
        {
            dispose();
        }
    }
    public static void main(String[] args) 
    {
        new Login_Panel();
    }
}

