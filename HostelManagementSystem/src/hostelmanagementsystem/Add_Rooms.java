package hostelmanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Add_Rooms extends JFrame implements ActionListener
{
    JTextField hostelAddress, totalRoom, price, RoomNummber;
    Choice Hostel;
    JComboBox Avalaiablity, Bedtype;
    JButton addRoom, cancel;
    String Owner_Name;
    Add_Rooms(String name)
    {
        super("Add New Hostel");
        this.Owner_Name = name;
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JLabel header = new JLabel("Add New Hostel");
        header.setBounds(225, 30, 350, 50);
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 40));
        header.setForeground(new Color(245, 246, 201, 255));
        add(header);
        
        JLabel hostelName = new JLabel("Select Hostel:");
        hostelName.setBounds(50, 110, 100, 30);
        hostelName.setOpaque(false);
        hostelName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        hostelName.setForeground(new Color(204, 204, 255));
        hostelName.setBorder(null);
        add(hostelName);
        
        Hostel = new Choice();
        Hostel.setBackground(new Color(24,0,83,255));
        Hostel.setForeground(Color.WHITE);
        Hostel.setBounds(150, 105, 200, 30);
        new RoundedBorder(40);
        Hostel.setFont(new Font("SansSerif Regular", Font.PLAIN, 20));
        Hostel.add(" ");
        try 
        {
            DataBase conn = new DataBase();
            String Query = "Select * from Hostels_Information";
            ResultSet Rs = conn.statement.executeQuery(Query);
            while(Rs.next()) 
            {
                if(Owner_Name.equals(Rs.getString("Hostel_Owner")))
                {
                    Hostel.add(Rs.getString("Hostel_Name"));
                }
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        add(Hostel);
        
        JSeparator line1 = new JSeparator();
        line1.setBounds(50, 140, 300, 10);
        line1.setBackground(new Color(204, 204, 255, 255));
        add(line1);
        
        JLabel l1 = new JLabel("Hostel Address:");
        l1.setBounds(400, 110, 300, 30);
        l1.setOpaque(false);
        l1.setHorizontalAlignment(JTextField.LEFT);
        l1.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        l1.setForeground(new Color(204, 204, 255));
        l1.setBorder(null);
        add(l1);
        
        hostelAddress = new JTextField();
        hostelAddress.setBounds(400, 110, 350, 30);
        hostelAddress.setOpaque(false);
        hostelAddress.setHorizontalAlignment(JTextField.RIGHT);
        hostelAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        hostelAddress.setForeground(new Color(204, 204, 255));
        hostelAddress.setBorder(null);
        add(hostelAddress);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(400, 140, 350, 10);
        line2.setBackground(new Color(204, 204, 255, 255));
        add(line2);
        
        JLabel l2 = new JLabel("Avaliable Rooms:");
        l2.setBounds(50, 160, 300, 30);
        l2.setOpaque(false);
        l2.setHorizontalAlignment(JTextField.LEFT);
        l2.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        l2.setForeground(new Color(204, 204, 255));
        l2.setBorder(null);
        add(l2);
        
        totalRoom = new JTextField();
        totalRoom.setBounds(50, 160, 300, 30);
        totalRoom.setOpaque(false);
        totalRoom.setHorizontalAlignment(JTextField.RIGHT);
        totalRoom.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        totalRoom.setForeground(new Color(204, 204, 255));
        totalRoom.setBorder(null);
        add(totalRoom);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(50, 190, 300, 10);
        line3.setBackground(new Color(204, 204, 255, 255));
        add(line3);
        
        String str [] = {"Available", "Occupied"};
        Avalaiablity = new JComboBox(str);
        Avalaiablity.setBounds(400, 160, 350, 30);
        Avalaiablity.setOpaque(false);
        Avalaiablity.setEditable(true);
        new Transparent(Avalaiablity.getComponents());
        Avalaiablity.setFont(new Font("SansSerif Regular", Font.PLAIN, 20));
        add(Avalaiablity);
        
        JSeparator line4 = new JSeparator();
        line4.setBounds(400, 190, 350, 10);
        line4.setBackground(new Color(204, 204, 255, 255));
        add(line4);
        
        String str1 [] = {"Single Bed", "Double Bed"};
        Bedtype = new JComboBox(str1);
        Bedtype.setBounds(50, 210, 300, 30);
        Bedtype.setOpaque(false);
        Bedtype.setEditable(true);
        new Transparent(Bedtype.getComponents());
        Bedtype.setFont(new Font("SansSerif Regular", Font.PLAIN, 20));
        add(Bedtype);
        
        JSeparator line5 = new JSeparator();
        line5.setBounds(50, 240, 300, 10);
        line5.setBackground(new Color(204, 204, 255, 255));
        add(line5);
        
        JLabel l = new JLabel("Price:");
        l.setBounds(400, 210, 200, 30);
        l.setOpaque(false);
        l.setHorizontalAlignment(JTextField.LEFT);
        l.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        l.setForeground(new Color(204, 204, 255));
        l.setBorder(null);
        add(l);
        
        price = new JTextField();
        price.setBounds(400, 210, 350, 30);
        price.setOpaque(false);
        price.setHorizontalAlignment(JTextField.CENTER);
        price.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        price.setForeground(new Color(204, 204, 255));
        price.setBorder(null);
        add(price);
        
        JSeparator line6 = new JSeparator();
        line6.setBounds(400, 240, 350, 10);
        line6.setBackground(new Color(204, 204, 255, 255));
        add(line6);
        
        JLabel roomno = new JLabel("Room Number:");
        roomno.setBounds(200, 270, 100, 30);
        roomno.setOpaque(false);
        roomno.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        roomno.setForeground(new Color(204, 204, 255));
        roomno.setHorizontalAlignment(JLabel.LEFT);
        roomno.setBorder(null);
        add(roomno);
        
        RoomNummber = new JTextField();
        RoomNummber.setBounds(200, 270, 350, 30);
        RoomNummber.setOpaque(false);
        RoomNummber.setHorizontalAlignment(JTextField.CENTER);
        RoomNummber.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        RoomNummber.setForeground(new Color(204, 204, 255));
        RoomNummber.setBorder(null);
        add(RoomNummber);
        
        JSeparator line7 = new JSeparator();
        line7.setBounds(200, 300, 350, 10);
        line7.setBackground(new Color(204, 204, 255, 255));
        add(line7);
        
        addRoom = new JButton("Add Room");
        addRoom.setBounds(150, 350, 200, 35);
        addRoom.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        addRoom.setBackground(new Color(0, 15, 26, 255));
        addRoom.setOpaque(false);
        addRoom.setContentAreaFilled(false);
        addRoom.setForeground(Color.white);
        addRoom.setHorizontalAlignment(JButton.CENTER);
        addRoom.setBorder(new RoundedBorder(25));
        addRoom.addActionListener(this);
        add(addRoom);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 350, 200, 35);
        cancel.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        cancel.setBackground(new Color(0, 0, 51, 255));
        cancel.setOpaque(false);
        cancel.setContentAreaFilled(false);
        cancel.setForeground(Color.white);
        cancel.setHorizontalAlignment(JButton.CENTER);
        cancel.setBorder(new RoundedBorder(25));
        cancel.addActionListener(this);
        add(cancel);           
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/2188.jpg"));
        Image i2 = i1.getImage().getScaledInstance(815, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds (0, 0, 815, 450);
        add(image);
        
        Hostel.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e) 
            {
                try 
                {
                    DataBase conn = new DataBase();
                    String Query = "Select * from Hostels_Information";
                    ResultSet Rs = conn.statement.executeQuery(Query);
                    while(Rs.next()) 
                    {
                        if(Hostel.getSelectedItem().equals(Rs.getString("Hostel_Name")))
                        {
                            hostelAddress.setText(Rs.getString("Location"));
                            String rooms = Rs.getString("Avaliable_Rooms");
                            int room = Integer.parseInt(rooms);
                            if(room == 1)
                            {
                                String R = Integer.toString(room);
                                totalRoom.setText(R);
                            }
                            else if(room > 1)
                            {
                                room = Integer.parseInt(rooms)-1;
                                String R = Integer.toString(room);
                                totalRoom.setText(R);
                            }                
                        }
                    }
                }
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        setBounds(440, 180, 815, 450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == addRoom)
        {
            if(RoomNummber.getText().matches("^[0123456789]*$") && !RoomNummber.getText().isEmpty())
            {
                String Hostel_name = Hostel.getSelectedItem();
                String Hostel_Address = hostelAddress.getText();
                String Total_Rooms = totalRoom.getText();
                String Room_Number = RoomNummber.getText();
                String Avalaiablity = (String)this.Avalaiablity.getSelectedItem();
                String Bed_Tpye = (String)Bedtype.getSelectedItem();
                String Price = price.getText();
                
                try
                {
                    DataBase Conn = new DataBase();
                    String Query = "insert into Add_Rooms values('"+ Owner_Name +"','"+ Hostel_name +"','"+ Hostel_Address +"', '"+ Total_Rooms +"', '"+ Room_Number +"', '"+ Avalaiablity +"', '"+ Bed_Tpye +"', '"+ Price +"')";
                    Conn.statement.executeUpdate(Query);
                    JOptionPane.showMessageDialog(null, "Room Added Successfully");
                    dispose();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Room Number");
            }
        }
        else
        {
            dispose();
        }       
    }
    public static void main(String[] args) 
    {
        new Add_Rooms("");
    }
}
