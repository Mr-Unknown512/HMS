package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class Seller_Panel extends JFrame implements ActionListener
{
    private JTable table;
    JButton addhostel, cancel, addroom, seeroom, seehostel;
    String Seller_Name;
    
    Seller_Panel(String Name)
    {
        super("Seller Panel");
        this.Seller_Name = Name;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        
        JLabel header = new JLabel("Welcome Mr."+Seller_Name);
        header.setBounds(450, 15, 500, 50);
        header.setForeground(new Color(245, 246, 201, 255));
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 30));
        header.setHorizontalAlignment(JLabel.CENTER);
        add(header);
        
        JLabel SName = new JLabel();
        SName.setBounds(60, 150, 350, 30);
        SName.setOpaque(false);
        SName.setHorizontalAlignment(JTextField.CENTER);
        SName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        SName.setForeground(new Color(255, 255, 255));
        SName.setBorder(null);
        add(SName);
        
        JSeparator line1 = new JSeparator();
        line1.setBounds(60, 180, 300, 10);
        line1.setBackground(new Color(255, 255, 255, 255));
        add(line1);
        
        JLabel SCNIC = new JLabel();
        SCNIC.setBounds(100, 220, 300, 30);
        SCNIC.setOpaque(false);
        SCNIC.setHorizontalAlignment(JTextField.CENTER);
        SCNIC.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        SCNIC.setForeground(new Color(255, 255, 255));
        SCNIC.setBorder(null);
        add(SCNIC);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(100, 250, 300, 10);
        line2.setBackground(new Color(255, 255, 255, 255));
        add(line2);
        
        JLabel SAddress = new JLabel();
        SAddress.setBounds(60, 290, 300, 30);
        SAddress.setOpaque(false);
        SAddress.setHorizontalAlignment(JTextField.CENTER);
        SAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        SAddress.setForeground(new Color(255, 255, 255));
        SAddress.setBorder(null);
        add(SAddress);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(60, 320, 300, 10);
        line3.setBackground(new Color(255, 255, 255, 255));
        add(line3);
        
        JLabel SPhone = new JLabel();
        SPhone.setBounds(100, 360, 300, 30);
        SPhone.setOpaque(false);
        SPhone.setHorizontalAlignment(JTextField.CENTER);
        SPhone.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        SPhone.setForeground(new Color(255, 255, 255));
        SPhone.setBorder(null);
        add(SPhone);
        
        JSeparator line4 = new JSeparator();
        line4.setBounds(100, 390, 300, 10);
        line4.setBackground(new Color(255, 255, 255, 255));
        add(line4);
       
        addhostel = new JButton("Add new Hostel");
        addhostel.setBounds(60, 430, 250, 35);
        addhostel.setFont(new Font("Tahoma", Font.BOLD, 20));
        addhostel.setBackground(new Color(0, 15, 26, 255));
        addhostel.setOpaque(false);
        addhostel.setContentAreaFilled(false);
        addhostel.setForeground(Color.white);
        addhostel.setBorder(new RoundedBorder(25));
        addhostel.addActionListener(this);
        add(addhostel);
        
        addroom = new JButton("Add Room");
        addroom.setBounds(150, 475, 250, 35);
        addroom.setFont(new Font("Tahoma", Font.BOLD, 20));
        addroom.setBackground(new Color(0, 15, 26, 255));
        addroom.setOpaque(false);
        addroom.setContentAreaFilled(false);
        addroom.setForeground(Color.white);
        addroom.setBorder(new RoundedBorder(25));
        addroom.addActionListener(this);
        add(addroom);
        
        seehostel = new JButton("See Hostels");
        seehostel.setBounds(60, 520, 250, 35);
        seehostel.setFont(new Font("Tahoma", Font.BOLD, 20));
        seehostel.setBackground(new Color(0, 15, 26, 255));
        seehostel.setOpaque(false);
        seehostel.setContentAreaFilled(false);
        seehostel.setForeground(Color.white);
        seehostel.setBorder(new RoundedBorder(25));
        seehostel.addActionListener(this);
        add(seehostel);

        seeroom = new JButton("See Rooms");
        seeroom.setBounds(150, 565, 250, 35);
        seeroom.setFont(new Font("Tahoma", Font.BOLD, 20));
        seeroom.setBackground(new Color(0, 15, 26, 255));
        seeroom.setOpaque(false);
        seeroom.setContentAreaFilled(false);
        seeroom.setForeground(Color.white);
        seeroom.setBorder(new RoundedBorder(25));
        seeroom.addActionListener(this);
        add(seeroom);
        
                
        cancel = new JButton("Cancel");
        cancel.setBounds(60, 610, 250, 35);
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
        
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Seller");
            while(rs.next()) 
            {
                if(Seller_Name.equals(rs.getString("Name")))
                {
                    SName.setText("Name    " + rs.getString("Name"));
                    SCNIC.setText("CNIC    " + rs.getString("CNIC"));
                    SAddress.setText("Address    " + rs.getString("Address"));
                    SPhone.setText("Contact    " + rs.getString("Contact"));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        setBounds(-10, -05, 1380, 740);
        setVisible(true);      
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == addhostel)
       {
           new Add_Hostel(Seller_Name);
       }
       else if(ae.getSource() == addroom)
       {
           new Add_Rooms(Seller_Name);
       }
       else if(ae.getSource() == seehostel)
       {
           new seehostel(Seller_Name);
       }
       
       else if(ae.getSource() == seeroom)
       {
           new Rooms(Seller_Name);
       }
       else
       {
           dispose();
           new Login_Panel();
       }
    }
    
    public static void main(String[] args) 
    {
        new Seller_Panel("");
    }
}

class Rooms extends JFrame 
{
    JTable table;
    String Owner_Name;
    Rooms(String Name) 
    {
        this.Owner_Name = Name;
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
            ResultSet rs = connection.statement.executeQuery("select * from Add_Rooms where Hostel_Owner = '"+ Owner_Name +"'");
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
}

class seehostel extends JFrame
{
    JTable table;
    String Owner_Name;
    seehostel(String Name) 
    {
        this.Owner_Name = Name;
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
            ResultSet rs = connection.statement.executeQuery("select * from hostels_information where Hostel_Owner = '"+ Owner_Name +"'");
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
}
