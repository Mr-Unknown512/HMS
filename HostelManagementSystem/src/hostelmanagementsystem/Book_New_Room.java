package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Book_New_Room extends JFrame implements ActionListener
{
    String Customer_Name;
    
    private final JTextField CustomerName, CustomerCNIC, CustomerAddress, CustomerContact, Profession;
    private final Choice HostalName,  RoomNo;
    private final JButton Book, back;
    JLabel location;
        
    Book_New_Room(String customer_name)
    {
        super("Book New Room");
        this.Customer_Name = customer_name;
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JLabel header = new JLabel("Book New Room");
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
        CustomerName.setEditable(false);
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
        CustomerCNIC.setEditable(false);
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
        CustomerAddress.setEditable(false);
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
        CustomerContact.setEditable(false);
        CustomerContact.setHorizontalAlignment(JTextField.CENTER);
        add(CustomerContact);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(425, 150, 250, 10);
        line3.setBackground(new Color(204, 204, 255, 255));
        add(line3);
        
        Profession = new JTextField("Profession");
        Profession.setBounds(75, 170, 250, 30);
        Profession.setOpaque(false);
        Profession.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Profession.setForeground(new Color(204, 204, 255));
        Profession.setBorder(null);
        Profession.setEditable(false);
        Profession.setHorizontalAlignment(JTextField.CENTER);
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
        Book.setBounds(75, 300, 250, 35);
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
        back.setBounds(425, 300, 250, 35);
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
        location.setBounds(200, 350, 450, 30);
        location.setFont(new Font("SansSerif Regular", Font.PLAIN, 20));
        location.setForeground(new Color(245, 246, 201, 255));
        add(location);
        
        try 
        {
            DataBase Conn = new DataBase();
            ResultSet rs = Conn.statement.executeQuery("select * from Room_Booking where Customer_Name = '"+ customer_name +"'");
            while (rs.next()) 
            {                
                CustomerName.setText(rs.getString("customer_name"));
                CustomerAddress.setText(rs.getString("Customer_Address"));
                CustomerCNIC.setText(rs.getString("Customer_CNIC"));
                CustomerContact.setText(rs.getString("Customer_Contact"));
                Profession.setText(rs.getString("Customer_Profession"));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/2188.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds (0, 0, 800, 500);
        add(image);
        setBounds(440, 180, 815, 450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Book)
        {
             String Customer_Name = CustomerName.getText();
                String Customer_CNIC = CustomerCNIC.getText();
                String Customer_Address = CustomerAddress.getText();
                String Customer_Contact = CustomerContact.getText();
                String Customer_Profession = Profession.getText();
                String Hostel_Name = HostalName.getSelectedItem();
                String Hostel_Room_Number = RoomNo.getSelectedItem();
                
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
                    String Query1 = "update Add_Rooms set Availability = 'Occupied', Total_Rooms = '"+ Remaining_Rooms +"' where Room_Number = '"+ Hostel_Room_Number +"'";
                    String Query2 = "update Hostels_Information set Avaliable_Rooms = '"+ Remaining_Rooms +"', Booked_Rooms = '"+ Booked_Rooms +"' where Hostel_Name = '"+ Hostel_Name +"'";
                    Conn.statement.executeUpdate(Query);
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
        else if(ae.getSource() == back)
        {
            dispose();
        }
    }
    public static void main(String[] args) 
    {
        new Book_New_Room("");
    }
}
