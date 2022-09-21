package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	public static Connection createConnection()
    {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/login";
    String username = "root";
    String password = "";
 
    try
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Post establishing a DB connection - "+con);
    }
    catch (SQLException e)
        {
           System.out.println("An error occurred. Maybe user/password is invalid");
         e.printStackTrace();
       }
    return con;
    }
}
