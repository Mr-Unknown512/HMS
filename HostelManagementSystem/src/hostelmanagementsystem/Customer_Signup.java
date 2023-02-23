package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Customer_Signup extends JFrame implements ActionListener
{
    JTextField CustomerName, CustomerCNIC, CustomerAddress, CustomerContact, username,Password, Conform;
    JButton Book, back;
    JComboBox Profession; 
    Choice HostalName, RoomNo;
    JLabel location ;

    Customer_Signup()
    {
        super("Customer Sign Up");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel header = new JLabel("Book Your Room");
        header.setBounds(250, 20, 350, 50);
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 40));
        header.setForeground(new Color(245, 246, 201, 255));
        add(header);
        
        CustomerName = new JTextField("Customer Name");
        CustomerName.setBounds(75, 70, 250, 30);
        CustomerName.setHorizontalAlignment(JTextField.CENTER);
        CustomerName.setOpaque(false);
        CustomerName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CustomerName.setForeground(new Color(204, 204, 255));
        CustomerName.setBorder(null);
        CustomerName.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                CustomerName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                CustomerName.setText("");
            }
        });
        add(CustomerName);
        
        JSeparator line = new JSeparator();
        line.setBounds(75, 100, 250, 10);
        line.setBackground(new Color(204, 204, 255, 255));
        add(line);
        
        CustomerCNIC = new JTextField("Customer CNIC Number");
        CustomerCNIC.setBounds(425, 70, 250, 30);
        CustomerCNIC.setOpaque(false);
        CustomerCNIC.setHorizontalAlignment(JTextField.CENTER);
        CustomerCNIC.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CustomerCNIC.setForeground(new Color(204, 204, 255));
        CustomerCNIC.setBorder(null);
        CustomerCNIC.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                CustomerCNIC.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                CustomerCNIC.setText("");
            }
        });
        add(CustomerCNIC);
        
        JSeparator line1 = new JSeparator();
        line1.setBounds(425, 100, 250, 10);
        line1.setBackground(new Color(204, 204, 255, 255));
        add(line1);
        
        CustomerAddress = new JTextField("Customer Address:");
        CustomerAddress.setBounds(75, 120, 250, 30);
        CustomerAddress.setOpaque(false);
        CustomerAddress.setHorizontalAlignment(JTextField.CENTER);
        CustomerAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CustomerAddress.setForeground(new Color(204, 204, 255));
        CustomerAddress.setBorder(null);
        CustomerAddress.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                CustomerAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                CustomerAddress.setText("");
            }
        });
        add(CustomerAddress);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(75, 150, 250, 30);
        line2.setBackground(new Color(204, 204, 255, 255));
        add(line2);
        
        CustomerContact = new JTextField("03xxxxxxxxx");
        CustomerContact.setBounds(425, 120, 250, 30);
        CustomerContact.setOpaque(false);
        CustomerContact.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CustomerContact.setForeground(new Color(204, 204, 255));
        CustomerContact.setBorder(null);
        CustomerContact.setHorizontalAlignment(JTextField.CENTER);
        CustomerContact.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                CustomerContact.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                CustomerContact.setText("");
            }
        });
        add(CustomerContact);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(425, 150, 250, 10);
        line3.setBackground(new Color(204, 204, 255, 255));
        add(line3);
        
        String str [] = {"Student", "Employee", "Traveler"};
        Profession = new JComboBox(str);
        Profession.setBounds(75, 170, 250, 30);
        Profession.setOpaque(false);
        Profession.setEditable(true);
        new Transparent(Profession.getComponents());
        Profession.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        add(Profession);
        
        JSeparator line3a = new JSeparator();
        line3a.setBounds(75, 200, 250, 10);
        line3a.setBackground(new Color(204, 204, 255, 255));
        add(line3a);
        
        HostalName = new Choice();
        HostalName.setBounds(425, 170, 250, 30);
        HostalName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        try 
        {
            DataBase Conn = new DataBase();
            String Query = "Select * from Hostels_Information";
            ResultSet rs = Conn.statement.executeQuery(Query);
            while (rs.next()) 
            {                
                HostalName.add(rs.getString("Hostel_Name"));
            }
        } 
        catch (Exception e1) 
        {
            e1.printStackTrace();
        }
        add(HostalName);
        
        JSeparator line3b = new JSeparator();
        line3b.setBounds(425, 200, 250, 10);
        line3b.setBackground(new Color(204, 204, 255, 255));
        add(line3b);
        
        RoomNo = new Choice();
        RoomNo.setBounds(75, 220, 250, 30);
        RoomNo.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        add(RoomNo);
        
        JSeparator line3c = new JSeparator();
        line3c.setBounds(75, 250, 250, 10);
        line3c.setBackground(new Color(204, 204, 255, 255));
        add(line3c);
        
        username = new JTextField("username");
        username.setBounds(425, 220, 250, 30);
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
        Conform.setBounds(425, 270, 250, 30);
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
        line5.setBounds(425, 300, 250, 10);
        line5.setBackground(new Color(204, 204, 255, 255));
        add(line5);
        
        HostalName.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
                try 
                {
                    DataBase Conn = new DataBase();
                    String Query = "Select * from Add_Rooms";
                    ResultSet rs = Conn.statement.executeQuery(Query);
                    while(rs.next()) 
                    {
                        if(HostalName.getSelectedItem().equals(rs.getString("Hostel_Name")) && rs.getString("Availability").equals("Available"))
                        {
                            RoomNo.add(rs.getString("Room_Number"));
                            location.setText(rs.getString("Hostel_Address"));
                        }
                    }
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });
        
        Book = new JButton("Book Room");
        Book.setBounds(75, 350, 250, 35);
        Book.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        Book.setBackground(new Color(0, 15, 26, 255));
        Book.setOpaque(false);
        Book.setContentAreaFilled(false);
        Book.setForeground(Color.white);
        Book.setHorizontalAlignment(JButton.CENTER);
        Book.setBorder(new RoundedBorder(25));
        Book.addActionListener(this);
        add(Book);
             
        back = new JButton("Cancel");
        back.setBounds(425, 350, 250, 35);
        back.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        back.setBackground(new Color(0, 0, 51, 255));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setForeground(Color.white);
        back.setHorizontalAlignment(JButton.CENTER);
        back.setBorder(new RoundedBorder(25));
        back.addActionListener(this);
        add(back);
        
        location  = new JLabel();
        location.setBounds(200, 400, 450, 30);
        location.setFont(new Font("SansSerif Regular", Font.PLAIN, 20));
        location.setForeground(new Color(245, 246, 201, 255));
        add(location);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/2188.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds (0, 0, 800, 500);
        add(image);

        setBounds(300, 100, 800, 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Book)
        {   
            if(CustomerName.getText().matches("^[a-z A-Z]*$") && !CustomerName.getText().isEmpty() && 
                CustomerCNIC.getText().matches("^[1234567890]*$") && !CustomerCNIC.getText().isEmpty() &&
               !CustomerAddress.getText().isEmpty() &&
                CustomerContact.getText().matches("^[1234567890]*$") && !CustomerContact.getText().isEmpty() &&
                Password.getText().equals(Conform.getText()))
            {
                String Customer_Name = CustomerName.getText();
                String Customer_CNIC = CustomerCNIC.getText();
                String Customer_Address = CustomerAddress.getText();
                String Customer_Contact = CustomerContact.getText();
                String Customer_Profession = (String)Profession.getSelectedItem();
                String Hostel_Name = HostalName.getSelectedItem();
                String Hostel_Room_Number = RoomNo.getSelectedItem();
                String Username = username.getText();
                String Password = this.Password.getText();
                
                String Total_Rooms = null;
                try {
                DataBase c = new DataBase();
                ResultSet rs = c.statement.executeQuery("Select * from Add_Rooms where Hostel_Name = '"+ HostalName.getSelectedItem() +"'");
                if(rs.next())
                {
                    Total_Rooms = rs.getString("Total_Rooms");
                }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
                
                int Remaining_Rooms = Integer.parseInt(Total_Rooms) - 1;
                int Booked_Rooms = Integer.parseInt(Total_Rooms) - Remaining_Rooms;
                
                
                
                try 
                {
                    DataBase Conn = new DataBase();
                    String Query = "insert into Room_Booking values('"+ Customer_Name +"', '"+ Customer_CNIC +"', '"+ Customer_Address +"', '"+ Customer_Contact +"', '"+ Customer_Profession +"', '"+ Hostel_Name +"', '"+ Hostel_Room_Number +"')";
                    String Query0 = "insert into Sign_UP_Accounts values('Customer', '"+ Customer_Name +"', '"+ Username +"', '"+ Password +"')";
                    String Query1 = "update Add_Rooms set Availability = 'Occupied', Total_Rooms = '"+ Remaining_Rooms +"' where Room_Number = '"+ Hostel_Room_Number +"'";
                    String Query2 = "update Hostels_Information set Avaliable_Rooms = '"+ Remaining_Rooms +"', Booked_Rooms = '"+ Booked_Rooms +"' where Hostel_Name = '"+ Hostel_Name +"'";
                    String Query3 = "insert into Customers values('"+ Customer_Name +"', '"+ Customer_CNIC +"', '"+ Customer_Address +"', '"+ Customer_Contact +"', '"+ Customer_Profession +"')";
                    Conn.statement.executeUpdate(Query);
                    Conn.statement.executeUpdate(Query0);
                    Conn.statement.executeUpdate(Query1);
                    Conn.statement.executeUpdate(Query2);
                    JOptionPane.showMessageDialog(null, "Room Booked Sucessfully");
                    dispose();
                    new Login_Panel();
                } 
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                if(!CustomerName.getText().matches("^[a-z A-Z]*$") || CustomerName.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Invalid Cutomer Name");
                }
                else if (!CustomerCNIC.getText().matches("^[1234567890]*$") || CustomerCNIC.getText().isEmpty() ) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Cutomer CNIC");
                }
                else if (CustomerAddress.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Cutomer Address");
                }
                else if (!CustomerContact.getText().matches("^[1234567890]*$") || CustomerContact.getText().isEmpty() ) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Cutomer Contact");
                }
                else if(!Password.getText().equals(Conform.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Password Do not Match");
                }            
            }
        }
        else
        {
            new Login_Panel();
        }
    }
    public static void main(String[] args) 
    {
        new Customer_Signup();
    }
}
