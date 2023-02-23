package hostelmanagementsystem;

import java.sql.*;

public class DataBase 
{
    Connection conn;
    Statement statement;
    DataBase() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Hostels", "root", "3264");
            statement = conn.createStatement();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
    
}
