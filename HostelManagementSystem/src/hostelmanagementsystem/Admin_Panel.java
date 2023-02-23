package hostelmanagementsystem;

import java.awt.*;

import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class Admin_Panel extends JFrame implements ActionListener
{
    
    String Admin_Name;
    JTable table;
    JButton hostel,  Customers, seeroom, Seller,cancel, Booked;
    Admin_Panel(String name)
    {
        super("Admin Panel");
        this.Admin_Name = name;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        
        JLabel header = new JLabel("Welcome Mr."+ Admin_Name);
        header.setBounds(450, 15, 500, 50);
        header.setForeground(new Color(245, 246, 201, 255));
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 30));
        header.setHorizontalAlignment(JLabel.CENTER);
        add(header);
        
        Seller = new JButton("View Seller Info");
        Seller.setBounds(60, 200, 250, 35);
        Seller.setFont(new Font("Tahoma", Font.BOLD, 20));
        Seller.setBackground(new Color(0, 15, 26, 255));
        Seller.setOpaque(false);
        Seller.setContentAreaFilled(false);
        Seller.setForeground(Color.white);
        Seller.setBorder(new RoundedBorder(25));
        Seller.addActionListener(this);
        add(Seller);
        
        hostel = new JButton("See Hostel Info");
        hostel.setBounds(150, 250, 250, 35);
        hostel.setFont(new Font("Tahoma", Font.BOLD, 20));
        hostel.setBackground(new Color(0, 15, 26, 255));
        hostel.setOpaque(false);
        hostel.setContentAreaFilled(false);
        hostel.setForeground(Color.white);
        hostel.setBorder(new RoundedBorder(25));
        hostel.addActionListener(this);
        add(hostel);
        

        seeroom = new JButton("See Rooms Info");
        seeroom.setBounds(60, 300, 250, 35);
        seeroom.setFont(new Font("Tahoma", Font.BOLD, 20));
        seeroom.setBackground(new Color(0, 15, 26, 255));
        seeroom.setOpaque(false);
        seeroom.setContentAreaFilled(false);
        seeroom.setForeground(Color.white);
        seeroom.setBorder(new RoundedBorder(25));
        seeroom.addActionListener(this);
        add(seeroom);
         
        Customers = new JButton("Customers Info");
        Customers.setBounds(150, 350, 250, 35);
        Customers.setFont(new Font("Tahoma", Font.BOLD, 20));
        Customers.setBackground(new Color(0, 15, 26, 255));
        Customers.setOpaque(false);
        Customers.setContentAreaFilled(false);
        Customers.setForeground(Color.white);
        Customers.setBorder(new RoundedBorder(25));
        Customers.addActionListener(this);
        add(Customers);
        
        Booked = new JButton("view Booked Rooms");
        Booked.setBounds(60, 400, 250, 35);
        Booked.setFont(new Font("Tahoma", Font.BOLD, 18));
        Booked.setBackground(new Color(0, 15, 26, 255));
        Booked.setOpaque(false);
        Booked.setContentAreaFilled(false);
        Booked.setForeground(Color.white);
        Booked.setBorder(new RoundedBorder(25));
        Booked.addActionListener(this);
        add(Booked);
                
        cancel = new JButton("Cancel");
        cancel.setBounds(150, 450, 250, 35);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
        cancel.setBackground(new Color(0, 15, 26, 255));
        cancel.setOpaque(false);
        cancel.setContentAreaFilled(false);
        cancel.setForeground(Color.white);
        cancel.setBorder(new RoundedBorder(25));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/2188.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds (0, 0, 1366, 768);
        add(image);

        setBounds(-10, -05, 1380, 740);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Seller)
        {
            new Seller_Info_Table();
        }
        else if(ae.getSource() == hostel)
        {
            new Hostels_Info_Table();
        }
        else if(ae.getSource() == seeroom)
        {
            new Rooms_Info_Table();
        }
        else if(ae.getSource() == Customers)
        {
            new Customers_Info_Table();
        }
        else if(ae.getSource() == Booked)
        {
            new Room_Booked_Info_Table();
        }
        else
        {
            dispose();
            new Login_Panel();
        }
    }
    public static void main(String args[])
    {
        new Admin_Panel("");
    }
}
class Customers_Info_Table extends JFrame implements ActionListener
{
    JTable table;
    Customers_Info_Table() 
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        table = new JTable();
        table.setOpaque(false);
        table.setForeground(Color.white);
        table.setRowHeight(25);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Customers");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(0, 0, 815, 450);
        
        scp.setOpaque(false);
        scp.getViewport().setOpaque(false);
        add(scp);
        
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
        
    }
}

class Rooms_Info_Table extends JFrame implements ActionListener
{
    JTable table;
    Rooms_Info_Table()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        table = new JTable();
        table.setOpaque(false);
        table.setForeground(Color.white);
        table.setRowHeight(25);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Add_Rooms");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(0, 0, 815, 450);
        
        scp.setOpaque(false);
        scp.getViewport().setOpaque(false);
        add(scp);
        
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
        
    }
}

class Room_Booked_Info_Table extends JFrame implements ActionListener
{
    JTable table;
    Room_Booked_Info_Table()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        table = new JTable();
        table.setOpaque(false);
        table.setForeground(Color.white);
        table.setRowHeight(25);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Room_Booking");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(0, 0, 815, 450);
        
        scp.setOpaque(false);
        scp.getViewport().setOpaque(false);
        add(scp);
        
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
        
    }
}

class Hostels_Info_Table extends JFrame implements ActionListener
{
    JTable table;
    Hostels_Info_Table() 
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        table = new JTable();
        table.setOpaque(false);
        table.setForeground(Color.white);
        table.setRowHeight(25);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Hostels_Information");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(0, 0, 815, 450);
        
        scp.setOpaque(false);
        scp.getViewport().setOpaque(false);
        add(scp);
        
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
        
    }
}

class Seller_Info_Table extends JFrame implements ActionListener
{
    JTable table;
    Seller_Info_Table() 
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        table = new JTable();
        table.setOpaque(false);
        table.setForeground(Color.white);
        table.setRowHeight(25);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Seller");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(0, 0, 815, 450);
        
        scp.setOpaque(false);
        scp.getViewport().setOpaque(false);
        add(scp);
        
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
        
    }
}
