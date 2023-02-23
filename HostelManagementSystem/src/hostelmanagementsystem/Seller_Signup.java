package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Seller_Signup extends JFrame implements ActionListener
{

    private final JTextField name, Identity, address, Phone,username, Password, Conform;
    private final JButton Register, back;
    Seller_Signup()
    {
        super("Seller Sign Up");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel header = new JLabel("Resigter Yourself");
        header.setBounds(250, 20, 350, 50);
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 40));
        header.setForeground(new Color(245, 246, 201, 255));
        add(header);
        
        name = new JTextField("Name");
        name.setBounds(305, 90, 200, 30);
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setOpaque(false);
        name.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        name.setForeground(new Color(204, 204, 255));
        name.setBorder(null);
        name.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                name.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                name.setText("");
            }
        });
        add(name);
        
        JSeparator line = new JSeparator();
        line.setBounds(305, 120, 200, 10);
        line.setBackground(new Color(204, 204, 255, 255));
        add(line);
        
        Identity = new JTextField("CNIC Number");
        Identity.setBounds(305, 140, 200, 30);
        Identity.setOpaque(false);
        Identity.setHorizontalAlignment(JTextField.CENTER);
        Identity.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Identity.setForeground(new Color(204, 204, 255));
        Identity.setBorder(null);
        Identity.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Identity.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Identity.setText("");
            }
        });
        add(Identity);
        
        JSeparator line1 = new JSeparator();
        line1.setBounds(305, 170, 200, 10);
        line1.setBackground(new Color(204, 204, 255, 255));
        add(line1);
        
        address = new JTextField("Address");
        address.setBounds(305, 190, 200, 30);
        address.setOpaque(false);
        address.setHorizontalAlignment(JTextField.CENTER);
        address.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        address.setForeground(new Color(204, 204, 255));
        address.setBorder(null);
        address.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                address.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                address.setText("");
            }
        });
        add(address);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(305, 220, 200, 10);
        line2.setBackground(new Color(204, 204, 255, 255));
        add(line2);
        
        Phone = new JTextField("03xxxxxxxxx");
        Phone.setBounds(305, 240, 200, 30);
        Phone.setOpaque(false);
        Phone.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Phone.setForeground(new Color(204, 204, 255));
        Phone.setBorder(null);
        Phone.setHorizontalAlignment(JTextField.CENTER);
        Phone.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                Phone.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                Phone.setText("");
            }
        });
        add(Phone);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(305, 270, 200, 10);
        line3.setBackground(new Color(204, 204, 255, 255));
        add(line3);
        
        username = new JTextField("username");
        username.setBounds(305, 290, 200, 30);
        username.setOpaque(false);
        username.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        username.setForeground(new Color(204, 204, 255));
        username.setBorder(null);
        username.setHorizontalAlignment(JTextField.CENTER);
        username.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                username.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                username.setText("");
            }
        });
        add(username);
        
        JSeparator line4 = new JSeparator();
        line4.setBounds(305, 320, 200, 10);
        line4.setBackground(new Color(204, 204, 255, 255));
        add(line4);
        
        Password = new JTextField("Password");
        Password.setBounds(305, 340, 200, 30);
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
        line4a.setBounds(305, 370, 200, 10);
        line4a.setBackground(new Color(204, 204, 255, 255));
        add(line4a);
        
        Conform = new JTextField ("Conform Password");
        Conform.setBounds(305, 390, 200, 30);
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
        
        JSeparator line5 = new JSeparator();
        line5.setBounds(305, 420, 200, 10);
        line5.setBackground(new Color(204, 204, 255, 255));
        add(line5);
        
        Register = new JButton("Register");
        Register.setBounds(425, 475, 159, 35);
        Register.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        Register.setBackground(new Color(0, 15, 26, 255));
        Register.setOpaque(false);
        Register.setContentAreaFilled(false);
        Register.setForeground(Color.white);
        Register.setHorizontalAlignment(JButton.CENTER);
        Register.setBorder(new RoundedBorder(25));
        Register.addActionListener(this);
        add(Register);
        
        
        back = new JButton("Back");
        back.setBounds(225, 475, 150, 35);
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
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds (0, 0, 800, 600);
        add(image);

        setBounds(200, 75, 800, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Register)
        {
            String Name = name.getText();
            String CNIC = Identity.getText();
            String Address = address.getText();
            String Contact = Phone.getText();
            String Username = username.getText();
            String Password = null;
            if(this.Password.getText().equals(this.Conform.getText()))
            {
                Password = this.Password.getText();
            }
            if(Name.matches("^[a-z A-Z]*$") && !Name.isEmpty() && CNIC.matches("^[0123456789]*$") && !CNIC.isEmpty() && Contact.matches("^[0123456789]*$") && !Contact.isEmpty())
            {
                try 
                {
                    DataBase conn = new DataBase();
                    String query = "insert into Seller values('" +Name+ "','" +CNIC+ "','" +Address+ "','" +Contact+ "')";
                    String query2 = "insert into Sign_UP_Accounts values('Seller', '" +Name+ "', '"+ Username +"', '"+ Password +"')";
                    conn.statement.executeUpdate(query);
                    conn.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Seller Added Sucessfully");
                    dispose();
                    new Login_Panel();
                } 
                catch (Exception e) 
                {
                }
            }
            else
            {
                if(!Name.matches("^[a-z A-Z]*$") ||Name.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }
                else if(!CNIC.matches("^[0123456789]*$") || CNIC.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid CNIC");
                }
                else if(!Contact.matches("^[0123456789]*$") || Contact.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid Contact Number");
                }
            }
        }
        else
        {
            dispose();
            new Login_Panel();
        }
        
    }
    public static void main(String args[])
    {
        new Seller_Signup();
    }
}
