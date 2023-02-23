package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Check_Out extends JFrame implements ActionListener
{
    String Customer_Name;
    
    private final JTextField CustomerName, CustomerCNIC, CustomerAddress, CustomerContact, Profession, HostalName, RoomNo, Deposite2;
    private final JButton checkout, back;
    JLabel location, Deposite, Deposite1;
        
    Check_Out(String customer_name)
    {
        super("checkout Room");
        this.Customer_Name = customer_name;
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JLabel header = new JLabel("checkout Room");
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
        
        
        HostalName = new JTextField("Hostel Name");
        HostalName.setBounds(425, 170, 250, 30);
        HostalName.setOpaque(false);
        HostalName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        HostalName.setForeground(new Color(204, 204, 255));
        HostalName.setBorder(null);
        HostalName.setEditable(false);
        HostalName.setHorizontalAlignment(JTextField.CENTER);
        add(HostalName);
        
        JSeparator line3b = new JSeparator();
        line3b.setBounds(425, 200, 250, 10);
        line3b.setBackground(new Color(204, 204, 255, 255));
        add(line3b);
        
        RoomNo = new JTextField("Room Number");
        RoomNo.setBounds(75, 220, 250, 30);
        RoomNo.setOpaque(false);
        RoomNo.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        RoomNo.setForeground(new Color(204, 204, 255));
        RoomNo.setBorder(null);
        RoomNo.setEditable(false);
        RoomNo.setHorizontalAlignment(JTextField.CENTER);
        add(RoomNo);
        
        JSeparator line3c = new JSeparator();
        line3c.setBounds(75, 250, 250, 10);
        line3c.setBackground(new Color(204, 204, 255, 255));
        add(line3c);
        
        Deposite = new JLabel("Total Bill :");
        Deposite.setBounds(425, 220, 100, 30);
        Deposite.setOpaque(false);
        Deposite.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Deposite.setForeground(new Color(204, 204, 255));
        Deposite.setBorder(null);
        Deposite.setHorizontalAlignment(JTextField.LEFT);
        add(Deposite);
        
        Deposite1 = new JLabel();
        Deposite1.setBounds(525, 220, 75, 30);
        Deposite1.setOpaque(false);
        Deposite1.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Deposite1.setForeground(new Color(204, 204, 255));
        Deposite1.setBorder(null);
        add(Deposite1);
        
        Deposite2 = new JTextField();
        Deposite2.setBounds(600, 220, 75, 30);
        Deposite2.setOpaque(false);
        Deposite2.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        Deposite2.setForeground(new Color(204, 204, 255));
        Deposite2.setBorder(null);
        Deposite2.setHorizontalAlignment(JTextField.RIGHT);
        add(Deposite2);
        
        JSeparator line3d = new JSeparator();
        line3d.setBounds(425, 250, 250, 10);
        line3d.setBackground(new Color(204, 204, 255, 255));
        add(line3d);
        
        checkout = new JButton("checkout Room");
        checkout.setBounds(75, 300, 250, 35);
        checkout.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        checkout.setBackground(new Color(0, 15, 26, 255));
        checkout.setOpaque(false);
        checkout.setContentAreaFilled(false);
        checkout.setForeground(Color.white);
        checkout.setHorizontalAlignment(JButton.CENTER);
        checkout.setBorder(new RoundedBorder(25));
        checkout.addActionListener(this);
        add(checkout);
             
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
                HostalName.setText(rs.getString("Hostel_Name"));
                RoomNo.setText(rs.getString("Hostel_Room_Number"));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        try 
        {
            DataBase Conn = new DataBase();
            String Query = "Select * from Add_Rooms where Room_Number = '"+ RoomNo.getText() +"' and Hostel_Name = '"+ HostalName.getText() +"'";
            ResultSet rs = Conn.statement.executeQuery(Query);
            while(rs.next()) 
            {
                Deposite1.setText(rs.getString("Price"));
            }
        } 
        catch (Exception e1) 
        {
            e1.printStackTrace();
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
        if(ae.getSource() == checkout)
        {
            String Bill = Deposite1.getText();
            String Payed = Deposite2.getText();
            
            String Total_Rooms = null;
            String book  = null;
            try 
            {
                DataBase c = new DataBase();
                ResultSet rs = c.statement.executeQuery("Select * from hostels_information where Hostel_Name = '"+ HostalName.getText()+"'");
                if(rs.next())
                {
                    Total_Rooms = rs.getString("Total_Rooms");
                    book = rs.getString("Booked_Rooms");
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
            int Remaining_Rooms = Integer.parseInt(Total_Rooms) + 1;
            int Booked_Rooms = Integer.parseInt(book)-1;
            
            if(Payed.equals(Bill))
            {
                try 
                {
                    DataBase conn = new DataBase();
                    conn.statement.executeUpdate("delete from Room_Booking where Hostel_Room_Number = '"+ RoomNo.getText() +"'");
                    conn.statement.executeUpdate("update Add_Rooms set Availability = 'Available', Total_Rooms = '"+ Remaining_Rooms +"' where Room_Number = '"+ RoomNo.getText() +"'");
                    conn.statement.executeUpdate("update Hostels_Information set Avaliable_Rooms = '"+ Remaining_Rooms +"', Booked_Rooms = '"+ Booked_Rooms +"' where Hostel_Name = '"+ HostalName.getText() +"'");
                    JOptionPane.showMessageDialog(null, "Room Free Now");
                    dispose();
                }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid price Field");
            }
        }
        else if(ae.getSource() == back)
        {
            dispose();
        }
    }
    public static void main(String[] args) 
    {
        new Check_Out("");
    }
}
