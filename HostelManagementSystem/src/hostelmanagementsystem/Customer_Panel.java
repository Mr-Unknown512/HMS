package hostelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class Customer_Panel extends JFrame implements ActionListener
{
    private JTable table;
    JButton book_new_room, cancel, check_out;
    String Customer_Name;
    
    Customer_Panel(String Name)
    {
        super("Customer Panel");
        this.Customer_Name = Name;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        
        JLabel header = new JLabel("Welcome Mr."+Customer_Name);
        header.setBounds(450, 15, 500, 50);
        header.setForeground(new Color(245, 246, 201, 255));
        header.setFont(new Font("SansSerif Regular", Font.BOLD, 30));
        header.setHorizontalAlignment(JLabel.CENTER);
        add(header);
        
        JLabel CName = new JLabel();
        CName.setBounds(60, 150, 350, 30);
        CName.setOpaque(false);
        CName.setHorizontalAlignment(JTextField.CENTER);
        CName.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CName.setForeground(new Color(255, 255, 255));
        CName.setBorder(null);
        add(CName);
        
        JSeparator line1 = new JSeparator();
        line1.setBounds(60, 180, 300, 10);
        line1.setBackground(new Color(255, 255, 255, 255));
        add(line1);
        
        JLabel CCNIC = new JLabel();
        CCNIC.setBounds(100, 220, 300, 30);
        CCNIC.setOpaque(false);
        CCNIC.setHorizontalAlignment(JTextField.CENTER);
        CCNIC.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CCNIC.setForeground(new Color(255, 255, 255));
        CCNIC.setBorder(null);
        add(CCNIC);
        
        JSeparator line2 = new JSeparator();
        line2.setBounds(100, 250, 300, 10);
        line2.setBackground(new Color(255, 255, 255, 255));
        add(line2);
        
        JLabel CAddress = new JLabel();
        CAddress.setBounds(60, 290, 300, 30);
        CAddress.setOpaque(false);
        CAddress.setHorizontalAlignment(JTextField.CENTER);
        CAddress.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CAddress.setForeground(new Color(255, 255, 255));
        CAddress.setBorder(null);
        add(CAddress);
        
        JSeparator line3 = new JSeparator();
        line3.setBounds(60, 320, 300, 10);
        line3.setBackground(new Color(255, 255, 255, 255));
        add(line3);
        
        JLabel CPhone = new JLabel();
        CPhone.setBounds(100, 360, 300, 30);
        CPhone.setOpaque(false);
        CPhone.setHorizontalAlignment(JTextField.CENTER);
        CPhone.setFont(new Font("SansSerif Regular", Font.PLAIN, 15));
        CPhone.setForeground(new Color(255, 255, 255));
        CPhone.setBorder(null);
        add(CPhone);
        
        JSeparator line4 = new JSeparator();
        line4.setBounds(100, 390, 300, 10);
        line4.setBackground(new Color(255, 255, 255, 255));
        add(line4);
        
        table = new JTable();
        table.setOpaque(false);
        table.setForeground(Color.white);
        table.setRowHeight(25);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        try
        {
            DataBase connection = new DataBase();
            ResultSet rs = connection.statement.executeQuery("select * from Room_Booking where Customer_Name = '"+ Customer_Name +"'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(450, 150, 800, 450);
        scp.setOpaque(false);
        scp.getViewport().setOpaque(false);
        add(scp);
        
        book_new_room = new JButton("Book New Room");
        book_new_room.setBounds(60, 450, 250, 35);
        book_new_room.setFont(new Font("Tahoma", Font.BOLD, 20));
        book_new_room.setBackground(new Color(0, 15, 26, 255));
        book_new_room.setOpaque(false);
        book_new_room.setContentAreaFilled(false);
        book_new_room.setForeground(Color.white);
        book_new_room.setBorder(new RoundedBorder(25));
        book_new_room.addActionListener(this);
        add(book_new_room);
        
        check_out = new JButton("Check Out");
        check_out.setBounds(150, 500, 250, 35);
        check_out.setFont(new Font("Tahoma", Font.BOLD, 20));
        check_out.setBackground(new Color(0, 15, 26, 255));
        check_out.setOpaque(false);
        check_out.setContentAreaFilled(false);
        check_out.setForeground(Color.white);
        check_out.setBorder(new RoundedBorder(25));
        check_out.addActionListener(this);
        add(check_out);
        
                
        cancel = new JButton("Cancel");
        cancel.setBounds(60, 550, 250, 35);
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
            ResultSet rs = connection.statement.executeQuery("select * from Room_Booking");
            while(rs.next()) 
            {
                if(Customer_Name.equals(rs.getString("Customer_Name")))
                {
                    CName.setText("Name    " + rs.getString("Customer_Name"));
                    CCNIC.setText("CNIC    " + rs.getString("Customer_CNIC"));
                    CAddress.setText("Address    " + rs.getString("Customer_Address"));
                    CPhone.setText("Contact    " + rs.getString("Customer_Contact"));
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
       if(ae.getSource() == book_new_room)
       {
           new Book_New_Room(Customer_Name);
       }
       else if(ae.getSource() == check_out)
       {
           new Check_Out(Customer_Name);
       }
       else
       {
           dispose();
           new Login_Panel();
       }
    }
    
    public static void main(String[] args) 
    {
        new Customer_Panel("");
    }
}
