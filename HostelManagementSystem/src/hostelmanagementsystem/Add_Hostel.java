
package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Add_Hostel extends JFrame implements ActionListener
{
    JTextField hostelName, hostelAddress, totalRoom;
    JButton addHostel, cancel;
    String Hostel_owner;
    Add_Hostel(String name)
    {
        super("Add New Hostel");
        this.Hostel_owner = name;
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JLabel header = new JLabel("Add New Hostel");
        header.setBounds(225, 30, 350, 50);
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 40));
        header.setForeground(new Color(245, 246, 201, 255));
        add(header);
        
        hostelName = new JTextField("Hostel Name");
        hostelName.setBounds(290, 110, 200, 30);
        hostelName.setOpaque(false);
        hostelName.setHorizontalAlignment(JTextField.CENTER);
        hostelName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        hostelName.setForeground(new Color(204, 204, 255));
        hostelName.setBorder(null);
        hostelName.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                hostelName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                hostelName.setText("");
            }
        });
        add(hostelName);
        
        JSeparator line1 = new JSeparator();
        line1.setBounds(290, 140, 200, 10);
        line1.setBackground(new Color(204, 204, 255, 255));
        add(line1);
        
        hostelAddress = new JTextField("Hostel Address");
        hostelAddress.setBounds(290, 160, 200, 30);
        hostelAddress.setOpaque(false);
        hostelAddress.setHorizontalAlignment(JTextField.CENTER);
        hostelAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        hostelAddress.setForeground(new Color(204, 204, 255));
        hostelAddress.setBorder(null);
        hostelAddress.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                hostelAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                hostelAddress.setText("");
            }
        });
        add(hostelAddress);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(290, 190, 200, 10);
        line2.setBackground(new Color(204, 204, 255, 255));
        add(line2);
        
        totalRoom = new JTextField("Total Rooms");
        totalRoom.setBounds(290, 210, 200, 30);
        totalRoom.setOpaque(false);
        totalRoom.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        totalRoom.setForeground(new Color(204, 204, 255));
        totalRoom.setBorder(null);
        totalRoom.setHorizontalAlignment(JTextField.CENTER);
        totalRoom.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent ME)
            {
                totalRoom.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
                totalRoom.setText("");
            }
        });
        add(totalRoom);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(290, 240, 200, 10);
        line3.setBackground(new Color(204, 204, 255, 255));
        add(line3);
        
        addHostel = new JButton("Add Hostel");
        addHostel.setBounds(290, 300, 200, 35);
        addHostel.setFont(new Font("SansSerif Regular", Font.BOLD, 20));
        addHostel.setBackground(new Color(0, 15, 26, 255));
        addHostel.setOpaque(false);
        addHostel.setContentAreaFilled(false);
        addHostel.setForeground(Color.white);
        addHostel.setHorizontalAlignment(JButton.CENTER);
        addHostel.setBorder(new RoundedBorder(25));
        addHostel.addActionListener(this);
        add(addHostel);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(290, 350, 200, 35);
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

        setBounds(440, 180, 815, 450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == addHostel)
        {
            if(hostelName.getText().matches("^[a-z A-Z]*$") && !hostelName.getText().isEmpty() )
            {
                String Hostel_Name = hostelName.getText();
                String Hostel_Addrss  =hostelAddress.getText();
                String TR = totalRoom.getText();
                String Total_Rooms = null;
                
                if(Integer.parseInt(TR) <= 50)
                {
                    Total_Rooms = TR;
            
                    String Avaliable_Rooms = Total_Rooms;
                    String Booked_Rooms = null;
                
                    try 
                    {
                        DataBase connection = new DataBase();
                        String Query = "insert into Hostels_Information values('"+ Hostel_owner +"','"+ Hostel_Name +"', '"+ Hostel_Addrss +"', '"+ Total_Rooms +"', '"+ Avaliable_Rooms +"', '"+ Booked_Rooms +"')";
                        connection.statement.executeUpdate(Query);
                        JOptionPane.showMessageDialog(null, "Hostel Add Sucessfully");
                        dispose();
                    } 
                    catch(Exception e)
                    {
                        //JOptionPane.showMessageDialog(null, e);
                        e.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Room Number Field");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Hostel Name");
            }
        }
        else
        {
            dispose();
        }
        
    }
    
    public static void main(String[] args) 
    {
        new Add_Hostel("");
    }
}
